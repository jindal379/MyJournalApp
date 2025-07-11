package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTests {


    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void saveNewUserTests(User user){
        assertTrue(userService.saveNewUser(user));

    }
}
