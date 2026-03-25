package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;// con este se crea la interface ,el jpa se encarga se hacer las conexiones,como trabajamos con lista no se necesita hacer la interface normal
import java.util.List;

@Repository
public class LibroRepository {
    //arreglo para guardar los libros 
    private List<Libro> listaLibros = new ArrayList<>();

    //metodo para inicializar los datos ficticios
    @PostConstruct
    public void init(){
        listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch"));
        listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new Libro(4,"978-0132350884","Clean Code","Prentice Hall",2008,"Robert C.Martin"));
    }

    //metodo que retorna todos los libros.
    public List<Libro> getAllBooks(){//retorna una lista pero operador list busco lista de libros.
        return listaLibros; //retorna toda la lista de libros.
    }

    //metodo que retorne un libro por su id
    public Libro getBookByid(int id){//retorna solo 1 libro
        for(Libro libro : listaLibros){//variable libro ,le paso el primer libro despues el 2 y asi
            if(libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    //metodo  que retorna un libro por su isbn, comparacion con string
    //equals comparo cadenas de texto
    //ia china deepseek 

    public Libro getBookByisbn(String isbn){
        for(Libro libro : listaLibros){
            if(libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    
    }

    //metodo para guardar un libro

    public Libro save(Libro libro){ //tambien se puede poner lib xd
        listaLibros.add(libro);
        return libro;
    }

    //metodo para actualizar un libro

    public Libro updateLibro(Libro lib){
        int id = 0; // el id del libro
        int idPosicion = 0; //posicion del libro que quiero actualizar 

        //primero vamos a buscar el libro
        for(int i = 0;i<listaLibros.size();i++){
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();// el id libro
                idPosicion = i;//posicion
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        
        listaLibros.set(idPosicion, libro1); //le paso la posicion del objeto que quiero cambiar 
        return libro1;
    }


    //metodo para eliminar un libro
    public void deleteBook(int id){
        //alternativa 1
        Libro libro = getBookByid(id);//primero se busca si hay un libro para eliminar si no encuentra nada da error
        if (libro != null){//si es que el libro es distinto a libro va el null
            listaLibros.remove(libro);
        }
        
        //alternativa 2
        int idPosicion = 0;
        for (int i = 0; i<listaLibros.size();i++){
            if (listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;//con break me rompe el ciclo y sale
            }
        }
        if(idPosicion > 0){
            listaLibros.remove(idPosicion);
        }

        //alternativa 3,esta es como mejor
        //colback es una funcion que s epasa por parametros,un  objeto y funcion se puede pasar 
        listaLibros.removeIf(x -> x.getId() == id);
    }

    
    //metodo total libros
    public int totalLibros(){
        return listaLibros.size();
    }
    
    

}
