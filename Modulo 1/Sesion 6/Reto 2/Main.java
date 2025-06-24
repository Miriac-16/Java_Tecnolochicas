// Archivo: Main.java
package reto2_s6; // Debe coincidir con el paquete de GestorTareas.java y las excepciones

public class Main {
    public static void main(String[] args) {
        // 3. En la clase Main: Actividades

        // Crear una instancia de GestorTareas
        GestorTareas gestor = new GestorTareas();

        // Agregar algunas tareas
        gestor.agregarTarea("Comprar víveres");
        gestor.agregarTarea("Preparar presentación");
        gestor.agregarTarea("Llamar a Juan");

        gestor.listarTareas();

        // Caso 1: Marcar una tarea existente como completada
        try {
            System.out.println("\n--- Intentando marcar 'Comprar víveres' como completada ---");
            gestor.marcarTareaCompletada("Comprar víveres");
            gestor.listarTareas();
        } catch (TareaNoEncontradaException | TareaYaCompletadaException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Caso 2: Intentar marcar una tarea ya completada
        try {
            System.out.println("\n--- Intentando marcar 'Comprar víveres' de nuevo como completada ---");
            gestor.marcarTareaCompletada("Comprar víveres"); // Debería lanzar TareaYaCompletadaException
            gestor.listarTareas();
        } catch (TareaNoEncontradaException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (TareaYaCompletadaException e) {
            System.err.println("Error al marcar tarea: " + e.getMessage()); // Captura TareaYaCompletadaException
        }

        // Caso 3: Intentar marcar una tarea que no existe
        try {
            System.out.println("\n--- Intentando marcar 'Pagar facturas' como completada (no existe) ---");
            gestor.marcarTareaCompletada("Pagar facturas"); // Debería lanzar TareaNoEncontradaException
            gestor.listarTareas();
        } catch (TareaNoEncontradaException e) {
            System.err.println("Error al marcar tarea: " + e.getMessage()); // Captura TareaNoEncontradaException
        } catch (TareaYaCompletadaException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Caso 4: Eliminar una tarea existente
        try {
            System.out.println("\n--- Intentando eliminar 'Llamar a Juan' ---");
            gestor.eliminarTarea("Llamar a Juan");
            gestor.listarTareas();
        } catch (TareaNoEncontradaException e) {
            System.err.println("Error al eliminar tarea: " + e.getMessage());
        }

        // Caso 5: Intentar eliminar una tarea que no existe
        try {
            System.out.println("\n--- Intentando eliminar 'Hacer ejercicio' (no existe) ---");
            gestor.eliminarTarea("Hacer ejercicio"); // Debería lanzar TareaNoEncontradaException
            gestor.listarTareas();
        } catch (TareaNoEncontradaException e) {
            System.err.println("Error al eliminar tarea: " + e.getMessage()); // Captura TareaNoEncontradaException
        }
    }
}