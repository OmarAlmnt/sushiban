/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_sql;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sushiban.Frm_sistema;

/**
 *
 * @author Alber
 */
public class Metodos_sql {

    public static ConexionBD conexion = new ConexionBD();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static ResultSet resultado1;
    public static ResultSet resultado2;
    public static String sql;
    private Component rootPane;

    /**
     *
     * @param nombre
     * @param apellidos
     * @param correo
     * @param contrasena
     * @return
     */
    public ResultSet guardar(String nombre, String apellidos, String correo, String contrasena) {

        int reultado = 0;
        Connection conexion = null;
        
        

        String sentencia_guardar = ("INSERT INTO usuarios (nombre,apellidos,correo,contrasena) VALUES (?,?,?,?)");

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, correo);
            sentencia_preparada.setString(4, contrasena);

            int resultado = sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos insertados con éxito");
            sentencia_preparada.close();
            conexion.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Datos no insertados");
            JOptionPane.showMessageDialog(rootPane,e);

        }

        return resultado;

    }

    public static String buscarNombre(String correo) {
        String busqueda_nombre = null;
        Connection coneccion = null;
        try {
            conexion = (ConexionBD) ConexionBD.conectar();
            String sentencia_buscar = ("SELECT nombre,apellido FROM usuarios WHERE correo = '" + correo + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);

            }
            conexion.close();
        } catch (Exception e) {

            System.out.println(e);

        }

        return busqueda_nombre;
    }
    
    public static void buscarUsarioRegistrado(String id, String correo, String contrasena, String nombre, String apellidos) {
        String busqueda_usuario = null;
        Connection conexion = null;
        

        try {
            conexion = ConexionBD.conectar();
            sql = "SELECT id,nombre,correo,contrasena,apellidos FROM usuarios WHERE correo = '" + correo + "' && contrasena = '" + contrasena + "'";
            sentencia_preparada = conexion.prepareStatement(sql);
            resultado = sentencia_preparada.executeQuery();
            
            
             if(correo.equals("root") && contrasena.equals("root")){
             JOptionPane.showMessageDialog(null, "Binevenido iniciaste sesion como root");
                
                 Frm_sistema ventana = new Frm_sistema();
                 ventana.setVisible(true);
        }
             
           else if (resultado.next()) {
                correo = resultado.getString("correo");
                contrasena = resultado.getString("contrasena");
                nombre = resultado.getString("nombre");
                apellidos = resultado.getString("apellidos");
                
                id = resultado.getString("id");
                
        
                Frm_sistema ventana = new Frm_sistema();
                ventana.setVisible(true);

               JOptionPane.showMessageDialog(null, "Binevenido (a) " + nombre + " " + apellidos);
               
               
                
            } else {
                JOptionPane.showMessageDialog(null, "Error en el usuario o contrasena ingresada");
                
                
            }

        } catch (SQLException e) {
            
            System.out.println(e);
        }

    }

    private static class formulario {

        private static void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public formulario() {
        }
    }
    
    
}
