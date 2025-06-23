// Archivo: OrdenMasa.java

/**
 * Representa una Orden de Producción en Masa.
 * Son los productos estándar, generados en grandes volúmenes.
 */
public class OrdenMasa extends OrdenProduccion {

    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("  Orden en Masa - Código: " + codigo + " - Cantidad: " + cantidad);
    }
}