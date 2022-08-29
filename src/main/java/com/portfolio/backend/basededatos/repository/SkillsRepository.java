
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer>{
    
}
