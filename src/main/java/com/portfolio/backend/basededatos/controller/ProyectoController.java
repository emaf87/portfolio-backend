/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Proyecto;
import com.portfolio.backend.basededatos.service.IProyectoService;
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

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET,
    RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private IProyectoService iProyectoService;

    @GetMapping
    @ResponseBody
    public List<Proyecto> getProyectos() {
        return iProyectoService.getProyectos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Proyecto findProyecto(@PathVariable int id) {
        return iProyectoService.findProyecto(id);
    }

    @PostMapping
    public String saveProyecto(@RequestBody Proyecto proy) {
        iProyectoService.saveProyecto(proy);
        return "Proyecto guardado";
    }

    @DeleteMapping("/{id}")
    public String deleteProyecto(@PathVariable int id) {
        iProyectoService.deleteProyecto(id);
        return "Proyecto eliminado";
    }

    @PutMapping("/{id}")
    public Proyecto editProyecto(@PathVariable int id,
                                   @RequestBody Proyecto proy) {
        Proyecto nuevoProy = iProyectoService.findProyecto(id);

        nuevoProy.setNombre(proy.getNombre());
        nuevoProy.setImg(proy.getImg());
        nuevoProy.setUrl(proy.getUrl());

        iProyectoService.saveProyecto(nuevoProy);
        return nuevoProy;
    }
}
