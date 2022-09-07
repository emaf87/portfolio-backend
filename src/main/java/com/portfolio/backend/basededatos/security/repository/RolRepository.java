
package com.portfolio.backend.basededatos.security.repository;

import com.portfolio.backend.basededatos.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepository extends JpaRepository<Rol, Integer>{
        
    public Optional<Rol> findByNombre(String nombre);
}
