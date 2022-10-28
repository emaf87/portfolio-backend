
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.basededatos.repository.ProyectRepository;

@Service
public class ProyectoService implements IProyectService{

    @Autowired
    private ProyectRepository proyectoRepository;
    
    @Override
    public List<Project> getProjects() {
        return proyectoRepository.findAll();
    }

    @Override
    public void saveProject(Project proy) {
        proyectoRepository.save(proy);
    }

    @Override
    public void deleteProject(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Project findProject(int id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProjectsList(List<Project> projList) {
        proyectoRepository.saveAll(projList);
    }
    
}
