// Archivo: Main.java
package reto2_s7; // Debe coincidir con el paquete de MonitorRecursos.java

// 2. Clase Main para probar el monitoreo
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema de monitoreo de recursos...");

        // Crear dos hilos de monitoreo con diferentes recursos e intervalos
        Thread monitorCPU = new Thread(new MonitorRecursos("CPU", 1000)); // Monitoreo de CPU cada 1 segundo
        Thread monitorMemoria = new Thread(new MonitorRecursos("Memoria", 2000)); // Monitoreo de Memoria cada 2 segundos

        // Iniciar los hilos
        monitorCPU.start();
        monitorMemoria.start();

        // Demostrar cómo detener el monitoreo después de un tiempo específico
        try {
            // Dejar que los monitores se ejecuten por 5 segundos
            System.out.println("\nEl monitoreo se ejecutará por 5 segundos. Esperando...");
            Thread.sleep(5500); // Un poco más de 5 segundos para asegurar algunas lecturas

            // Interrumpir los hilos para detener el monitoreo
            System.out.println("\nDeteniendo el monitoreo...");
            monitorCPU.interrupt();
            monitorMemoria.interrupt();

            // Esperar a que los hilos terminen completamente
            monitorCPU.join();
            monitorMemoria.join();
        } catch (InterruptedException e) {
            System.err.println("El hilo principal fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Sistema de monitoreo de recursos finalizado.");
    }
}