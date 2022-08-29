
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    
     public List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion edu);
    
    public void deleteEducacion(int id);
    
    public Educacion findEducacion(int id);
}
