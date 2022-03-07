package com.dtos;

import com.entities.Vacataire;
import lombok.Data;

import java.util.List;

@Data
public class CoursDto {

    private Long Id;
    private String Intitule;
    public List<Vacataire> mesVacataires;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String intitule) {
        Intitule = intitule;
    }

    public List<Vacataire> getMesVacataires() {
        return mesVacataires;
    }

    public void setMesVacataires(List<Vacataire> mesVacataires) {
        this.mesVacataires = mesVacataires;
    }

}
