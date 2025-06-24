// Archivo: OrdenPersonalizada.java

/**
 * Representa una Orden de Producción Personalizada.
 * Estas órdenes son únicas y se adaptan a los requerimientos de un cliente específico.
 */
public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    // Método para obtener el nombre del cliente asociado a la orden
    public String getCliente() {
        return cliente;
    }

    /**
     * Este método simula la aplicación de un costo adicional
     * por la personalización de la orden.
     * En un escenario real, esto podría modificar un atributo de costo interno.
     */
    public void agregarCostoAdicional(int costo) {
        // Lógica para añadir costo (aquí solo se simula en la salida)
    }

    @Override
    public void mostrarResumen() {
        System.out.println("  Orden Personalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }
}