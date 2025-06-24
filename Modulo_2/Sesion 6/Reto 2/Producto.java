// Archivo: Producto.java (modificado)
package com.tecnolochicas.inventario; // Asegúrate de que el paquete sea el correcto

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; // Importar ManyToOne
import jakarta.persistence.JoinColumn; // Importar JoinColumn
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

/**
 * Entidad que representa un Producto en el sistema de inventario.
 * Ahora incluye una relación ManyToOne con la entidad Marca.
 */
@Entity
@Data
@NoArgsConstructor // Para el constructor sin argumentos, necesario para JPA
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía.")
    private String descripcion;

    @Min(value = 1, message = "El precio debe ser al menos 1.")
    private double precio;

    // Relación ManyToOne con Marca: muchos productos pueden pertenecer a una marca
    @ManyToOne // Indica una relación Many-to-One
    @JoinColumn(name = "marca_id") // Define la columna de la clave foránea en la tabla 'productos'
    private Marca marca; // Atributo para la marca del producto

    // Constructor actualizado para incluir la marca
    public Producto(String nombre, String descripcion, double precio, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    // Constructor original (puede ser útil si no siempre se asigna una marca de inmediato)
    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}