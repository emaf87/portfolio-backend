package com.portfolio.backend.basededatos.controller;

import com.portfolio.backend.basededatos.model.Datos;
import com.portfolio.backend.basededatos.service.IDatosService;
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
@RequestMapping("/datos")
public class DatosController {

    @Autowired
    private IDatosService interDatos;

    @GetMapping
    @ResponseBody
    public List<Datos> getDatos() {
        return interDatos.getDatos();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Datos getDato(@PathVariable int id){
        
        Datos data =  interDatos.findDato(id);
        return data;
    }

    @PostMapping
    @ResponseBody
    public String saveDatos(@RequestBody Datos data) {
        interDatos.saveDatos(data);
        return "datos guardados";
    }
    
    @DeleteMapping("/{id}")
    public String deleteDato(@PathVariable int id){
        interDatos.deleteDatos(id);
        return "Dato eliminado";
    }
    
    @PutMapping("/{id}")
    public Datos updateDato(@PathVariable int id,
            @RequestBody Datos data){
        
        Datos updateDato = interDatos.findDato(id);
        
        updateDato.setNombre(data.getNombre());
        updateDato.setApellido(data.getApellido());
        updateDato.setCiudad(data.getCiudad());
        updateDato.setAcercade(data.getAcercade());
        updateDato.setNacionalidad(data.getNacionalidad());
        updateDato.setTitulo(data.getTitulo());
        
        interDatos.saveDatos(updateDato);
        return updateDato;
    }
    
}
