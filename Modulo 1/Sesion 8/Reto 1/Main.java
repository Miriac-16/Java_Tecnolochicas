// Archivo: Main.java
package reto1_s8; // Debe coincidir con el paquete de las demás clases

// 4. Clase Main para simular el sistema
public class Main {
    public static void main(String[] args) {
        // Crear la estación meteorológica
        EstacionMeteorologica estacion = new EstacionMeteorologica();

        // Crear los observadores
        DisplayCondicionesActuales displayHogar = new DisplayCondicionesActuales("Display del Hogar"); // cite: Screenshot 2025-06-24 at 12.10.57 a.m..jpg
        AlertaMeteorologica sistemaAlerta = new AlertaMeteorologica("Sistema de Alerta Nacional"); // cite: Screenshot 2025-06-24 at 12.10.57 a.m..jpg
        DisplayCondicionesActuales displayOficina = new DisplayCondicionesActuales("Display de la Oficina");

        // Registrar los observadores en la estación
        System.out.println("--- Registrando Observadores ---");
        estacion.agregarObservador(displayHogar);
        estacion.agregarObservador(sistemaAlerta);
        estacion.agregarObservador(displayOficina);

        // Simular cambios en las condiciones meteorológicas
        estacion.establecerCondiciones("Soleado y 25°C");
        estacion.establecerCondiciones("Nublado con posibilidad de lluvia ligera");
        estacion.establecerCondiciones("Lluvia fuerte y viento"); // Esto debería activar la alerta
        estacion.establecerCondiciones("Tormenta eléctrica inminente"); // Esto también debería activar la alerta
        estacion.establecerCondiciones("Parcialmente nublado");

        // Eliminar un observador y simular otro cambio
        System.out.println("\n--- Eliminando un Observador ---");
        estacion.eliminarObservador(displayOficina);
        estacion.establecerCondiciones("Condiciones de huracán - ¡BUSCAR REFUGIO!"); // Esto debería activar la alerta solo en los observadores restantes
    }
}