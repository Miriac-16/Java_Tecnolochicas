// Archivo: Main.java
package reto1_s4; // Debe coincidir con el paquete de Factura.java

public class Main {
    public static void main(String[] args) {
        // 4. En la clase Main: Actividades

        // Crear dos facturas con el mismo folio pero diferentes clientes o totales
        Factura facturaA = new Factura("FAC001", "Juan Pérez", 1450.0); // cite: Screenshot 2025-06-23 at 11.54.13 p.m..jpg
        Factura facturaB = new Factura("FAC001", "Comercial XYZ", 2000.0); // Mismo folio, diferente cliente/total

        // Mostrar ambas facturas usando toString()
        System.out.println(facturaA);
        System.out.println(facturaB);

        // Comparar si son iguales con equals()
        System.out.println("¿Las facturas son iguales?: " + facturaA.equals(facturaB)); // Debería ser 'true'
    }
}