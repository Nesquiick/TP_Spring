package com.controllers;

import com.dtos.CoursDto;
import com.services.impl.CoursServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursServiceImpl coursService;

    public CoursController(CoursServiceImpl coursService) {
        this.coursService = coursService;
    }

    @GetMapping
    public List<CoursDto> getCours(){
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public CoursDto getUnCours(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    @PostMapping
    public CoursDto saveCours(final @RequestBody CoursDto coursDto){
        return coursService.postCours(coursDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCours(@PathVariable Long id){
        return coursService.deleteCours(id);
    }
}
