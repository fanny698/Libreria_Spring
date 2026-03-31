package com.biblioteca.service;


import com.biblioteca.model.Prestamo;
import com.biblioteca.repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> getPrestamos(){
        return prestamoRepository.getAllPrestamos();
    }

    public Prestamo getPrestamoById(int id){
        return prestamoRepository.getPrestamoById(id);

    }

    public Prestamo updatePrestamo(Prestamo prestamo){
        return prestamoRepository.updatePrestamo(prestamo);
    }

    public void deletePrestamo(int id){
        prestamoRepository.deletePrestamo(id);
    }


    public Prestamo savePrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);

    }


}
