
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
public class Experience {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exp;
    @Basic
    private String job;
    private String company;
    private String started;
    private String ended;
    private String logo;
}
