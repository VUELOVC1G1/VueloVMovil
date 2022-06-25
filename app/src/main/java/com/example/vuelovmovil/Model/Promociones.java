package com.example.vuelovmovil.Model;

public class Promociones {

    private int id;
    private String descripcion;
    private int descuento;
    private Vuelo vuelo;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
}
