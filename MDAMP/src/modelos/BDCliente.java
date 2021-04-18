/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author magdielo-pacheco
 */
public class BDCliente {
    private Cliente cliente;
    private static Connection con;
    
    public BDCliente() {
        con=Conexion.getConnection();
    }
    
    public void agregarDatos(Cliente nCliente) throws SQLException {
        cliente=nCliente;
            PreparedStatement ps;
            ps=con.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            int res=ps.executeUpdate();
    }
    
    public Cliente buscar(int tel) throws SQLException{
        cliente=new Cliente();
            PreparedStatement ps;
            ResultSet res;
            ps=con.prepareStatement("Select * From Cliente where Telefono=?");
            ps.setInt(1, tel);
            res=ps.executeQuery();
            if(res.next()){
                cliente.setNombre(res.getString("Nombre"));
                cliente.setApellido(res.getString("Apellido"));
                cliente.setTelefono(String.valueOf(res.getInt("Telefono")));
                cliente.setDireccion(res.getString("Direccion"));
            }
        return cliente;
    }
    
}
