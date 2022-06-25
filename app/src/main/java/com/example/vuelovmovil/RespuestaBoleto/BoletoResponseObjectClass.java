package com.example.vuelovmovil.RespuestaBoleto;

import com.example.vuelovmovil.Models.Asientos;
import com.example.vuelovmovil.Models.Maletas;
import com.example.vuelovmovil.Model.Vuelo;
import com.example.vuelovmovil.Models.Pago;
import com.example.vuelovmovil.Response.MainResponseObjectClass;

import java.util.List;

public class BoletoResponseObjectClass {

    private String id;
    private String fecha;
    private String qr;
    private Pago pago;
    List<Maletas> maletas;
    List<Asientos> asientos;
    MainResponseObjectClass pasajero;
    Vuelo vuelo;



    public BoletoResponseObjectClass(String id, String fecha, String qr, Pago pago, List<Maletas> maletas, List<Asientos> asientos, MainResponseObjectClass pasajero, Vuelo vuelo) {
        this.id = id;
        this.fecha = fecha;
        this.qr = qr;
        this.pago = pago;
        this.maletas = maletas;
        this.asientos = asientos;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getQr() {
        return qr;
    }

    public Pago getPago() {
        return pago;
    }

    public List<Maletas> getMaletas() {
        return maletas;
    }

    public List<Asientos> getAsientos() {
        return asientos;
    }

    public MainResponseObjectClass getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
}
