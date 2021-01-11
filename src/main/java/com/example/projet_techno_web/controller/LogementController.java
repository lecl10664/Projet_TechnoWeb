package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.data.LogementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@SessionAttributes({"UserLogged"})
public class LogementController {

    @Autowired
    LogementDAO logementDAO;

    @GetMapping("/logementListe")
    public List<Logement> getLogementListe() {
        return logementDAO.findAll();
    }

    @GetMapping("/logementRecherche")
    public List<Logement> getLogementListeByVille(@RequestParam String ville) {
        return logementDAO.findByVille(ville);

    }

    //Exemple pour recup infos de session
    //@GetMapping("/logementExemple")
    //public String logement (@ModelAttribute("UserLogged") User userLoggged) {
    // et la tu as l'object userLogged, qui est un user avec les infos du user connecté


    @GetMapping("/logement")
    public Optional<Logement> getLogementById(@RequestParam Long id) {
        return logementDAO.findById(id);
    }

    @PostMapping("/logement")
    public Logement saveLogement(@RequestBody Logement logement) {
        return logementDAO.save(logement);
    }

    @DeleteMapping("/logement")
    public void deleteLogement(@RequestParam Long id) {
        logementDAO.deleteById(id);
    }






}
