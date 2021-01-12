package com.example.projet_techno_web.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OccupationLogement {

    @Id
    @GeneratedValue
    private long id;
    private long idOwner;
    private long idMembre;
    private long idLogement;
    private String dateA;
    private String dateD;

    private long etat; // "demande" "ok"




    //Constructors
    public OccupationLogement() {
    }
    public OccupationLogement(long idOwner, long idMembre, long idLogement, String dateA, String dateD, long etat) {
        this.idOwner = idOwner;
        this.idMembre = idMembre;
        this.idLogement = idLogement;
        this.dateA = dateA;
        this.dateD = dateD;
        this.etat = etat;
    }


    //Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }

    public long getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(long idMembre) {
        this.idMembre = idMembre;
    }

    public long getIdLogement() {
        return idLogement;
    }

    public void setIdLogement(long idLogement) {
        this.idLogement = idLogement;
    }

    public String getDateA() {
        return dateA;
    }

    public void setDateA(String dateA) {
        this.dateA = dateA;
    }

    public String getDateD() {
        return dateD;
    }

    public void setDateD(String dateD) {
        this.dateD = dateD;
    }

    public long getEtat() {
        return etat;
    }

    public void setEtat(long etat) {
        this.etat = etat;
    }
}
