// Archivo: PlataformaEducativa.java

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que simula una plataforma educativa.
 * Demuestra el uso de genéricos y wildcards para gestionar y manipular
 * diferentes tipos de materiales de un curso de forma flexible.
 */
public class PlataformaEducativa {

    /**
     * Muestra los detalles de una lista de cualquier tipo de material de curso.
     * Utiliza un wildcard de límite superior (`? extends MaterialCurso`)
     * para permitir la lectura de elementos que son MaterialCurso o subclases.
     */
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    /**
     * Calcula y muestra la duración total en minutos de una lista de videos.
     * También utiliza un wildcard de límite superior (`? extends Video`)
     * para asegurar que solo se procesen objetos de tipo Video o sus subclases.
     */
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int duracionTotal = 0;
        for (Video video : lista) {
            duracionTotal += video.getDuracionMinutos();
        }
        System.out.println("\nDuración total de videos: " + duracionTotal + " minutos");
    }

    /**
     * Marca una lista de ejercicios como revisados y muestra un mensaje por cada uno.
     * Se emplea un wildcard de límite inferior (`? super Ejercicio`) porque
     * se modificará el estado interno de los objetos Ejercicio. Esto permite que
     * la lista pueda ser de tipo Ejercicio o de alguna de sus superclases
     * (como MaterialCurso o Object), manteniendo la seguridad de tipo al escribir.
     */
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) { // Se itera como Object para compatibilidad con <? super T>
            if (obj instanceof Ejercicio) { // Se verifica el tipo antes de castear
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.marcarComoRevisado();
                System.out.println("  Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
            }
        }
    }

    /**
     * Filtra y muestra los materiales de un autor específico.
     * Demuestra una operación de filtrado sobre una lista genérica de MaterialCurso.
     */
    public static void filtrarMaterialesPorAutor(List<? extends MaterialCurso> todosLosMateriales, String autorFiltrar) {
        System.out.println("\nFiltrando materiales por autor: " + autorFiltrar);
        for (MaterialCurso material : todosLosMateriales) {
            if (material.getAutor().equalsIgnoreCase(autorFiltrar)) {
                material.mostrarDetalle();
            }
        }
    }


    public static void main(String[] args) {
        // Creación de instancias de los diferentes materiales del curso
        List<MaterialCurso> materialesDelCurso = new ArrayList<>();
        materialesDelCurso.add(new Video("Introducción a Java", "Mario", 15));
        materialesDelCurso.add(new Video("POO en Java", "Carlos", 20));
        materialesDelCurso.add(new Articulo("Historia de Java", "Ana", 1200));
        materialesDelCurso.add(new Articulo("Tipos de datos", "Luis", 800));
        materialesDelCurso.add(new Ejercicio("Variables y tipos", "Luis", false));
        materialesDelCurso.add(new Ejercicio("Condicionales", "Mario", false));

        System.out.println("Materiales del curso:");
        mostrarMateriales(materialesDelCurso);

        // Lista específica para videos para calcular duración
        List<Video> soloVideos = new ArrayList<>();
        soloVideos.add(new Video("Introducción a Java", "Mario", 15));
        soloVideos.add(new Video("POO en Java", "Carlos", 20));
        contarDuracionVideos(soloVideos);

        // Marcar ejercicios como revisados
        List<Ejercicio> ejerciciosPendientes = new ArrayList<>();
        ejerciciosPendientes.add(new Ejercicio("Variables y tipos", "Luis", false));
        ejerciciosPendientes.add(new Ejercicio("Condicionales", "Mario", false));
        marcarEjerciciosRevisados(ejerciciosPendientes);

        // Mostrar el estado actualizado de los ejercicios (recreando la lista para reflejar el cambio si no se actualizara la referencia original)
        // Ojo: Si la lista 'ejerciciosPendientes' es parte de 'materialesDelCurso' y se modifica,
        // la lista principal reflejará el cambio. Para la demostración, podemos volver a mostrar
        // la lista principal o los ejercicios específicos.
        System.out.println("\nEstado actualizado de ejercicios:");
        // Una forma de verificar el estado después de marcar
        materialesDelCurso.forEach(material -> {
            if (material instanceof Ejercicio) {
                material.mostrarDetalle();
            }
        });


        // Desafío adicional (no especificado explícitamente pero común: filtrar por autor)
        filtrarMaterialesPorAutor(materialesDelCurso, "Mario");
    }
}