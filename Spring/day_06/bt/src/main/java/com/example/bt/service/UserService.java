package com.example.bt.service;

import com.example.bt.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

//    public void createData() {
//        for (int i = 0; i < 10; i++) {
//            User user = User.builder()
//                    .id(i)
//                    .userName("Nguyễn Văn " + i)
//                    .passWord("Abc " + i)
//                    .email("hihi@gmail.com"+i)
//                    .phone("123460"+i)
//                    .build();
//            users.add(user);
//        }
//    }

    public List<User> getAlUser() {
//        createData();
        return users;
    }
    public void saveUser(User user) {
        user.setId(users.size());
        users.add(user);
    }

    public void delete(String id) {
        users.removeIf(a->a.getId() == Integer.parseInt(id));
    }

    public User findById(String id) {
        return users.stream().filter(s->s.getId() == Integer.parseInt(id)).findFirst().get();
    }

    public void updateUser(User user) {
        users.forEach(s->{
            if(s.getId() != user.getId()){
                return;
            }
            s.setId(user.getId());
            s.setUserName(user.getUserName());
            s.setPassWord(user.getPassWord());
            s.setPhone(user.getPhone());
            s.setEmail(user.getEmail());
        });
    }
}
