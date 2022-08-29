
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Skills;
import java.util.List;


public interface ISkillsService {
    
    public List<Skills> getSkills();
    
    public void saveSkill(Skills skill);
    
    public void deleteSkill(int id);
    
    public Skills findSkill(int id);
}
