// Archivo: Sucursal.java
import java.util.List;
import java.util.ArrayList;

/**
 * Representa una sucursal de la clínica.
 * Cada sucursal mantiene un registro de las encuestas de satisfacción
 * recolectadas de sus pacientes.
 */
public class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.encuestas = new ArrayList<>();
    }

    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    // Métodos para acceder a los atributos de la sucursal
    public String getNombre() {
        return nombre;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }

    /**
     * Agrega una encuesta a la lista de encuestas de esta sucursal.
     * @param encuesta La encuesta a añadir.
     */
    public void agregarEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    @Override
    public String toString() {
        return "Sucursal [nombre=" + nombre + ", encuestas=" + encuestas.size() + " encuestas]";
    }
}