// Archivo: DisplayCondicionesActuales.java
package reto1_s8; // Debe coincidir con el paquete de Observador.java

// 3. Clase DisplayCondicionesActuales (Observador Concreto)
public class DisplayCondicionesActuales implements Observador {
    private String nombreDisplay;

    public DisplayCondicionesActuales(String nombreDisplay) {
        this.nombreDisplay = nombreDisplay;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombreDisplay + ": Mostrando condiciones actuales: " + mensaje); // Muestra las condiciones actuales
    }
}