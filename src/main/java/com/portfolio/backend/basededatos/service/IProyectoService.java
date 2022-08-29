
package com.portfolio.backend.basededatos.service;


import com.portfolio.backend.basededatos.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> getProyectos();
    
    public void saveProyecto(Proyecto proy);
    
    public void deleteProyecto(int id);
    
    public Proyecto findProyecto(int id);
    
   
    
    
}
