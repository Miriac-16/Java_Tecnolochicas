// Archivo: MaterialCurso.java

/**
 * Clase base abstracta para representar cualquier material dentro de un curso.
 * Define las propiedades fundamentales que todo material debe tener:
 * un título descriptivo y el autor que lo creó.
 */
public abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Métodos para acceder a la información básica del material
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    /**
     * Método abstracto que será implementado por cada subclase
     * para mostrar los detalles específicos de cada tipo de material.
     */
    public abstract void mostrarDetalle();
}