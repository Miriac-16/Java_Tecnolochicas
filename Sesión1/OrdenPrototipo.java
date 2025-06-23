// Archivo: OrdenPrototipo.java

/**
 * Representa una Orden de Producción de Tipo Prototipo.
 * Son las órdenes que se encuentran en fase de desarrollo o prueba.
 */
public class OrdenPrototipo extends OrdenProduccion {
    private String faseDesarrollo; // Ej. "Diseño", "Pruebas", "Refinamiento"

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    // Método para obtener la fase actual de desarrollo del prototipo
    public String getFaseDesarrollo() {
        return faseDesarrollo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("  Orden Prototipo - Código: " + codigo + " - Cantidad: " + cantidad + " - Fase: " + faseDesarrollo);
    }
}