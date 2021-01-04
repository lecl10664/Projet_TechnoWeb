package com.example.projet_techno_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serviceTexte;



    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long serviceId) {
        this.id = serviceId;
    }

    public String getServiceTexte() {
        return serviceTexte;
    }

    public void setServiceTexte(String serviceTexte) {
        this.serviceTexte = serviceTexte;
    }
}
