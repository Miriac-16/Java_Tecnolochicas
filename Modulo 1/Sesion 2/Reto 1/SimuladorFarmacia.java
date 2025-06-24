// Archivo: SimuladorFarmacia.java
package reto1_s2; // Puedes ajustar el nombre del paquete si es necesario

import java.util.Scanner; // Para la entrada de datos por consola

public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg

        System.out.println("--- Simulador de Farmacia con Descuento ---");

        // 2. Solicita al usuario los siguientes datos:
        System.out.print("Ingrese el nombre del medicamento: ");
        String nombreMedicamento = scanner.nextLine(); // Tipo String

        System.out.print("Ingrese el precio unitario del medicamento: ");
        double precioUnitario = scanner.nextDouble(); // Tipo double

        System.out.print("Ingrese la cantidad de piezas: ");
        int cantidadPiezas = scanner.nextInt(); // Tipo int

        // Consumir el salto de línea pendiente después de nextInt()
        scanner.nextLine();

        // 3. Calcula el total sin descuento multiplicando el precio por la cantidad.
        var totalSinDescuento = precioUnitario * cantidadPiezas; // Uso de 'var'

        // 4. Supón que si el total supera los $500.00, la farmacia ofrece un 15% de descuento.
        // Aplica el descuento usando el operador ternario ( ? : ) sin estructuras if.
        double descuento = (totalSinDescuento > 500.00) ? (totalSinDescuento * 0.15) : 0.0; // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg, Screenshot 2025-06-23 at 11.45.04 p.m..jpg
        boolean aplicaDescuento = (totalSinDescuento > 500.00) ? true : false; // Determina si se aplicó descuento

        double totalAPagar = totalSinDescuento - descuento;

        // 5. Muestra en consola el resumen con el siguiente formato:
        System.out.println("\n--- Resumen de la Compra ---");
        System.out.println("Medicamento: " + nombreMedicamento); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg
        System.out.println("Cantidad: " + cantidadPiezas); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg
        System.out.println("Precio unitario: $" + String.format("%.2f", precioUnitario)); // Formato para 2 decimales
        System.out.println("Total sin descuento: $" + String.format("%.2f", totalSinDescuento)); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg
        System.out.println("¿Aplica descuento?: " + aplicaDescuento); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg
        System.out.println("Descuento: $" + String.format("%.2f", descuento)); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg
        System.out.println("Total a pagar: $" + String.format("%.2f", totalAPagar)); // cite: Screenshot 2025-06-23 at 11.44.52 p.m..jpg

        // Cierra el scanner
        scanner.close();
    }
}