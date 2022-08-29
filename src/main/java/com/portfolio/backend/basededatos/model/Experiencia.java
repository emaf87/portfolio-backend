
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
public class Experiencia {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exp;
    @Basic
    private String puesto;
    private String empresa;
    private String inicio;
    private String fin;
    private String logo;
}
