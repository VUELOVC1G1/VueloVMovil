package com.example.vuelovmovil.Models;

public class Pago {
    private boolean estado;
    private String tipo;
    private double valor;

    public Pago(boolean estado, String tipo, double valor) {
        this.estado = estado;
        this.tipo = tipo;
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
