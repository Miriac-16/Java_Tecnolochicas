// Archivo: Video.java

/**
 * Representa un material de curso de tipo Video.
 * Además del título y autor, incluye la duración en minutos.
 */
public class Video extends MaterialCurso {
    private int duracionMinutos;

    public Video(String titulo, String autor, int duracionMinutos) {
        super(titulo, autor);
        this.duracionMinutos = duracionMinutos;
    }

    // Método para obtener la duración del video
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("  Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracionMinutos + " min");
    }
}