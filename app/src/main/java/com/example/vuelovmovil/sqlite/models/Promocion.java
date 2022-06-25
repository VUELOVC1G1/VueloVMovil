package com.example.vuelovmovil.sqlite.models;

import java.io.Serializable;
import java.util.Date;

public class Promocion implements Serializable {
    private Long id;
    private String descripcion;
    private int descuento;
    private double precio;
    private String fechaVuelo;
    private String rutaDescripcion;
    private String origen;
    private String destino;

    public Promocion() {
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getRutaDescripcion() {
        return rutaDescripcion;
    }

    public void setRutaDescripcion(String rutaDescripcion) {
        this.rutaDescripcion = rutaDescripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
