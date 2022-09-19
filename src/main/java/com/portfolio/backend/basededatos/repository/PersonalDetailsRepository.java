
package com.portfolio.backend.basededatos.repository;

import com.portfolio.backend.basededatos.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository  extends JpaRepository<PersonalDetails, Integer>{
    
}
