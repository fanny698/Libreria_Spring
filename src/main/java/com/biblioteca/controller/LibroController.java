package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping ("/api/v1/libros") //peticion para acceder a la data que le estoy pasando y para ir probando PUT,DELETE,POST,GET .
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<?> getBooks(){//ya no va a ser lista por si sola , ahora es con responseentity(onjeto de respuesta que quiero enviar ) adelante 
        List<Libro> libros = libroService.getBooks();
        Map<String,Object> response = new HashMap<>(); //llave objeto
        if(libros == null || libros.isEmpty()){
           
            response.put("timestamp",LocalDateTime.now());
            response.put("status",HttpStatus.NO_CONTENT.value());
            response.put("message", "No hay libros registrados");
            response.put("data", "null");//es mejor enviar lista vacia 
            return ResponseEntity.ok(response);
        }
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("data", libros);//es mejor enviar lista vacia 
        return ResponseEntity.ok(response);
        
    }

    // si hago la misma ruta de raiz localhost:8080/api/v1/libros y se le agrega un 1 ,este busca solo 1 libro no todos 
    @GetMapping("{id}")//obtener
    public Libro getBookById(@PathVariable int id){
        return libroService.getBookById(id);
    }
    
    @PostMapping //guardar /insert
    public Libro saveBook(@RequestBody Libro libro){
        return libroService.saveBook(libro);
    }
    
    
    @PutMapping("{id}") //editar/actualizar
    public Libro updateBook(@PathVariable int id,@RequestBody Libro libro){
        return libroService.updateBook(libro);
    }
    
    @DeleteMapping("{id}")//eliminar 
    public String delteBook(@PathVariable int id){
        return libroService.deleteBook(id);
    }


}
