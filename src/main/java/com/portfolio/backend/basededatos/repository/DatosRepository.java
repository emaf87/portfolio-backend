
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosRepository  extends JpaRepository<Datos, Integer>{
    
}
