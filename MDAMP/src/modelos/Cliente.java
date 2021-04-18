/**
 * Clase para almacenar y regresar información del cliente, será utilizada para
 * registrar esta información dentro de la base de datos, o también obtener esa
 * información de ahí.
 * */
package modelos;

/**
 *
 * @author Inzunza Kevin
 * @version 16-04-2021
 *
 */
public class Cliente {

    private String nombre; //Atributo para el nombre
    private String apellido; //Atributo para el apellido
    private String telefono; //Atributo para el número de teléfono siendo un identificador
    private String direccion; //Atributo apra la dirección

    /**
     * Constuctor vació, el cual permite ingresar los datos uno por uno
     */
    public Cliente() {
    }

    /**
     * Constuctor que permite almacenar todos los datos en un mismo momento.
     *
     * @param nombre
     * @param apellido
     * @param telefono
     * @param direccion
     */
    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     * Regresa la información actual del nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Ingresa un nuevo nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la información actual del apellido
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Ingresa un nuevo apellido
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Regresa la información actual del número de teléfono
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Ingresa un nuevo telefono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Regresa la información actual de la direcció
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Ingresa una nueva dirección
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
