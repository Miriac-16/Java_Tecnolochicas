// Archivo: Vuelo.java
package reto1_s3; // Puedes ajustar el nombre del paquete si es necesario

public class Vuelo {
    // Atributos de la clase Vuelo
    private final String codigoVuelo; // Código único del vuelo
    private String destino; // Ciudad destino del vuelo
    private String horaSalida; // Hora de salida en formato 24h
    private Pasajero asientoReservado; // Referencia al pasajero que reservó el asiento (puede ser null)

    // Constructor del vuelo
    public Vuelo(String codigo, String destino, String horaSalida) {
        this.codigoVuelo = codigo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null; // Inicialmente no hay pasajero asignado
    }

    // Método para reservar asiento (sin sobrecarga, usa objeto Pasajero)
    public boolean reservarAsiento(Pasajero p) {
        if (this.asientoReservado == null) { // Asigna pasajero si no hay reserva previa
            this.asientoReservado = p;
            System.out.println("Reserva realizada con éxito.");
            return true;
        } else {
            System.out.println("El asiento ya está reservado.");
            return false;
        }
    }

    // Método sobrecargado para reservar asiento (usa nombre y pasaporte)
    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (this.asientoReservado == null) {
            this.asientoReservado = new Pasajero(nombre, pasaporte);
            System.out.println("Reserva realizada con éxito (por nombre/pasaporte).");
            return true;
        } else {
            System.out.println("El asiento ya está reservado por otro pasajero.");
            return false;
        }
    }

    // Método para cancelar reserva
    public void cancelarReserva() {
        if (this.asientoReservado != null) {
            this.asientoReservado = null; // Elimina al pasajero asignado
            System.out.println("Reserva cancelada correctamente.");
        } else {
            System.out.println("No hay reserva para cancelar.");
        }
    }

    // Método para obtener el itinerario
    public String obtenerItinerario() {
        String itinerario = "Itinerario del vuelo:\n" +
                            "Código: " + codigoVuelo + "\n" +
                            "Destino: " + destino + "\n" +
                            "Salida: " + horaSalida + "\n";
        if (asientoReservado != null) { // Muestra la información del vuelo y del pasajero
            itinerario += "Pasajero: " + asientoReservado.getNombre() + "";
        } else {
            itinerario += "Pasajero: No asignado";
        }
        return itinerario;
    }
}