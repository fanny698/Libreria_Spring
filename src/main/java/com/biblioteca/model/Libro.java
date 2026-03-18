package com.biblioteca.model; // con new java class se crea este paquete automaticamente

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Libro {

    private int id;
    private String isbn; //identificador unico que tienen los libros
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;


}
