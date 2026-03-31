package com.biblioteca.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Prestamo {
    private int idLibro;
    private int idPrestamo;
    private String runSolicitante;
    private Date fechaSolicitud;
    private Date fechaEntrega;
    private int cantidadDias;
    private int multas = 0;

}
