package com.company.plataformalogogenia.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JmixEntity
@Table(name = "PERIODO_ACADEMICO", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_PERIODO_ACADEMICO_UNQ", columnNames = {"FECHA_INICIO"}),
        @UniqueConstraint(name = "IDX_PERIODO_ACADEMICO_UNQ_1", columnNames = {"FECHA_FIN"}),
        @UniqueConstraint(name = "IDX_PERIODO_ACADEMICO_UNQ_2", columnNames = {"NOMBRE"})
})
@Entity
public class PeriodoAcademico {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaInicio;

    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaFin;

    @Column(name = "NOMBRE", nullable = false)
    @NotNull
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}