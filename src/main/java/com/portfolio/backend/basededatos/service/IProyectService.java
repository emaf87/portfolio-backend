
package com.portfolio.backend.basededatos.service;


import com.portfolio.backend.basededatos.model.Proyect;
import java.util.List;


public interface IProyectService {
    
    public List<Proyect> getProyects();
    
    public void saveProyect(Proyect proy);
    
    public void deleteProyect(int id);
    
    public Proyect findProyect(int id);
    
   
    
    
}
