/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Educacion;
import com.portfolio.backend.basededatos.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository educacionRepository;
    
    @Override
    public List<Educacion> getEducacion() {
        return educacionRepository.findAll();
    }

    @Override
    public void saveEducacion(Educacion edu) {
        educacionRepository.save(edu);
    }

    @Override
    public void deleteEducacion(int id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        return educacionRepository.findById(id).orElse(null);
    }
    
}
