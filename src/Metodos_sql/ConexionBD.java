/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alber
 */
public class ConexionBD {

    public static String url = "jdbc:mysql://remotemysql.com:3306/cHituHF5Qn?autoReconnect=true&useSSL=false";
    public static String usuario = "cHituHF5Qn";
    public static String contrasena = "OfAwx4SpnY";
    public static String clase = "com.mysql.jdbc.Driver";

    /*metodo de conexion*/
    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);
        }

        return conexion;

    }

    PreparedStatement prepareStatement(String sentencia_buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
