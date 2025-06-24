// Archivo: Tarea.java
package reto2_s6; // Debe coincidir con el paquete de las excepciones

// 1. Clase Tarea
public class Tarea {
    // Atributos
    private String descripcion;
    private boolean completada; // true si está completa, false si está pendiente

    // Constructor
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false; // Por defecto, una tarea nueva no está completada
    }

    // Métodos getter
    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    // Método setter para el estado de completada
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "- " + descripcion + " [" + (completada ? "Completada" : "Pendiente") + "]";
    }
}