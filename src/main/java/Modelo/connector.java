package Modelo;

import Modelo.RowMappers.EmpleadoRowMapper;
import Modelo.RowMappers.ProyectoRowMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Calls;

/**
 *
 * @author monkeeboi
 */
public class Connector {

    Calls calls = new Calls();

    public List<Empleado> accederBaseDatosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception E) {
        }

        empleados = calls.recogerTabla(new ArrayList<>(), "SELECT * FROM empleado", new EmpleadoRowMapper());

        return empleados;
    }

    public List<Proyecto> accederBaseDatosProyecto() {
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception E) {
        }

        proyectos = calls.recogerTabla(new ArrayList<>(), "SELECT * FROM proyecto", new ProyectoRowMapper());

        return proyectos;
    }

    public List<Proveedor> accederBaseDatosProveedor() {
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception E) {
        }

        proveedores = calls.recogerTabla(new ArrayList<>(), "SELECT * FROM proveedor", new ProveedorRowMapper());

        return proveedores;
    }

    public List<Producto> accederBaseDatosProducto() {
        List<Producto> productos = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception E) {
            System.out.println("nop");
        }

        Connection conn = null;

        try {
            String url = "jdbc:sqlite:baseDeDatos.db3";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
        }

        String cons = "SELECT * FROM producto";
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            consulta = conn.prepareStatement(cons);
            resultado = consulta.executeQuery();

            while (resultado.next()) {

                String codigo = resultado.getString(1);
                String dni = resultado.getString(2);
                int precio = resultado.getInt(3);

                Producto producto = new Producto(codigo, dni, precio);
                productos.add(producto);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (consulta != null) {
                try {
                    consulta.close();
                    resultado.close();
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }

            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }

        return productos;
    }
}
