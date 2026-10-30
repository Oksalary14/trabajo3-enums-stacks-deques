package com.ces2.trabajo3.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Biblioteca {
    private String nombre;

    private EnumLibro tipo;
    private Categoria categoria;

    private Deque<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayDeque<>();
    }

    public Biblioteca(String nombre, EnumLibro tipo, Categoria categoria) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.libros = new ArrayDeque<>();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(EnumLibro tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public String getNombre() { return nombre; }
    public EnumLibro getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Deque<Libro> getLibros() { return libros; }
}