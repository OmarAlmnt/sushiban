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
            con=DriverManager.getConnection("jdbc:mysql://epiz_25365054_sushiban/woodtool","epiz_25365054","8ROhcEJNJwn0");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error:" +e);
        }
    }
}

