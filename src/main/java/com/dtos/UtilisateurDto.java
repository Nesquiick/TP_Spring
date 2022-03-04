package com.dtos;
import lombok.Data;

@Data
public class UtilisateurDto {

    private Long Id;
    private String prenom;
    private String nom;
    private String motDePasse;
    private String mail;
}
