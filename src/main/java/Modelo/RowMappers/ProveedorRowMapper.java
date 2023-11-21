package Modelo.RowMappers;

import Modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorRowMapper implements RowMapper<Proveedor> {

    @Override
    public Proveedor mapRow(ResultSet resultSet) throws SQLException {
        try {
            int codigo = resultSet.getInt("Codigo");
            String nombreProyecto = resultSet.getString("Nombre");
            Integer codigoProducto = resultSet.getInt("codigoProducto");
            Proveedor proveedor = new Proveedor(codigo, nombreProyecto);
            if(codigoProducto != null){
                proveedor.setCodigoProducto(codigoProducto);
            }
            return proveedor;
        } catch (SQLException e) {
            // Manejar la excepción de manera adecuada, puedes imprimir un mensaje o lanzar una excepción personalizada si es necesario.
            throw new RuntimeException("Error al mapear la fila del empleado", e);
        }
    }
}
