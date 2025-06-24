// Archivo: SistemaPedidosPizzeria.java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase principal que simula el sistema de gestión de pedidos de una pizzería.
 * Demuestra el uso de la Stream API y Optional para filtrar, transformar
 * y procesar pedidos de manera eficiente y segura, especialmente para
 * la generación de mensajes de confirmación a domicilio.
 */
public class SistemaPedidosPizzeria {

    public static void main(String[] args) {
        System.out.println("Procesando pedidos de la pizzería...\n");

        // Creación de una lista de pedidos simulados
        List<Pedido> listaDePedidos = new ArrayList<>();
        listaDePedidos.add(new Pedido("Ana", "domicilio", "555-1234"));
        listaDePedidos.add(new Pedido("Roberto", "local", null));
        listaDePedidos.add(new Pedido("Carlos", "domicilio", "555-5678"));
        listaDePedidos.add(new Pedido("Marta", "local", "555-9999")); // Teléfono pero entrega local
        listaDePedidos.add(new Pedido("Pedro", "domicilio", null));
        listaDePedidos.add(new Pedido("Luisa", "domicilio", "555-4321"));

        // Procesar la lista de pedidos usando Stream API:
        // 1. Filtrar solo los pedidos con tipo de entrega "domicilio".
        // 2. Recuperar los teléfonos disponibles usando Optional (flatMap para Optional).
        // 3. Transformar cada teléfono en un mensaje de confirmación.
        List<String> mensajesConfirmacion = listaDePedidos.stream()
            .filter(pedido -> "domicilio".equalsIgnoreCase(pedido.getTipoEntrega())) // Paso 1: Filtrar por tipo de entrega
            .map(Pedido::getTelefono)                                      // Mapear cada pedido a su Optional<String> de teléfono
            .flatMap(Optional::stream)                                     // Paso 2: Desempaquetar Optional<String> a Stream<String>, filtrando los vacíos
            .map(telefono -> "Confirmación enviada al número: " + telefono) // Paso 3: Transformar el teléfono en mensaje
            .collect(Collectors.toList());                                 // Recolectar los mensajes en una lista

        // 4. Mostrar todos los mensajes en consola.
        System.out.println("Mensajes de confirmación para pedidos a domicilio:");
        if (mensajesConfirmacion.isEmpty()) {
            System.out.println("  No hay pedidos a domicilio con teléfono disponible para confirmar.");
        } else {
            mensajesConfirmacion.forEach(System.out::println);
        }

        System.out.println("\nProcesamiento de pedidos finalizado.");
    }
}