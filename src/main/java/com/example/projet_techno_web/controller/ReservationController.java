package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.ChatDAO;
import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"UserLogged"})
public class ReservationController {

    @Autowired
    private final UserDAO userDAO;
    private final ChatDAO chatDAO;
    private final LogementDAO logementDAO;


    public ReservationController(UserDAO userDAO, ChatDAO chatDAO, LogementDAO logementDAO){
        this.userDAO = userDAO; this.chatDAO = chatDAO; this.logementDAO = logementDAO;
    }


    @PostMapping("/reservation")
    public String reservation(@ModelAttribute("UserLogged") User userLogged){
        long dir;



        return "redirect:chat"+dir;
    }
}
