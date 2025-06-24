// Archivo: AlertaMeteorologica.java
package reto1_s8; // Debe coincidir con el paquete de Observador.java

// 3. Clase AlertaMeteorologica (Observador Concreto)
public class AlertaMeteorologica implements Observador {
    private String nombreAlerta;

    public AlertaMeteorologica(String nombreAlerta) {
        this.nombreAlerta = nombreAlerta;
    }

    @Override
    public void actualizar(String mensaje) {
        // La alerta solo se activa bajo ciertas condiciones
        if (mensaje.toLowerCase().contains("lluvia fuerte") || mensaje.toLowerCase().contains("tormenta") || mensaje.toLowerCase().contains("huracán")) {
            System.out.println(nombreAlerta + ": ¡ALERTA! Se requiere atención inmediata: " + mensaje); // Activa la alerta
        } else {
            System.out.println(nombreAlerta + ": Monitoreando... Sin alertas críticas. Condiciones: " + mensaje);
        }
    }
}