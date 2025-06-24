// Archivo: EstacionMeteorologica.java
package reto1_s8; // Debe coincidir con el paquete de Observador.java

import java.util.ArrayList;
import java.util.List;

// 2. Clase EstacionMeteorologica (Sujeto/Observable)
public class EstacionMeteorologica {
    private List<Observador> observadores; // Lista de observadores registrados
    private String condicionesActuales; // Estado que los observadores monitorean

    public EstacionMeteorologica() {
        this.observadores = new ArrayList<>();
    }

    // Método para registrar un observador
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("Observador agregado.");
    }

    // Método para eliminar un observador
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("Observador eliminado.");
    }

    // Método para notificar a todos los observadores
    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(condicionesActuales);
        }
    }

    // Método para establecer nuevas condiciones meteorológicas y notificar
    public void establecerCondiciones(String nuevasCondiciones) {
        this.condicionesActuales = nuevasCondiciones;
        System.out.println("\n--- La estación meteorológica ha actualizado las condiciones a: " + nuevasCondiciones + " ---");
        notificarObservadores(); // Notifica a todos los observadores sobre el cambio
    }
}