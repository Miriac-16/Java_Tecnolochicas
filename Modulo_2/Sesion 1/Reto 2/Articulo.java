// Archivo: Articulo.java

/**
 * Representa un material de curso de tipo Artículo.
 * Contiene el número de palabras como un atributo adicional.
 */
public class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    // Método para obtener el conteo de palabras del artículo
    public int getPalabras() {
        return palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("  Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras);
    }
}