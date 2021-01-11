package com.example.projet_techno_web.model;

import javax.persistence.*;

@Entity
@Table (name = "Message")
public class Message {

    @Id
    @GeneratedValue
    private long id;
    private long idUser;
    @Column(length=1000000)
    private String text;


    //Constructors
    public Message() {
    }
    public Message(long idUser, String text) {
        this.idUser = idUser;
        this.text = text;
    }

    //Getters et setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdUser() {
        return idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
