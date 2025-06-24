// Archivo: ProcesadorPedidos.java
package reto1_s7; // Puedes ajustar el nombre del paquete si es necesario

// 1. Clase ProcesadorPedidos que implementa Runnable
public class ProcesadorPedidos implements Runnable {
    private String pedidoId; // Identificador del pedido
    private int duracionProcesamiento; // Duración en milisegundos

    // Constructor
    public ProcesadorPedidos(String pedidoId, int duracionProcesamiento) {
        this.pedidoId = pedidoId;
        this.duracionProcesamiento = duracionProcesamiento;
    }

    // Implementación del método run()
    @Override
    public void run() {
        System.out.println("Iniciando procesamiento del pedido: " + pedidoId + " (duración: " + duracionProcesamiento + "ms)"); // cite: Screenshot 2025-06-24 at 12.08.25 a.m..jpg
        try {
            Thread.sleep(duracionProcesamiento); // Simula el trabajo
        } catch (InterruptedException e) {
            // Manejo de InterruptedException
            System.out.println("El procesamiento del pedido " + pedidoId + " fue interrumpido.");
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción
        }
        System.out.println("Pedido " + pedidoId + " procesado y completado."); // cite: Screenshot 2025-06-24 at 12.08.25 a.m..jpg
    }
}