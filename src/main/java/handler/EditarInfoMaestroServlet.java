package handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/ActualizarMaestroServlet")

public class EditarInfoMaestroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recopila los datos del maestro que se desean actualizar desde los parámetros de la solicitud
        String idMaestro = request.getParameter("idMaestro");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");
        String sexo = request.getParameter("sexo");
        String materia = request.getParameter("materia");
        String password = request.getParameter("password");


        Connection conn = null;
        try {

            Conexion conexion = new Conexion();
            conexion.conectar();

            conn = conexion.getConnection();

            // Define la consulta SQL para actualizar la información del maestro
            String query = "UPDATE profesor SET Nombre=?, Apellido=?, Edad=?, Sexo=?, Materia=?, Password=? WHERE ID=?";

            // Crea una sentencia preparada
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            // Establece los valores de los parámetros en la sentencia preparada
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, edad);
            preparedStatement.setString(4, sexo);
            preparedStatement.setString(5, materia);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, idMaestro);

            // Ejecuta la consulta de actualización
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // La actualización fue exitosa
                response.getWriter().println("Información del maestro actualizada correctamente.");
            } else {
                // No se actualizó ningún registro (es posible que el maestro con ese ID no exista)
                response.getWriter().println("No se encontró el maestro para actualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al actualizar la información del maestro.");
        } finally {
            // Cierra la conexión a la base de datos
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
