package com.example.projet_techno_web.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long homeId;
    private String type;
    private String adresse;
    private String ville;
    private int codePostal;
    private String pays;
    private String description;

    @OneToMany
    private List<Contrainte> listeContraintes;

    @OneToMany
    private List<Service> listeServices;

    @OneToMany
    private List<Commentaire> listeCommentaires;






    // Getter and Setter

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
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
