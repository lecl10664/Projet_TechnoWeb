package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.data.LogementUpdateDAO;
import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"UserLogged"})
public class MyLogementsController {

    @Autowired
    private final LogementDAO logementDAO;
    private final LogementUpdateDAO logementUpdateDAO;

    public MyLogementsController(LogementUpdateDAO logementUpdateDAO, LogementDAO logementDAO) {
        this.logementUpdateDAO = logementUpdateDAO;
        this.logementDAO = logementDAO;
    }

    @GetMapping("/mylogements")
    public String showPage(@ModelAttribute("UserLogged") User userlogged, Model model){
        Long idMembre = userlogged.getId();
        //model.addAttribute("listLogements", logementDAO.findAll());
        model.addAttribute("listLogements",logementDAO.findByIdMembre(idMembre));
        return "MyLogements";
    }

    @PostMapping("/mylogements")
    public String updateLogements(@ModelAttribute("UserLogged") User userlogged, Model model, @ModelAttribute Logement newLogement){
        Logement logement = new Logement(newLogement.getId(), newLogement.getType(), newLogement.getAdresse(), newLogement.getVille(), newLogement.getCodepostal(), newLogement.getPays(), newLogement.getDescription(), newLogement.getIdMembre(), newLogement.getIdContrainte(), newLogement.getIdService(), newLogement.getIdCommentaire());

        logementUpdateDAO.updateUser(logement.getAdresse(),userlogged.getId());

        return "redirect:mylogements";
    }
}
