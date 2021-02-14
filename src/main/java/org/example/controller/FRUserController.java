package org.example.controller;


import org.example.domain.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class FRUserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult errors) {
        if (errors.hasErrors()) {
            return "addUser";
        }
        userService.add(user);
        return "redirect:/showUsers";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String showRegisterUserForm(User user) {
        return "addUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user.getId());
        return "redirect:/";
    }


    @GetMapping("/showUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
