package handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maestro {
    private Connection conn;

    public Maestro(Connection conn) {
        this.conn = conn;
    }

    public boolean agregarMaestro(String nombre, String apellido, int edad, String sexo, String materia) {
        try {
            String insertQuery = "INSERT INTO profesor (Nombre, Apellido, Edad, Sexo, Materia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, sexo);
            preparedStatement.setString(5, materia);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarMaestro(int id, String nombre, String apellido, int edad, String sexo, String materia) {
        try {
            String updateQuery = "UPDATE profesor SET Nombre=?, Apellido=?, Edad=?, Sexo=?, Materia=? WHERE ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, sexo);
            preparedStatement.setString(5, materia);
            preparedStatement.setInt(6, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMaestro(int id) {
        try {
            String deleteQuery = "DELETE FROM profesor WHERE ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void obtenerInformacionMaestro(int id) {
        try {
            String selectQuery = "SELECT * FROM profesor WHERE ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maestroID = resultSet.getInt("ID");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                int edad = resultSet.getInt("Edad");
                String sexo = resultSet.getString("Sexo");
                String materia = resultSet.getString("Materia");

                System.out.println("ID: " + maestroID);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Sexo: " + sexo);
                System.out.println("Materia: " + materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

