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



        
 @SuppressWarnings("empty-statement")
    public static String[] login(String correo, String password) throws SQLException {
       
        String[] session = new String[2];
        Statement st = null;
        ResultSet sp = null;
        st=cn.con.createStatement();
        String nombre = "";
        String confirmacion = "";
        try {
            sp=st.executeQuery("select * from usuario");
        } catch (SQLException ex) {
        }
        try {
            while (sp.next()) {

                if (sp.getString("correo").equals(correo) && sp.getString("password").equals(password) ){
                    
                     nombre = sp.getString("nombre");
                     confirmacion = "true";
                     break;
                }else{
                    nombre = "error";
                    confirmacion = "false";
                }

            }
        } catch (SQLException ex) {

            System.out.println(ex);

        }
     
        session[0] = confirmacion;
        session[1]= nombre;
        return session;
        
    }
    
    
    
}
