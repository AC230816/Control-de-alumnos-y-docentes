package sv.edu.udb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "VerInfoMaestroServlet", value = "/VerInfoMaestroServlet")
public class VerInfoMaestroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // No crea una nueva sesión si no existe
        if (session != null) {
            String htmlResponse =
                    "<div id='dynamicContent' class = 'alert alert-info' style='width: 100%;'>"
                    + "<h3>Mi Información</h3>"
                    + "<table class='table table-bordered table-striped'>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre</th>"
                    + "<th>Apellido</th>"
                    + "<th>Edad</th>"
                    + "<th>Sexo</th>"
                    + "<th>Materia</th>"
                    + "<th>Contraseña</th>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + session.getAttribute("ID") + "</td>"
                    + "<td>" + session.getAttribute("usuario") + "</td>"
                    + "<td>" + session.getAttribute("apellido") + "</td>"
                    + "<td>" + session.getAttribute("edad") + "</td>"
                    + "<td>" + session.getAttribute("sexo") + "</td>"
                    + "<td>" + session.getAttribute("materia") + "</td>"
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
            request.getRequestDispatcher("maestro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}