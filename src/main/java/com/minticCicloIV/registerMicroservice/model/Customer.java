package com.minticCicloIV.registerMicroservice.model;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private String id_;

    private String username;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String celular;
    private String correo;
    private String barrio;
    private String direccion;
    private Integer idMascota;

    private boolean casapropia;
    private boolean homejob;
    private boolean cuidador;
    private Integer salario;
    private Integer numMascotas;

    private boolean recomendado;

    public Customer(String correo, String username, String nombres, String apellidos, String cedula, String celular, String barrio, String direccion,Integer idMascota, boolean casapropia, boolean homejob, boolean cuidador, Integer salario, Integer numMascotas, boolean recomendado) {
        this.id_  = (username+correo);
        this.correo = correo;
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.celular = celular;
        this.barrio = barrio;
        this.direccion = direccion;
        this.idMascota=idMascota;
        this.casapropia = casapropia;
        this.homejob = homejob;
        this.cuidador = cuidador;
        this.salario = salario;
        this.numMascotas = numMascotas;
        this.recomendado = recomendado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isCasapropia() {
        return casapropia;
    }

    public void setCasapropia(boolean casapropia) {
        this.casapropia = casapropia;
    }

    public boolean isHomejob() {
        return homejob;
    }

    public void setHomejob(boolean homejob) {
        this.homejob = homejob;
    }

    public boolean isCuidador() {
        return cuidador;
    }

    public void setCuidador(boolean cuidador) {
        this.cuidador = cuidador;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getNumMascotas() {
        return numMascotas;
    }

    public void setNumMascotas(Integer numMascotas) {
        this.numMascotas = numMascotas;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }


    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }
}
