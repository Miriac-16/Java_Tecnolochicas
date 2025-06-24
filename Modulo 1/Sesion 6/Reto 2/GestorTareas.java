// Archivo: GestorTareas.java
package reto2_s6; // Debe coincidir con el paquete de Tarea.java y las excepciones

import java.util.ArrayList; // Para la lista de tareas
import java.util.List; // Para usar la interfaz List

// 1. Clase GestorTareas
public class GestorTareas {
    private List<Tarea> tareas; // Usa ArrayList para almacenar tareas

    // Constructor
    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    // Método agregarTarea()
    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea '" + descripcion + "' agregada.");
    }

    // Método marcarTareaCompletada()
    public void marcarTareaCompletada(String descripcion) throws TareaNoEncontradaException, TareaYaCompletadaException {
        Tarea tareaEncontrada = null;
        for (Tarea tarea : tareas) {
            if (tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
                tareaEncontrada = tarea;
                break;
            }
        }

        if (tareaEncontrada == null) { // Si la tarea no existe
            throw new TareaNoEncontradaException("La tarea '" + descripcion + "' no fue encontrada.");
        }

        if (tareaEncontrada.isCompletada()) { // Si la tarea ya está completada
            throw new TareaYaCompletadaException("La tarea '" + descripcion + "' ya está marcada como completada.");
        }

        tareaEncontrada.setCompletada(true);
        System.out.println("Tarea '" + descripcion + "' marcada como completada.");
    }

    // Método eliminarTarea()
    public void eliminarTarea(String descripcion) throws TareaNoEncontradaException {
        Tarea tareaAEliminar = null;
        for (Tarea tarea : tareas) {
            if (tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
                tareaAEliminar = tarea;
                break;
            }
        }

        if (tareaAEliminar == null) { // Si la tarea no existe
            throw new TareaNoEncontradaException("La tarea '" + descripcion + "' no fue encontrada para eliminar.");
        }

        tareas.remove(tareaAEliminar);
        System.out.println("Tarea '" + descripcion + "' eliminada.");
    }

    // Método para listar todas las tareas (útil para verificar el estado)
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
        } else {
            System.out.println("\n--- Lista de Tareas ---");
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }
}