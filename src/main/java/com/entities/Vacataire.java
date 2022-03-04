package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Vacataire extends Utilisateur{

    @ManyToOne
    public Cours sonCours;
}
