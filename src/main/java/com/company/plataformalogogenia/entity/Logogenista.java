package com.company.plataformalogogenia.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "LOGOGENISTA", indexes = {
        @Index(name = "IDX_LOGOGENISTA_FK_ID_CUENTA", columnList = "FK_ID_CUENTA")
})
@Entity
public class Logogenista {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @Column(name = "NOMBRES", nullable = false, length = 40)
    @NotNull
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 40)
    @NotNull
    private String apellidos;

    @Column(name = "TELEFONO", length = 22)
    private String telefono;

    @Column(name = "CORREO", nullable = false, length = 80)
    @NotNull
    private String correo;

    @Column(name = "PAIS", nullable = false, length = 110)
    @NotNull
    private String pais;

    @Column(name = "CIUDAD", nullable = false, length = 110)
    @NotNull
    private String ciudad;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "FK_ID_CUENTA", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User idCuenta;

    public User getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(User idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}