// Archivo: SistemaSoporteVital.java
import java.util.concurrent.Callable;

/**
 * Simula el Subsistema de Soporte Vital.
 * Monitorea la presión, el oxígeno y las condiciones internas de la nave.
 * Su objetivo es asegurar el bienestar de la tripulación.
 */
public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simula la verificación de parámetros vitales.
        Thread.sleep(1000); // Retraso simulado
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}