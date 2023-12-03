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

    /**
     * Constructor de la clase Conector. Se encarga de establecer la conexión a
     * la base de datos SQLite.
     */
    public Conector(String nombreBaseDatos) {
        try {
            // URL de conexión a la base de datos SQLite
            String url = "jdbc:sqlite:" + nombreBaseDatos;

            // Intentar establecer la conexión utilizando el DriverManager
            conn = DriverManager.getConnection(url);

            // Imprimir mensaje en la consola indicando que la conexión se ha establecido con éxito
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            // En caso de error, imprimir el mensaje de la excepción en la consola
            System.out.println(e.getMessage());
        }
    }

    /**
     * Establece la conexión con la base de datos.
     *
     * @return La conexión establecida con la base de datos.
     */
    public Connection conectorBaseDatos() {
        return conn;
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @param conn La conexión a la base de datos que se cerrará.
     * @throws SQLException Si ocurre un error al intentar cerrar la conexión.
     */
    public void cerrarConexion(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Consulta la base de datos para obtener la lista de empleados.
     *
     * @param conn La conexión a la base de datos.
     * @return Una lista de objetos Empleado que representa los registros
     * obtenidos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Empleado> consultarBaseDatosEmpleado(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Empleado> empleados = new ArrayList<>();

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

    /**
     * Consulta la base de datos para obtener la lista de proyectos.
     *
     * @param conn La conexión a la base de datos.
     * @return Una lista de objetos Proyecto que representa los registros
     * obtenidos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Proyecto> consultarBaseDatosProyecto(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Proyecto> proyectos = new ArrayList<>();

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

    /**
     * Consulta la base de datos para obtener la lista de productos.
     *
     * @param conn La conexión a la base de datos.
     * @return Una lista de objetos Producto que representa los registros
     * obtenidos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Producto> consultarBaseDatosProducto(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Producto> productos = new ArrayList<>();

        try {
            consulta = conn.prepareStatement("SELECT * FROM producto");
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                Producto producto = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));

                // Consulta para obtener proyectos relacionados con el producto
                PreparedStatement consulta1 = conn.prepareStatement("SELECT * FROM proyecto WHERE codigoProducto = ?");
                consulta1.setInt(1, resultado.getInt(1));
                ResultSet resultado1 = consulta1.executeQuery();

                if (resultado.getInt(4) != 0) {
                    producto.setCodigoProveedor(resultado.getInt(4));
                }

                while (resultado1.next()) {
                    producto.setCodigoProyectos(resultado1.getInt(2));
                }

                productos.add(producto);

                // Cierre de recursos de la consulta de proyectos
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
            // Cierre de recursos de la consulta principal
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

    /**
     * Consulta la base de datos para obtener la lista de proveedores.
     *
     * @param conn La conexión a la base de datos.
     * @return Una lista de objetos Proveedor que representa los registros
     * obtenidos.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Proveedor> consultarBaseDatosProveedor(Connection conn) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Proveedor> proveedores = new ArrayList<>();

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

    /**
     * Añade un nuevo producto a la base de datos.
     *
     * @param nombre El nombre del nuevo producto.
     * @param precio El precio del nuevo producto.
     * @throws SQLException Si ocurre un error al ejecutar la inserción o al
     * cerrar los recursos.
     */
    public void anadirProductoBaseDatos(String nombre, Integer precio) throws SQLException {
        // Sentencia SQL para la inserción de un nuevo producto
        String sentenciaSQL = "INSERT INTO producto (Codigo, Nombre, Precio) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sentenciaSQL);

        // Guardar el estado de AutoCommit actual y desactivarlo
        final boolean oldAutoCommit = statement.getConnection().getAutoCommit();
        statement.getConnection().setAutoCommit(false);

        try {
            try {
                // Preparar la sentencia con los parámetros
                statement.setString(2, nombre);
                statement.setInt(3, precio);

                // Ejecutar la inserción
                statement.executeUpdate();

                // Obtener las claves generadas, si las hay
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // Actualizar el código del producto con la clave generada
                    statement.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                // Cerrar el statement
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            // En caso de excepción, realizar un rollback
            statement.getConnection().rollback();
        } finally {
            // Realizar un commit y restaurar el estado original de AutoCommit
            statement.getConnection().commit();
            statement.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    /**
     * Añade un nuevo empleado a la base de datos.
     *
     * @param dni El número de DNI del nuevo empleado.
     * @param nombre El nombre del nuevo empleado.
     * @throws SQLException Si ocurre un error al ejecutar la inserción o al
     * cerrar los recursos.
     */
    public void anadirEmpleadoBaseDatos(String dni, String nombre) throws SQLException {
        // Sentencia SQL para la inserción de un nuevo empleado
        String sentenciaSQL = "INSERT INTO empleado (Codigo, DNI, Nombre) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sentenciaSQL);

        // Guardar el estado de AutoCommit actual y desactivarlo
        final boolean oldAutoCommit = statement.getConnection().getAutoCommit();
        statement.getConnection().setAutoCommit(false);

        try {
            try {
                // Preparar la sentencia con los parámetros
                statement.setString(2, dni);
                statement.setString(3, nombre);

                // Ejecutar la inserción
                statement.executeUpdate();

                // Obtener las claves generadas, si las hay
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // Actualizar el código del empleado con la clave generada
                    statement.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                // Cerrar el statement
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            // En caso de excepción, realizar un rollback
            statement.getConnection().rollback();
        } finally {
            // Realizar un commit y restaurar el estado original de AutoCommit
            statement.getConnection().commit();
            statement.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    /**
     * Añade un nuevo proyecto a la base de datos.
     *
     * @param nombre El nombre del nuevo proyecto.
     * @param presupuesto El presupuesto del nuevo proyecto.
     * @throws SQLException Si ocurre un error al ejecutar la inserción o al
     * cerrar los recursos.
     */
    public void anadirProyectoBaseDatos(String nombre, Integer presupuesto) throws SQLException {
        // Sentencia SQL para la inserción de un nuevo proyecto
        String sentenciaSQL = "INSERT INTO proyecto (Codigo, Nombre, Presupuesto) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sentenciaSQL);

        // Guardar el estado de AutoCommit actual y desactivarlo
        final boolean oldAutoCommit = statement.getConnection().getAutoCommit();
        statement.getConnection().setAutoCommit(false);

        try {
            try {
                // Preparar la sentencia con los parámetros
                statement.setString(2, nombre);
                statement.setInt(3, presupuesto);

                // Ejecutar la inserción
                statement.executeUpdate();

                // Obtener las claves generadas, si las hay
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // Actualizar el código del proyecto con la clave generada
                    statement.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                // Cerrar el statement
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            // En caso de excepción, realizar un rollback
            statement.getConnection().rollback();
        } finally {
            // Realizar un commit y restaurar el estado original de AutoCommit
            statement.getConnection().commit();
            statement.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    /**
     * Añade un nuevo proveedor a la base de datos.
     *
     * @param nombre El nombre del nuevo proveedor.
     * @throws SQLException Si ocurre un error al ejecutar la inserción o al
     * cerrar los recursos.
     */
    public void anadirProveedorBaseDatos(String nombre) throws SQLException {
        // Sentencia SQL para la inserción de un nuevo proveedor
        String sentenciaSQL = "INSERT INTO Proveedor (Codigo, Nombre) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sentenciaSQL);

        // Guardar el estado de AutoCommit actual y desactivarlo
        final boolean oldAutoCommit = statement.getConnection().getAutoCommit();
        statement.getConnection().setAutoCommit(false);

        try {
            try {
                // Preparar la sentencia con los parámetros
                statement.setString(2, nombre);

                // Ejecutar la inserción
                statement.executeUpdate();

                // Obtener las claves generadas, si las hay
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // Actualizar el código del proveedor con la clave generada
                    statement.setInt(1, id);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                // Cerrar el statement
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            // En caso de excepción, realizar un rollback
            statement.getConnection().rollback();
        } finally {
            // Realizar un commit y restaurar el estado original de AutoCommit
            statement.getConnection().commit();
            statement.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    /**
     * Elimina un objeto de la base de datos mediante una consulta específica.
     *
     * @param codigo El código del objeto a eliminar.
     * @param consulta La consulta SQL para realizar la eliminación.
     * @throws SQLException Si ocurre un error al ejecutar la eliminación o al
     * cerrar los recursos.
     */
    public void eliminarObjetoBaseDatos(int codigo, String consulta) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(consulta)) {
            // Guardar el estado de AutoCommit actual y desactivarlo
            final boolean oldAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);

            try {
                // Establecer el parámetro de código en la consulta
                statement.setInt(1, codigo);

                // Ejecutar la eliminación
                statement.executeUpdate();

                // Confirmar la transacción
                conn.commit();
            } catch (SQLException sqle) {
                // En caso de error, realizar un rollback
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException rollbackException) {
                        rollbackException.printStackTrace();
                    }
                }
                sqle.printStackTrace();
            } finally {
                // Restaurar el estado original de AutoCommit
                conn.setAutoCommit(oldAutoCommit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica un producto en la base de datos.
     *
     * @param id La ID del producto a modificar.
     * @param nuevoNombre El nuevo nombre del producto.
     * @param nuevoPrecio El nuevo precio del producto.
     * @throws SQLException Si ocurre un error al ejecutar la actualización o al
     * cerrar los recursos.
     */
    public void modificarProductoBaseDatos(Integer id, String nuevoNombre, Integer nuevoPrecio) throws SQLException {
        // Sentencia SQL para la actualización del producto
        String sentencia = "UPDATE producto SET Nombre = ?, Precio = ? WHERE Codigo = ?";
        try (PreparedStatement statement = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            statement.setString(1, nuevoNombre);
            statement.setInt(2, nuevoPrecio);
            statement.setInt(3, id);

            // Ejecutar la actualización
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se encontró el producto y se realizó la modificación
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún producto con la ID proporcionada.");
            } else {
                System.out.println("Producto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            // En caso de error, imprimir la traza y realizar un rollback
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Modifica un empleado en la base de datos.
     *
     * @param id La ID del empleado a modificar.
     * @param dni El nuevo número de DNI del empleado.
     * @param nombre El nuevo nombre del empleado.
     * @throws SQLException Si ocurre un error al ejecutar la actualización o al
     * cerrar los recursos.
     */
    public void modificarEmpleadoBaseDatos(Integer id, String dni, String nombre) throws SQLException {
        // Sentencia SQL para la actualización del empleado
        String sentencia = "UPDATE empleado SET DNI = ?, Nombre = ? WHERE Codigo = ?";
        try (PreparedStatement statement = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setInt(3, id);

            // Ejecutar la actualización
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se encontró el empleado y se realizó la modificación
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún empleado con la ID proporcionada.");
            } else {
                System.out.println("Empleado modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            // En caso de error, imprimir la traza y realizar un rollback
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Modifica un proyecto en la base de datos.
     *
     * @param id La ID del proyecto a modificar.
     * @param nombre El nuevo nombre del proyecto.
     * @param presupuesto El nuevo presupuesto del proyecto.
     * @throws SQLException Si ocurre un error al ejecutar la actualización o al
     * cerrar los recursos.
     */
    public void modificarProyectoBaseDatos(Integer id, String nombre, Integer presupuesto) throws SQLException {
        // Sentencia SQL para la actualización del proyecto
        String sentencia = "UPDATE proyecto SET Nombre = ?, Presupuesto = ? WHERE Codigo = ?";
        try (PreparedStatement statement = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            statement.setString(1, nombre);
            statement.setInt(2, presupuesto);
            statement.setInt(3, id);

            // Ejecutar la actualización
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se encontró el proyecto y se realizó la modificación
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún proyecto con la ID proporcionada.");
            } else {
                System.out.println("Proyecto modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            // En caso de error, imprimir la traza y realizar un rollback
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Modifica un proveedor en la base de datos.
     *
     * @param id La ID del proveedor a modificar.
     * @param nombre El nuevo nombre del proveedor.
     * @throws SQLException Si ocurre un error al ejecutar la actualización o al
     * cerrar los recursos.
     */
    public void modificarProveedorBaseDatos(Integer id, String nombre) throws SQLException {
        // Sentencia SQL para la actualización del proveedor
        String sentencia = "UPDATE proveedor SET Nombre = ? WHERE Codigo = ?";
        try (PreparedStatement statement = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            statement.setString(1, nombre);
            statement.setInt(2, id);

            // Ejecutar la actualización
            int filasAfectadas = statement.executeUpdate();

            // Verificar si se encontró el proveedor y se realizó la modificación
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún proveedor con la ID proporcionada.");
            } else {
                System.out.println("Proveedor modificado exitosamente.");
            }
        } catch (SQLException sqle) {
            // En caso de error, imprimir la traza y realizar un rollback
            sqle.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Busca un empleado en la base de datos por su ID.
     *
     * @param id La ID del empleado a buscar.
     * @return Un objeto Empleado si se encuentra, o null si no se encuentra.
     */
    public Empleado buscarEmpleado(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Preparar la consulta SQL para buscar un empleado por su ID
            consulta = conn.prepareStatement("SELECT * FROM empleado WHERE Codigo = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Empleado
            if (resultado.next()) {
                // Crear un objeto Empleado con los datos obtenidos de la consulta
                Empleado empleado = new Empleado(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
                return empleado;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún empleado con el ID: " + id);
                return null;
            }
        } catch (SQLException sqle) {
            // Manejar la excepción (puedes imprimir la traza, lanzar una excepción diferente, etc.)
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // En caso de error, o si no se encontró el empleado, devolver null
        return null;
    }

    /**
     * Busca un proyecto en la base de datos por su ID.
     *
     * @param id La ID del proyecto a buscar.
     * @return Un objeto Proyecto si se encuentra, o null si no se encuentra.
     */
    public Proyecto buscarProyecto(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Preparar la consulta SQL para buscar un proyecto por su ID
            consulta = conn.prepareStatement("SELECT * FROM proyecto WHERE Codigo = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Proyecto
            if (resultado.next()) {
                // Crear un objeto Proyecto con los datos obtenidos de la consulta
                Proyecto proyecto = new Proyecto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                proyecto.setCodigoProducto(resultado.getInt(4));
                return proyecto;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún proyecto con el ID: " + id);
                return null;
            }
        } catch (SQLException sqle) {
            // Manejar la excepción (puedes imprimir la traza, lanzar una excepción diferente, etc.)
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // En caso de error, o si no se encontró el proyecto, devolver null
        return null;
    }

    /**
     * Busca un producto en la base de datos por su ID.
     *
     * @param id La ID del producto a buscar.
     * @return Un objeto Producto si se encuentra, o null si no se encuentra.
     */
    public Producto buscarProducto(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Preparar la consulta SQL para buscar un producto por su ID
            consulta = conn.prepareStatement("SELECT * FROM producto WHERE Codigo = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Producto
            if (resultado.next()) {
                // Crear un objeto Producto con los datos obtenidos de la consulta
                Producto producto = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
                producto.setCodigoProveedor(resultado.getInt(4));
                return producto;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún producto con el ID: " + id);
                return null;
            }
        } catch (SQLException sqle) {
            // Manejar la excepción (puedes imprimir la traza, lanzar una excepción diferente, etc.)
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // En caso de error, o si no se encontró el producto, devolver null
        return null;
    }

    /**
     * Busca un proveedor en la base de datos por su ID.
     *
     * @param id La ID del proveedor a buscar.
     * @return Un objeto Proveedor si se encuentra, o null si no se encuentra.
     */
    public Proveedor buscarProveedor(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            // Preparar la consulta SQL para buscar un proveedor por su ID
            consulta = conn.prepareStatement("SELECT * FROM proveedor WHERE Codigo = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Verificar si hay resultados antes de intentar crear un objeto Proveedor
            if (resultado.next()) {
                // Crear un objeto Proveedor con los datos obtenidos de la consulta
                Proveedor proveedor = new Proveedor(resultado.getInt(1), resultado.getString(2));
                proveedor.setProductoProveedor(resultado.getInt(3));
                return proveedor;
            } else {
                // No hay resultados, puedes manejarlo de alguna manera (lanzar una excepción, devolver un valor predeterminado, etc.)
                System.out.println("No se encontró ningún proveedor con el ID: " + id);
                return null;
            }
        } catch (SQLException sqle) {
            // Manejar la excepción (puedes imprimir la traza, lanzar una excepción diferente, etc.)
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // En caso de error, o si no se encontró el proveedor, devolver null
        return null;
    }

    /**
     * Añade una relación entre un proyecto y un empleado en la base de datos.
     *
     * @param id La ID del proyecto.
     * @param id2 La ID del empleado.
     * @throws SQLException Si ocurre un error al ejecutar la inserción o al
     * cerrar los recursos.
     */
    public void anadirRelacionProyectoEmpleado(Integer id, Integer id2) throws SQLException {
        // Sentencia SQL para la inserción de la relación proyecto-empleado
        String sent = "INSERT INTO trabajan (CodigoProyecto, CodigoEmpleado) VALUES (?, ?)";
        PreparedStatement stat = conn.prepareStatement(sent);

        final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
        stat.getConnection().setAutoCommit(false);

        try {
            try {
                // Establecer los parámetros en la sentencia
                stat.setInt(1, id);
                stat.setInt(2, id2);

                // Ejecutar la inserción
                stat.executeUpdate();
                ResultSet generateKeys = stat.getGeneratedKeys();

                // Obtener la clave generada, si es necesario
                if (generateKeys.next()) {
                    int id1 = generateKeys.getInt(1);
                    stat.setInt(1, id1);
                }
            } catch (SQLException sqle) {
                // Imprimir la traza en caso de error
                sqle.printStackTrace();
            } finally {
                // Cerrar el recurso PreparedStatement
                try {
                    stat.close();
                } catch (SQLException sqle2) {
                    sqle2.printStackTrace();
                }
            }
        } catch (Exception e) {
            // En caso de error, realizar un rollback
            stat.getConnection().rollback();
        } finally {
            // Realizar el commit y restaurar la configuración original de AutoCommit
            stat.getConnection().commit();
            stat.getConnection().setAutoCommit(oldAutoCommit);
        }
    }

    /**
     * Busca empleados asociados a un proyecto en la base de datos.
     *
     * @param id La ID del proyecto.
     * @return Una lista de IDs de empleados asociados al proyecto.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Integer> buscarEmpleadoRelacionTrabajan(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Integer> integers = new ArrayList<>();

        try {
            // Preparar la consulta SQL para buscar empleados asociados a un proyecto
            consulta = conn.prepareStatement("SELECT * FROM trabajan WHERE CodigoProyecto = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Recorrer los resultados y añadir las IDs de empleados a la lista
            while (resultado.next()) {
                integers.add(resultado.getInt(2));
            }
        } catch (SQLException sqle) {
            // Imprimir la traza en caso de error
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // Devolver la lista de IDs de empleados asociados al proyecto
        return integers;
    }

    /**
     * Busca proyectos asociados a un empleado en la base de datos.
     *
     * @param id La ID del empleado.
     * @return Una lista de IDs de proyectos asociados al empleado.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * cerrar los recursos.
     */
    public List<Integer> buscarProyectoRelacionTrabajan(Integer id) {
        PreparedStatement consulta = null;
        ResultSet resultado = null;
        List<Integer> integers = new ArrayList<>();

        try {
            // Preparar la consulta SQL para buscar proyectos asociados a un empleado
            consulta = conn.prepareStatement("SELECT * FROM trabajan WHERE CodigoEmpleado = ?");
            consulta.setInt(1, id);

            // Ejecutar la consulta
            resultado = consulta.executeQuery();

            // Recorrer los resultados y añadir las IDs de proyectos a la lista
            while (resultado.next()) {
                integers.add(resultado.getInt(3));
            }
        } catch (SQLException sqle) {
            // Imprimir la traza en caso de error
            sqle.printStackTrace();
        } finally {
            // Cerrar los recursos en el bloque finally para asegurar su liberación
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

        // Devolver la lista de IDs de proyectos asociados al empleado
        return integers;
    }

    /**
     * Inserta o modifica una relación entre un proyecto y un producto en la
     * base de datos.
     *
     * @param id La ID del proyecto o producto, dependiendo de la consulta
     * proporcionada.
     * @param consulta La consulta SQL que determina la relación y cómo insertar
     * o modificar los datos.
     * @param nuevo La nueva información a insertar o modificar en la relación.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * realizar un rollback.
     */
    public void insertarRelacionEnProyectoElProducto(Integer id, String consulta, Integer nuevo) throws SQLException {
        String sentencia = consulta;

        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            stat.setInt(1, nuevo);
            stat.setInt(2, id);

            // Ejecutar la consulta
            int filasAfectadas = stat.executeUpdate();

            // Verificar el resultado de la ejecución
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún registro con la ID proporcionada.");
            } else {
                System.out.println("Registro modificado o insertado exitosamente.");
            }
        } catch (SQLException sqle) {
            // Imprimir la traza en caso de error
            sqle.printStackTrace();

            // Realizar rollback en caso de error
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Inserta o modifica una relación entre un proveedor y un producto en la
     * base de datos.
     *
     * @param id La ID del proveedor o producto, dependiendo de la consulta
     * proporcionada.
     * @param consulta La consulta SQL que determina la relación y cómo insertar
     * o modificar los datos.
     * @param nuevo La nueva información a insertar o modificar en la relación.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * realizar un rollback.
     */
    public void insertarRelacionEnProveedorElProducto(Integer id, String consulta, Integer nuevo) throws SQLException {
        String sentencia = consulta;

        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            // Establecer los parámetros en la sentencia
            stat.setInt(1, nuevo);
            stat.setInt(2, id);

            // Ejecutar la consulta
            int filasAfectadas = stat.executeUpdate();

            // Verificar el resultado de la ejecución
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún registro con la ID proporcionada.");
            } else {
                System.out.println("Registro modificado o insertado exitosamente.");
            }
        } catch (SQLException sqle) {
            // Imprimir la traza en caso de error
            sqle.printStackTrace();

            // Realizar rollback en caso de error
            if (conn != null) {
                conn.rollback();
            }
        }
    }

    /**
     * Elimina una relación en la base de datos utilizando una consulta
     * específica y una ID.
     *
     * @param id La ID del registro a eliminar.
     * @param consulta La consulta SQL que determina qué relación eliminar y
     * cómo realizar la operación.
     * @throws SQLException Si ocurre un error al ejecutar la consulta o al
     * realizar un rollback.
     */
    public void eliminarRelacion(String id, String consulta) throws SQLException {
        String sentencia = consulta + id;

        try (PreparedStatement stat = conn.prepareStatement(sentencia)) {
            // Establecer el parámetro en la sentencia como null
            stat.setString(1, null);

            // Ejecutar la consulta
            int filasAfectadas = stat.executeUpdate();

            // Verificar el resultado de la ejecución
            if (filasAfectadas == 0) {
                System.out.println("No se encontró ningún registro con la ID proporcionada.");
            } else {
                System.out.println("Registro eliminado exitosamente.");
            }
        } catch (SQLException sqle) {
            // Imprimir la traza en caso de error
            sqle.printStackTrace();

            // Realizar rollback en caso de error
            if (conn != null) {
                conn.rollback();
            }
        }
    }

}
