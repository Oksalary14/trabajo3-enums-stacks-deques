package com.ces2.trabajo3.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Libro {
    private String titulo;
    private String autor;

    private EnumLibro tipo;
    private Categoria categoria;

    private Stack<Integer> conteo;

    public Libro() {
        this.conteo = new Stack<>();
    }

    public Libro(String titulo, String autor, EnumLibro tipo, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setTipo(EnumLibro tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public void agregarConteo(int valor) {
        this.conteo.push(valor);
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public EnumLibro getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Stack<Integer> getConteo() { return conteo; }

    public void verTotales(Function<Libro, Integer> funcionSuma) {
        int total = funcionSuma.apply(this);
        System.out.println(" [Consola] El total de datos enteros del libro '" + titulo + "' es: " + total);
    }
}