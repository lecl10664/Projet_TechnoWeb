package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"UserLogged"})
public class ConnexionController {

    @Autowired
    private final UserDAO userDAO;

    public ConnexionController(UserDAO userDAO) {this.userDAO = userDAO;}

    @GetMapping("/login")
    public String showPage(Model model){
        model.addAttribute("User", new User());
        return "Connexion";
    }



    @PostMapping("/login")
    public String testConnexion(@ModelAttribute User user, Model model) {
        String eMail = user.geteMail();
        String password = user.getPassword();
        String dir = "";

        List<User> listUser = userDAO.findByEMail("%"+eMail+"%");
        User checkUser = listUser.get(0);
        String checkEMail = checkUser.geteMail();
        String checkPassword = checkUser.getPassword();


        boolean testEMail = eMail.equals(checkEMail);
        boolean testPassword = password.equals(checkPassword);

        if (testEMail && testPassword){
            model.addAttribute("UserLogged",checkUser);
            dir = "home";
        }


        return "redirect:"+dir;
    }



}
