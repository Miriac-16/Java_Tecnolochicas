// Archivo: SistemaNavegacion.java
import java.util.concurrent.Callable;

/**
 * Simula el Subsistema de Navegación de una misión espacial.
 * Se encarga de calcular trayectorias y realizar correcciones orbitales.
 * Implementa Callable para devolver un estado al finalizar su operación.
 */
public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simula un proceso de cálculo complejo.
        Thread.sleep(1500); // Retraso simulado
        return "Navegación: trayectoria corregida con éxito.";
    }
}