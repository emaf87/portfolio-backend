package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Experience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.portfolio.backend.basededatos.service.IExperienceService;

@CrossOrigin(origins = "https://miporfolio-eaf.web.app/", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    @Autowired
    private IExperienceService iExperienceService;

    @GetMapping
    @ResponseBody
    public List<Experience> getExperiencia() {
        return iExperienceService.getExperience();
    }
    
    @GetMapping("/{id}")
    public Experience getExperiencia(@PathVariable int id){
        return iExperienceService.findExperience(id);
    }

    @PostMapping
    public String saveExperiencia(@RequestBody Experience exp) {
        iExperienceService.saveExperience(exp);
        return "Experiencia guardada";
    }
    
    @DeleteMapping("/{id}")
    public String deleteExperiencia(@PathVariable int id){
        iExperienceService.deleteExperience(id);
        return "Experiencia eliminada";
    }
    
    @PutMapping("/{id}")
    public Experience updateExperiencia(@PathVariable int id,
            @RequestBody Experience exp){
        
        Experience updateExperiencia = iExperienceService.findExperience(id);
        
        updateExperiencia.setJob(exp.getJob());
        updateExperiencia.setCompany(exp.getCompany());
        updateExperiencia.setStarted(exp.getStarted());
        updateExperiencia.setEnded(exp.getEnded());
        updateExperiencia.setLogo(exp.getLogo());
        
        iExperienceService.saveExperience(updateExperiencia);
        
        return updateExperiencia;
    }
    
     @PutMapping("/savelist")
    public String saveEducationList(@RequestBody List<Experience> expList){
        iExperienceService.saveExperieceList(expList);
        return "Lista guardada";
    }
}
