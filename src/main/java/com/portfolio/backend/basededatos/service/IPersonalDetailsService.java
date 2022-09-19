
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.PersonalDetails;
import java.util.List;


public interface IPersonalDetailsService {
    
       
    public List<PersonalDetails> getPersonalDetails();
    
    public void savePersonalDetails(PersonalDetails data);
    
    public void deletePersonalDetails(int id);
    
    public PersonalDetails findPersonalDetails(int id);
    
}
