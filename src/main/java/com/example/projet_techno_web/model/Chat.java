package com.example.projet_techno_web.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Chat {

    @Id
    @GeneratedValue
    private long id;

    private long idS;
    private long idR;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id2", referencedColumnName = "id")
    List<Message> messages = new ArrayList<>();



    //Constructors
    public Chat() {
    }

    public Chat(long idS, long idR) {
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}



