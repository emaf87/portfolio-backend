package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Education;
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
import com.portfolio.backend.basededatos.service.IEducationService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private IEducationService iEducationService;

    @GetMapping
    @ResponseBody
    public List<Education> getEducaction() {
        return iEducationService.getEducation();
    }

    @GetMapping("/{id}")
    public Education getEducation(@PathVariable int id) {
        return iEducationService.findEducation(id);
    }

    @PostMapping
    public String saveEducation(@RequestBody Education edu) {
        iEducationService.saveEducation(edu);
        return "Educacion guardada";
    }

    @DeleteMapping("/{id}")
    public String deleteEducacion(@PathVariable int id) {
        iEducationService.deleteEducation(id);
        return "Educacion eliminada correctamente";
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable int id,
            @RequestBody Education edu) {

        Education updateEducacion = iEducationService.findEducation(id);

        updateEducacion.setGrade(edu.getGrade());
        updateEducacion.setDegree(edu.getDegree());
        updateEducacion.setInstitution(edu.getInstitution());
        updateEducacion.setStarted(edu.getStarted());
        updateEducacion.setEnded(edu.getEnded());
        updateEducacion.setLogo(edu.getLogo());

        iEducationService.saveEducation(updateEducacion);
        return updateEducacion;
    }
    
    @PutMapping("/savelist")
    public String saveEducationList(@RequestBody List<Education> eduList){
        iEducationService.saveEducationList(eduList);
        return "Lista guardada";
    }

}
