// Archivo: Principal.java
package reto1_s3; // Debe coincidir con el paquete de Vuelo.java y Pasajero.java

public class Principal {
    public static void main(String[] args) {
        // 3. En la clase Principal: Actividades

        // Crear al menos un pasajero y un vuelo
        Vuelo vuelo1 = new Vuelo("UX123", "París", "14:30"); // cite: Screenshot 2025-06-23 at 11.48.25 p.m..jpg
        Pasajero pasajero1 = new Pasajero("Ana Martínez", "ABC789"); // cite: Screenshot 2025-06-23 at 11.48.25 p.m..jpg

        // Reservar el asiento en el vuelo
        System.out.println("--- Intento de reserva 1 ---");
        vuelo1.reservarAsiento(pasajero1);

        // Mostrar el itinerario
        System.out.println("\n" + vuelo1.obtenerItinerario());

        // Intentar reservar el mismo asiento con otro pasajero (debería fallar)
        System.out.println("\n--- Intento de reserva 2 (con otro pasajero) ---");
        Pasajero pasajero2 = new Pasajero("Juan Pérez", "XYZ101");
        vuelo1.reservarAsiento(pasajero2); // Esto no debería reservarse

        // Cancelar la reserva
        System.out.println("\n--- Cancelando reserva ---");
        vuelo1.cancelarReserva();

        // Mostrar nuevamente el itinerario (debería estar sin pasajero)
        System.out.println("\n" + vuelo1.obtenerItinerario());

        // Reservar un asiento en el vuelo usando un nombre y pasaporte (método sobrecargado)
        System.out.println("\n--- Intento de reserva 3 (con nombre y pasaporte) ---");
        vuelo1.reservarAsiento("Carlos Gómez", "DEF456");

        // Mostrar el itinerario actualizado
        System.out.println("\n" + vuelo1.obtenerItinerario());
    }
}