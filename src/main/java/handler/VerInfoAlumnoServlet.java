package handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerInfoAlumnoervlet")
public class VerInfoAlumnoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/controludb";
        String user = "";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM estudiante";
            ResultSet resultSet = statement.executeQuery(query);

            request.setAttribute("estudiantes", resultSet);
            request.getRequestDispatcher("VerinfoAlumnoServlet.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al obtener los datos de la base de datos.");
        }
    }
}
