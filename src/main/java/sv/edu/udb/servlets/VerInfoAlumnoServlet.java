package sv.edu.udb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "VerInfoAlumnoServlet", value = "/VerInfoAlumnoServlet")
public class VerInfoAlumnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // No crea una nueva sesión si no existe
        if (session != null) {
            String usuario = (String) session.getAttribute("usuario");
            String password = (String) session.getAttribute("password");

            Alumno alumno = new Alumno();
            alumno.setNombre(usuario);
            alumno.setPassword(password);

            Conexion conn = new Conexion();
            conn.conectar();
            try{
                alumno.setQuery();
                conn.setRs(alumno.getQuery());
                ResultSet rs = conn.getRs();

                while(rs.next()){
                    alumno.setApellido(rs.getString("Apellido"));
                    alumno.setEdad(rs.getInt("Edad"));
                    alumno.setSexo(rs.getString("Sexo"));
                    alumno.setId(rs.getInt("IDEstudiante"));
                }

                rs.close();
            } catch (Exception e){
                System.out.println("Error en VerInfoAlumnoServlet");
            }
            conn.cerrar();

            String htmlResponse = "<div id='dynamicContent' class='alert alert-info'>"
                    + "<h3>Mi Información</h3>"
                    + "<table class='table table-bordered table-striped'>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre</th>"
                    + "<th>Apellido</th>"
                    + "<th>Edad</th>"
                    + "<th>Sexo</th>"
                    + "<th>Contraseña</th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + alumno.getId() + "</td>"
                    + "<td>" + alumno.getNombre() + "</td>"
                    + "<td>" + alumno.getApellido() + "</td>"
                    + "<td>" + alumno.getEdad() + "</td>"
                    + "<td>" + alumno.getSexo() + "</td>"
                    + "<td>" + alumno.getPassword() + "</td>"
                    + "</tr>"
                    + "</table>"
                    + "<button class='btn btn-danger' onclick='cerrarHtml()'>Cerrar</button>"
                    + "</div>"
                    + "<script>"
                    + "function cerrarHtml() {"
                    + "  var dynamicContent = document.getElementById('dynamicContent');"
                    + "  dynamicContent.style.display = 'none';"
                    + "}"
                    + "</script>";

            request.setAttribute("htmlResponse", htmlResponse);
            request.getRequestDispatcher("alumno.jsp").forward(request,response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}