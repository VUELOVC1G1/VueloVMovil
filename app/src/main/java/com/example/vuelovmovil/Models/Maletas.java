package com.example.vuelovmovil.Models;

public class Maletas {

    private String peso;
    private int precio;

    public Maletas(String peso, int precio) {
        this.peso = peso;
        this.precio = precio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
