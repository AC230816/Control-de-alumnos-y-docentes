package sv.edu.udb.servlets.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VerInfoAlumnosServlet",value = "/VerInfoAlumnosServlet")
public class VerInfoAlumnosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String alumnos = generarHtml();
        request.setAttribute("alumnos", alumnos);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String generarHtml(){
        Conexion conn = new Conexion();
        List<Alumno> alumnos;
        StringBuilder sb = new StringBuilder();

        conn.conectar();
        alumnos = conn.selectAlumnos();
        conn.cerrar();

        sb.append("<div id = 'dynamicContent' class = 'alert alert-info' >");
        sb.append("<table class='table table-bordered table-striped'>");
        sb.append("<tr>");
        sb.append("<th>ID</th>");
        sb.append("<th>Nombre</th>");
        sb.append("<th>Apellido</th>");
        sb.append("<th>Edad</th>");
        sb.append("<th>Sexo</th>");
        sb.append("</tr>");

        for(Alumno alumno : alumnos){
            sb.append("<tr>");
            sb.append("<td>").append(alumno.getId()).append("</td>");
            sb.append("<td>").append(alumno.getNombre()).append("</td>");
            sb.append("<td>").append(alumno.getApellido()).append("</td>");
            sb.append("<td>").append(alumno.getEdad()).append("</td>");
            sb.append("<td>").append(alumno.getSexo()).append("</td>");
            sb.append("</tr>");
        }

        sb.append("</table>");
        sb.append("<button class='btn btn-danger' onclick='cerrarHtml()'>Cerrar</button>");
        sb.append("</div>");
        sb.append("<script>");
        sb.append("function cerrarHtml() {");
        sb.append("  var dynamicContent = document.getElementById('dynamicContent');");
        sb.append("  dynamicContent.style.display = 'none';");
        sb.append("}");
        sb.append("</script>");

        return sb.toString();
    }
}