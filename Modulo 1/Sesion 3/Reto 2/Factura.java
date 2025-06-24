// Archivo: Factura.java
package reto2_s3; // Puedes ajustar el nombre del paquete si es necesario

import java.util.Optional; // Para manejar el RFC opcional

public class Factura {
    // Atributos privados aplicando encapsulación
    private double monto; // Cantidad total de la factura
    private String descripcion; // Breve concepto de lo facturado
    private Optional<String> rfc; // RFC del cliente (puede estar presente o no)

    // Constructor público
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        // Si el RFC es null, debe almacenarse usando Optional.empty()
        this.rfc = Optional.ofNullable(rfc);
    }

    // Método público getResumen()
    public String getResumen() {
        String rfcString = rfc.isPresent() ? rfc.get() : "[No proporcionado]"; // cite: Screenshot 2025-06-23 at 11.50.12 p.m..jpg
        return "Factura generada:\n" + // cite: Screenshot 2025-06-23 at 11.50.25 p.m..jpg
               "Descripción: " + descripcion + "\n" + // cite: Screenshot 2025-06-23 at 11.50.25 p.m..jpg
               "Monto: $" + String.format("%.1f", monto) + "\n" + // Formato a un decimal para que coincida con el ejemplo
               "RFC: " + rfcString; // cite: Screenshot 2025-06-23 at 11.50.25 p.m..jpg
    }

    // Opcional: Podrías añadir getters para los atributos si fueran necesarios para otros propósitos.
    // Aunque el reto pide encapsulación, el método getResumen() es el principal para la salida.
    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Optional<String> getRfc() {
        return rfc;
    }
}