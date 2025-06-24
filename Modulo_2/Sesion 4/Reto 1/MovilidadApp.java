// Archivo: MovilidadApp.java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom; // Para simular latencias variadas
import java.util.concurrent.TimeUnit; // Para usar en sleep

/**
 * Simula una aplicación de movilidad que gestiona solicitudes de viaje.
 * Utiliza CompletableFuture para realizar operaciones asíncronas y no bloqueantes,
 * como el cálculo de ruta y la estimación de tarifa, y luego combina sus resultados
 * para una notificación al usuario.
 */
public class MovilidadApp {

    /**
     * Simula el cálculo de la ruta óptima entre un origen y un destino.
     * Esta operación es asíncrona y tiene una latencia simulada.
     *
     * @return Un CompletableFuture que eventualmente contendrá la ruta calculada.
     */
    public CompletableFuture<String> calcularRuta() {
        System.out.println("Calculando ruta...");
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula la latencia de 2 a 3 segundos
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reestablece el estado de interrupción
                return "Error: Cálculo de ruta interrumpido.";
            }
            return "Ruta: Centro -> Norte";
        });
    }

    /**
     * Simula la estimación de la tarifa del viaje, considerando distancia y demanda.
     * Esta operación también es asíncrona con una latencia simulada.
     *
     * @return Un CompletableFuture que eventualmente contendrá la tarifa estimada.
     */
    public CompletableFuture<Double> estimarTarifa() {
        System.out.println("Estimando tarifa...");
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula la latencia de 1 a 2 segundos
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 2001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reestablece el estado de interrupción
                return 0.0; // En caso de interrupción, retorna una tarifa base o error
            }
            return 75.50; // Valor fijo para la simulación
        });
    }

    /**
     * Combina las operaciones asíncronas de cálculo de ruta y estimación de tarifa.
     * Una vez que ambas operaciones completan su ejecución, se genera un mensaje
     * de confirmación para el usuario.
     *
     * @return Un CompletableFuture que, al completarse, generará el mensaje final
     * para el usuario.
     */
    public CompletableFuture<String> combinarOperacionesYNotificar() {
        // Obtenemos los CompletableFuture para las tareas individuales
        CompletableFuture<String> futureRuta = calcularRuta();
        CompletableFuture<Double> futureTarifa = estimarTarifa();

        // Parte 2: Encadenar las operaciones usando thenCombine
        // thenCombine ejecuta una función cuando AMBOS CompletableFutures se completan.
        CompletableFuture<String> resultadoFinal = futureRuta.thenCombine(futureTarifa, (ruta, tarifa) -> {
            // Este bloque se ejecuta cuando tanto la ruta como la tarifa están disponibles
            return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
        }).exceptionally(ex -> {
            // Manejo de errores: Si alguna de las operaciones anteriores falla,
            // este bloque capturará la excepción y retornará un mensaje de error.
            System.err.println("Ocurrió un error en el proceso asíncrono: " + ex.getMessage());
            return "Error en la solicitud de viaje: Por favor, inténtalo de nuevo.";
        });

        return resultadoFinal;
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();

        // Iniciamos el proceso asíncrono y obtenemos un CompletableFuture<String>
        // que representa el mensaje final que se mostrará al usuario.
        CompletableFuture<String> mensajeUsuarioFuture = app.combinarOperacionesYNotificar();

        // Podemos hacer otras cosas aquí mientras las tareas se ejecutan en segundo plano.
        System.out.println("Procesando otras solicitudes de usuarios...");
        // Simular que el hilo principal está ocupado
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Bloqueamos el hilo principal solo para obtener el resultado final
        // Esto se haría en una aplicación real cuando el resultado es necesario para la UI o siguiente paso.
        try {
            String mensajeFinal = mensajeUsuarioFuture.get(); // get() bloquea hasta que el Future se completa
            System.out.println("\n--- Notificación al Usuario ---");
            System.out.println(mensajeFinal);
        } catch (Exception e) {
            System.err.println("No se pudo obtener el mensaje final: " + e.getMessage());
        }

        System.out.println("Aplicación de movilidad: Proceso completado.");
    }
}