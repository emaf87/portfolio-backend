
package com.portfolio.backend.basededatos.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Educacion {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_edu;
    @Basic
    private String nivel;
    private String titulo;
    private String institucion;
    private String inicio;
    private String  fin;
    private String logo;
}
