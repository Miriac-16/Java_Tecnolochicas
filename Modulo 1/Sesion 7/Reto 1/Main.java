// Archivo: Main.java
package reto1_s7; // Debe coincidir con el paquete de ProcesadorPedidos.java

// 2. Clase Main para simular la gestión de pedidos
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando el sistema de procesamiento de pedidos..."); // cite: Screenshot 2025-06-24 at 12.08.25 a.m..jpg

        // Crear y ejecutar múltiples pedidos en hilos separados
        Thread pedido1 = new Thread(new ProcesadorPedidos("001", 3000)); // Pedido 001, 3 segundos
        Thread pedido2 = new Thread(new ProcesadorPedidos("002", 2000)); // Pedido 002, 2 segundos
        Thread pedido3 = new Thread(new ProcesadorPedidos("003", 4000)); // Pedido 003, 4 segundos
        Thread pedido4 = new Thread(new ProcesadorPedidos("004", 1500)); // Pedido 004, 1.5 segundos

        // Iniciar los hilos
        pedido1.start();
        pedido2.start();
        pedido3.start();
        pedido4.start();

        System.out.println("Todos los pedidos han sido enviados para procesamiento asíncrono."); // cite: Screenshot 2025-06-24 at 12.08.25 a.m..jpg

        // Opcional: Esperar a que todos los hilos terminen si se desea (usando .join())
        try {
            pedido1.join();
            pedido2.join();
            pedido3.join();
            pedido4.join();
        } catch (InterruptedException e) {
            System.err.println("El hilo principal fue interrumpido mientras esperaba a los pedidos.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los procesamientos de pedidos han finalizado.");
    }
}