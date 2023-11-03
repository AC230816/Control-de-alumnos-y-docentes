package sv.edu.udb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Maestro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VerInfoMaestrosServlet", value = "/VerInfoMaestrosServlet")
public class VerInfoMaestrosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maestros = generarHtml();
        request.setAttribute("maestros", maestros);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String generarHtml(){
        Conexion conn = new Conexion();
        List<Maestro> maestros;
        StringBuilder sb = new StringBuilder();

        conn.conectar();
        maestros = conn.selectMaestros();
        conn.cerrar();

        sb.append("<div id = 'dynamicContent' class = 'alert alert-info' >");
        sb.append("<table class='table table-bordered table-striped'>");
        sb.append("<tr>");
        sb.append("<th>ID</th>");
        sb.append("<th>Nombre</th>");
        sb.append("<th>Apellido</th>");
        sb.append("<th>Edad</th>");
        sb.append("<th>Sexo</th>");
        sb.append("<th>Materia</th>");
        sb.append("</tr>");

        for(Maestro maestro : maestros){
            sb.append("<tr>");
            sb.append("<td>").append(maestro.getId()).append("</td>");
            sb.append("<td>").append(maestro.getNombre()).append("</td>");
            sb.append("<td>").append(maestro.getApellido()).append("</td>");
            sb.append("<td>").append(maestro.getEdad()).append("</td>");
            sb.append("<td>").append(maestro.getSexo()).append("</td>");
            sb.append("<td>").append(maestro.getMateria()).append("</td>");
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