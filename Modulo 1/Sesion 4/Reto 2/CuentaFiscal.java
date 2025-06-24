// Archivo: CuentaFiscal.java
package reto2_s4; // Puedes ajustar el nombre del paquete si es necesario

import java.util.Objects; // Para usar Objects.equals()

// 2. Crea una clase tradicional llamada CuentaFiscal
public class CuentaFiscal {
    // Atributos privados
    private final String rfc; // no modificable una vez asignado
    private double saldoDisponible;

    // 3. Implementa lo siguiente en CuentaFiscal: Constructor con validación
    public CuentaFiscal(String rfc, double saldoDisponible) {
        if (saldoDisponible < 0) { // Validación para que el saldo no sea negativo
            throw new IllegalArgumentException("El saldo disponible no puede ser negativo.");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    // Getters para ambos atributos
    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Método validarRFC() que compare el RFC de la cuenta con el de la declaración, usando Objects.equals()
    public boolean validarRFC(DeclaracionImpuestos declaracion) {
        return Objects.equals(this.rfc, declaracion.rfcContribuyente()); // Uso de Objects.equals()
    }

    // Sobreescribir toString() para una mejor representación en la salida
    @Override
    public String toString() {
        return "Cuenta fiscal registrada con RFC: " + rfc + ", saldo disponible: $" + saldoDisponible;
    }
}