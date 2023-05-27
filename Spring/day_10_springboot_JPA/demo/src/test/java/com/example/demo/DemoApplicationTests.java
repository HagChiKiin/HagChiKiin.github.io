package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_user() {
        User user = new User(null,"kien@gmail.com","kien", LocalDate.now().minusYears(26),true);
        userRepository.save(user);
    }
    @Test
    void save_user_list() {
        List<User> users = List.of(new User(null,"a","a@gmail.com",LocalDate.now().minusYears(26),true),
                new User(null,"b","b@gmail.com",LocalDate.now().minusYears(23),true)
        );
        userRepository.saveAll(users);
    }
    @Test
    void find_user(){
        Optional<User> userOptional = userRepository.findById(1);
        userOptional.ifPresent(System.out::println);
    }

    @Test
    void example_test(){
        User user = userRepository.findByEmail("a@gmail.com").orElse(null);
        User user1 = userRepository.findByEmailUsingJPQL("a@gmail.com").orElse(null);
        User user2 = userRepository.findByEmailUsingNativeQuery("a@gmail.com").orElse(null);
        System.out.println("user"+user);
        System.out.println("user1"+user1);
        System.out.println("user2"+user2);
    }


}
