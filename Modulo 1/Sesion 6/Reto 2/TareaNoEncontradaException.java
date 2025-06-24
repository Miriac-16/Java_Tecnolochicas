// Archivo: TareaNoEncontradaException.java
package reto2_s6; // Puedes ajustar el nombre del paquete si es necesario

// 2. Excepción personalizada para tarea no encontrada
public class TareaNoEncontradaException extends Exception {
    public TareaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}