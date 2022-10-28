/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Project;
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

@CrossOrigin(origins = "https://miporfolio-eaf.web.app/", methods = {RequestMethod.DELETE, RequestMethod.GET,
    RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/proyect")
public class ProyectController {

    @Autowired
    private IProyectService iProyectService;

    @GetMapping
    @ResponseBody
    public List<Project> getProyectos() {
        return iProyectService.getProjects();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Project findProyecto(@PathVariable int id) {
        return iProyectService.findProject(id);
    }

    @PostMapping
    public String saveProyecto(@RequestBody Project proy) {
        iProyectService.saveProject(proy);
        return "Proyecto guardado";
    }

    @DeleteMapping("/{id}")
    public String deleteProyecto(@PathVariable int id) {
        iProyectService.deleteProject(id);
        return "Proyecto eliminado";
    }

    @PutMapping("/{id}")
    public Project editProyect(@PathVariable int id,
                                   @RequestBody Project proy) {
        Project newProyect = iProyectService.findProject(id);

        newProyect.setName(proy.getName());
        newProyect.setDescription(proy.getDescription());
        newProyect.setDate(proy.getDate());
        newProyect.setImage(proy.getImage());
        newProyect.setUrl(proy.getUrl());

        iProyectService.saveProject(newProyect);
        return newProyect;
    }
    
    @PutMapping("/savelist")
    public String saveEducationList(@RequestBody List<Project> projList) {
        iProyectService.saveProjectsList(projList);
        return "Lista guardada";
    }
}
