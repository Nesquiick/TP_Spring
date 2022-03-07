package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Vacataire> getMesVacataires() {
        return mesVacataires;
    }

    public void setMesVacataires(List<Vacataire> mesVacataires) {
        this.mesVacataires = mesVacataires;
    }

    public String intitule;
    @OneToMany
    public List<Vacataire> mesVacataires;
}
