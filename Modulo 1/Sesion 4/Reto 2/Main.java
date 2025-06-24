// Archivo: Main.java
package reto2_s4; // Debe coincidir con el paquete de DeclaracionImpuestos.java y CuentaFiscal.java

public class Main {
    public static void main(String[] args) {
        // 4. En la clase Main: Actividades

        // Crear una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("XAXX010101000", 8700.0); // cite: Screenshot 2025-06-23 at 11.54.45 p.m..jpg

        // Crear una cuenta fiscal
        CuentaFiscal cuenta = new CuentaFiscal("XAXX010101000", 9500.0); // cite: Screenshot 2025-06-23 at 11.54.45 p.m..jpg

        // Mostrar la información de ambas
        System.out.println("Declaración enviada por RFC: " + declaracion.rfcContribuyente() + " por $" + declaracion.montoDeclarado()); // cite: Screenshot 2025-06-23 at 11.54.45 p.m..jpg
        System.out.println(cuenta); // Usa el toString() de CuentaFiscal

        // Valida si el RFC coincide y muestra el resultado
        boolean rfcCoincide = cuenta.validarRFC(declaracion);
        System.out.println("¿RFC válido para esta cuenta?: " + rfcCoincide); // cite: Screenshot 2025-06-23 at 11.54.45 p.m..jpg

        // Ejemplo adicional para probar la validación del constructor (opcional, descomentar para probar)
        // try {
        //     CuentaFiscal cuentaInvalida = new CuentaFiscal("RFCINVALIDO", -100.0);
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Error al crear cuenta fiscal: " + e.getMessage());
        // }
    }
}