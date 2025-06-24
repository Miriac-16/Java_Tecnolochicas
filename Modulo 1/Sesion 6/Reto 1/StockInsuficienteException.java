// Archivo: StockInsuficienteException.java
package reto1_s6; // Puedes ajustar el nombre del paquete si es necesario

// 2. Excepción personalizada para stock insuficiente
public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}