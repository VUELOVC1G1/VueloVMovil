package com.example.vuelovmovil.sqlite.models;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private Long id;
    private String origen;
    private String destino;
    private Date fechaIda;
    private Date fechaRegreso;
}
