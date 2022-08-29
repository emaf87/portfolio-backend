/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Experiencia;
import com.portfolio.backend.basededatos.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    private ExperienciaRepository experienciaRepository;
    
    @Override
    public List<Experiencia> getExperiencias() {
        return experienciaRepository.findAll();
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        experienciaRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(int id) {
        return experienciaRepository.findById(id).orElse(null);
    }
    
}
