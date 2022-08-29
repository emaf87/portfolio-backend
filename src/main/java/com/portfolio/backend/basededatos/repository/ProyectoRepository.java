
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
}
