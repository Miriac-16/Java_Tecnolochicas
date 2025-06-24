// Archivo: AnalizadorCalidadClinica.java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase principal para el análisis de calidad de la experiencia del paciente en una clínica.
 * Utiliza la Stream API y flatMap para procesar encuestas de satisfacción
 * recolectadas de múltiples sucursales, identificando áreas de mejora
 * basadas en comentarios de pacientes insatisfechos.
 */
public class AnalizadorCalidadClinica {

    public static void main(String[] args) {
        System.out.println("Iniciando análisis de encuestas de satisfacción...\n");

        // Creación de datos de prueba: sucursales con sus encuestas
        List<Sucursal> sucursales = new ArrayList<>();

        // Sucursal Centro
        List<Encuesta> encuestasCentro = new ArrayList<>();
        encuestasCentro.add(new Encuesta("Paciente A", "El tiempo de espera fue largo", 2)); // Calificación <= 3
        encuestasCentro.add(new Encuesta("Paciente B", "Muy buena atención del personal.", 5));
        encuestasCentro.add(new Encuesta("Paciente C", null, 3)); // Calificación <= 3, sin comentario
        sucursales.add(new Sucursal("Centro", encuestasCentro));

        // Sucursal Norte
        List<Encuesta> encuestasNorte = new ArrayList<>();
        encuestasNorte.add(new Encuesta("Paciente D", "La atención fue buena, pero la limpieza puede mejorar", 3)); // Calificación <= 3
        encuestasNorte.add(new Encuesta("Paciente E", "Excelente servicio, volveré.", 5));
        sucursales.add(new Sucursal("Norte", encuestasNorte));

        // Sucursal Sur (sin encuestas insatisfechas con comentario, o sin comentarios)
        List<Encuesta> encuestasSur = new ArrayList<>();
        encuestasSur.add(new Encuesta("Paciente F", null, 1)); // Calificación <= 3, sin comentario
        encuestasSur.add(new Encuesta("Paciente G", "Todo perfecto.", 4));
        sucursales.add(new Sucursal("Sur", encuestasSur));

        // Procesar las encuestas usando Stream API y flatMap:
        List<String> mensajesDeSeguimiento = sucursales.stream()
            // 1. Desanidar todas las encuestas de las sucursales usando flatMap.
            //    Cada sucursal se "aplana" en un stream de sus encuestas.
            .flatMap(sucursal -> sucursal.getEncuestas().stream().map(encuesta -> new Object() { // Objeto anónimo para agrupar encuesta y nombre de sucursal
                Encuesta e = encuesta;
                String sNombre = sucursal.getNombre();
            }))
            // 2. Filtrar solo las encuestas con calificación menor o igual a 3 (pacientes insatisfechos).
            .filter(item -> item.e.getCalificacion() <= 3)
            // 3. Recuperar los comentarios disponibles usando Optional.
            //    flatMap con Optional::stream desecha los Optional.empty()
            .flatMap(item -> item.e.getComentario().map(comentario -> new Object() { // Creamos un nuevo objeto anónimo con sucursal y comentario
                String sNombre = item.sNombre;
                String c = comentario;
            }).stream()) // Transformamos Optional<Comentario+Sucursal> a Stream<Comentario+Sucursal>
            // 4. Transformar cada comentario en un mensaje de seguimiento.
            .map(item -> "Sucursal " + item.sNombre + ": Seguimiento a paciente con comentario: \"" + item.c + "\"")
            // 5. Mostrar todos los mensajes en consola.
            .collect(Collectors.toList());


        System.out.println("Mensajes de seguimiento para el área de calidad:");
        if (mensajesDeSeguimiento.isEmpty()) {
            System.out.println("  No se encontraron comentarios de pacientes insatisfechos para seguimiento.");
        } else {
            mensajesDeSeguimiento.forEach(System.out::println);
        }

        System.out.println("\nAnálisis de encuestas completado.");
    }
}