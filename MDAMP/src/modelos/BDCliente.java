/*
 * Clase encargada del manejo de los clientes en la base de datos, para esto se
 * implementaron metodos basicos del CRUD en base a las reglas proporcionadas por
 * MySQL
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pacheco Magdiel
 * @version 16-04-2021
 */
public class BDCliente {

    private Cliente cliente;
    private static Connection con;

    /**
     * Constructor de la clase donde se establece la conexion hacia la base de
     * datos
     */
    public BDCliente() {
        con = Conexion.getConnection();
    }

    /**
     * Metodo utilizado para agregar clientes dentro de la base de datos
     * conforme a lo que el usuario haya ingresado por parte de la interfaz,
     * para esto se utilizo el comando INSERT INTO que nos ofrece MySQL
     *
     * @param nCliente Creacion de nuevo objeto tipo Cliente
     * @throws SQLException
     */
    public void agregarDatos(Cliente nCliente) throws SQLException {
        cliente = nCliente;
        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?)");
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellido());
        ps.setString(3, cliente.getTelefono());
        ps.setString(4, cliente.getDireccion());
        int res = ps.executeUpdate();
    }

    /**
     * Metodo utilizado para buscar clientes dentro de la base de datos conforme
     * a lo que el usuario haya ingresado por parte de la interfaz, para esto se
     * utilizo el comando Select * from que nos ofrece MySQL.
     *
     * @param tel Parametro por el cual se estara buscando al cliente en la base
     * de datos
     * @return cliente Retorna el cliente obtenido desde la base de datos
     * @throws SQLException
     */
    public Cliente buscar(long tel) throws SQLException {
        cliente = new Cliente();
        PreparedStatement ps;
        ResultSet res;
        ps = con.prepareStatement("Select * From Cliente where Telefono=?");
        ps.setLong(1, tel);
        res = ps.executeQuery();
        if (res.next()) {
            cliente.setNombre(res.getString("Nombre"));
            cliente.setApellido(res.getString("Apellido"));
            cliente.setTelefono(String.valueOf(res.getLong("Telefono")));
            cliente.setDireccion(res.getString("Direccion"));
        }
        return cliente;
    }

    /**
     * Metodo utilizado para buscar a todos los clientes registrados 
     * dentro de la base de datos
     * @return ArrayList de Clientes
     * @throws SQLException 
     */
    public ArrayList<Cliente> consultar() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet res;
        ps = con.prepareStatement("Select * From Cliente");
        res = ps.executeQuery();
        while (res.next()) {
            cliente = new Cliente();
            cliente.setNombre(res.getString("Nombre"));
            cliente.setApellido(res.getString("Apellido"));
            cliente.setTelefono(String.valueOf(res.getLong("Telefono")));
            cliente.setDireccion(res.getString("Direccion"));
            clientes.add(cliente);
        }
        return clientes;
    }
}
