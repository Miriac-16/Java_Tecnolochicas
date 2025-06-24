// Archivo: Main.java
package reto1_s6; // Debe coincidir con el paquete de Producto.java y las excepciones

public class Main {
    public static void main(String[] args) {
        // 3. En la clase Main: Actividades

        // Instancia un objeto Producto
        Producto lapiz = new Producto("Lápiz HB", 1.50, 10); // 10 unidades en stock inicialmente

        System.out.println("Estado inicial: " + lapiz);

        // Simular compras y reposiciones, capturando las excepciones

        // Caso 1: Compra exitosa
        try {
            System.out.println("\n--- Intento de compra exitosa ---");
            lapiz.comprar(3); // Compra 3 lápices
            System.out.println("Estado actual: " + lapiz);
        } catch (StockInsuficienteException | CantidadInvalidaException e) {
            System.err.println("Error en la compra: " + e.getMessage()); // Imprime el mensaje de la excepción
        }

        // Caso 2: Compra con stock insuficiente
        try {
            System.out.println("\n--- Intento de compra con stock insuficiente ---");
            lapiz.comprar(10); // Intenta comprar 10, pero solo quedan 7
            System.out.println("Estado actual: " + lapiz);
        } catch (StockInsuficienteException e) {
            System.err.println("Error en la compra: " + e.getMessage()); // Debería capturar StockInsuficienteException
        } catch (CantidadInvalidaException e) {
            System.err.println("Error en la compra: " + e.getMessage());
        }

        // Caso 3: Compra con cantidad inválida (0)
        try {
            System.out.println("\n--- Intento de compra con cantidad inválida (0) ---");
            lapiz.comprar(0);
            System.out.println("Estado actual: " + lapiz);
        } catch (CantidadInvalidaException e) {
            System.err.println("Error en la compra: " + e.getMessage()); // Debería capturar CantidadInvalidaException
        } catch (StockInsuficienteException e) {
            System.err.println("Error en la compra: " + e.getMessage());
        }

        // Caso 4: Reposición exitosa
        try {
            System.out.println("\n--- Intento de reposición exitosa ---");
            lapiz.reponer(5); // Repone 5 lápices
            System.out.println("Estado actual: " + lapiz);
        } catch (CantidadInvalidaException e) {
            System.err.println("Error en la reposición: " + e.getMessage());
        }

        // Caso 5: Reposición con cantidad inválida (-2)
        try {
            System.out.println("\n--- Intento de reposición con cantidad inválida (-2) ---");
            lapiz.reponer(-2);
            System.out.println("Estado actual: " + lapiz);
        } catch (CantidadInvalidaException e) {
            System.err.println("Error en la reposición: " + e.getMessage()); // Debería capturar CantidadInvalidaException
        }
    }
}