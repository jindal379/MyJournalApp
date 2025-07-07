package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(JournalEntryService.class);

    public List<JournalEntity> getAll(){
        return journalEntryRepository.findAll();
    }



    //@Transactional
    public void saveEntry(JournalEntity journalEntity, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntity.setDate(LocalDateTime.now());
            JournalEntity saved = journalEntryRepository.save(journalEntity);
            user.getJournalEntities().add(saved);
            userService.saveUser(user);
        }catch (Exception e){
            log.error("Exception",e);
        }
    }
    public void saveEntry(JournalEntity journalEntity) {
            journalEntryRepository.save(journalEntity);

    }
    public Optional<JournalEntity> findByID(ObjectId id){
//        return Optional.ofNullable(journalEntryRepository.findById(id).orElse(null));
        return journalEntryRepository.findById(id);
    }
    public void deleteByID(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntities().removeIf(x -> x.getId().equals(id));
        userService.saveNewUser(user);
        journalEntryRepository.deleteById(id);

    }

}
// controller -->service-->repository
