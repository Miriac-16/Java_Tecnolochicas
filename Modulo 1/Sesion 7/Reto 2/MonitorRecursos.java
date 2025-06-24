// Archivo: MonitorRecursos.java
package reto2_s7; // Puedes ajustar el nombre del paquete si es necesario

// 1. Clase MonitorRecursos que implementa Runnable
public class MonitorRecursos implements Runnable {
    private String nombreRecurso; // Nombre del recurso a monitorear (CPU, Memoria, Disco)
    private int intervaloMonitoreo; // Intervalo en milisegundos

    // Constructor
    public MonitorRecursos(String nombreRecurso, int intervaloMonitoreo) {
        this.nombreRecurso = nombreRecurso;
        this.intervaloMonitoreo = intervaloMonitoreo;
    }

    // Implementación del método run()
    @Override
    public void run() {
        System.out.println("Iniciando monitoreo de " + nombreRecurso + " con intervalo de " + intervaloMonitoreo + "ms.");
        try {
            while (!Thread.currentThread().isInterrupted()) { // Monitoreo continuo hasta interrupción
                // Simula la lectura de datos del recurso
                double uso = Math.random() * 100; // Valor aleatorio entre 0 y 100
                System.out.printf("[%s] Uso actual: %.2f%%%n", nombreRecurso, uso); // cite: Screenshot 2025-06-24 at 12.08.56 a.m..jpg

                Thread.sleep(intervaloMonitoreo); // Espera el intervalo especificado
            }
        } catch (InterruptedException e) {
            // Manejo de InterruptedException
            System.out.println("Monitoreo de " + nombreRecurso + " ha sido interrumpido."); // cite: Screenshot 2025-06-24 at 12.08.56 a.m..jpg
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción
        }
        System.out.println("Monitoreo de " + nombreRecurso + " finalizado.");
    }
}