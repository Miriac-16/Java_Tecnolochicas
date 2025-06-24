// Archivo: Principal.java
package reto1_s1; // Debe coincidir con el paquete de Paciente.java

import java.util.Scanner; // Importa la clase Scanner para entrada de datos

public class Principal {
    public static void main(String[] args) {
        // 2. Utiliza la clase Scanner para solicitar los datos desde la consola:
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Registro de Paciente ---");
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine(); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg

        System.out.print("Ingrese la edad del paciente: ");
        int edadPaciente = scanner.nextInt(); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg
        scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()

        System.out.print("Ingrese el número de expediente: ");
        String numeroExpedientePaciente = scanner.nextLine(); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg

        // 5. Crea un objeto de tipo Paciente y asigna los valores ingresados:
        Paciente paciente1 = new Paciente(nombrePaciente, edadPaciente, numeroExpedientePaciente); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg

        System.out.println("\n--- Información del Paciente Registrado ---");
        // Llama al método mostrarInformacion() para mostrar los datos en consola:
        paciente1.mostrarInformacion(); // cite: Screenshot 2025-06-23 at 11.37.14 p.m..jpg

        // Cierra el scanner para liberar recursos
        scanner.close();
    }
}