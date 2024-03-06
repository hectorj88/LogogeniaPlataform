package com.company.plataformalogogenia.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@JmixEntity
@Table(name = "REPORTE", indexes = {
        @Index(name = "IDX_REPORTE_FK_TUTORIA", columnList = "FK_TUTORIA_ID"),
        @Index(name = "IDX_REPORTE_FKPERIODOACADEMICO", columnList = "FK_PERIODO_ACADEMICO_ID")
})
@Entity
public class Reporte {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_TUTORIA_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Tutoria tutoriaId;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_PERIODO_ACADEMICO_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PeriodoAcademico periodoAcademicoId;

    @Column(name = "FECHA_HORA_ENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEnvio;

    @Column(name = "URI_VIDEO_SESION1", nullable = false)
    @NotNull
    private FileRef videoSesion1;

    @Column(name = "URI_VIDEO_SESION2", nullable = false)
    @NotNull
    private FileRef videoSesion2;

    @Column(name = "URI_ESCANEO_SESION1", nullable = false)
    @NotNull
    private FileRef escaneoSesion1;

    @Column(name = "URI_ESCANEO_SESION2", nullable = false)
    @NotNull
    private FileRef escaneoSesion2;

    @Column(name = "RETROALIMENTACION", length = 6000)
    private String retroalimentacion;

    @Column(name = "ULTIMO_CAMBIO_POR", length = 70)
    private String ultimoCambioPor;

    @Composition
    @OneToMany(mappedBy = "reporte", cascade = CascadeType.PERSIST)
    private List<Indicador> indicadores;

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public String getUltimoCambioPor() {
        return ultimoCambioPor;
    }

    public void setUltimoCambioPor(String ultimoCambioPor) {
        this.ultimoCambioPor = ultimoCambioPor;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public FileRef getEscaneoSesion2() {
        return escaneoSesion2;
    }

    public void setEscaneoSesion2(FileRef escaneoSesion2) {
        this.escaneoSesion2 = escaneoSesion2;
    }

    public FileRef getEscaneoSesion1() {
        return escaneoSesion1;
    }

    public void setEscaneoSesion1(FileRef escaneoSesion1) {
        this.escaneoSesion1 = escaneoSesion1;
    }

    public FileRef getVideoSesion2() {
        return videoSesion2;
    }

    public void setVideoSesion2(FileRef videoSesion2) {
        this.videoSesion2 = videoSesion2;
    }

    public FileRef getVideoSesion1() {
        return videoSesion1;
    }

    public void setVideoSesion1(FileRef videoSesion1) {
        this.videoSesion1 = videoSesion1;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public PeriodoAcademico getPeriodoAcademicoId() {
        return periodoAcademicoId;
    }

    public void setPeriodoAcademicoId(PeriodoAcademico periodoAcademicoId) {
        this.periodoAcademicoId = periodoAcademicoId;
    }

    public Tutoria getTutoriaId() {
        return tutoriaId;
    }

    public void setTutoriaId(Tutoria tutoriaId) {
        this.tutoriaId = tutoriaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}