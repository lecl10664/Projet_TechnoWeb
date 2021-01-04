package com.example.projet_techno_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentaireId;
    private String commentaireTexte;
    // private int membreId;



    // Getter and Setter

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getCommentaireTexte() {
        return commentaireTexte;
    }

    public void setCommentaireTexte(String commentaireTexte) {
        this.commentaireTexte = commentaireTexte;
    }
}
