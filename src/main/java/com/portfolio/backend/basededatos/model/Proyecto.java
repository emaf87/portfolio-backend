package com.portfolio.backend.basededatos.model;

import com.sun.istack.NotNull;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @NotNull
    private String nombre;
    @NotNull
    private String url;
    @NotNull
    private String img;
}
