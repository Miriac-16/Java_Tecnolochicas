// Archivo: RegistradorLog.java
package reto2_s8; // Debe coincidir con el paquete de OyenteEvento.java

// 3. Clase RegistradorLog (Oyente Concreto)
public class RegistradorLog implements OyenteEvento {
    private String nombreLog;

    public RegistradorLog(String nombreLog) {
        this.nombreLog = nombreLog;
    }

    @Override
    public void manejarEvento(String mensajeEvento) {
        System.out.println("Registrando en el log '" + nombreLog + "': " + mensajeEvento); // Simula el registro en un archivo de log
    }
}