// Archivo: Principal.java
package reto1_s5; // Debe coincidir con el paquete de Producto.java, Electronico.java, Alimento.java

import java.time.LocalDate; // Necesario para LocalDate

// 3. Clase Principal para probar las clases
public class Principal {
    public static void main(String[] args) {
        // Crear instancias de Electronico y Alimento
        Electronico laptop = new Electronico("Laptop Ultra", 1200.00, "EL001", 24); // cite: Screenshot 2025-06-23 at 11.58.36 p.m..jpg
        Alimento leche = new Alimento("Leche Entera", 35.50, "AL001", LocalDate.now().plusDays(5)); // Caduca en 5 días (aplica descuento)
        Alimento pan = new Alimento("Pan Integral", 40.00, "AL002", LocalDate.now().plusMonths(1)); // No aplica descuento

        // Mostrar información y precio final de cada producto
        System.out.println("--- Información de Productos ---");

        System.out.println("\nProducto Electrónico:");
        laptop.mostrarInformacion();
        System.out.printf("   Precio Final (con IVA): $%.2f%n", laptop.calcularPrecioFinal()); // cite: Screenshot 2025-06-23 at 11.58.36 p.m..jpg

        System.out.println("\nProducto Alimento (cerca de caducar):");
        leche.mostrarInformacion();
        System.out.printf("   Precio Final (con descuento): $%.2f%n", leche.calcularPrecioFinal()); // cite: Screenshot 2025-06-23 at 11.58.36 p.m..jpg

        System.out.println("\nProducto Alimento (no cerca de caducar):");
        pan.mostrarInformacion();
        System.out.printf("   Precio Final: $%.2f%n", pan.calcularPrecioFinal());
    }
}