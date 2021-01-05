package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.model.Logement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutLogementAdminController {

    @Autowired
    private final LogementDAO logementDAO;


    public AjoutLogementAdminController(LogementDAO logementDAO) {
        this.logementDAO = logementDAO;
    }

    @GetMapping("/addLogementAdmin")
    public String showPage(Model model){
        model.addAttribute("newLogement",new Logement());
        return "AjoutLogementAdmin";
    }

    @PostMapping("/addLogementAdmin")
    public String addAdminLogement(@ModelAttribute Logement newLogement){
        String dir = "";
        Logement logement = new Logement(newLogement.getId(), newLogement.getNom(), newLogement.getType(), newLogement.getAdresse(), newLogement.getVille(), newLogement.getCodePostal(), newLogement.getPays(), newLogement.getDescription());
        logementDAO.save(logement);
        return "redirect:"+dir;
    }




}
