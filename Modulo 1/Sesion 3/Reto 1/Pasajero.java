// Archivo: Pasajero.java
package reto1_s3; // Puedes ajustar el nombre del paquete si es necesario

public class Pasajero {
    // Atributos de la clase Pasajero
    private String nombre; // Nombre del pasajero
    private String pasaporte; // Número de pasaporte

    // Constructor
    public Pasajero(String nombre, String pasaporte) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    // Opcional: Podrías agregar setters si se permite modificar nombre/pasaporte después de la creación
    // public void setNombre(String nombre) { this.nombre = nombre; }
    // public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }
}