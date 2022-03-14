package com.services;

import com.dtos.VacataireDto;

import java.util.List;

public interface VacataireService {

    VacataireDto postVacataire(VacataireDto vacataireDto);

    VacataireDto getVacataireById(Long vacataireId);

    boolean deleteVacataire(Long vacataireId);

    List<VacataireDto> getAllVacataire();

}
