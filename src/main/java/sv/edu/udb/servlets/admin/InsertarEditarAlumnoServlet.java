package sv.edu.udb.servlets.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InsertarEditarAlumnoServlet",urlPatterns = {"/InsertarEditarAlumnoServlet","/InsertarAlumno","/EditarAlumno"})
public class InsertarEditarAlumnoServlet extends HttpServlet {
    Conexion conn = new Conexion();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("1".equals(action)){
            String adminResponseAlumno =
                    "<div class='row' id ='dynamicContent'>"
                    + "<div class='col-md-12'>"
                    + "<h3>Seleccione una opcion</h3>"
                    + "</div>"
                    + "<div class='col-md-6'>"
                    + "<a href='InsertarAlumno?action=2' class='btn btn-info'>Insertar Alumno</a>"
                    + "</div>"
                    + "<div class='col-md-6'>"
                    + "<a href='EditarAlumno?action=3' class='btn btn-info'>Editar Alumno</a>"
                    + "</div>"
                    + "<div class='col-md-6'>"
                    + "<button class='btn btn-danger' onclick='cerrarHtml()' style = 'margin-top:10px'>Cerrar</button>"
                    + "</div>"
                    + "</div>"
                    + "<script>"
                    + "function cerrarHtml() {"
                    + "  var dynamicContent = document.getElementById('dynamicContent');"
                    + "  dynamicContent.style.display = 'none';"
                    + "}"
                    + "</script>";

            request.setAttribute("adminResponseAlumno",adminResponseAlumno);
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } else if("2".equals(action)){
            response.sendRedirect("insertaralumno.jsp");
        } else if("3".equals(action)){
            StringBuilder sb = new StringBuilder();
            List<Integer> IDS;

            conn.conectar();
            IDS = conn.selectIDEstudiante();
            for(int id : IDS){
                sb.append("<option").append(" value = '").append(id).append("'>");
                sb.append(id);
                sb.append("</option>");
            }

            conn.cerrar();

            request.setAttribute("IDS",sb.toString());
            request.getRequestDispatcher("editaralumno.jsp").forward(request,response);
        } else if("4".equals(action)){
            response.sendRedirect("admin.jsp");
        } else if("5".equals(action)){
            response.sendRedirect("admin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("insertar".equals(action)){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String password = request.getParameter("password");

            conn.conectar();
            conn.insertRegistroAlumno(nombre,apellido,edad,sexo,password);
            conn.cerrar();

            response.sendRedirect("admin.jsp");
        } else if("editar".equals(action)){
            conn.conectar();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String password = request.getParameter("password");
            String edad = request.getParameter("edad");
            int id = Integer.parseInt(request.getParameter("id"));

            if(!nombre.isEmpty()){
                conn.updateNombreAlumno(nombre, id);
            }
            if(!apellido.isEmpty()){
                conn.updateApellidoAlumno(apellido, id);
            }
            if(!password.isEmpty()){
                conn.updatePasswordAlumno(password,id);
            }
            if(!edad.isEmpty()){
                int intEdad = Integer.parseInt(edad);
                conn.updateEdadAlumno(intEdad, id);
            }

            conn.cerrar();
            response.sendRedirect("admin.jsp");
        }
    }
}