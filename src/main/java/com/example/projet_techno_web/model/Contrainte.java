package com.example.projet_techno_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrainte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contrainteId;
    private String contrainteTexte;


    // Getter and Setter

    public Long getContrainteId() {
        return contrainteId;
    }

    public void setContrainteId(Long contrainteId) {
        this.contrainteId = contrainteId;
    }

    public String getContrainteTexte() {
        return contrainteTexte;
    }

    public void setContrainteTexte(String contrainteTexte) {
        this.contrainteTexte = contrainteTexte;
    }
}
