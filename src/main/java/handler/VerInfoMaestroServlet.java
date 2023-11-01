package handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerInfoMaestroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            // Conecta a la base de datos
            Conexion conexion = new Conexion();
            conexion.conectar();
            conn = conexion.getConnection();

            // Obtiene el ID del maestro de los parámetros de la solicitud
            String idMaestro = request.getParameter("idMaestro");

            if (idMaestro != null) {
                // Realiza una consulta para obtener la información del maestro
                String query = "SELECT * FROM profesor WHERE ID = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(idMaestro));

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Obtiene los datos del maestro
                    String nombre = resultSet.getString("Nombre");
                    String apellido = resultSet.getString("Apellido");
                    String edad = resultSet.getString("Edad");
                    String sexo = resultSet.getString("Sexo");
                    // Agrega más campos según sea necesario

                    // Establece los datos en el alcance de solicitud para el JSP
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("apellido", apellido);
                    request.setAttribute("edad", edad);
                    request.setAttribute("sexo", sexo);
                    // Agrega más atributos según sea necesario

                    // Redirige al JSP para mostrar la información
                    request.getRequestDispatcher("verInfoMaestro.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Maestro no encontrado.");
                }
            } else {
                response.getWriter().println("ID del maestro no proporcionado en la solicitud.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al obtener la información del maestro.");
        } catch (NumberFormatException e) {
            response.getWriter().println("ID del maestro no válido.");
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
