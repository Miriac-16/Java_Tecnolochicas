// Archivo: Factura.java
package reto1_s4; // Puedes ajustar el nombre del paquete si es necesario

import java.util.Objects; // Necesario para Objects.hash y Objects.equals en equals/hashCode

public class Factura {
    // Atributos de la clase Factura
    private String folio;
    private String cliente;
    private double total;

    // Constructor con parámetros para inicializar todos los atributos
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Método toString() para mostrar la información de la factura
    @Override
    public String toString() {
        // Formato: Factura [folio=..., cliente=..., total=$...]
        return "Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // Método equals() para que dos facturas se consideren iguales si tienen el mismo folio
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        // La comparación se basa únicamente en el folio
        return Objects.equals(folio, factura.folio);
    }

    // Método hashCode() basado en el atributo folio
    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    // Opcional: Métodos getter para acceder a los atributos si fuera necesario
    public String getFolio() {
        return folio;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}