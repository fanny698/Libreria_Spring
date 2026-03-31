package com.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.biblioteca.model.Prestamo;

import jakarta.annotation.PostConstruct;

@Repository
public class PrestamoRepository {
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    @PostConstruct
    public void init(){
        // datos de prueba opcionales
        listaPrestamos.add(new Prestamo(1, 1, "12345678-9", null, null, 7, 0));
        listaPrestamos.add(new Prestamo(2, 2, "98765432-1", null, null, 5, 0));
    }

    // obtener todos
    public List<Prestamo> getAllPrestamos(){
        return listaPrestamos;
    }

    // obtener por id
    public Prestamo getPrestamoById(int id){
        for(Prestamo p : listaPrestamos){
            if(p.getIdPrestamo() == id){
                return p;
            }
        }
        return null;
    }

    // guardar
    public Prestamo save(Prestamo prestamo){
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    // actualizar
    public Prestamo updatePrestamo(Prestamo prestamo){

        for(int i = 0; i < listaPrestamos.size(); i++){
            if(listaPrestamos.get(i).getIdPrestamo() == prestamo.getIdPrestamo()){
                listaPrestamos.set(i, prestamo);
                return prestamo;
            }
        }
        return null;//retorna null si no se encuentra el prestamo a actualizar
    }

    // eliminar
    public void deletePrestamo(int id){
        listaPrestamos.removeIf(p -> p.getIdPrestamo() == id);
    }

}
