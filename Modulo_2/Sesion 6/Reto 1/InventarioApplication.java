// Archivo: InventarioApplication.java (o una clase de prueba separada)
package com.tecnolochicas.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

/**
 * Clase principal de la aplicación de Inventario Inteligente.
 * Demuestra la creación de entidades JPA con validaciones y
 * el uso de consultas personalizadas de Spring Data JPA.
 */
@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductoRepository productoRepository) {
        return args -> {
            System.out.println("--- Iniciando Sistema de Inventario Inteligente ---");

            // 4. Prueba las consultas y validaciones desde CommandLineRunner:
            // Guardar al menos 4 productos (asegúrate de que algunos cumplan las condiciones)
            System.out.println("\n--- Guardando productos de ejemplo ---");
            productoRepository.save(new Producto("Laptop Lenovo", "Potente laptop para trabajo", 1250.00));
            productoRepository.save(new Producto("Mouse Logitech", "Mouse ergonómico inalámbrico", 35.00));
            productoRepository.save(new Producto("Teclado Mecánico", "Teclado RGB con switches azules", 95.00));
            productoRepository.save(new Producto("Monitor Dell UltraSharp", "Monitor 4K de 27 pulgadas", 320.00));
            productoRepository.save(new Producto("Auriculares Sony", "Auriculares con cancelación de ruido", 250.00));
            productoRepository.save(new Producto("Webcam HD", "Cámara web para videollamadas", 49.99));
            productoRepository.save(new Producto("Tablet Samsung", "Tablet compacta para ocio", 300.00));
            System.out.println("Productos guardados.");

            // Demostrar validaciones (esto fallaría si no estuviera comentado)
            // try {
            //     productoRepository.save(new Producto("", "Producto sin nombre", 50.00));
            // } catch (jakarta.validation.ConstraintViolationException e) {
            //     System.err.println("Error de validación (esperado): " + e.getMessage());
            // }

            // Imprimir todos los productos con precio mayor a 500
            System.out.println("\n--- Productos con precio mayor a 500: ---");
            List<Producto> productosCaros = productoRepository.findByPrecioGreaterThan(500.00);
            productosCaros.forEach(System.out::println);

            // Imprimir todos los productos que contengan "lap" en su nombre
            System.out.println("\n--- Productos que contienen 'lap': ---");
            List<Producto> productosConLap = productoRepository.findByNombreContainingIgnoreCase("lap");
            productosConLap.forEach(System.out::println);

            // Imprimir productos con precio entre 400 y 1000
            System.out.println("\n--- Productos con precio entre 400 y 1000: ---");
            List<Producto> productosRangoPrecio = productoRepository.findByPrecioBetween(40.00, 1000.00); // Ajustado el rango para incluir más productos de ejemplo
            productosRangoPrecio.forEach(System.out::println);

            // Imprimir productos cuyo nombre comience con "m" o "M"
            System.out.println("\n--- Productos cuyo nombre empieza con 'm': ---");
            List<Producto> productosConM = productoRepository.findByNombreStartingWithIgnoreCase("m");
            productosConM.forEach(System.out::println);

            System.out.println("\n--- Sistema de Inventario Inteligente Finalizado ---");
        };
    }
}