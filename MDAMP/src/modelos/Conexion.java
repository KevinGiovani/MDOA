/*
 * Clase utilizada para realizar la conexion hacia la base de datos, para esto 
 * se asigno la direccion URL, nombre de usuario al igual que la contraseña a utilizar
 * para ingresar a esta base de datos antes mencionada por parte de MySQL.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pacheco Magdiel
 * @version 16-04-2021
 */
public class Conexion {

    private static Connection con = null;

    static {
        String URL = "jdbc:mysql://localhost:3306/MiPollo"; //URL utilizado para el ingreso hacia la base de datos
        String USERNAME = "cesarP"; //Usuario principal de la base de datos
        String PASSWORD = "AsaderoMP"; //Contraseña para el usuario principal
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Uso de la libreria jdbc especializada en la conexion de la base de datos
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion Exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo estatico para establecer la conexion hacia la base de datos
     *
     * @return Regresa el estado de la conexion
     */
    public static Connection getConnection() {
        return con;
    }

    /**
     * Metodo estatico para desconectarse de la base de datos
     *
     * @return Regresa el estado de la conexion
     * @throws SQLException
     */
    public static Connection desconectar() throws SQLException {
        con.close();
        System.out.println("Conexion finalizada");
        return con;
    }
}
