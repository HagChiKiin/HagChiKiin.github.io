package com.example.bt.controller;

import com.example.bt.model.User;
import com.example.bt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping
    public String getUser(Model model) {
        List<User> users = userService.getAlUser();
        model.addAttribute("danhSachUser", users);
        return "user-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model) {
        User user = new User();
        model.addAttribute("userTaoMoi", user);
        return "create-user";
    }
    @PostMapping
    public String createNewStudent(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") String id){
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable("id") String id, Model model){
        User user = userService.findById(id);
        model.addAttribute("userCapNhatMoi",user);
        return "edit-user";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
