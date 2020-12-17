package com.example.projet_techno_web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Home {
    @Id
    @GeneratedValue
    private int homeId;
    private String type;
    private String adresse;
    private String ville;
    private int codePostal;
    private String pays;
    private String description;


}
