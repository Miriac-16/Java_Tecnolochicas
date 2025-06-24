// Archivo: Principal.java
package reto2_s1; // Debe coincidir con el paquete de Entrada.java

public class Principal {
    public static void main(String[] args) {
        // Crea al menos dos objetos de tipo Entrada
        Entrada entrada1 = new Entrada("Concierto de Rock", 850.50);
        Entrada entrada2 = new Entrada("Obra de Teatro 'Sueño de una Noche'", 450.00); // Ejemplo de la imagen
        Entrada entrada3 = new Entrada("Festival de Cine Independiente", 200.00);

        System.out.println("--- Información de Entradas ---");

        // Llama al método mostrarInformacion() para mostrar los datos en consola
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();
        entrada3.mostrarInformacion();
    }
}