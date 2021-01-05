package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.data.LogementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class LogementController {

    @Autowired
    LogementDAO logementDAO;

    @GetMapping("/homeListe")
    public List<Logement> getHomeListe() {
        return logementDAO.findAll();
    }

    @GetMapping("/home")
    public Optional<Logement> getHomeById(@RequestParam Long id) {
        return logementDAO.findById(id);
    }

    @PostMapping("/home")
    public Logement saveHome(@RequestBody Logement logement) {
        return logementDAO.save(logement);
    }

    @DeleteMapping("/home")
    public void deleteHome(@RequestParam Long id) {
        logementDAO.deleteById(id);
    }






}
