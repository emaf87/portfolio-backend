package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Skills;
import com.portfolio.backend.basededatos.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})

public class SkillsController {

    @Autowired
    private ISkillsService iSkillsService;

    @GetMapping
    @ResponseBody
    public List<Skills> getSkills() {
        return iSkillsService.getSkills();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Skills getSkill(@PathVariable int id) {
        return iSkillsService.findSkill(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseBody
    public String saveSkill(@RequestBody Skills skill) {
        iSkillsService.saveSkill(skill);
        return "Skill guardado";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteSkill(@PathVariable int id) {
        iSkillsService.deleteSkill(id);
        return "Skill eliminado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Skills updateSkill(@PathVariable int id,
            @RequestBody Skills skill) {
        Skills updateSkill = iSkillsService.findSkill(id);
        updateSkill.setName(skill.getName());
        updateSkill.setValue(skill.getValue());
        iSkillsService.saveSkill(updateSkill);
        return updateSkill;
    }

    @PutMapping("/savelist")
    public String saveEducationList(@RequestBody List<Skills> expList) {
        iSkillsService.saveSkillsList(expList);
        return "Lista guardada";
    }

}
