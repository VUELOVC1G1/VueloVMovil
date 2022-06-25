package com.example.vuelovmovil.Models;

import com.example.vuelovmovil.Models.Asientos;
import com.example.vuelovmovil.Models.Maletas;
import com.example.vuelovmovil.Models.Pago;

import java.util.List;

public class BoletoObjectClass {

    List<Asientos> asientos;
    private String fecha;
    List<Maletas> maletas;
    Pago pago;
    private int pasajeroId;
    private String qr;
    private int vueloId;

    public BoletoObjectClass(List<Asientos> asientos, String fecha, List<Maletas> maletas, Pago pago, int pasajeroId, String qr, int vueloId) {
        this.asientos = asientos;
        this.fecha = fecha;
        this.maletas = maletas;
        this.pago = pago;
        this.pasajeroId = pasajeroId;
        this.qr = qr;
        this.vueloId = vueloId;
    }

    public List<Asientos> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asientos> asientos) {
        this.asientos = asientos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Maletas> getMaletas() {
        return maletas;
    }

    public void setMaletas(List<Maletas> maletas) {
        this.maletas = maletas;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public int getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(int pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public int getVueloId() {
        return vueloId;
    }

    public void setVueloId(int vueloId) {
        this.vueloId = vueloId;
    }
}
