// Archivo: DeclaracionImpuestos.java
package reto2_s4; // Puedes ajustar el nombre del paquete si es necesario

// 1. Crea un record llamado DeclaracionImpuestos
public record DeclaracionImpuestos(String rfcContribuyente, double montoDeclarado) {
    // Los records automáticamente generan constructor, getters, equals(), hashCode() y toString()
    // para sus componentes.
    // No necesitamos sobreescribir toString() ni equals()/hashCode() manualmente para este reto,
    // ya que el formato de salida se gestiona en Main y la comparación se hará con Objects.equals
    // en CuentaFiscal.
}