// Archivo: Producto.java
package reto1_s6; // Debe coincidir con el paquete de las excepciones

// 1. Clase Producto
public class Producto {
    // Atributos
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Método comprar()
    public void comprar(int cantidad) throws StockInsuficienteException, CantidadInvalidaException {
        // Lanza CantidadInvalidaException si la cantidad es menor o igual a 0
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad a comprar debe ser mayor que cero.");
        }
        // Lanza StockInsuficienteException si no hay stock suficiente
        if (this.stock < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente para " + nombre + ". Stock actual: " + stock + ", solicitado: " + cantidad);
        }
        this.stock -= cantidad;
        System.out.println("Compra de " + cantidad + " unidades de " + nombre + " realizada con éxito. Stock restante: " + stock);
    }

    // Método reponer()
    public void reponer(int cantidad) throws CantidadInvalidaException {
        // Lanza CantidadInvalidaException si la cantidad es menor o igual a 0
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad a reponer debe ser mayor que cero.");
        }
        this.stock += cantidad;
        System.out.println("Repuestas " + cantidad + " unidades de " + nombre + ". Stock actual: " + stock);
    }

    // Getters para mostrar información (opcional, pero útil para la depuración)
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: $" + String.format("%.2f", precio) + ", Stock: " + stock;
    }
}