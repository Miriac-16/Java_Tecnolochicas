// Archivo: MonitorUCI.java
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.Random;

/**
 * Simula un sistema reactivo de monitoreo de signos vitales en una Unidad de Cuidados Intensivos (UCI).
 * Genera datos continuos para múltiples pacientes, filtra valores críticos
 * (Frecuencia Cardíaca, Presión Arterial, Nivel de Oxígeno), aplica backpressure
 * para controlar el flujo y emite alertas en consola para eventos anómalos.
 */
public class MonitorUCI {

    private final Random random = new Random();

    /**
     * Simula la generación continua de datos de signos vitales para un paciente.
     * Cada paciente emite datos cada 300 ms con valores aleatorios para FC, PA y SpO2.
     *
     * @param idPaciente El ID único del paciente.
     * @return Un Flux de Strings que representan los signos vitales del paciente.
     */
    public Flux<String> generarFlujoSignosVitales(int idPaciente) {
        return Flux.interval(Duration.ofMillis(300), Schedulers.parallel()) // Frecuencia sugerida: cada 300 ms
                .map(tick -> {
                    // Simular valores aleatorios para FC, PA y SpO2
                    int fc = 60 + random.nextInt(80); // FC: 60-139 bpm
                    int paSistolica = 90 + random.nextInt(70); // PA: 90-159 mmHg
                    int paDiastolica = 60 + random.nextInt(40); // PA: 60-99 mmHg
                    int spo2 = 85 + random.nextInt(15); // SpO2: 85-99%

                    String data = "Paciente " + idPaciente + ": FC=" + fc + " bpm, PA=" + paSistolica + "/" + paDiastolica + " mmHg, SpO2=" + spo2 + "%";
                    return new SignosVitales(idPaciente, fc, paSistolica, paDiastolica, spo2);
                })
                // Parte 2: Filtrar los eventos críticos con las condiciones dadas
                .filter(sv -> { // Filtra valores críticos
                    // Frecuencia cardíaca: < 50 o > 120 bpm
                    boolean fcCritica = sv.getFc() < 50 || sv.getFc() > 120;
                    // Presión arterial: < 90/60 mmHg o > 140/90 mmHg
                    boolean paCritica = (sv.getPaSistolica() < 90 || sv.getPaDiastolica() < 60) ||
                                        (sv.getPaSistolica() > 140 || sv.getPaDiastolica() > 90);
                    // Oxígeno en sangre: < 90%
                    boolean spo2Critica = sv.getSpo2() < 90;
                    return fcCritica || paCritica || spo2Critica;
                })
                // Parte 4: Mostrar alertas en consola para eventos críticos
                .map(sv -> {
                    StringBuilder alerta = new StringBuilder("⚠️ Paciente " + sv.getIdPaciente() + " - ");
                    if (sv.getFc() < 50 || sv.getFc() > 120) {
                        alerta.append("FC crítica: ").append(sv.getFc()).append(" bpm ");
                    }
                    if ((sv.getPaSistolica() < 90 || sv.getPaDiastolica() < 60) ||
                        (sv.getPaSistolica() > 140 || sv.getPaDiastolica() > 90)) {
                        alerta.append("PA crítica: ").append(sv.getPaSistolica()).append("/").append(sv.getPaDiastolica()).append(" mmHg ");
                    }
                    if (sv.getSpo2() < 90) {
                        alerta.append("SpO2 baja: ").append(sv.getSpo2()).append("% ");
                    }
                    return alerta.toString().trim();
                })
                .name("paciente-" + idPaciente + "-flux") // Nombre para depuración
                .log(); // Para observar el flujo en la consola
    }

    /**
     * Clase interna para representar los signos vitales de un paciente.
     * Facilita el paso de datos entre las operaciones del Flux.
     */
    private static class SignosVitales {
        private final int idPaciente;
        private final int fc;
        private final int paSistolica;
        private final int paDiastolica;
        private final int spo2;

        public SignosVitales(int idPaciente, int fc, int paSistolica, int paDiastolica, int spo2) {
            this.idPaciente = idPaciente;
            this.fc = fc;
            this.paSistolica = paSistolica;
            this.paDiastolica = paDiastolica;
            this.spo2 = spo2;
        }

        public int getIdPaciente() { return idPaciente; }
        public int getFc() { return fc; }
        public int getPaSistolica() { return paSistolica; }
        public int getPaDiastolica() { return paDiastolica; }
        public int getSpo2() { return spo2; }
    }

    public static void main(String[] args) {
        MonitorUCI monitor = new MonitorUCI();

        System.out.println("Iniciando monitoreo de signos vitales en UCI...\n");

        // Simular generación continua de datos para 3 pacientes
        Flux<String> flujoPaciente1 = monitor.generarFlujoSignosVitales(1);
        Flux<String> flujoPaciente2 = monitor.generarFlujoSignosVitales(2);
        Flux<String> flujoPaciente3 = monitor.generarFlujoSignosVitales(3);

        // Fusionar los flujos de todos los pacientes en un solo flujo de alertas.
        // Parte 3: Aplicar backpressure con delayElements() para procesar eventos críticos a un ritmo más lento (1 seg).
        Flux.merge(flujoPaciente1, flujoPaciente2, flujoPaciente3)
            .delayElements(Duration.ofSeconds(1), Schedulers.boundedElastic()) // Procesar eventos críticos a 1 seg
            .doOnNext(System.out::println) // Mostrar alertas en consola
            .doOnError(error -> System.err.println("Error en el flujo de monitoreo: " + error.getMessage()))
            .doOnComplete(() -> System.out.println("\nMonitoreo de signos vitales finalizado."))
            .subscribe(); // Iniciar la suscripción

        // Mantener la aplicación en ejecución para que los flujos sigan emitiendo
        try {
            Thread.sleep(20000); // Simular el monitoreo por 20 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nSistema de monitoreo de UCI detenido.");
    }
}