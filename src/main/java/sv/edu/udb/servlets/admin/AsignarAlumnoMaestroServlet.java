package sv.edu.udb.servlets.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Maestro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AsignarAlumnoMaestroServlet", urlPatterns = {"/AsignarAlumnoMaestroServlet"})
public class AsignarAlumnoMaestroServlet extends HttpServlet {
    Conexion conn = new Conexion();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sbAlumno = new StringBuilder();
        StringBuilder sbMaestro = new StringBuilder();

        conn.conectar();

        List<Alumno> alumnos = conn.selectAlumnos();

        for(Alumno alumno : alumnos){
            sbAlumno.append("<option value = '").append(alumno.getId()).append("'>");
            sbAlumno.append(alumno.getNombre());
            sbAlumno.append("</option>");
        }

        List<Maestro> maestros = conn.selectMaestros();

        for(Maestro maestro : maestros){
            sbMaestro.append("<option value = '").append(maestro.getId()).append("'>");
            sbMaestro.append(maestro.getNombre());
            sbMaestro.append("</option>");
        }

        conn.cerrar();

        request.setAttribute("alumnos",sbAlumno.toString());
        request.setAttribute("maestros",sbMaestro.toString());
        request.getRequestDispatcher("asignaralumno.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("alumno"));
        int idMaestro = Integer.parseInt(request.getParameter("docente"));

        conn.conectar();
        conn.updateMaestroAsignado(idMaestro,idAlumno);
        conn.cerrar();

        response.sendRedirect("admin.jsp");
    }
}