package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.model.Home;
import com.example.projet_techno_web.repo.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class HomeController {

    @Autowired
    HomeRepo homeRepo;

    @GetMapping("/homeListe")
    public List<Home> getHomeListe() {
        return homeRepo.findAll();
    }

    @GetMapping("/home")
    public Optional<Home> getHomeById(@RequestParam Long id) {
        return homeRepo.findById(id);
    }

    @PostMapping("/home")
    public Home saveHome(@RequestBody Home home) {
        return homeRepo.save(home);
    }

    @DeleteMapping("/home")
    public void deleteHome(@RequestParam Long id) {
        homeRepo.deleteById(id);
    }
    





}
