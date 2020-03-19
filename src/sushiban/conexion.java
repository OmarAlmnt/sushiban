/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sushiban;
import java.sql.*;

public class conexion {
    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/k1fHcxn5cd?autoReconnect=true&useSSL=false","k1fHcxn5cd","reqBtzJ9v5");
            System.out.println("funciona");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error:" +e);
        }
    }
}

