
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Experience;
import java.util.List;

public interface IExperienceService {
    
    public List<Experience> getExperience();
    
    public void saveExperience(Experience exp);
    
    public void deleteExperience(int id);
    
    public Experience findExperience(int id);
}
