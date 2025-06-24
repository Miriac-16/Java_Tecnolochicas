// Archivo: RecursoMedico.java
import java.util.concurrent.locks.ReentrantLock;

/**
 * Representa un Recurso Médico crítico dentro de una instalación hospitalaria,
 * como una sala de cirugía o un equipo especializado.
 * Utiliza ReentrantLock para asegurar que solo un profesional médico
 * pueda acceder y utilizar el recurso a la vez, evitando conflictos.
 */
public class RecursoMedico {
    private final String nombre; // Nombre del recurso (ej. "Sala de cirugía")
    private final ReentrantLock bloqueoRecurso = new ReentrantLock(); // El candado para el acceso exclusivo

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Simula el uso del recurso médico por parte de un profesional.
     * Este método gestiona la entrada, el tiempo de uso simulado y la salida del recurso,
     * asegurando la exclusividad mediante ReentrantLock.
     *
     * @param profesional El nombre del profesional que intenta usar el recurso.
     */
    public void usar(String profesional) {
        // Adquirimos el bloqueo. Si el recurso ya está en uso, el hilo espera aquí.
        bloqueoRecurso.lock();
        try {
            // Confirmación de entrada al recurso
            System.out.println(profesional + " ha ingresado a " + nombre);

            // Simulación del tiempo de uso del recurso
            // El tiempo varía para simular diferentes procedimientos
            long tiempoUso = (long) (Math.random() * 1500) + 500; // Entre 500 y 2000 ms
            Thread.sleep(tiempoUso);

            // Confirmación de salida del recurso
            System.out.println(profesional + " ha salido de " + nombre);

        } catch (InterruptedException e) {
            // Manejo de interrupciones durante el uso del recurso
            System.err.println(profesional + " fue interrumpido mientras usaba " + nombre + ": " + e.getMessage());
            Thread.currentThread().interrupt(); // Reestablece el estado de interrupción
        } finally {
            // Es CRÍTICO liberar el bloqueo en el bloque finally para asegurar
            // que se libera incluso si ocurre una excepción.
            bloqueoRecurso.unlock();
        }
    }
}