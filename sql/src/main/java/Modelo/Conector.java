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

    private Connection conn;

    public Conector() {
        try {
            String url = "jdbc:sqlite:baseDeDatos.db3";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection conectorBaseDatos() {
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

                empleados.add(empleado);

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
                proyecto.setCodigoProducto(resultado.getInt(4));

                proyectos.add(proyecto);

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
            consulta = conn.prepareStatement("SELECT * FROM producto");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Producto producto = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                PreparedStatement consulta1 = conn.prepareStatement("SELECT * FROM proyecto WHERE codigoProducto==" + resultado.getInt(1));
                ResultSet resultado1 = consulta1.executeQuery();

                if (resultado.getInt(4) != 0) {
                    producto.setCodigoProveedor(resultado.getInt(4));
                }

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

    public List<Proveedor> consultarBaseDatosProveedor(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Proveedor> proveedores = new ArrayList<Proveedor>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM proveedor");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Proveedor proveedor = new Proveedor(resultado.getInt(1), resultado.getString(2));
                if (resultado.getInt(3) != 0) {
                    proveedor.setProductoProveedor(resultado.getInt(3));
                }

                proveedores.add(proveedor);

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
        return proveedores;
    }

    public void anadirProductoBaseDatos(String nombre, Integer precio) throws SQLException {
        String sent = "INSERT INTO producto (Codigo, Nombre, Precio) VALUES (?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);
        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);
        try {
            try {
                stat = conn.prepareStatement(sent);

                stat.setString(2, nombre);
                stat.setInt(3, precio);

                stat.executeUpdate();

                ResultSet generateKeys = stat.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id = generateKeys.getInt(1);
                    stat.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                try {
                    if (stat != null) {
                        stat.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            stat.getConnection().rollback();
        } finally {
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    public void anadirEmpleadoBaseDatos(String dni, String nombre) throws SQLException {
        String sent = "INSERT INTO empleado (Codigo, DNI, Nombre) VALUES (?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);
        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);
        try {
            try {
                stat = conn.prepareStatement(sent);

                stat.setString(2, dni);
                stat.setString(3, nombre);

                stat.executeUpdate();
                ResultSet generateKeys = stat.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id = generateKeys.getInt(1);
                    stat.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                try {
                    if (stat != null) {
                        stat.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            stat.getConnection().rollback();
        } finally {
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    public void anadirProyectoBaseDatos(String nombre, Integer presupuesto) throws SQLException {
        String sent = "INSERT INTO proyecto (Codigo, Nombre, Presupuesto) VALUES (?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);
        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);
        try {
            try {
                stat = conn.prepareStatement(sent);

                stat.setString(2, nombre);
                stat.setInt(3, presupuesto);

                stat.executeUpdate();
                ResultSet generateKeys = stat.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id = generateKeys.getInt(1);
                    stat.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                try {
                    if (stat != null) {
                        stat.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            stat.getConnection().rollback();
        } finally {
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    public void anadirProveedorBaseDatos(String nombre) throws SQLException {
        String sent = "INSERT INTO Proveedor (Codigo, Nombre) VALUES (?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);
        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);
        try {
            try {
                stat = conn.prepareStatement(sent);

                stat.setString(2, nombre);

                stat.executeUpdate();
                ResultSet generateKeys = stat.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id = generateKeys.getInt(1);
                    stat.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                try {
                    if (stat != null) {
                        stat.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            stat.getConnection().rollback();
        } finally {
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    public void eliminarObjetoBaseDatos(int codigo, String consulta) throws SQLException {
        try (PreparedStatement stat = conn.prepareStatement(consulta)) {
            final boolean oldAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);

            try {
                stat.setInt(1, codigo);
                stat.executeUpdate();
                conn.commit();
            } catch (SQLException sqle) {
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackException) {
                        rollbackException.printStackTrace();
                    }
                }
                sqle.printStackTrace();
            } finally {
                conn.setAutoCommit(oldAutoCommit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarProductoBaseDatos(Integer id, String nuevoNombre, Integer nuevoPrecio) throws SQLException {
        String sentencia = "UPDATE producto SET Nombre = ?, Precio = ? WHERE Codigo = ?";
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setString(1, nuevoNombre);
            stat.setInt(2, nuevoPrecio);
            stat.setInt(3, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    public void modificarEmpleadoBaseDatos(Integer id, String dni, String nombre) throws SQLException {
        String sentencia = "UPDATE empleado SET DNI = ?, Nombre = ? WHERE Codigo = ?";
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setString(1, dni);
            stat.setString(2, nombre);
            stat.setInt(3, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    public void modificarProyectoBaseDatos(Integer id, String nombre, Integer presupuesto) throws SQLException {
        String sentencia = "UPDATE proyecto SET Nombre = ?, Presupuesto = ? WHERE Codigo = ?";
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setString(1, nombre);
            stat.setInt(2, presupuesto);
            stat.setInt(3, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    public void modificarProveedorBaseDatos(Integer id, String nombre) throws SQLException {
        String sentencia = "UPDATE proveedor SET Nombre = ? WHERE Codigo = ?";
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setString(1, nombre);
            stat.setInt(2, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    public Empleado buscarEmpleado(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conn.prepareStatement("SELECT * FROM empleado WHERE Codigo = ?");
            consulta.setInt(1, id);

            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Empleado
            if (resultado.next()) {
                Empleado empleado = new Empleado(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                return empleado;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún empleado con el ID: " + id);
                return null;
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
        return null;
    }

    public Proyecto buscarProyecto(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conn.prepareStatement("SELECT * FROM proyecto WHERE Codigo = ?");
            consulta.setInt(1, id);

            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Proyecto
            if (resultado.next()) {
                Proyecto proyecto = new Proyecto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                proyecto.setCodigoProducto(resultado.getInt(4));
                return proyecto;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún proyecto con el ID: " + id);
                return null;
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
        return null;
    }

    public Producto buscarProducto(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conn.prepareStatement("SELECT * FROM producto WHERE Codigo = ?");
            consulta.setInt(1, id);

            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Producto
            if (resultado.next()) {
                Producto producto = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                producto.setCodigoProveedor(resultado.getInt(4));
                return producto;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún producto con el ID: " + id);
                return null;
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
        return null;
    }

    public Proveedor buscarProveedor(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        try {
            consulta = conn.prepareStatement("SELECT * FROM proveedor WHERE Codigo = ?");
            consulta.setInt(1, id);

            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Proveedor
            if (resultado.next()) {
                Proveedor proveedor = new Proveedor(resultado.getInt(1), resultado.getString(2));
                proveedor.setProductoProveedor(resultado.getInt(3));
                return proveedor;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún proveedor con el ID: " + id);
                return null;
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
        return null;
    }

    public void anadirRelacionProyectoEmpleado(Integer id, Integer id2) throws SQLException {
        String sent = "INSERT INTO trabajan (Codigo, CodigoProyecto, CodigoEmpleado) VALUES (?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);
        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);
        try {
            try {
                stat = conn.prepareStatement(sent);

                stat.setInt(2, id);
                stat.setInt(3, id2);

                stat.executeUpdate();
                ResultSet generateKeys = stat.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id1 = generateKeys.getInt(1);
                    stat.setInt(1, id1);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                try {
                    stat.close();
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            stat.getConnection().rollback();
        } finally {
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    public List<Integer> buscarEmpleadoRelacioTrabajan(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Integer> integers = new ArrayList<Integer>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM trabajan WHERE CodigoProyecto==" + id);
            resultado = consulta.executeQuery();

            while (resultado.next()) {

                integers.add(resultado.getInt(2));

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
        return integers;
    }

    public List<Integer> buscarProyectoRelacioTrabajan(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Integer> integers = new ArrayList<Integer>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM trabajan WHERE CodigoEmpleado==" + id);
            resultado = consulta.executeQuery();

            while (resultado.next()) {

                integers.add(resultado.getInt(3));

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
        return integers;
    }

    public void insertarRelacionEnProyectoElProducto(Integer id, String consulta, Integer nuevo) throws SQLException {
        String sentencia = consulta;
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setInt(1, nuevo);
            stat.setInt(2, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }
    
    public void insertarRelacionEnProveedorElProducto(Integer id, String consulta, Integer nuevo) throws SQLException {
        String sentencia = consulta;
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setInt(1, nuevo);
            stat.setInt(2, id);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    public void eliminarRelacion(String id, String consulta) throws SQLException {
        String sentencia = consulta + id;
        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            stat.setString(1, null);

            int filasAfectadas = stat.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }
}
