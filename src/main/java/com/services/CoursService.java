package com.services;

import com.dtos.CoursDto;

import java.util.List;

public interface CoursService {

    CoursDto postCours(CoursDto coursDto);

    CoursDto getCoursById(Long coursId);

    boolean deleteCours(Long coursId);

    List<CoursDto> getAllCours();

}
