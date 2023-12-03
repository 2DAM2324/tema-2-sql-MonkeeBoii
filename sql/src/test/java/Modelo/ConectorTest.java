
import Modelo.Conector;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Proyecto;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConectorTest {

    private static Conector conector;

    @BeforeAll
    public static void setUpClass() throws Exception {
        // Inicializa el conector antes de las pruebas
        conector = new Conector("BaseDeDatos_1.db3");
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        // Cierra la conexión después de todas las pruebas
        conector.cerrarConexion(conector.conectorBaseDatos());
    }

    @Test
    public void testConectorBaseDatos() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        // Verifica que la conexión no sea nula
        assertNotNull(conexion, "La conexión no debería ser nula");

        // Verifica que la conexión sea la misma que la conexión interna del Conector
        assertEquals(conector.conectorBaseDatos(), conexion, "Las conexiones deberían ser iguales");
    }

    @Test
    public void testCerrarConexion() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        try {
            // Intenta cerrar la conexión
            conector.cerrarConexion(conexion);

            // Verifica que la conexión haya sido cerrada correctamente
            assertTrue(conexion.isClosed(), "La conexión debería estar cerrada");
        } catch (SQLException e) {
            fail("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    @Test
    public void testConsultarBaseDatosEmpleado() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        try {
            // Inserta datos de prueba en la base de datos
            insertarDatosDePrueba(conexion);

            // Ejecuta la consulta utilizando el método a probar
            List<Empleado> empleados = conector.consultarBaseDatosEmpleado(conexion);

            // Verifica que la lista de empleados no sea nula y contenga al menos un empleado
            assertNotNull(empleados, "La lista de empleados no debería ser nula");
            assertFalse(empleados.isEmpty(), "La lista de empleados no debería estar vacía");

            // Puedes agregar más aserciones según tus necesidades
        } catch (SQLException e) {
            fail("Error al ejecutar la prueba: " + e.getMessage());
        }
    }

    @Test
    public void testConsultarBaseDatosProyecto() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        try {
            // Inserta datos de prueba en la base de datos
            insertarDatosDePruebaProyecto(conexion);

            // Ejecuta la consulta utilizando el método a probar
            List<Proyecto> proyectos = conector.consultarBaseDatosProyecto(conexion);

            // Verifica que la lista de proyectos no sea nula y contenga al menos un proyecto
            assertNotNull(proyectos, "La lista de proyectos no debería ser nula");
            assertFalse(proyectos.isEmpty(), "La lista de proyectos no debería estar vacía");

            // Puedes agregar más aserciones según tus necesidades
        } catch (SQLException e) {
            fail("Error al ejecutar la prueba: " + e.getMessage());
        }
    }

    @Test
    public void testConsultarBaseDatosProducto() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        try {
            // Inserta datos de prueba en la base de datos
            insertarDatosDePruebaProducto(conexion);

            // Ejecuta la consulta utilizando el método a probar
            List<Producto> productos = conector.consultarBaseDatosProducto(conexion);

            // Verifica que la lista de productos no sea nula y contenga al menos un producto
            assertNotNull(productos, "La lista de productos no debería ser nula");
            assertFalse(productos.isEmpty(), "La lista de productos no debería estar vacía");

            // Puedes agregar más aserciones según tus necesidades
        } catch (SQLException e) {
            fail("Error al ejecutar la prueba: " + e.getMessage());
        }
    }

    @Test
    public void testConsultarBaseDatosProveedor() {
        // Obtiene la conexión utilizando el método conectorBaseDatos
        Connection conexion = conector.conectorBaseDatos();

        try {
            // Inserta datos de prueba en la base de datos
            insertarDatosDePruebaProveedor(conexion);

            // Ejecuta la consulta utilizando el método a probar
            List<Proveedor> proveedores = conector.consultarBaseDatosProveedor(conexion);

            // Verifica que la lista de proveedores no sea nula y contenga al menos un proveedor
            assertNotNull(proveedores, "La lista de proveedores no debería ser nula");
            assertFalse(proveedores.isEmpty(), "La lista de proveedores no debería estar vacía");

            // Puedes agregar más aserciones según tus necesidades
        } catch (SQLException e) {
            fail("Error al ejecutar la prueba: " + e.getMessage());
        }
    }

    // Método auxiliar para insertar datos de prueba en la base de datos para empleados
    private void insertarDatosDePrueba(Connection conexion) throws SQLException {
        String insertQuery = "INSERT INTO empleado (Codigo, Dni, Nombre) VALUES (?, ?, ?)";
        try (PreparedStatement insertStatement = conexion.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "NombrePrueba");
            insertStatement.setString(3, "ApellidoPrueba");
            insertStatement.executeUpdate();
        }
    }

    // Método auxiliar para insertar datos de prueba en la base de datos para proyectos
    private void insertarDatosDePruebaProyecto(Connection conexion) throws SQLException {
        String insertQuery = "INSERT INTO proyecto (Codigo, Nombre, Presupuesto) VALUES (?, ?, ?)";
        try (PreparedStatement insertStatement = conexion.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "ProyectoPrueba");
            insertStatement.setInt(3, 10); // Duración de prueba
            // Código de producto de prueba
            insertStatement.executeUpdate();
        }
    }

    // Método auxiliar para insertar datos de prueba en la base de datos para productos
    private void insertarDatosDePruebaProducto(Connection conexion) throws SQLException {
        // Inserta datos en la tabla producto
        String insertQueryProducto = "INSERT INTO producto (Codigo, Nombre, Precio) VALUES (?, ?, ?)";
        try (PreparedStatement insertStatementProducto = conexion.prepareStatement(insertQueryProducto)) {
            insertStatementProducto.setInt(1, 1);
            insertStatementProducto.setString(2, "ProductoPrueba");
            insertStatementProducto.setInt(3, 100); // Precio de prueba
            insertStatementProducto.executeUpdate();
        }

        // Inserta datos en la tabla proyecto relacionada con el producto
        String insertQueryProyecto = "INSERT INTO proyecto (Codigo, Nombre, Presupuesto) VALUES (?, ?, ?)";
        try (PreparedStatement insertStatementProyecto = conexion.prepareStatement(insertQueryProyecto)) {
            insertStatementProyecto.setInt(1, 1);
            insertStatementProyecto.setString(2, "ProyectoPrueba");
            insertStatementProyecto.setInt(3, 10);  // Duración de prueba

            insertStatementProyecto.executeUpdate();
        }
    }

    // Método auxiliar para insertar datos de prueba en la base de datos para proveedores
    private void insertarDatosDePruebaProveedor(Connection conexion) throws SQLException {
        // Inserta datos en la tabla proveedor
        String insertQueryProveedor = "INSERT INTO proveedor (Codigo, Nombre) VALUES (?, ?)";
        try (PreparedStatement insertStatementProveedor = conexion.prepareStatement(insertQueryProveedor)) {
            insertStatementProveedor.setInt(1, 1);
            insertStatementProveedor.setString(2, "ProveedorPrueba");
            insertStatementProveedor.executeUpdate();
        }
    }

    // Agrega más pruebas según sea necesario para cubrir otros métodos de tu clase Conector
    // Asegúrate de cubrir casos exitosos y casos de excepción según corresponda
}
