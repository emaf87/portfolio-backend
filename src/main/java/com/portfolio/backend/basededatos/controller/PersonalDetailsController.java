package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.PersonalDetails;
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
import com.portfolio.backend.basededatos.service.IPersonalDetailsService;

@CrossOrigin(origins = "https://miporfolio-eaf.web.app/*", methods = {RequestMethod.DELETE, RequestMethod.GET,
   RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/personaldetails")
public class PersonalDetailsController {

    @Autowired
    private IPersonalDetailsService iPersonalDetailsService;

    @GetMapping
    @ResponseBody
    public List<PersonalDetails> getPersonalDetails() {
        return iPersonalDetailsService.getPersonalDetails();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public PersonalDetails getPersonalDetails(@PathVariable int id){
        
        PersonalDetails data =  iPersonalDetailsService.findPersonalDetails(id);
        return data;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseBody
    public String savePersonalDetails(@RequestBody PersonalDetails data) {
        iPersonalDetailsService.savePersonalDetails(data);
        return "datos guardados";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deletePersonalDetails(@PathVariable int id){
        iPersonalDetailsService.deletePersonalDetails(id);
        return "Dato eliminado";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public PersonalDetails updatePersonalDetails(@PathVariable int id,
            @RequestBody PersonalDetails data){
        
        PersonalDetails updateDato = iPersonalDetailsService.findPersonalDetails(id);
        
        updateDato.setName(data.getName());
        updateDato.setLastname(data.getLastname());
        updateDato.setCity(data.getCity());
        updateDato.setAboutMe(data.getAboutMe());
        updateDato.setNationality(data.getNationality());
        updateDato.setDegree(data.getDegree());
        
        iPersonalDetailsService.savePersonalDetails(updateDato);
        return updateDato;
    }
    
}
