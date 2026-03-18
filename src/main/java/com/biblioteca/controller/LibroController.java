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

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/api/v1/libros") //peticion para acceder a la data que le estoy pasando y para ir probando PUT,DELETE,POST,GET .
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getBooks(){
        return libroService.getBooks();
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
