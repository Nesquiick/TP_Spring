package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.entities.Vacataire;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("coursService")
public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository){this.coursRepository = coursRepository;}

    @Override
    public CoursDto postCours(CoursDto coursDto){
        Cours cours = coursDtoToEntity((coursDto));
        cours = coursRepository.save(cours);
        return coursEntityToDto(cours);
    }

    @Override
    public CoursDto getCoursById(Long coursId){
        Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        return coursEntityToDto(cours);
    }

    @Override
    public boolean deleteCours(Long coursId){
        coursRepository.deleteById(coursId);
        return true;
    }

    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> coursDto = new ArrayList<>();
        List<Cours> cours = coursRepository.findAll();
        cours.forEach(unCours -> {
            coursDto.add(coursEntityToDto(unCours));
        });
        return coursDto;

    }

    private CoursDto coursEntityToDto(Cours cours){
        CoursDto coursDto = new CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());
        coursDto.setMesVacataires(cours.getMesVacataires());
        return coursDto;
    }

    private Cours coursDtoToEntity(CoursDto coursDto){
        Cours cours = new Cours();
        cours.setId(coursDto.getId());
        cours.setIntitule(coursDto.getIntitule());
        cours.setMesVacataires(coursDto.getMesVacataires());
        return cours;
    }

}
