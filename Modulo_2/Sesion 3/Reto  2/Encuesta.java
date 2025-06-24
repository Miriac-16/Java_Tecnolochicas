// Archivo: Encuesta.java
import java.util.Optional;

/**
 * Representa una encuesta de satisfacción de un paciente.
 * Contiene el nombre del paciente, un comentario opcional y una calificación.
 */
public class Encuesta {
    private String paciente;
    private String comentario; // Puede ser null si no se dejó uno
    private int calificacion;  // Escala del 1 al 5

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    // Métodos para acceder a los atributos de la encuesta
    public String getPaciente() {
        return paciente;
    }

    /**
     * Proporciona el comentario de la encuesta envuelto en un Optional.
     * Facilita el manejo de comentarios ausentes de forma segura.
     *
     * @return Un Optional que contiene el comentario si está presente,
     * o un Optional vacío si es null.
     */
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }

    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return "Encuesta [paciente=" + paciente + ", calificacion=" + calificacion + ", comentario=" + comentario + "]";
    }
}