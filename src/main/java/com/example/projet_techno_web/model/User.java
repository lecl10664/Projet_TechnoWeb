package com.example.projet_techno_web.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String lName;
    private String fName;
    private String eMail;
    private String password;



    //Constructors
    public User() {
    }

    public User(long id, String lName, String fName, String eMail, String password) {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.eMail = eMail;
        this.password = password;
    }



    // Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
