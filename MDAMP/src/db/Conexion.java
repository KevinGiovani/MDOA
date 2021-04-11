/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author magdielo-pacheco
 */
public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/MiPollo";
    private static final String USERNAME="CesarP";
    private static final String PASSWORD="AsaderoMP";
    
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion Exitosa");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
    
}
