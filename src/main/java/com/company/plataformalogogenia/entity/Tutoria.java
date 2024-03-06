package com.company.plataformalogogenia.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JmixEntity
@Table(name = "TUTORIA", indexes = {
        @Index(name = "IDX_TUTORIA_FK_LOGOGENISTA", columnList = "FK_LOGOGENISTA_ID"),
        @Index(name = "IDX_TUTORIA_FK_ALUMNO", columnList = "FK_ALUMNO_ID")
})
@Entity
public class Tutoria {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_LOGOGENISTA_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Logogenista logogenistaId;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_ALUMNO_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Alumno alumnoId;

    @Column(name = "ESTADO", nullable = false, length = 50)
    @NotNull
    private String estado;

    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaInicio;

    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Logogenista getLogogenistaId() {
        return logogenistaId;
    }

    public void setLogogenistaId(Logogenista logogenistaId) {
        this.logogenistaId = logogenistaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}