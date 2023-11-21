package Modelo.RowMappers;

import Modelo.Producto;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoRowMapper implements RowMapper<Producto> {
    @Override
    public Producto mapRow(ResultSet resultSet) throws SQLException {
        try {
            int codigo = resultSet.getInt("Codigo");
            String nombre = resultSet.getString("Nombre");
            int precio = resultSet.getInt("Precio");
            int codigoProveedor = resultSet.getInt("codigoProveedor");
            Producto producto = new Producto(codigo, nombre, precio);
            
            
            return producto;
        } catch (SQLException e) {
            // Manejar la excepción de manera adecuada, puedes imprimir un mensaje o lanzar una excepción personalizada si es necesario.
            throw new RuntimeException("Error al mapear la fila del empleado", e);
        }
    }
}
