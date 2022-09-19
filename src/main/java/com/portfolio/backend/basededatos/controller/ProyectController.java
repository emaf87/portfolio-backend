/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Proyect;
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
import com.portfolio.backend.basededatos.service.IProyectService;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET,
    RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/proyect")
public class ProyectController {

    @Autowired
    private IProyectService iProyectService;

    @GetMapping
    @ResponseBody
    public List<Proyect> getProyectos() {
        return iProyectService.getProyects();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Proyect findProyecto(@PathVariable int id) {
        return iProyectService.findProyect(id);
    }

    @PostMapping
    public String saveProyecto(@RequestBody Proyect proy) {
        iProyectService.saveProyect(proy);
        return "Proyecto guardado";
    }

    @DeleteMapping("/{id}")
    public String deleteProyecto(@PathVariable int id) {
        iProyectService.deleteProyect(id);
        return "Proyecto eliminado";
    }

    @PutMapping("/{id}")
    public Proyect editProyect(@PathVariable int id,
                                   @RequestBody Proyect proy) {
        Proyect newProyect = iProyectService.findProyect(id);

        newProyect.setName(proy.getName());
        newProyect.setImage(proy.getImage());
        newProyect.setUrl(proy.getUrl());

        iProyectService.saveProyect(newProyect);
        return newProyect;
    }
}
