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
public class Conector {

    Connection conn;

    public Connection conectorBaseDatos() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception E) {
            System.out.println("nop");
        }
        if (conn == null) {
            try {
                String url = "jdbc:sqlite:/home/monkeeboi/Instituto/tema-2-sql-MonkeeBoii/sql/baseDeDatos.db3";
                conn = DriverManager.getConnection(url);

                System.out.println("Conexion establecida olee");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            }
        }
        return conn;
    }

    public void cerrarConexion(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public List<Empleado> consultarBaseDatosEmpleado(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Empleado> empleados = new ArrayList<Empleado>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM empleado");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Empleado empleado = new Empleado(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                PreparedStatement consulta1 = conn.prepareStatement("SELECT * FROM trabajan WHERE codigoEmpleado==" + resultado.getInt(1));
                ResultSet resultado1 = consulta1.executeQuery();

                while (resultado1.next()) {
                    empleado.setCodigoProyecto(resultado1.getInt(3));
                }
                    
                empleados.add(empleado);
                
                if (consulta1 != null) {
                    try {
                        consulta1.close();
                        resultado1.close();
                    } catch (SQLException sqle2) {
                        sqle2.printStackTrace();
                    }
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (consulta != null) {
                try {
                    consulta.close();
                    if (resultado != null) {
                        resultado.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }

            }
        }
        return empleados;
    }
    
    public List<Proyecto> consultarBaseDatosProyecto(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Proyecto> proyectos = new ArrayList<Proyecto>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM proyecto");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Proyecto proyecto = new Proyecto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                PreparedStatement consulta1 = conn.prepareStatement("SELECT * FROM trabajan WHERE codigoProyecto==" + resultado.getInt(1));
                ResultSet resultado1 = consulta1.executeQuery();
                proyecto.setCodigoProducto(resultado.getInt(4));
                
                while (resultado1.next()) {
                    proyecto.setCodigoEmpleado(resultado1.getInt(2));
                }
                
                proyectos.add(proyecto);
                if (consulta1 != null) {
                    try {
                        consulta1.close();
                        resultado1.close();
                    } catch (SQLException sqle2) {
                        sqle2.printStackTrace();
                    }
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (consulta != null) {
                try {
                    consulta.close();
                    if (resultado != null) {
                        resultado.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }

            }
        }
        return proyectos;
    }
    
    public List<Producto> consultarBaseDatosProducto(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM productos");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Producto producto = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                PreparedStatement consulta1 = conn.prepareStatement("SELECT * FROM proyecto WHERE codigoProducto==" + resultado.getInt(1));
                ResultSet resultado1 = consulta1.executeQuery();
                producto.setCodigoProveedor(resultado.getInt(4));
                
                while (resultado1.next()) {
                    producto.setCodigoProyectos(resultado1.getInt(2));
                }
                
                productos.add(producto);
                if (consulta1 != null) {
                    try {
                        consulta1.close();
                        resultado1.close();
                    } catch (SQLException sqle2) {
                        sqle2.printStackTrace();
                    }
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (consulta != null) {
                try {
                    consulta.close();
                    if (resultado != null) {
                        resultado.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }

            }
        }
        return productos;
    }
}
