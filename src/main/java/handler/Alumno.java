package handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alumno {
    private Connection conn;

    public boolean editarInfoButton(int id, String nombre, String apellido, String materia) {
        try {
            String updateQuery = "UPDATE alumno SET Nombre=?, Apellido=?, Materia=? WHERE ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, materia);
            preparedStatement.setInt(4, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
