package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Experiencia;
import com.portfolio.backend.basededatos.service.IExperienciaService;
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

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;

    @GetMapping
    @ResponseBody
    public List<Experiencia> getExperiencia() {
        return interExperiencia.getExperiencias();
    }
    
    @GetMapping("/{id}")
    public Experiencia getExperiencia(@PathVariable int id){
        return interExperiencia.findExperiencia(id);
    }

    @PostMapping
    public String saveExperiencia(@RequestBody Experiencia exp) {
        interExperiencia.saveExperiencia(exp);
        return "Experiencia guardada";
    }
    
    @DeleteMapping("/{id}")
    public String deleteExperiencia(@PathVariable int id){
        interExperiencia.deleteExperiencia(id);
        return "Experiencia eliminada";
    }
    
    @PutMapping("/{id}")
    public Experiencia updateExperiencia(@PathVariable int id,
            @RequestBody Experiencia exp){
        
        Experiencia updateExperiencia = interExperiencia.findExperiencia(id);
        
        updateExperiencia.setPuesto(exp.getPuesto());
        updateExperiencia.setEmpresa(exp.getEmpresa());
        updateExperiencia.setInicio(exp.getInicio());
        updateExperiencia.setFin(exp.getFin());
        updateExperiencia.setLogo(exp.getLogo());
        
        interExperiencia.saveExperiencia(updateExperiencia);
        
        return updateExperiencia;
    }
}
