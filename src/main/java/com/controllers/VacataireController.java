package com.controllers;

import com.dtos.VacataireDto;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataires")
public class VacataireController {
    private final VacataireServiceImpl vacataireService;

    public VacataireController(VacataireServiceImpl vacataireService) {
        this.vacataireService = vacataireService;
    }

    @GetMapping
    public List<VacataireDto> getVacataires(){
        return vacataireService.getAllVacataire();
    }

    @GetMapping("/{id}")
    public VacataireDto getVacataire(@PathVariable Long id){
        return vacataireService.getVacataireById(id);
    }

    @PostMapping
    public VacataireDto saveVacataire(final @RequestBody VacataireDto vacataireDto){
        return vacataireService.postVacataire(vacataireDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteVacataire(@PathVariable Long id) {
        return vacataireService.deleteVacataire(id);
    }

}
