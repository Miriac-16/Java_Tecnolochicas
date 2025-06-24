// Archivo: ProfesionalMedicoTarea.java

/**
 * Clase que representa la tarea de un profesional médico intentando
 * utilizar un RecursoMedico específico.
 * Implementa Runnable para ser ejecutada en un hilo separado.
 */
public class ProfesionalMedicoTarea implements Runnable {
    private final String nombreProfesional;
    private final RecursoMedico recurso;

    public ProfesionalMedicoTarea(String nombreProfesional, RecursoMedico recurso) {
        this.nombreProfesional = nombreProfesional;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        // El hilo actual representa al profesional y llama al método 'usar' del recurso.
        recurso.usar(nombreProfesional);
    }
}