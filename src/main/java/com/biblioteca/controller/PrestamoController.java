package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




import java.util.List;




@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<?> getPrestamos() {
        List<Prestamo> prestamos = prestamoService.getPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrestamoById(@PathVariable int id){
        Prestamo prestamo = prestamoService.getPrestamoById(id);

        if(prestamo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no encontrado");
        }

        return ResponseEntity.ok(prestamo);
    }

    @PostMapping//crea un nuevos datos de prestamos y guardar un nuevo prestamo
    public ResponseEntity<?> savePrestamo(@RequestBody Prestamo prestamo){
        Prestamo savedPrestamo = prestamoService.savePrestamo(prestamo);
        return new ResponseEntity<>(savedPrestamo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")//actualizar por id
    public ResponseEntity<?> updatePrestamo(@PathVariable int id, @RequestBody Prestamo prestamo){
        prestamo.setIdPrestamo(id);
        Prestamo updated = prestamoService.updatePrestamo(prestamo);

        if(updated == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no encontrado");
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")//eliminar por id 
    public ResponseEntity<?> deletePrestamo(@PathVariable int id){
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build(); // 204
    }
}