/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author magdielo-pacheco
 */
public class BDPedido {
    private Pedido pedido;
    
    public BDPedido() {
        
    }
    public void agregarDatos(Pedido nPedido) {
        pedido=nPedido;
        try{
            Connection con=null;
            con=Conexion.getConnection();
            PreparedStatement ps;
            ps=con.prepareStatement("INSERT INTO Pedido (Id_Cliente,Paquete,Extra,Fecha,Total) VALUES (?,?,?,?,?)");
            ps.setInt(1, pedido.getIdCliente());
            ps.setString(2, pedido.getPaquete());
            ps.setString(3, pedido.getExtra());
            ps.setString(4, pedido.getFecha());
            ps.setInt(5, pedido.getTotal());
            int res=ps.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
