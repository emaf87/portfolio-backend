
package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Skills;
import com.portfolio.backend.basededatos.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService{
    
    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public List<Skills> getSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public void saveSkill(Skills skill) {
        skillsRepository.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public Skills findSkill(int id) {
        return skillsRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSkillsList(List<Skills> skillList) {
        skillsRepository.saveAll(skillList);
    }
}
