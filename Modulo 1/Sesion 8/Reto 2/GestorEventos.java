// Archivo: GestorEventos.java
package reto2_s8; // Debe coincidir con el paquete de OyenteEvento.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2. Clase GestorEventos (Sujeto/Publicador)
public class GestorEventos {
    // Mapa para almacenar listas de oyentes por tipo de evento
    private Map<String, List<OyenteEvento>> oyentes;

    public GestorEventos() {
        this.oyentes = new HashMap<>();
    }

    // Método para suscribir un oyente a un tipo de evento específico
    public void suscribir(String tipoEvento, OyenteEvento oyente) {
        // Si el tipo de evento no existe, crea una nueva lista de oyentes
        oyentes.computeIfAbsent(tipoEvento, k -> new ArrayList<>()).add(oyente);
        System.out.println("Oyente " + oyente.getClass().getSimpleName() + " suscrito al evento: " + tipoEvento);
    }

    // Método para desuscribir un oyente de un tipo de evento
    public void desuscribir(String tipoEvento, OyenteEvento oyente) {
        List<OyenteEvento> listaOyentes = oyentes.get(tipoEvento);
        if (listaOyentes != null && listaOyentes.remove(oyente)) {
            System.out.println("Oyente " + oyente.getClass().getSimpleName() + " desuscrito del evento: " + tipoEvento);
        } else {
            System.out.println("Oyente " + oyente.getClass().getSimpleName() + " no estaba suscrito a " + tipoEvento + " o no existe el evento.");
        }
    }

    // Método para notificar a todos los oyentes de un tipo de evento
    public void notificar(String tipoEvento, String mensajeEvento) {
        List<OyenteEvento> listaOyentes = oyentes.get(tipoEvento);
        if (listaOyentes != null) {
            System.out.println("\n--- Notificando evento '" + tipoEvento + "': " + mensajeEvento + " ---");
            for (OyenteEvento oyente : listaOyentes) {
                oyente.manejarEvento(mensajeEvento); // Llama al método manejarEvento de cada oyente
            }
        } else {
            System.out.println("\nNo hay oyentes suscritos al evento: " + tipoEvento);
        }
    }
}