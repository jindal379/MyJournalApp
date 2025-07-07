package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired private UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAllJournalEntriesOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntity> all = user.getJournalEntities();
        if(all !=null && !all.isEmpty()) {
            return new ResponseEntity(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping()
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity myEntry) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/id/{myID}")
    public ResponseEntity<JournalEntity> getGeneralEntryByID(@PathVariable ObjectId myID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);

        List<JournalEntity> collect = user.getJournalEntities().stream().filter(x -> x.getId().equals(myID)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            Optional<JournalEntity> journalEntity = journalEntryService.findByID(myID);
            if (journalEntity.isPresent()) {
                return new ResponseEntity<>(journalEntity.get(), HttpStatus.OK);
                // return ResponseEntity.ok(journalEntity.get());
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{userName}/{myID}")
    public ResponseEntity<JournalEntity> deleteGeneralEntryByID(@PathVariable ObjectId myID, @PathVariable String userName) {
        journalEntryService.deleteByID(myID, userName);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//     @DeleteMapping("/id/{myID}")
//    public ResponseEntity<JournalEntity> deleteGeneralEntryByID(@PathVariable ObjectId myID) {
//        journalEntryService.deleteByID(myID);
//       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }




// Without HTTP code,
//    @PutMapping("/id/{id}")
//    public JournalEntity updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntity newEntry){
//        JournalEntity oldEntry = journalEntryService.findByID(id).orElse(null);
//        if(oldEntry !=null){
//            oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent() );
//            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals(("")) ? newEntry.getTitle() : oldEntry.getTitle());
//        }
//        journalEntryService.saveEntry(oldEntry);
//        return oldEntry;
//    }

    // With HTTP code in Postman so we are using ResponseEntity Class
    @PutMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> updateEntry(
            @PathVariable ObjectId myId,
            @RequestBody JournalEntity newEntry,
            @PathVariable String userName) {
        JournalEntity oldEntry = journalEntryService.findByID(myId).orElse(null);
        if (oldEntry != null) {
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals(("")) ? newEntry.getTitle() : oldEntry.getTitle());

            journalEntryService.saveEntry(oldEntry);

            return new ResponseEntity<>(oldEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}




