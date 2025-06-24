// Archivo: AeropuertoControl.java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit; // Para usar en sleep y awaitTermination

/**
 * Simula el sistema de control de un aeropuerto internacional.
 * Gestiona de forma asíncrona múltiples verificaciones críticas (pista, clima,
 * tráfico aéreo, personal en tierra) para determinar si un aterrizaje puede ser autorizado.
 * Utiliza CompletableFuture para operaciones paralelas y manejo combinado de resultados.
 */
public class AeropuertoControl {

    /**
     * Simula la verificación de la disponibilidad de la pista.
     * Puede haber ocupación o mantenimiento.
     *
     * @return Un CompletableFuture que indica si la pista está disponible (true) o no (false).
     */
    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001)); // Latencia de 2-3 segundos
                // Simula una posible indisponibilidad de la pista (ej. 10% de probabilidad de false)
                boolean disponible = ThreadLocalRandom.current().nextDouble() > 0.1;
                System.out.println("Pista disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error: Verificación de pista interrumpida.");
                return false; // Si hay interrupción, consideramos la pista no disponible por seguridad
            }
        });
    }

    /**
     * Simula la verificación de las condiciones climáticas.
     * Evalúa factores como tormentas, niebla o vientos fuertes.
     *
     * @return Un CompletableFuture que indica si el clima es favorable (true) o no (false).
     */
    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001)); // Latencia de 2-3 segundos
                // Simula un clima desfavorable ocasional (ej. 15% de probabilidad de false)
                boolean favorable = ThreadLocalRandom.current().nextDouble() > 0.15;
                System.out.println("Clima favorable: " + favorable);
                return favorable;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error: Verificación de clima interrumpida.");
                return false;
            }
        });
    }

    /**
     * Simula la verificación del tráfico aéreo cercano.
     * Se asegura de que no haya otros vuelos aproximándose que puedan interferir.
     *
     * @return Un CompletableFuture que indica si el tráfico aéreo está despejado (true) o no (false).
     */
    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001)); // Latencia de 2-3 segundos
                // Simula tráfico aéreo ocasionalmente no despejado (ej. 5% de probabilidad de false)
                boolean despejado = ThreadLocalRandom.current().nextDouble() > 0.05;
                System.out.println("Tráfico aéreo despejado: " + despejado);
                return despejado;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error: Verificación de tráfico aéreo interrumpida.");
                return false;
            }
        });
    }

    /**
     * Simula la verificación de la disponibilidad del personal en tierra.
     * Esto incluye personal de guía, seguridad, etc.
     *
     * @return Un CompletableFuture que indica si el personal está disponible (true) o no (false).
     */
    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001)); // Latencia de 2-3 segundos
                boolean disponible = ThreadLocalRandom.current().nextDouble() > 0.0; // Siempre true para simular éxito
                System.out.println("Personal disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error: Verificación de personal en tierra interrumpida.");
                return false;
            }
        });
    }

    /**
     * Combina todas las verificaciones de condiciones para autorizar o denegar un aterrizaje.
     * Todas las verificaciones se ejecutan en paralelo. El aterrizaje solo se autoriza
     * si todas las condiciones son óptimas (todas devuelven true).
     * Utiliza allOf para esperar a que todas las tareas se completen.
     *
     * @return Un CompletableFuture<String> que contendrá el mensaje de autorización o denegación.
     */
    public CompletableFuture<String> autorizarAterrizaje() {
        System.out.println("Verificando condiciones para aterrizaje...");

        CompletableFuture<Boolean> pistaCF = verificarPista();
        CompletableFuture<Boolean> climaCF = verificarClima();
        CompletableFuture<Boolean> traficoCF = verificarTraficoAereo();
        CompletableFuture<Boolean> personalCF = verificarPersonalTierra();

        // Parte 3: Combinar los resultados usando allOf y thenApply
        // allOf espera a que TODOS los CompletableFutures dados se completen.
        CompletableFuture<Void> todasLasVerificaciones = CompletableFuture.allOf(
            pistaCF, climaCF, traficoCF, personalCF
        );

        // thenApply se ejecuta cuando 'todasLasVerificaciones' se completa.
        // Dentro de thenApply, obtenemos los resultados individuales.
        return todasLasVerificaciones.thenApply(v -> {
            try {
                boolean pistaOK = pistaCF.join(); // join() es como get() pero no lanza excepciones chequeadas
                boolean climaOK = climaCF.join();
                boolean traficoOK = traficoCF.join();
                boolean personalOK = personalCF.join();

                if (pistaOK && climaOK && traficoOK && personalOK) {
                    return "Aterrizaje autorizado: todas las condiciones óptimas.";
                } else {
                    return "Aterrizaje denegado: condiciones no óptimas.";
                }
            } catch (Exception ex) {
                // Esto maneja excepciones que podrían haber ocurrido en los CF individuales
                // y que join() las propaga como UncheckedExecutionException.
                System.err.println("Error al consolidar resultados de verificación: " + ex.getMessage());
                return "Aterrizaje denegado: error en el sistema de verificación.";
            }
        }).exceptionally(ex -> {
            // Parte 5: Usar exceptionally para manejar cualquier error en el proceso
            // Esto capturará cualquier excepción no manejada anteriormente en el pipeline,
            // incluyendo las que pudieran propagarse desde 'allOf' si alguna tarea subyacente falla.
            System.err.println("Excepción inesperada durante la autorización de aterrizaje: " + ex.getMessage());
            return "Aterrizaje denegado: fallo crítico en el sistema.";
        });
    }

    public static void main(String[] args) {
        AeropuertoControl aeropuerto = new AeropuertoControl();

        // Solicitamos la autorización de aterrizaje de forma asíncrona.
        CompletableFuture<String> mensajeAterrizajeFuture = aeropuerto.autorizarAterrizaje();

        // El hilo principal puede seguir haciendo otras cosas mientras se realizan las verificaciones.
        System.out.println("Esperando autorización de aterrizaje... El sistema está procesando otras solicitudes.");

        // Bloqueamos para obtener el resultado final del aterrizaje.
        try {
            String mensajeFinal = mensajeAterrizajeFuture.get(8, TimeUnit.SECONDS); // Espera máximo 8 segundos
            System.out.println("\n--- Decisión de Aterrizaje ---");
            System.out.println(mensajeFinal);
        } catch (java.util.concurrent.TimeoutException e) {
            System.err.println("La verificación de aterrizaje excedió el tiempo límite.");
        } catch (Exception e) {
            System.err.println("Error al obtener la decisión de aterrizaje: " + e.getMessage());
        }

        System.out.println("Sistema de control de aeropuerto: Proceso de aterrizaje finalizado.");
    }
}