// Archivo: NotificadorEmail.java
package reto2_s8; // Debe coincidir con el paquete de OyenteEvento.java

// 3. Clase NotificadorEmail (Oyente Concreto)
public class NotificadorEmail implements OyenteEvento {
    private String direccionEmail;

    public NotificadorEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }

    @Override
    public void manejarEvento(String mensajeEvento) {
        System.out.println("Email enviado a " + direccionEmail + ": " + mensajeEvento); // Simula el envío de un email
    }
}