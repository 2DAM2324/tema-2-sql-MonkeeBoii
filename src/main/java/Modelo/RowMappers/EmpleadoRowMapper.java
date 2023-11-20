package Modelo.RowMappers;

import Modelo.Empleado;
import Modelo.RowMappers.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoRowMapper implements RowMapper<Empleado> {

    @Override
    public Empleado mapRow(ResultSet resultSet) throws SQLException {
        try {
            int codigo = resultSet.getInt("codigo");
            String dni = resultSet.getString("dni");
            String nombre = resultSet.getString("nombre");
            return new Empleado(codigo, dni, nombre);
        } catch (SQLException e) {
            // Manejar la excepción de manera adecuada, puedes imprimir un mensaje o lanzar una excepción personalizada si es necesario.
            throw new RuntimeException("Error al mapear la fila del empleado", e);
        }

    }
}
