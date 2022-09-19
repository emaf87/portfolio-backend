/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Experience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.basededatos.repository.ExperienceRepository;

@Service
public class ExperienceService implements IExperienceService{

    @Autowired
    private ExperienceRepository experienciaRepository;
    
    @Override
    public List<Experience> getExperience() {
        return experienciaRepository.findAll();
    }

    @Override
    public void saveExperience(Experience exp) {
        experienciaRepository.save(exp);
    }

    @Override
    public void deleteExperience(int id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(int id) {
        return experienciaRepository.findById(id).orElse(null);
    }
    
}
