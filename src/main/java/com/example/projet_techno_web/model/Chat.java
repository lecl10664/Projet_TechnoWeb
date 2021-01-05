package com.example.projet_techno_web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat {

    @Id
    @GeneratedValue
    private long id;

    @Column(length=1000000)
    private String text;

    private long idS;
    private long idR;


    //Constructors
    public Chat() {
    }

    public Chat(long id, String text, long idS, long idR) {
        this.id = id;
        this.text = text;
        this.idS = idS;
        this.idR = idR;
    }

    //Getters et setterss
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIdS() {
        return idS;
    }

    public void setIdS(long idS) {
        this.idS = idS;
    }

    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
    }
}



