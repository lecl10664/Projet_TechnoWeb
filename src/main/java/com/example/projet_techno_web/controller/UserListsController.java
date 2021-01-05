package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserListsController {

    @Autowired
    private final UserDAO userDAO;

    public UserListsController (UserDAO userDAO) {this.userDAO = userDAO;}


    @GetMapping("/userlist")
    public String showUsers(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("listUsers", userDAO.findAll());
        return "UsersList";
    }

}
