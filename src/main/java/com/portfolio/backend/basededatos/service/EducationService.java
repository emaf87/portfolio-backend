/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Education;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.basededatos.repository.EducationRepository;

@Service
public class EducationService implements IEducationService{

    @Autowired
    private EducationRepository educationRepository;
    
    @Override
    public List<Education> getEducation() {
        return educationRepository.findAll();
    }

    @Override
    public void saveEducation(Education edu) {
        educationRepository.save(edu);
    }

    @Override
    public void deleteEducation(int id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(int id) {
        return educationRepository.findById(id).orElse(null);
    }
    
}
