
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
     public List<Experiencia> getExperiencias();
    
    public void saveExperiencia(Experiencia exp);
    
    public void deleteExperiencia(int id);
    
    public Experiencia findExperiencia(int id);
}
