package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserPageController {

    @Autowired
    private final UserDAO userDAO;

    public UserPageController(UserDAO userDAO) {this.userDAO = userDAO;}

}
