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
    @Column(length=1000000)
    private String adresse;
    private String ville;
    private Integer codePostal;
    private String pays;

    @Column(length=1000000)
    private String description;


    @OneToMany
    private List<Contrainte> listeContraintes;

    @OneToMany
    private List<Service> listeServices;

    @OneToMany
    private List<Commentaire> listeCommentaires;


    // Constructor

    public Logement(Long id, String nom, String type, String adresse, String ville, Integer codePostal, String pays, String description) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
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

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Contrainte> getListeContraintes() {
        return listeContraintes;
    }

    public void setListeContraintes(List<Contrainte> listeContraintes) {
        this.listeContraintes = listeContraintes;
    }

    public List<Service> getListeServices() {
        return listeServices;
    }

    public void setListeServices(List<Service> listeServices) {
        this.listeServices = listeServices;
    }

    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }
}
