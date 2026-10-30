package com.ces2.trabajo3.repositories;

import com.ces2.trabajo3.modelo.*;
import org.springframework.stereotype.Component;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Component
public class LibroRepository {

    private Stack<Libro> stackLibros;
    private Biblioteca biblioteca;

    public LibroRepository() {
        Libro libro1 = new Libro("Cien años de soledad", "García Márquez", EnumLibro.NOVELA, Categoria.FICCION);
        Libro libro2 = new Libro("Veinte poemas de amor", "Pablo Neruda", EnumLibro.POESIA, Categoria.FICCION);
        Libro libro3 = new Libro("Crónica de una muerte anunciada", "García Márquez", EnumLibro.CRONICA, Categoria.NO_FICCION);
        Libro libro4 = new Libro("El principito", "Saint-Exupéry", EnumLibro.CUENTO, Categoria.LITERATURA_INFANTIL);
        Libro libro5 = new Libro("El amor en los tiempos del cólera", "García Márquez", EnumLibro.NOVELA, Categoria.FICCION);

        libro1.agregarConteo(10);
        libro1.agregarConteo(20);
        libro1.agregarConteo(30);

        libro2.agregarConteo(5);
        libro2.agregarConteo(15);

        libro3.agregarConteo(8);

        libro4.agregarConteo(12);
        libro4.agregarConteo(25);
        libro4.agregarConteo(40);
        libro4.agregarConteo(50);

        libro5.agregarConteo(18);
        libro5.agregarConteo(22);

        stackLibros = new Stack<>();
        stackLibros.push(libro1);
        stackLibros.push(libro2);
        stackLibros.push(libro3);
        stackLibros.push(libro4);
        stackLibros.push(libro5);

        biblioteca = new Biblioteca("Biblioteca CES2", EnumLibro.NOVELA, Categoria.FICCION);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
    }

    public Stack<Libro> getStackLibros() {
        return stackLibros;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public List<String> iterarStack() {
        List<String> resultados = new ArrayList<>();
        ListIterator<Libro> listIterator = stackLibros.listIterator();

        while (listIterator.hasNext()) {
            Libro libro = listIterator.next();
            String info = "📚 Título: " + libro.getTitulo() + 
                          " | Autor: " + libro.getAutor() + 
                          " | Tipo: " + libro.getTipo() + 
                          " | Categoría: " + libro.getCategoria() + 
                          " | Datos en Stack: " + libro.getConteo();
            resultados.add(info);
        }
        return resultados;
    }

    public List<String> iterarDeque() {
        List<String> resultados = new ArrayList<>();
        Iterator<Libro> iterator = biblioteca.getLibros().iterator();

        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            String info = "🏛️ Título: " + libro.getTitulo() + 
                          " | Autor: " + libro.getAutor() + 
                          " | Tipo: " + libro.getTipo() + 
                          " | Categoría: " + libro.getCategoria();
            resultados.add(info);
        }
        return resultados;
    }

    public List<String> filtrarPorEnum() {
        Deque<Libro> dequeDeLibros = new ArrayDeque<>(stackLibros);

        return dequeDeLibros.stream()
                .filter(libro -> libro.getTipo() == EnumLibro.NOVELA)
                .map(libro -> "🔍 Filtro Enum (NOVELA): " + libro.getTitulo() + 
                              " | Autor: " + libro.getAutor() + 
                              " | Categoría: " + libro.getCategoria())
                .collect(Collectors.toList());
    }
}