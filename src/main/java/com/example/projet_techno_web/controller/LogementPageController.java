package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.model.Logement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class LogementPageController {

    @Autowired
    private final LogementDAO logementDAO;

    public LogementPageController(LogementDAO logementDAO) {this.logementDAO = logementDAO;}

    @GetMapping("/logement/{id}")
    public String showPage(Model model, @PathVariable Long id){

        Optional<Logement> listLogement =logementDAO.findById(id);
        Logement checkLogement = listLogement.get();
        model.addAttribute("user", checkLogement);

        return "Logement";
    }


}


