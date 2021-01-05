package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@SessionAttributes({"UserLogged"})
public class AccueilController {


    public AccueilController() {}


    @GetMapping("/home")
    public String showPageSession(@ModelAttribute("UserLogged") User userLogged){


        return "Accueil";
    }

}
