// Archivo: SistemaControlTermico.java
import java.util.concurrent.Callable;

/**
 * Simula el Subsistema de Control Térmico.
 * Supervisa las temperaturas internas y externas de la nave,
 * crucial para evitar sobrecalentamientos o congelaciones.
 */
public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simula el ajuste y monitoreo de la temperatura.
        Thread.sleep(1200); // Retraso simulado
        return "Control térmico: temperatura estable (22°C).";
    }
}