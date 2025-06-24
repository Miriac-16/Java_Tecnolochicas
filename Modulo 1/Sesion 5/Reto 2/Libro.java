// Archivo: Libro.java
package reto2_s5; // Debe coincidir con el paquete de Prestable.java

// 1. Crea una clase Libro
public class Libro implements Prestable { // Implementa la interfaz Prestable
    // Atributos privados
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado; // Estado de préstamo del libro

    // Constructor
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false; // Inicialmente, no está prestado
    }

    // Método para mostrar información del libro
    // Sobreescribe este método para incluir si está prestado o no.
    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible")); // Muestra el estado de préstamo
    }

    // Implementación de los métodos de la interfaz Prestable
    @Override
    public void prestar() {
        if (!prestado) {
            this.prestado = true;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' ya está prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            this.prestado = false;
            System.out.println("El libro '" + titulo + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + titulo + "' no estaba prestado.");
        }
    }

    // Opcional: Getters si fueran necesarios para otros propósitos
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }
}