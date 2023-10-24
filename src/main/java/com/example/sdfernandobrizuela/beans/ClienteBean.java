package com.example.sdfernandobrizuela.beans;

import com.example.sdfernandobrizuela.abstracts.AbstractBean;
import com.example.sdfernandobrizuela.interfaces.IClienteBean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteBean extends AbstractBean implements IClienteBean {
    @Column
    private String nombre;
    @Column
    private String ruc;
    @Column
    private String cedula;
    @Column
    private String telefono;
    @Column
    private String email;
    @Column
    private String numeroTarjeta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

}