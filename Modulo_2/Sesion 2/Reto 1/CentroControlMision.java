// Archivo: CentroControlMision.java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit; // Para usar shutdown y awaitTermination

/**
 * Clase principal que simula el Centro de Control de una Misión Espacial.
 * Coordina la ejecución paralela de varios subsistemas críticos
 * utilizando programación concurrente con ExecutorService y Future.
 */
public class CentroControlMision {

    public static void main(String[] args) {
        System.out.println("Simulación de misión espacial iniciada...");

        // Parte 2: Ejecutar tareas con ExecutorService
        // Creamos un pool de hilos con 4 hilos, uno por cada subsistema.
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista para almacenar los objetos Future, que representarán el resultado
        // de la ejecución de cada subsistema.
        List<Future<String>> resultadosFuturos = new ArrayList<>();

        try {
            // Enviamos cada subsistema como una tarea al ExecutorService.
            // submit() devuelve un Future, que podemos usar para obtener el resultado más tarde.
            System.out.println("Iniciando subsistemas en paralelo...");
            resultadosFuturos.add(executor.submit(new SistemaComunicaciones()));
            resultadosFuturos.add(executor.submit(new SistemaSoporteVital()));
            resultadosFuturos.add(executor.submit(new SistemaControlTermico()));
            resultadosFuturos.add(executor.submit(new SistemaNavegacion()));

            // Parte 3: Mostrar los resultados al finalizar
            // Recuperamos los resultados de cada subsistema cuando estén disponibles.
            // Future.get() es un método bloqueante, espera hasta que la tarea termine.
            System.out.println("\nReportes de los subsistemas:");
            for (Future<String> future : resultadosFuturos) {
                try {
                    String resultado = future.get(); // Obtiene el resultado de la tarea
                    System.out.println(resultado);
                } catch (Exception e) {
                    System.err.println("Error al obtener el resultado de un subsistema: " + e.getMessage());
                }
            }

            System.out.println("\nTodos los subsistemas reportan estado operativo.");

        } finally {
            // Es crucial apagar el ExecutorService cuando ya no se necesite.
            // Esto evita que los hilos sigan activos y libera recursos.
            executor.shutdown(); // Inicia el apagado, no acepta nuevas tareas.

            try {
                // Esperamos un tiempo prudencial para que todas las tareas en curso finalicen.
                // Si no terminan en este tiempo, se cierran forzosamente.
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println("Algunos subsistemas no terminaron a tiempo. Forzando cierre.");
                    executor.shutdownNow(); // Intenta detener todas las tareas en ejecución.
                }
            } catch (InterruptedException ie) {
                // Si el hilo actual es interrumpido mientras espera, forzamos el cierre.
                System.err.println("Interrupción durante el apagado del ExecutorService. Forzando cierre.");
                executor.shutdownNow();
                Thread.currentThread().interrupt(); // Reestablece el estado de interrupción.
            }
        }
    }
}