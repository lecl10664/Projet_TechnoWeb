package com.example.projet_techno_web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Logement {

    @Id
    @GeneratedValue
    private long id;

    @Column(length=1000000)
    private String type;
    @Column(length=1000000)
    private String adresse;
    @Column(length=1000000)
    private String ville;
    @Column(length=1000000)
    private String codepostal;
    @Column(length=1000000)
    private String pays;
    @Column(length=1000000)
    private String description;
    private long idMembre;
    private long idContrainte;
    private long idService;
    private long idCommentaire;



    //Constructors
    public Logement() {
    }

    public Logement(long id, String type, String adresse, String ville, String codepostal, String pays, String description,  long idMembre, long idContrainte, long idService, long idCommentaire) {
        this.id = id;
        this.type = type;
        this.adresse = adresse;
        this.ville = ville;
        this.codepostal = codepostal;
        this.pays = pays;
        this.description = description;
        this.idMembre = idMembre;
        this.idContrainte = idContrainte;
        this.idService = idService;
        this.idCommentaire = idCommentaire;

    }

    //Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
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

    public long getIdContrainte() {
        return idContrainte;
    }

    public void setIdContrainte(long idContrainte) {
        this.idContrainte = idContrainte;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public long getIdMembre() { return idMembre; }

    public void setIdMembre(long idMembre) { this.idMembre = idMembre; }
}
