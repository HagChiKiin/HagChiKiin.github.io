package com.example.demojparelationship;

import com.example.demojparelationship.entity.IdentityCard;
import com.example.demojparelationship.entity.Post;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.IdentityCardRepository;
import com.example.demojparelationship.repository.PostRepository;
import com.example.demojparelationship.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.awt.*;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class DemoJpaRelationshipApplicationTests {
    @Autowired
    private IdentityCardRepository identityCardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    void save_user() {
        Faker faker = new Faker();
        IdentityCard identityCard =new IdentityCard(null,"111");
        identityCardRepository.save(identityCard);

        //tạo card
//        User user = new User(null,"Kiên","kien@gmail.com","123",identityCard,);
//        userRepository.save(user);
    }

    @Test
    void save_user1() {
        User user = User.builder()
                .name("Kim")
                .email("kim@gmail.com")
                .password("222")
                .identityCard(new IdentityCard(null,"222"))
                .build();
        userRepository.save(user);
    }

    @Test
    void find_user(){
        User user = userRepository.findById(2).orElse(null);
        System.out.println(user);
    }
    @Test
    void delete_user(){
       userRepository.deleteById(2);
    }

    @Test
    void save_user_post(){
       User user = User.builder()
               .name("Kim")
                .email("kim@gmail.com")
                .password("222")
               .build();
       userRepository.save(user);
        for (int i = 1; i <= 3; i++) {
            Post post = new Post(null,"post- "+i,user);
            postRepository.save(post);

        }
    }
    @Test
    void orphan_removal(){
        User user = userRepository.findById(4).orElse(null);
        List<Post> postList = user.getPost();
        postList.remove(0);
    }

}
