// Archivo: Main.java
package reto2_s5; // Debe coincidir con el paquete de Libro.java y Prestable.java

public class Main {
    public static void main(String[] args) {
        // 3. En la clase Main: Actividades

        // Crea una instancia de Libro
        Libro miLibro = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728"); // cite: Screenshot 2025-06-23 at 11.59.31 p.m..jpg

        System.out.println("--- Estado inicial del libro ---");
        miLibro.mostrarInfo(); // Muestra la información y el estado inicial

        // Presta el libro
        System.out.println("\n--- Intentando prestar el libro ---");
        miLibro.prestar();

        // Muestra la información después del préstamo
        System.out.println("\n--- Estado del libro después del préstamo ---");
        miLibro.mostrarInfo();

        // Intenta prestar el libro de nuevo (debería mostrar mensaje de que ya está prestado)
        System.out.println("\n--- Intentando prestar el libro de nuevo ---");
        miLibro.prestar();

        // Devuelve el libro
        System.out.println("\n--- Devolviendo el libro ---");
        miLibro.devolver();

        // Muestra la información después de la devolución
        System.out.println("\n--- Estado del libro después de la devolución ---");
        miLibro.mostrarInfo();

        // Intenta devolver el libro de nuevo (debería mostrar mensaje de que no estaba prestado)
        System.out.println("\n--- Intentando devolver el libro de nuevo ---");
        miLibro.devolver();
    }
}