// Archivo: GestionOrdenesFabrica.java

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal para la gestión de órdenes de producción.
 * Utiliza genéricos y wildcards para manejar eficientemente
 * diferentes tipos de órdenes dentro del sistema.
 */
public class GestionOrdenesFabrica {

    /**
     * Muestra el resumen de cualquier lista de órdenes de producción.
     * Utiliza un wildcard de límite superior (`? extends OrdenProduccion`)
     * para permitir la lectura de cualquier objeto que sea una OrdenProduccion
     * o una subclase de ella.
     */
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    /**
     * Procesa específicamente órdenes de tipo OrdenPersonalizada.
     * Se usa un wildcard de límite inferior (`? super OrdenPersonalizada`)
     * para indicar que la lista puede contener objetos de tipo OrdenPersonalizada
     * o sus superclases, permitiendo realizar operaciones que modifiquen
     * el estado de objetos de tipo OrdenPersonalizada.
     */
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\nProcesando órdenes personalizadas con ajuste de costo adicional...");
        for (Object obj : lista) { // Se itera como Object para compatibilidad con <? super T>
            if (obj instanceof OrdenPersonalizada) { // Se verifica el tipo antes de castear
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                System.out.println("  Orden " + orden.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    // Desafío Adicional: Conteo por tipo de orden
    /**
     * Calcula y muestra el conteo total de órdenes por cada tipo.
     * Proporciona un resumen cuantitativo de la producción.
     */
    public static void contarTiposDeOrdenes(List<? extends OrdenProduccion> lista) {
        int masaCount = 0;
        int personalizadaCount = 0;
        int prototipoCount = 0;

        for (OrdenProduccion orden : lista) {
            if (orden instanceof OrdenMasa) {
                masaCount++;
            } else if (orden instanceof OrdenPersonalizada) {
                personalizadaCount++;
            } else if (orden instanceof OrdenPrototipo) {
                prototipoCount++;
            }
        }
        System.out.println("\n--- Resumen de Órdenes Totales ---");
        System.out.println("  Producción en masa: " + masaCount);
        System.out.println("  Personalizadas: " + personalizadaCount);
        System.out.println("  Prototipos: " + prototipoCount);
    }


    public static void main(String[] args) {
        // Creación de listas para cada tipo de orden
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // Demostración de los métodos de gestión de órdenes
        System.out.println("--- Órdenes Registradas ---");

        System.out.println("\nÓrdenes de Producción en Masa:");
        mostrarOrdenes(ordenesMasa);

        System.out.println("\nÓrdenes Personalizadas:");
        mostrarOrdenes(ordenesPersonalizadas);

        System.out.println("\nÓrdenes Prototipo:");
        mostrarOrdenes(ordenesPrototipo);

        // Procesamiento específico de órdenes personalizadas
        procesarPersonalizadas(ordenesPersonalizadas, 200);

        // Preparación para el conteo total de órdenes
        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();
        todasLasOrdenes.addAll(ordenesMasa);
        todasLasOrdenes.addAll(ordenesPersonalizadas);
        todasLasOrdenes.addAll(ordenesPrototipo);

        // Ejecución del conteo de tipos de órdenes
        contarTiposDeOrdenes(todasLasOrdenes);
    }
}