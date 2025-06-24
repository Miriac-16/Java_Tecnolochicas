// Archivo: InventarioApplication.java (modificado)
package com.tecnolochicas.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

/**
 * Clase principal de la aplicación de Inventario Inteligente.
 * Ahora demuestra el uso de relaciones ManyToOne entre Producto y Marca,
 * permitiendo un catálogo de productos más organizado.
 */
@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductoRepository productoRepository, MarcaRepository marcaRepository) {
        return args -> {
            System.out.println("--- Iniciando Catálogo de Productos Avanzado ---");

            // 4. Crear al menos 2 marcas
            System.out.println("\n--- Creando Marcas ---");
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            Marca logitech = new Marca("Logitech"); // Nueva marca para ejemplos
            Marca dell = new Marca("Dell"); // Nueva marca
            Marca sony = new Marca("Sony"); // Nueva marca

            marcaRepository.save(apple);
            marcaRepository.save(samsung);
            marcaRepository.save(logitech);
            marcaRepository.save(dell);
            marcaRepository.save(sony);
            System.out.println("Marcas creadas.");

            // Asegurarse de que la base de datos esté limpia para pruebas consistentes
            productoRepository.deleteAll();
            System.out.println("Productos existentes eliminados para nueva prueba.");


            // 4. Asociar al menos 2 productos a cada marca
            System.out.println("\n--- Asociando Productos a Marcas ---");
            productoRepository.save(new Producto("iPhone 15", "El último smartphone de Apple", 1200.00, apple));
            productoRepository.save(new Producto("iPad Pro", "Tablet potente para profesionales", 900.00, apple));
            productoRepository.save(new Producto("MacBook Air M3", "Laptop ultraligera y potente", 1500.00, apple));

            productoRepository.save(new Producto("Galaxy S24", "Smartphone Android de alta gama", 1000.00, samsung));
            productoRepository.save(new Producto("Smart TV 65\"", "Televisor 4K UHD", 800.00, samsung));
            productoRepository.save(new Producto("Monitor Curvo", "Monitor gaming de 34 pulgadas", 650.00, samsung));

            productoRepository.save(new Producto("Mouse G502 Hero", "Mouse gaming de alto rendimiento", 79.99, logitech));
            productoRepository.save(new Producto("Teclado MX Keys", "Teclado premium para productividad", 119.00, logitech));

            productoRepository.save(new Producto("XPS 15", "Laptop de alto rendimiento", 1800.00, dell));
            productoRepository.save(new Producto("Monitor UltraSharp 27", "Monitor profesional 4K", 550.00, dell));

            productoRepository.save(new Producto("Auriculares WH-1000XM5", "Cancelación de ruido líder", 350.00, sony));
            productoRepository.save(new Producto("PlayStation 5", "Consola de videojuegos", 500.00, sony));

            System.out.println("Productos asociados a marcas.");

            // 4. Mostrar los productos agrupados por marca
            System.out.println("\n--- Productos agrupados por Marca: ---");
            List<Marca> todasLasMarcas = marcaRepository.findAll();
            List<Producto> todosLosProductos = productoRepository.findAll(); // Obtener todos los productos una vez

            todasLasMarcas.forEach(marca -> {
                System.out.println("▶️ " + marca.getNombre() + ":");
                todosLosProductos.stream() // Usamos el stream de todos los productos
                    .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId())) // Filtramos por ID de marca
                    .forEach(p -> System.out.println("  - " + p.getNombre()));
            });

            System.out.println("\n--- Catálogo de Productos Avanzado Finalizado ---");
        };
    }
}