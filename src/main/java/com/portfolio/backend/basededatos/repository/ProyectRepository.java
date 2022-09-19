
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Integer>{
    
}
