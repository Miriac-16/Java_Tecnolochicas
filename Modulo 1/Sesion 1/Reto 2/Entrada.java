// Archivo: Entrada.java
package reto2_s1; // Puedes ajustar el nombre del paquete si es necesario

public class Entrada {
    // Atributos de la clase Entrada
    private String nombreEvento; // cite: Screenshot 2025-06-23 at 11.43.19 p.m..jpg
    private double precioEntrada; // cite: Screenshot 2025-06-23 at 11.43.19 p.m..jpg

    // Constructor que recibe ambos valores al momento de crear el objeto
    public Entrada(String nombreEvento, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEntrada = precioEntrada;
    }

    // Método público llamado mostrarInformacion()
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento + " | Precio: $" + precioEntrada); // cite: Screenshot 2025-06-23 at 11.43.19 p.m..jpg
    }

    // Opcional: Si más adelante necesitas acceder a los atributos individualmente, puedes añadir getters.
    // public String getNombreEvento() { return nombreEvento; }
    // public double getPrecioEntrada() { return precioEntrada; }
}