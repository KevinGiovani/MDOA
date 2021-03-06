/*
 * Clase encargada del manejo de los pedidos dentro de la base de datos, para esto se
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
public class BDPedido {

    private Pedido pedido;
    private static Connection con;

    /**
     * Constructor de la clase donde se establece la conexion hacia la base de
     * datos
     */
    public BDPedido() {
        con = Conexion.getConnection();
    }

    /**
     * Metodo utilizado para agregar nuevos pedidos dentro de la base de datos
     * conforme a lo que el usuario haya ingresado por parte de la interfaz,
     * para esto se utilizo el comando INSERT INTO que nos ofrece MySQL
     *
     * @param nPedido Creacion de nuevo objeto tipo Pedido
     * @throws SQLException
     */
    public void agregarDatos(Pedido nPedido) throws SQLException {
        pedido = nPedido;
        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO Pedido (Id_Cliente,Paquete,Extra,Fecha,Total) VALUES (?,?,?,?,?)");
        ps.setLong(1, pedido.getIdCliente());
        ps.setString(2, pedido.getPaquete());
        ps.setString(3, pedido.getExtra());
        ps.setString(4, pedido.getFecha());
        ps.setInt(5, pedido.getTotal());
        ps.executeUpdate();

    }
    
    /**
     * Metodo utilizado para obtener todos los pedidos realizados dentro de la base de datos
     * @return Arraylist de pedido
     * @throws SQLException 
     */
    public ArrayList<Pedido> consultar() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet res;
        ps = con.prepareStatement("Select * From Pedido");
        res = ps.executeQuery();
        while (res.next()) {
            pedido = new Pedido();
            pedido.setIdPedido(res.getInt("Id_Pedido"));
            pedido.setIdCliente(res.getLong("Id_Cliente"));
            pedido.setPaquete(res.getString("Paquete"));
            pedido.setExtra(res.getString("Extra"));
            pedido.setFecha(res.getString("Fecha"));
            pedido.setTotal(res.getInt("Total"));
            pedidos.add(pedido);
        }
        return pedidos;
    }
    
    /**
     * Metodo utilizado para buscar un pedido en especifico
     * @param busqueda
     * @return pedido
     * @throws SQLException 
     */
    public ArrayList<Pedido> buscar(String busqueda) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet res;
        ps = con.prepareStatement(
                "Select * From Pedido where Id_Pedido like ?"
        );
        ps.setString(1, String.valueOf(busqueda) + "%");
        res = ps.executeQuery();
        while (res.next()) {
            pedido = new Pedido();
            pedido.setIdPedido(res.getInt("Id_Pedido"));
            pedido.setIdCliente(res.getLong("Id_Cliente"));
            pedido.setPaquete(res.getString("Paquete"));
            pedido.setExtra(res.getString("Extra"));
            pedido.setFecha(res.getString("Fecha"));
            pedido.setTotal(res.getInt("Total"));
            pedidos.add(pedido);
        }
        return pedidos;
    }
    
    /**
     * Metodo utilizado para obtener todos los pedidos de un cliente en especifico
     * @param busqueda
     * @return Arraylist de pedidos
     * @throws SQLException 
     */
    public ArrayList<Pedido> consultarPedidosPorNumTel(String busqueda) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("Select * From Pedido where Id_Cliente like ?");;
        ResultSet res;
        ps.setString(1, String.valueOf(busqueda) + "%");
        res = ps.executeQuery();
        while (res.next()) {
            pedido = new Pedido();
            pedido.setIdPedido(res.getInt("Id_Pedido"));
            pedido.setIdCliente(res.getLong("Id_Cliente"));
            pedido.setPaquete(res.getString("Paquete"));
            pedido.setExtra(res.getString("Extra"));
            pedido.setFecha(res.getString("Fecha"));
            pedido.setTotal(res.getInt("Total"));
            pedidos.add(pedido);
        }
        return pedidos;
    }
    
    
}
