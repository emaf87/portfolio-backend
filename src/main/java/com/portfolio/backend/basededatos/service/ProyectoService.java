
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Proyect;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.basededatos.repository.ProyectRepository;

@Service
public class ProyectoService implements IProyectService{

    @Autowired
    private ProyectRepository proyectoRepository;
    
    @Override
    public List<Proyect> getProyects() {
        return proyectoRepository.findAll();
    }

    @Override
    public void saveProyect(Proyect proy) {
        proyectoRepository.save(proy);
    }

    @Override
    public void deleteProyect(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyect findProyect(int id) {
        return proyectoRepository.findById(id).orElse(null);
    }
    
}
