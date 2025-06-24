// Archivo: Ejercicio.java

/**
 * Representa un material de curso de tipo Ejercicio.
 * Incluye un estado booleano para indicar si ha sido revisado o no.
 */
public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado) {
        super(titulo, autor);
        this.revisado = revisado;
    }

    // Método para obtener el estado de revisión del ejercicio
    public boolean isRevisado() {
        return revisado;
    }

    // Método para marcar el ejercicio como revisado
    public void marcarComoRevisado() {
        this.revisado = true;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("  Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}