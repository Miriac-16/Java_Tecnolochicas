// Archivo: OrdenProduccion.java

/**
 * Clase base para todas las Órdenes de Producción en el sistema.
 * Define la estructura fundamental que cada orden debe tener:
 * un código identificador y la cantidad a producir.
 */
public abstract class OrdenProduccion {
    protected String codigo;
    protected int cantidad;

    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    // Métodos para acceder a la información de la orden
    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Este método abstracto asegura que cada tipo de orden
     * pueda presentar su información de manera específica.
     * Es la forma en que cada orden "se muestra" en el sistema.
     */
    public abstract void mostrarResumen();
}