
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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_edu;
    @Basic
    private int rowIndex;
    private String grade;
    private String degree;
    private String institution;
    private String started;
    private String ended;
    private String logo;
}
