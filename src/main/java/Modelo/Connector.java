package Modelo;

import Modelo.RowMappers.EmpleadoRowMapper;
import Modelo.RowMappers.ProyectoRowMapper;
import java.util.ArrayList;
import java.util.List;
import Modelo.RowMappers.ProductoRowMapper;
import Modelo.RowMappers.ProveedorRowMapper;

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
        }

        productos = calls.recogerTabla(new ArrayList<>(), "SELECT * FROM producto", new ProductoRowMapper());

        return productos;
    }
}
