package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InscriptionController {

    @Autowired
    private final UserDAO userDAO;

    public InscriptionController(UserDAO userDAO) { this.userDAO = userDAO;}


    @GetMapping("/signup")
    public String showPage(Model model){
        model.addAttribute("newUser",new User());
        return "Inscription";
    }

    @PostMapping("/signup")
    public String inscriptionUser(@ModelAttribute User newUser){
        String dir = "";
        User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());

        //Problème de ce code qui a pour but de check si le mail existe déjà
        //String eMail = user.geteMail();
        //List<User> listUser = userDAO.findByEMail("%"+eMail+"%");
        //String checkEMail = listUser.get(0).geteMail();
        //boolean testEMail = eMail.equals(checkEMail);
        //if(!testEMail){
        //    userDAO.save(user);
        //    dir = "login";
        //} else {
        //    dir = "signup";
        //}

        userDAO.save(user);

        return "redirect:"+dir;
    }



}
