/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monkeeboi
 */
public class connector {
    
    public List<Empleado> accederBaseDatosEmpleados() {
         List<Empleado> empleados = new ArrayList<>();
         
          try{
        Class.forName("org.sqlite.JDBC");
        }
        catch(Exception E){
            System.out.println("nop");
        }
        
        Connection conn = null;
        
        try{
            String url = "jdbc:sqlite:/home/monkeeboi/Instituto/tema-2-sql-MonkeeBoii/baseDeDatos.db3 ";
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){}
        
        
        String cons = "SELECT * FROM empleado";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                
                int codigo = resultado.getInt(1);
                String dni = resultado.getString(2);
                String nombre = resultado.getString(3);
                
                Empleado empleado = new Empleado(codigo, dni, nombre);
                empleados.add(empleado);
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if (consulta != null){
                try{
                   consulta.close();
                    resultado.close(); 
                }
                catch(SQLException sqle2){
                    sqle2.printStackTrace();
                }
                
            }
        }
        
        
        // Cerrar conexion con la base de datos
        try{
            if (conn != null)
                conn.close();
        }
        catch(SQLException e2){
            System.out.println(e2.getMessage());
        }

        return empleados;
    }
    
    public List<Proyecto> accederBaseDatosProyecto() {
         List<Proyecto> proyectos = new ArrayList<>();
         
          try{
        Class.forName("org.sqlite.JDBC");
        }
        catch(Exception E){
            System.out.println("nop");
        }
        
        Connection conn = null;
        
        try{
            String url = "jdbc:sqlite:/home/monkeeboi/Instituto/tema-2-sql-MonkeeBoii/baseDeDatos.db3 ";
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){}
        
        
        String cons = "SELECT * FROM proyecto";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                
                String codigo = resultado.getString(1);
                String nombre = resultado.getString(2);
                String presupuesto = resultado.getString(3);
                String codigoProducto = resultado.getString(4);
                
                Proyecto proyecto = new Proyecto(codigo, nombre, presupuesto);
                
                proyecto.setCodigoProducto(codigoProducto);
                proyectos.add(proyecto);
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if (consulta != null){
                try{
                   consulta.close();
                    resultado.close(); 
                }
                catch(SQLException sqle2){
                    sqle2.printStackTrace();
                }
                
            }
        }
        
        
        // Cerrar conexion con la base de datos
        try{
            if (conn != null)
                conn.close();
        }
        catch(SQLException e2){
            System.out.println(e2.getMessage());
        }

        return proyectos;
    }
    
    public List<Proveedor> accederBaseDatosProveedor() {
         List<Proveedor> proveedores = new ArrayList<>();
         
          try{
        Class.forName("org.sqlite.JDBC");
        }
        catch(Exception E){
            System.out.println("nop");
        }
        
        Connection conn = null;
        
        try{
            String url = "jdbc:sqlite:/home/monkeeboi/Instituto/tema-2-sql-MonkeeBoii/baseDeDatos.db3 ";
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){}
        
        
        String cons = "SELECT * FROM proveedor";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                
                String codigo = resultado.getString(1);
                String nombre = resultado.getString(2);
                String codigoProducto = resultado.getString(3);
                
                Proveedor proveedor = new Proveedor(codigo, nombre);
                
                proveedor.setCodigoProducto(codigoProducto);
                proveedores.add(proveedor);
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if (consulta != null){
                try{
                   consulta.close();
                    resultado.close(); 
                }
                catch(SQLException sqle2){
                    sqle2.printStackTrace();
                }
                
            }
        }
        
        
        // Cerrar conexion con la base de datos
        try{
            if (conn != null)
                conn.close();
        }
        catch(SQLException e2){
            System.out.println(e2.getMessage());
        }

        return proveedores;
    }
    
    public List<Producto> accederBaseDatosProducto() {
         List<Producto> productos = new ArrayList<>();
         
          try{
        Class.forName("org.sqlite.JDBC");
        }
        catch(Exception E){
            System.out.println("nop");
        }
        
        Connection conn = null;
        
        try{
            String url = "jdbc:sqlite:/home/monkeeboi/Instituto/tema-2-sql-MonkeeBoii/baseDeDatos.db3 ";
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){}
        
        
        String cons = "SELECT * FROM producto";
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        
        try{
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();
            
            while(resultado.next()){
                
                String codigo = resultado.getString(1);
                String dni = resultado.getString(2);
                int precio = resultado.getInt(3);
                
                Producto producto = new Producto(codigo, dni, precio);
                productos.add(producto);
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if (consulta != null){
                try{
                   consulta.close();
                    resultado.close(); 
                }
                catch(SQLException sqle2){
                    sqle2.printStackTrace();
                }
                
            }
        }
        
        
        // Cerrar conexion con la base de datos
        try{
            if (conn != null)
                conn.close();
        }
        catch(SQLException e2){
            System.out.println(e2.getMessage());
        }

        return productos;
    }
}
