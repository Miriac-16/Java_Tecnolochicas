// Archivo: Paciente.java
package reto1_s1; // Puedes ajustar el nombre del paquete si es necesario

public class Paciente {
    // Atributos de la clase Paciente (privados para encapsulamiento, aunque no se pide getters/setters explícitamente en esta fase)
    private String nombre;
    private int edad;
    private String numeroExpediente;

    // Constructor para inicializar los atributos
    public Paciente(String nombre, int edad, String numeroExpediente) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroExpediente = numeroExpediente;
    }

    // Método para mostrar la información del paciente
    public void mostrarInformacion() { // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg
        System.out.println("Paciente: " + nombre); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg
        System.out.println("Edad: " + edad); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg
        System.out.println("Expediente: " + numeroExpediente); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg
    }

    // Opcional: Puedes añadir getters y setters si más adelante necesitas acceder o modificar los atributos de forma individual.
    // public String getNombre() { return nombre; }
    // public void setNombre(String nombre) { this.nombre = nombre; }
    // ...
}