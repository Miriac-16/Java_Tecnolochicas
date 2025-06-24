// Archivo: CantidadInvalidaException.java
package reto1_s6; // Puedes ajustar el nombre del paquete si es necesario

// 2. Excepción personalizada para cantidad inválida
public class CantidadInvalidaException extends Exception {
    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}