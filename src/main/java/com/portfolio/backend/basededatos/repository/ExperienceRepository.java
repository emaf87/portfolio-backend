
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    
}
