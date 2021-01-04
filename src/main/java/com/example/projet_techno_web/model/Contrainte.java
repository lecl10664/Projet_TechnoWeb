package com.example.projet_techno_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrainte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contrainteTexte;


    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long contrainteId) {
        this.id = contrainteId;
    }

    public String getContrainteTexte() {
        return contrainteTexte;
    }

    public void setContrainteTexte(String contrainteTexte) {
        this.contrainteTexte = contrainteTexte;
    }
}
