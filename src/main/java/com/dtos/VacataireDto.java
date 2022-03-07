package com.dtos;

import com.entities.Cours;
import lombok.Data;

@Data
public class VacataireDto extends UtilisateurDto{

    private Cours sonCours;

    public Cours getSonCours() {
        return sonCours;
    }

    public void setSonCours(Cours sonCours) {
        this.sonCours = sonCours;
    }
}
