package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@SessionAttributes({"UserLogged"})
public class LogementController {

    @Autowired
    LogementDAO logementDAO;




    @GetMapping("/logementListe")
    public String showLogementListe(Model model) {
        model.addAttribute("listeLogement", logementDAO.findAll());

        model.addAttribute("logementRecherche", new Logement());

        return "logementListe";
    }


    //Exemple pour recup infos de session
    //@GetMapping("/logementExemple")
    //public String logement (@ModelAttribute("UserLogged") User userLoggged) {
    // et la tu as l'object userLogged, qui est un user avec les infos du user connecté


    @GetMapping("/logement/{id}")
    public String showLogement(@PathVariable("id")Long id, Model model){

        Optional<Logement> listL = logementDAO.findById(id);
        Logement logement = listL.get();
        model.addAttribute("logement",logement);

        return "Logement";
    }

    @GetMapping("/logement")
    public Optional<Logement> getLogementById(@RequestParam Long id) {
        return logementDAO.findById(id);
    }

    @DeleteMapping("/logement")
    public void deleteLogement(@RequestParam Long id) {
        logementDAO.deleteById(id);
    }



    @GetMapping("/ajoutLogement")
    public String showPageAjoutLogement(Model model){
        model.addAttribute("newLogement",new Logement());
        return "ajoutLogement";
    }


    @PostMapping("/ajoutLogement")
    public String inscriptionUser(@ModelAttribute  Logement newLogement) {
        String dir = "";
        logementDAO.save(newLogement);

        return "redirect:" + dir;
    }


    /*@GetMapping("/rechercheLogement")
    public String showPageRecherche(Model model){
        model.addAttribute("villeRecherche", "");
        return "logementRecherche";
    }*/
    @GetMapping("/rechercheLogement/{villeRecherche}")
    public String showLogementRecherche(Model model, @PathVariable String villeRecherche) {
        model.addAttribute("listeLogementRecherche", logementDAO.findByVille(villeRecherche));

        return "logementRecherche";
    }

    @PostMapping("/rechercheLogement")
    public String redirectLogementRecherche(@ModelAttribute Logement logementRecherche){
        return "redirect:rechercheLogement/" + logementRecherche.getVille();
    }




}
