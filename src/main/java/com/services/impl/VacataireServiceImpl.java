package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service("vacataireService")
public class VacataireServiceImpl implements VacataireService {

    private final VacataireRepository vacataireRepository;

    public VacataireServiceImpl(VacataireRepository vacataireRepository) {
        this.vacataireRepository = vacataireRepository;
    }

    @Override
    public VacataireDto postVacataire(VacataireDto vacataireDto) {
        Vacataire vacataire = vacataireDtoToEntity(vacataireDto);
        vacataire = vacataireRepository.save(vacataire);
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public VacataireDto getVacataireById(Long vacataireId) {
        Vacataire vacataire = vacataireRepository.findById(vacataireId).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public boolean deleteVacataire(Long vacataireId) {
        vacataireRepository.deleteById(vacataireId);
        return true;
    }

    @Override
    public List<VacataireDto> getAllVacataire(){
        List<VacataireDto> vacataireDto = new ArrayList<>();
        List<Vacataire> vacataires = vacataireRepository.findAll();
        vacataires.forEach(vacataire -> {
            vacataireDto.add(vacataireEntityToDto(vacataire));
        });
        return vacataireDto;
    }


    private VacataireDto vacataireEntityToDto(Vacataire vacataire){
        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(vacataire.getId());
        vacataireDto.setMail(vacataire.getMail());
        vacataireDto.setNom(vacataire.getNom());
        vacataireDto.setPrenom(vacataire.getPrenom());
        vacataireDto.setSonCours(vacataire.getSonCours());
        return vacataireDto;
    }

    private Vacataire vacataireDtoToEntity(VacataireDto vacataireDto){
        Vacataire vacataire = new Vacataire();
        vacataire.setId(vacataireDto.getId());
        vacataire.setMail(vacataireDto.getMail());
        vacataire.setNom(vacataireDto.getNom());
        vacataire.setPrenom(vacataireDto.getPrenom());
        vacataire.setSonCours(vacataireDto.getSonCours());
        return vacataire;
    }

}
