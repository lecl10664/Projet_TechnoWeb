package com.example.projet_techno_web.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String type;
    private String adresse;
    private Integer codePostal;
    private String ville;

    @Column(length=1000000)
    private String description;

    @Column(length=1000000)
    private String contraintes;

    @Column(length=1000000)
    private String services;

    @OneToMany
    private List<Commentaire> listeCommentaires;

    @OneToOne
    private User user;


    // Constructor

    public Logement(Long id, String nom, String type, String adresse, String ville, Integer codePostal, String description) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.description = description;
    }

    public Logement() {
    }

    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long homeId) {
        this.id = homeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getContraintes() {
        return contraintes;
    }

    public void setContraintes(String contraintes) {
        this.contraintes = contraintes;
    }
}

