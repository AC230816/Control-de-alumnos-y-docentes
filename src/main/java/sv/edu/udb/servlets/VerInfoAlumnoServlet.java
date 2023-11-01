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
                    + "<td>" + session.getAttribute("ID") + "</td>"
                    + "<td>" + session.getAttribute("usuario") + "</td>"
                    + "<td>" + session.getAttribute("apellido") + "</td>"
                    + "<td>" + session.getAttribute("edad") + "</td>"
                    + "<td>" + session.getAttribute("sexo") + "</td>"
                    + "<td>" + session.getAttribute("password") + "</td>"
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