/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Datos;
import com.portfolio.backend.basededatos.repository.DatosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosService implements IDatosService{
    
    
     @Autowired
    private DatosRepository datosRepo;

    @Override
    public List<Datos> getDatos() {
        return datosRepo.findAll();
    }

    @Override
    public void saveDatos(Datos data) {
        datosRepo.save(data);
    }

    @Override
    public void deleteDatos(int id) {
        datosRepo.deleteById(id);
    }

    @Override
    public Datos findDato(int id) {
        return datosRepo.findById(id).orElse(null);
    }
}
