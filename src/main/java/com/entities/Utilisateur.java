package com.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public abstract class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String prenom;
    private String nom;
    private String motDePasse;
    private String mail;
}
