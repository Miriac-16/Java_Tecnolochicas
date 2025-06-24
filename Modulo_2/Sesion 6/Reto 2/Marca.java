// Archivo: Marca.java
package com.tecnolochicas.inventario; // Asegúrate de que el paquete sea el correcto

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor; // Para el constructor sin argumentos

/**
 * Entidad que representa una Marca en el catálogo de productos.
 * Utilizada para establecer relaciones ManyToOne con la entidad Producto.
 */
@Entity
@Data // Anotación de Lombok para generar getters, setters, toString, equals y hashCode
@NoArgsConstructor // Para generar un constructor sin argumentos, necesario para JPA
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Llave primaria autogenerada
    private Long id;

    private String nombre; // Nombre de la marca

    public Marca(String nombre) {
        this.nombre = nombre;
    }
}