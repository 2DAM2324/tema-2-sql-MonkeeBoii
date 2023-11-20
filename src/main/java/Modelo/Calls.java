package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Modelo.RowMappers.RowMapper;

public class Calls {

    private static final String URL = "jdbc:sqlite:baseDeDatos.db3";

    private Connection establecerConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private void cerrarRecursos(Connection conn, PreparedStatement consulta, ResultSet resultado) {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> recogerTabla(List<T> elementos, String consultaStr, RowMapper<T> rowMapper) {
        Connection conn = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            conn = establecerConexion();
            consulta = conn.prepareStatement(consultaStr);
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                T elemento = rowMapper.mapRow(resultado);
                elementos.add(elemento);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            cerrarRecursos(conn, consulta, resultado);
        }

        return elementos;
    }
}
