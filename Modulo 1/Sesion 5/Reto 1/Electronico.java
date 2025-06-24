// Archivo: Electronico.java
package reto1_s5; // Debe coincidir con el paquete de Producto.java

// 2. Clase derivada Electronico
public class Electronico extends Producto {
    // Atributo específico de Electrónico
    private int garantiaMeses;

    // Constructor
    public Electronico(String nombre, double precioBase, String idProducto, int garantiaMeses) {
        super(nombre, precioBase, idProducto); // Llama al constructor de la clase base
        this.garantiaMeses = garantiaMeses;
    }

    // Sobreescribir mostrarInformacion() para añadir la garantía
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base
        System.out.println("   Garantía: " + garantiaMeses + " meses.");
    }

    // Sobreescribir calcularPrecioFinal() para añadir impuesto (16% de IVA)
    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.16; // Aplica 16% de IVA
    }
}