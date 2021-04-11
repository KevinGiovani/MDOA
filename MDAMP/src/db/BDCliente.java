/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author magdielo-pacheco
 */
public class BDCliente {
    

    public BDCliente() {
        
    }

    public void agregarDatos(String nombre,String apellido,String telefono,String direccion) {
        try{
            Connection con=null;
            con=Conexion.getConnection();
            PreparedStatement ps;
            ps=con.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telefono);
            ps.setString(4, direccion);
            int res=ps.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
