
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
public class PersonalDetails {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String name;
    private String lastname;
    private String degree;
    private String city;
    private String nationality;
    private String aboutMe; 
   
    
    
}
