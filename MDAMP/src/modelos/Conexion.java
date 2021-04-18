/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author magdielo-pacheco
 */
public class Conexion {
     private static Connection con=null;
    
    static{
    String URL="jdbc:mysql://localhost:3306/MiPollo";
    String USERNAME="CesarP";
    String PASSWORD="AsaderoMP";
     try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion Exitosa");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public static Connection getConnection(){
        return con;
    }
    
    public static Connection desconectar() throws SQLException{
        con.close();
        System.out.println("Adiós");
        return con;
    }
}
