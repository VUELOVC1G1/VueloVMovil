package com.example.vuelovmovil.Models;


import com.example.vuelovmovil.dataObjectClass;

public class MainObjectClass {

    private String cedula;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private dataObjectClass usuario;

    public MainObjectClass(String cedula, String nombre, String apellido, String fechaNacimiento, dataObjectClass usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public dataObjectClass getUsuario() {
        return usuario;
    }

    public void setUsuario(dataObjectClass usuario) {
        this.usuario = usuario;
    }
}
