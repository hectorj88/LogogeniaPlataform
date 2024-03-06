package com.company.plataformalogogenia.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@JmixEntity
@Table(name = "INDICADOR", indexes = {
        @Index(name = "IDX_INDICADOR_FKIDCOMPETENCIA", columnList = "FK_COMPETENCIA_ID"),
        @Index(name = "IDX_INDICADOR_REPORTE", columnList = "REPORTE_ID")
})
@Entity
public class Indicador {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @Composition
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_COMPETENCIA_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Competencia idCompetencia;

    @PositiveOrZero
    @Max(100)
    @Column(name = "PORCENTAJE_COMPLETADO", nullable = false)
    @NotNull
    private Integer porcentajeCompletado;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "REPORTE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reporte reporte;

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Integer getPorcentajeCompletado() {
        return porcentajeCompletado;
    }

    public void setPorcentajeCompletado(Integer porcentajeCompletado) {
        this.porcentajeCompletado = porcentajeCompletado;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}