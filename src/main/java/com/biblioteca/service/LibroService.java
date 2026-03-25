package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getBooks(){
        return libroRepository.getAllBooks();
    }

    public Libro saveBook(Libro libro){
        return libroRepository.save(libro);

    }

    public Libro getBookById(int id){
        return libroRepository.getBookByid(id);
    }


    public Libro getBookByIsbn(String isbn){
        return libroRepository.getBookByisbn(isbn);
    }



    public Libro updateBook(Libro libro){
        return libroRepository.updateLibro(libro);
    }

    public String deleteBook(int id){
        libroRepository.deleteBook(id);
        return "Producto eliminado";
    }

    //metodo para obtener libro
    public int totalLibrosV1(){
        return libroRepository.getAllBooks().size();
    }
    
    //metodo para el total de libros
    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    //tiene que estar en el service porque es logica 
    //metodo para cantidad de libros en un año especifico 
    public long countBookByYear(int anio) {
        return libroRepository.getAllBooks().stream()
            .filter(libro -> libro.getFechaPublicacion() == anio)
            .count();
    }

    //optional es un contenedor de resultado que indican un valor nos ayuda a prevenir el null exception
    //metodo libro mas antiguo (menor año de publicacion)
    public Optional<Libro> getOldestBook(){
        return libroRepository.getAllBooks().stream()
                .min(Comparator.comparingInt(Libro::getFechaPublicacion));
            
    }

    //metodo adicional retorna un mapa con la cantidad de libros por año,fecha de publicacion
    public Map<Integer, Long> countBookByYearGrouped(){
        return libroRepository.getAllBooks().stream()
                .collect(Collectors.groupingBy(
                    Libro::getFechaPublicacion,
                    Collectors.counting()
                ));
    }

}
