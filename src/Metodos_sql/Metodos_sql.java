/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;




public class Metodos_sql {

 public static conexion cn=new conexion();


        
    public static boolean login(String correo, String password) throws SQLException {
           boolean intento = false;
        
        Statement st = null;
        ResultSet sp = null;
        st=cn.con.createStatement();
        try {
            sp=st.executeQuery("select * from usuario where");
        } catch (SQLException ex) {
        }
        try {
            while (sp.next()) {

                if (sp.getString("correo").equals(correo) && sp.getString("password").equals(password) ){
                    intento = true;
                
                
                    break;

                }

            }
        } catch (SQLException ex) {

            System.out.println(ex);

        }
        return intento;
    }
    
    
    
}
