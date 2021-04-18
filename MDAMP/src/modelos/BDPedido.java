/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author magdielo-pacheco
 */
public class BDPedido {
    private Pedido pedido;
    private static Connection con;
    
    public BDPedido() {
        con=Conexion.getConnection();
    }
    public void agregarDatos(Pedido nPedido) throws SQLException {
        pedido=nPedido;
            PreparedStatement ps;
            ps=con.prepareStatement("INSERT INTO Pedido (Id_Cliente,Paquete,Extra,Fecha,Total) VALUES (?,?,?,?,?)");
            ps.setInt(1, pedido.getIdCliente());
            ps.setString(2, pedido.getPaquete());
            ps.setString(3, pedido.getExtra());
            ps.setString(4, pedido.getFecha());
            ps.setInt(5, pedido.getTotal());
            int res=ps.executeUpdate();
            
    }
}
