// Archivo: MarcaRepository.java
package com.tecnolochicas.inventario; // Asegúrate de que el paquete sea el correcto

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Marca.
 * Provee métodos CRUD básicos para la gestión de marcas.
 */
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    // Spring Data JPA provee automáticamente los métodos CRUD básicos aquí
}