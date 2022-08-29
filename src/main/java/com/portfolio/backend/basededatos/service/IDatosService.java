
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Datos;
import java.util.List;


public interface IDatosService {
    
       
    public List<Datos> getDatos();
    
    public void saveDatos(Datos data);
    
    public void deleteDatos(int id);
    
    public Datos findDato(int id);
    
}
