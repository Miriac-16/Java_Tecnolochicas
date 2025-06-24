// Archivo: Main.java
package reto2_s8; // Debe coincidir con el paquete de las demás clases

// 4. Clase Main para probar el sistema
public class Main {
    public static void main(String[] args) {
        // Crear un gestor de eventos
        GestorEventos gestor = new GestorEventos();

        // Crear instancias de oyentes
        NotificadorEmail adminEmail = new NotificadorEmail("admin@example.com"); // cite: Screenshot 2025-06-24 at 12.11.29 a.m..jpg
        NotificadorEmail soporteEmail = new NotificadorEmail("soporte@example.com");
        RegistradorLog logSistema = new RegistradorLog("SystemLog"); // cite: Screenshot 2025-06-24 at 12.11.29 a.m..jpg
        RegistradorLog logAuditoria = new RegistradorLog("AuditLog");

        // Suscribir oyentes a diferentes tipos de eventos
        System.out.println("--- Suscribiendo Oyentes ---");
        gestor.suscribir("error", adminEmail);
        gestor.suscribir("error", logSistema);
        gestor.suscribir("alerta", soporteEmail);
        gestor.suscribir("alerta", logSistema);
        gestor.suscribir("transaccion", logAuditoria);
        gestor.suscribir("transaccion", adminEmail); // admin también quiere notificaciones de transacciones

        // Simular la ocurrencia de diferentes eventos
        gestor.notificar("error", "Error crítico en la base de datos: Conexión perdida."); // cite: Screenshot 2025-06-24 at 12.11.29 a.m..jpg
        gestor.notificar("transaccion", "Nueva compra procesada por el usuario 123."); // cite: Screenshot 2025-06-24 at 12.11.29 a.m..jpg
        gestor.notificar("alerta", "Uso de CPU excedió el 90%."); // cite: Screenshot 2025-06-24 at 12.11.29 a.m..jpg
        gestor.notificar("informacion", "El sistema se ha iniciado correctamente."); // No hay oyentes para este evento inicialmente

        // Desuscribir un oyente y simular otro evento
        System.out.println("\n--- Desuscribiendo Oyentes ---");
        gestor.desuscribir("error", adminEmail); // Admin ya no recibirá errores

        System.out.println("\n--- Simulación después de desuscripción ---");
        gestor.notificar("error", "Error secundario en el módulo de autenticación."); // Solo logSistema debería recibirlo ahora
        gestor.notificar("alerta", "El espacio en disco está bajo."); // soporteEmail y logSistema aún lo reciben
    }
}