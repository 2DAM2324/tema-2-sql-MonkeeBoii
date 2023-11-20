package Modelo.RowMappers;
import Modelo.Proyecto;
import Modelo.RowMappers.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectoRowMapper implements RowMapper<Proyecto> {
    @Override
    public Proyecto mapRow(ResultSet resultSet) throws SQLException {
        try{
        String codigo = resultSet.getString("codigo");
        String nombreProyecto = resultSet.getString("nombre");
        String presupuesto = resultSet.getString("presupuesto");
        String codigoProducto = resultSet.getString("codigo_producto");
        Proyecto proyecto = new Proyecto(codigo, nombreProyecto, presupuesto);
        proyecto.setCodigoProducto(codigoProducto);
        return proyecto;
        }catch(SQLException e) {
            // Manejar la excepción de manera adecuada, puedes imprimir un mensaje o lanzar una excepción personalizada si es necesario.
            throw new RuntimeException("Error al mapear la fila del empleado", e); 
        }
    }
}
