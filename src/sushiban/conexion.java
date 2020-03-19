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
            con=DriverManager.getConnection("jdbc:mysql://b7o3f0z8mwzsjgdgl2qw-mysql.services.clever-cloud.com:3306/b7o3f0z8mwzsjgdgl2qw?autoReconnect=true&useSSL=false","ug848wzvhsoop2qb","OXPwl3nicWsclMYDgUwV");
            System.out.println("funciona");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error:" +e);
        }
    }
}

