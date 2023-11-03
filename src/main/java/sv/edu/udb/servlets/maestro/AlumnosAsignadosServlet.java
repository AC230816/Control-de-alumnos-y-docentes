package sv.edu.udb.servlets.maestro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlumnosAsignadosServlet", value = "/AlumnosAsignadosServlet")
public class AlumnosAsignadosServlet extends HttpServlet {
    Conexion conn = new Conexion();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        Object idMaestro = session.getAttribute("ID");
        int id = 0;

        if(idMaestro instanceof Integer){
            id = ((Integer) idMaestro).intValue();
        }

        String alumnos = generarHtml(id);
        request.setAttribute("alumnos", alumnos);
        request.getRequestDispatcher("maestro.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String generarHtml(int id){
        List<Alumno> alumnos;
        StringBuilder sb = new StringBuilder();

        conn.conectar();
        alumnos = conn.selectAlumnosAsignados(id);
        conn.cerrar();

        sb.append("<div id = 'dynamicContent' class = 'alert alert-info' >");
        sb.append("<h3>Alumnos Asignados</h3>");
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