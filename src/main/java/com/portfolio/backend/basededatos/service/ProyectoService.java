
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Proyecto;
import com.portfolio.backend.basededatos.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Override
    public List<Proyecto> getProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public void saveProyecto(Proyecto proy) {
        proyectoRepository.save(proy);
    }

    @Override
    public void deleteProyecto(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(int id) {
        return proyectoRepository.findById(id).orElse(null);
    }
    
}
