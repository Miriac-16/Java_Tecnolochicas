// Archivo: TareaYaCompletadaException.java
package reto2_s6; // Puedes ajustar el nombre del paquete si es necesario

// 2. Excepción personalizada para tarea ya completada
public class TareaYaCompletadaException extends Exception {
    public TareaYaCompletadaException(String mensaje) {
        super(mensaje);
    }
}