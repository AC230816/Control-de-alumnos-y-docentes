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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/VerAlumnosAsignadosServlet")
public class AlumnosAsignadosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
            conn = conexion.getConnection();


            String idMaestro = request.getParameter("idMaestro");

            if (idMaestro != null) {
                String query = "SELECT Nombre, Apellido FROM alumno WHERE IDMaestro = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(idMaestro));

                ResultSet resultSet = preparedStatement.executeQuery();

                List<String> alumnosAsignados = new ArrayList<>();
                while (resultSet.next()) {
                    String nombreAlumno = resultSet.getString("Nombre");
                    String apellidoAlumno = resultSet.getString("Apellido");
                    alumnosAsignados.add(nombreAlumno + " " + apellidoAlumno);
                }

                request.setAttribute("alumnosAsignados", alumnosAsignados);

                request.getRequestDispatcher("alumnosAsignados.jsp").forward(request, response);
            } else {
                response.getWriter().println("ID del maestro no proporcionado en la solicitud.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al obtener la lista de alumnos asignados al maestro.");
        } catch (NumberFormatException e) {
            response.getWriter().println("ID del maestro no válido.");
        } finally {
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
