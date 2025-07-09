package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public List<User> getAll(){
        return userRepository.findAll();
    }

   
    public void saveNewUser(User user ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }

    public void saveAdmin(User user ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER, ADMIN"));
        userRepository.save(user);
    }


    public void saveUser(User user ) {
         userRepository.save(user);
    }
    public Optional<User> findByID(ObjectId id){
//        return Optional.ofNullable(journalEntryRepository.findById(id).orElse(null));
        return userRepository.findById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


//    public void deleteByUserName(String userName) {
//        userRepository.deleteByUserName(userName);
//    }

//    public void deleteByUserName(String userName) {
//
//    }


}
// controller -->service-->repository
