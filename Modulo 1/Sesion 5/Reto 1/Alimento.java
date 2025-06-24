// Archivo: Alimento.java
package reto1_s5; // Debe coincidir con el paquete de Producto.java

import java.time.LocalDate; // Para manejar fechas

// 2. Clase derivada Alimento
public class Alimento extends Producto {
    // Atributo específico de Alimento
    private LocalDate fechaCaducidad;

    // Constructor
    public Alimento(String nombre, double precioBase, String idProducto, LocalDate fechaCaducidad) {
        super(nombre, precioBase, idProducto); // Llama al constructor de la clase base
        this.fechaCaducidad = fechaCaducidad;
    }

    // Sobreescribir mostrarInformacion() para añadir la fecha de caducidad
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base
        System.out.println("   Fecha de Caducidad: " + fechaCaducidad);
    }

    // Sobreescribir calcularPrecioFinal() para aplicar descuento si está cerca de caducar
    @Override
    public double calcularPrecioFinal() {
        LocalDate hoy = LocalDate.now();
        // Si la fecha de caducidad es en 7 días o menos, aplica 20% de descuento
        if (fechaCaducidad.isBefore(hoy.plusDays(7)) || fechaCaducidad.isEqual(hoy.plusDays(7))) {
            return precioBase * 0.80; // 20% de descuento
        }
        return precioBase;
    }
}