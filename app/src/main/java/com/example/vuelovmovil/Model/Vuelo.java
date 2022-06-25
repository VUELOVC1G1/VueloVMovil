package com.example.vuelovmovil.Model;

public class Vuelo {

    private int id;
    private String fechaCreacion;
    private int precio;
    private String observacion;
    private String fechaVuelo;
    private boolean estado;
    private HorarioResponse horarioResponse;
    private RutaResponse rutaResponse;
    private TipoVueloResponse tipoVueloResponse;

    public int getId() {
        return id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public HorarioResponse getHorarioResponse() {
        return horarioResponse;
    }

    public RutaResponse getRutaResponse() {
        return rutaResponse;
    }

    public TipoVueloResponse getTipoVueloResponse() {
        return tipoVueloResponse;
    }
}
