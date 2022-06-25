package com.example.vuelovmovil.Models;

public class Asientos {

    private int id;
    private String nombre;
    private int precio;
    private TipoAsiento tipoAsiento;

    public Asientos(int id, String nombre, int precio, TipoAsiento tipoAsiento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoAsiento = tipoAsiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }
}

