package com.company.plataformalogogenia.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JmixEntity
@Table(name = "ALUMNO")
@Entity
public class Alumno {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @Column(name = "NOMBRES", nullable = false, length = 70)
    @NotNull
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 70)
    @NotNull
    private String apellidos;

    @Column(name = "TELEFONO", length = 22)
    private String telefono;

    @Email
    @Column(name = "CORREO", length = 110)
    private String correo;

    @Column(name = "PAIS", nullable = false, length = 110)
    @NotNull
    private String pais;

    @Column(name = "CIUDAD", nullable = false, length = 110)
    @NotNull
    private String ciudad;

    @Column(name = "DIAGNOSTICO", length = 110)
    private String diagnostico;

    @Column(name = "INSTITUCION_EDUCATIVA", length = 150)
    private String institucionEducativa;

    @Column(name = "GRADO_ESCOLAR", length = 110)
    private String gradoEscolar;

    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGradoEscolar() {
        return gradoEscolar;
    }

    public void setGradoEscolar(String gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
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