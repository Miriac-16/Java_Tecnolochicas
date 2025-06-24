// Archivo: Pedido.java
import java.util.Optional;

/**
 * Representa un pedido realizado a la pizzería.
 * Contiene información sobre el cliente, el tipo de entrega (domicilio o local)
 * y el número de teléfono para confirmación, que puede ser opcional.
 */
public class Pedido {
    private String cliente;
    private String tipoEntrega; // "domicilio" o "local"
    private String telefono;    // Puede ser null

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    // Métodos para acceder a los atributos del pedido
    public String getCliente() {
        return cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    /**
     * Proporciona el número de teléfono del cliente envuelto en un Optional.
     * Esto maneja de forma elegante la posibilidad de que el teléfono no esté presente,
     * evitando NullPointerExceptions y promoviendo código más claro.
     *
     * @return Un Optional que contiene el número de teléfono si está disponible,
     * o un Optional vacío si es null.
     */
    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", tipoEntrega=" + tipoEntrega + ", telefono=" + telefono + "]";
    }
}