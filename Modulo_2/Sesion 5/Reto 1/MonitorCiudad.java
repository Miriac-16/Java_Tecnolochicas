// Archivo: MonitorCiudad.java
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger; // Para contar semáforos en rojo

/**
 * Simula el sistema de monitoreo en tiempo real de una ciudad inteligente (Meridian Prime).
 * Utiliza Project Reactor para gestionar múltiples flujos de datos asíncronos y no bloqueantes,
 * filtrando eventos críticos y generando alertas.
 */
public class MonitorCiudad {

    private final Random random = new Random();

    /**
     * Simula el flujo de datos de sensores de tráfico.
     * Detecta niveles de congestión y emite alertas si superan el 70%.
     *
     * @return Un Flux de Strings que representan el estado de la congestión.
     */
    public Flux<String> generarFlujoTrafico() {
        return Flux.interval(Duration.ofMillis(500)) // Frecuencia sugerida: cada 500 ms
                .map(tick -> random.nextInt(101)) // Nivel de congestión 0-100%
                .filter(congestion -> congestion > 70) // Filtrar congestión mayor al 70%
                .map(congestion -> "Alerta: Congestión del " + congestion + "% en Avenida Solar")
                // Simulación de backpressure con delayElements para mostrar el efecto
                // Los elementos son emitidos con un pequeño retraso adicional si el suscriptor no puede procesarlos tan rápido.
                .delayElements(Duration.ofMillis(100), Schedulers.boundedElastic())
                .name("trafico-flux") // Nombre para depuración
                .log(); // Para observar el flujo en la consola
    }

    /**
     * Simula el flujo de datos de contaminación del aire.
     * Genera alertas si el nivel de partículas PM2.5 supera los 50 ug/m3.
     *
     * @return Un Flux de Strings que representan el estado de la contaminación.
     */
    public Flux<String> generarFlujoContaminacion() {
        return Flux.interval(Duration.ofMillis(600)) // Frecuencia sugerida: cada 600 ms
                .map(tick -> random.nextInt(100)) // Nivel de partículas PM2.5 (ug/m3)
                .filter(pm25 -> pm25 > 50) // Filtrar contaminación superior a 50 ug/m3
                .map(pm25 -> "Alerta: Contaminación alta (PM2.5: " + pm25 + " ug/m3)")
                .name("contaminacion-flux")
                .log();
    }

    /**
     * Simula el flujo de datos de accidentes viales.
     * Prioriza emergencias según la gravedad del accidente (Baja, Media, Alta).
     *
     * @return Un Flux de Strings que representan los eventos de accidentes.
     */
    public Flux<String> generarFlujoAccidentes() {
        String[] prioridades = {"Baja", "Media", "Alta"};
        return Flux.interval(Duration.ofMillis(800)) // Frecuencia sugerida: cada 800 ms
                .map(tick -> prioridades[random.nextInt(prioridades.length)])
                .filter(prioridad -> "Alta".equals(prioridad)) // Filtrar accidentes con prioridad Alta
                .map(prioridad -> "Emergencia vial: Accidente con prioridad " + prioridad)
                .name("accidentes-flux")
                .log();
    }

    /**
     * Simula el flujo de datos de trenes maglev.
     * Controla la frecuencia y detecta retrasos mayores a 5 minutos.
     *
     * @return Un Flux de Strings que representan los retrasos de trenes.
     */
    public Flux<String> generarFlujoTrenesMaglev() {
        return Flux.interval(Duration.ofMillis(700)) // Frecuencia sugerida: cada 700 ms
                .map(tick -> random.nextInt(15)) // Retraso en minutos (0-10 min, extendido a 14 para más variabilidad)
                .filter(retraso -> retraso > 5) // Filtrar retrasos mayores a 5 minutos
                .map(retraso -> "Tren maglev con retraso crítico: " + retraso + " minutos")
                // Otro ejemplo de backpressure simulado
                .onBackpressureBuffer(10) // Buffer de 10 elementos si el suscriptor no puede procesar
                .name("trenes-flux")
                .log();
    }

    /**
     * Simula el flujo de datos de semáforos inteligentes.
     * Ajusta tiempos según la repetición de señales rojas.
     *
     * @return Un Flux de Strings que representan el estado de los semáforos.
     */
    public Flux<String> generarFlujoSemaforos() {
        AtomicInteger semaforoRojoConsecutivo = new AtomicInteger(0); // Contador para semáforos en rojo consecutivos
        String[] estadosSemaforo = {"Verde", "Amarillo", "Rojo"};
        return Flux.interval(Duration.ofMillis(400)) // Frecuencia sugerida: cada 400 ms
                .map(tick -> {
                    String estado = estadosSemaforo[random.nextInt(estadosSemaforo.length)];
                    if ("Rojo".equals(estado)) {
                        semaforoRojoConsecutivo.incrementAndGet();
                    } else {
                        semaforoRojoConsecutivo.set(0); // Resetear contador si no es rojo
                    }
                    return estado;
                })
                .filter(estado -> "Rojo".equals(estado) && semaforoRojoConsecutivo.get() >= 3) // Filtrar semáforo en rojo más de 3 veces seguidas
                .map(estado -> "Semáforo en Rojo detectado " + semaforoRojoConsecutivo.get() + " veces seguidas en cruce Norte")
                .name("semaforos-flux")
                .log();
    }

    public static void main(String[] args) {
        MonitorCiudad monitor = new MonitorCiudad();

        System.out.println("Iniciando monitoreo de sistemas críticos de Meridian Prime...\n");

        // Parte 5: Implementar suscripciones separadas para cada flujo (usando merge)
        // Se pueden usar suscripciones separadas para cada flujo, o combinarlas con merge.
        // Aquí combinamos todos los flujos en uno solo para una visualización consolidada
        // y para demostrar la emisión de alertas globales.
        Flux<String> todosLosEventosCriticos = Flux.merge(
                monitor.generarFlujoTrafico(),
                monitor.generarFlujoContaminacion(),
                monitor.generarFlujoAccidentes(),
                monitor.generarFlujoTrenesMaglev(),
                monitor.generarFlujoSemaforos()
        );

        // Contar el número de eventos críticos para la alerta global
        AtomicInteger eventosCriticosCount = new AtomicInteger(0);

        // Suscribirse a los eventos críticos y mostrarlos en consola
        todosLosEventosCriticos
            .doOnNext(event -> { // Se ejecuta cada vez que un elemento pasa por aquí
                System.out.println(event); // Emite en consola los eventos críticos detectados con mensajes descriptivos.
                eventosCriticosCount.incrementAndGet(); // Contamos los eventos críticos
            })
            .doOnError(error -> System.err.println("Error en un flujo: " + error.getMessage()))
            .doOnComplete(() -> System.out.println("\nMonitoreo de sistemas críticos finalizado."))
            .subscribe(); // Inicia la suscripción y el flujo de datos

        // Simular que el sistema corre por un tiempo
        try {
            Thread.sleep(15000); // Ejecutar la simulación por 15 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Emitir una alerta global si se detectaron múltiples eventos críticos
        if (eventosCriticosCount.get() > 2) { // Umbral arbitrario para "múltiples"
            System.out.println("\nAlerta global: Múltiples eventos críticos detectados en Meridian Prime");
        } else {
            System.out.println("\nAlerta global: Nivel de eventos críticos bajo. Monitoreo continuo.");
        }

        System.out.println("Simulación de la ciudad inteligente detenida.");
    }
}