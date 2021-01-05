package com.example.projet_techno_web.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OccupationLogement {

    @Id
    @GeneratedValue
    private long id;
    private long idMembre;
    private long idLogement;
    private String date;




    //Constructors
    public OccupationLogement() {
    }
    public OccupationLogement(long id, long idMembre, long idLogement, String date) {
        this.id = id;
        this.idMembre = idMembre;
        this.idLogement = idLogement;
        this.date = date;
    }


    //Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
