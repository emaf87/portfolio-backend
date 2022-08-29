package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Educacion;
import com.portfolio.backend.basededatos.service.IEducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private IEducacionService interEducacion;

    @GetMapping
    @ResponseBody
    public List<Educacion> getEducacion() {
        return interEducacion.getEducacion();
    }

    @GetMapping("/{id}")
    public Educacion getSkill(@PathVariable int id) {
        return interEducacion.findEducacion(id);
    }

    @PostMapping
    public String saveEducacion(@RequestBody Educacion edu) {
        interEducacion.saveEducacion(edu);
        return "Educacion guardada";
    }

    @DeleteMapping("/{id}")
    public String deleteEducacion(@PathVariable int id) {
        interEducacion.deleteEducacion(id);
        return "Educacion eliminada correctamente";
    }

    @PutMapping("/{id}")
    public Educacion updateSkill(@PathVariable int id,
            @RequestBody Educacion edu) {

        Educacion updateEducacion = interEducacion.findEducacion(id);

        updateEducacion.setNivel(edu.getNivel());
        updateEducacion.setTitulo(edu.getTitulo());
        updateEducacion.setInstitucion(edu.getInstitucion());
        updateEducacion.setInicio(edu.getInicio());
        updateEducacion.setFin(edu.getFin());
        updateEducacion.setLogo(edu.getLogo());

        interEducacion.saveEducacion(updateEducacion);
        return updateEducacion;
    }

}
