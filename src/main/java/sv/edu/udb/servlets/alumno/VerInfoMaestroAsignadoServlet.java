package sv.edu.udb.servlets.alumno;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Maestro;

import java.io.IOException;

@WebServlet(name = "VerInfoMaestroAsignadoServlet", value = "/VerInfoMaestroAsignadoServlet")
public class VerInfoMaestroAsignadoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int idMaestroAsignado = Integer.parseInt(session.getAttribute("IDMaestroAsignado").toString());

        Conexion conn = new Conexion();
        conn.conectar();
        Maestro maestro = conn.selectMaestroAsignado(idMaestroAsignado);
        conn.cerrar();

        String htmlResponseMaestroAsignado =
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
                        + "</tr>"
                        + "<tr>"
                        + "<td>" + maestro.getId() + "</td>"
                        + "<td>" + maestro.getNombre() + "</td>"
                        + "<td>" + maestro.getApellido() + "</td>"
                        + "<td>" + maestro.getEdad() + "</td>"
                        + "<td>" + maestro.getSexo() + "</td>"
                        + "<td>" + maestro.getMateria() + "</td>"
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
        request.setAttribute("maestroAsignado",htmlResponseMaestroAsignado);
        request.getRequestDispatcher("alumno.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}