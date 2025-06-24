// Archivo: CajeroAutomatico.java
package reto2_s2; // Puedes ajustar el nombre del paquete si es necesario

import java.util.Scanner; // Para la entrada de datos por consola

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2. Define un saldo inicial, la variable deberá ser inferida por Java (var).
        var saldo = 1000.00; // Saldo inicial de ejemplo
        int opcion;

        // 4. El programa debe repetirse usando un while hasta que el usuario elija salir (opción 4).
        do {
            // 3. Muestra un menú interactivo en consola con las siguientes opciones:
            System.out.println("\n--- Bienvenido al cajero automático ---"); // cite: Screenshot 2025-06-23 at 11.46.26 p.m..jpg
            System.out.println("1. Consultar saldo"); // cite: Screenshot 2025-06-23 at 11.46.26 p.m..jpg
            System.out.println("2. Depositar dinero"); // cite: Screenshot 2025-06-23 at 11.46.26 p.m..jpg
            System.out.println("3. Retirar dinero"); // cite: Screenshot 2025-06-23 at 11.46.26 p.m..jpg
            System.out.println("4. Salir"); // cite: Screenshot 2025-06-23 at 11.46.26 p.m..jpg
            System.out.print("Elija una opción: ");

            // Validación para asegurar que el input sea un número entero
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 4.");
                scanner.next(); // Consume la entrada incorrecta
                System.out.print("Elija una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            // 5. Utiliza un switch para manejar las opciones:
            switch (opcion) {
                case 1:
                    // 1. Consultar saldo -> Mostrar el saldo actual.
                    System.out.printf("Su saldo actual es: $%.2f%n", saldo);
                    break; // Control de flujo
                case 2:
                    // 2. Depositar dinero -> Pedir monto a depositar y sumarlo al saldo.
                    System.out.print("Ingrese el monto a depositar: $");
                    // Validación para asegurar que el input sea un número doble
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Monto inválido. Por favor, ingrese un número.");
                        scanner.next();
                        System.out.print("Ingrese el monto a depositar: $");
                    }
                    double deposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.printf("Depósito de $%.2f realizado. Nuevo saldo: $%.2f%n", deposito, saldo);
                    } else {
                        System.out.println("El monto a depositar debe ser positivo.");
                    }
                    break; // Control de flujo
                case 3:
                    // 3. Retirar dinero -> Pedir monto a retirar.
                    System.out.print("Ingrese el monto a retirar: $");
                    // Validación para asegurar que el input sea un número doble
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Monto inválido. Por favor, ingrese un número.");
                        scanner.next();
                        System.out.print("Ingrese el monto a retirar: $");
                    }
                    double retiro = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Validar si hay saldo suficiente.
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.printf("Retiro de $%.2f realizado. Nuevo saldo: $%.2f%n", retiro, saldo);
                    } else if (retiro <= 0) {
                        System.out.println("El monto a retirar debe ser positivo.");
                    }
                    else {
                        // Si no hay suficiente, mostrar mensaje y continuar sin restar.
                        System.out.println("Saldo insuficiente. No se puede realizar el retiro."); // cite: Screenshot 2025-06-23 at 11.46.39 p.m..jpg
                    }
                    break; // Control de flujo
                case 4:
                    // 4. Salir -> Mostrar mensaje de despedida y terminar el programa.
                    System.out.println("Gracias por usar el cajero automático. ¡Hasta pronto!");
                    break; // Control de flujo
                default:
                    // Desafío adicional (opcional): Si el usuario ingresa una opción inválida, muestra un mensaje de error y vuelve a mostrar el menú sin detener el programa.
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    // `continue` no es estrictamente necesario aquí si el `do-while` ya se encarga,
                    // pero se incluye para ilustrar su uso potencial en otros escenarios de control de flujo.
                    continue; // Control de flujo
            }
        } while (opcion != 4); // El programa se repite hasta que la opción sea 4

        // Cierra el scanner para liberar recursos
        scanner.close();
    }
}