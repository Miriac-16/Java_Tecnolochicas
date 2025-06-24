// Archivo: Producto.java
package reto1_s5; // Puedes ajustar el nombre del paquete si es necesario

// 1. Clase base Producto
public class Producto {
    // Atributos protegidos para que las subclases puedan acceder directamente
    protected String nombre;
    protected double precioBase;
    protected String idProducto;

    // Constructor
    public Producto(String nombre, double precioBase, String idProducto) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.idProducto = idProducto;
    }

    // Método para mostrar información del producto
    public void mostrarInformacion() {
        System.out.println("ID: " + idProducto + ", Nombre: " + nombre + ", Precio Base: $" + String.format("%.2f", precioBase));
    }

    // Método a ser sobreescrito por las subclases
    public double calcularPrecioFinal() {
        return precioBase; // Por defecto, el precio final es el precio base
    }
}