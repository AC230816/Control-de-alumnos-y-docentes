package sv.edu.udb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;

import java.io.IOException;

@WebServlet(name = "EditarInfoMaestroServlet", urlPatterns = {"/EditarInfoMaestroServlet","/EditarInfoMaestro"})
public class EditarInfoMaestroServlet extends HttpServlet {
    Conexion conn = new Conexion();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession(false);
        if (session != null) {
            String htmlResponse =
                    "<div id='dynamicContent' class='alert alert-info'>"
                            + "<h3>Actualizar Mi Información</h3>"
                            + "<form action = 'EditarInfoMaestro' method = 'post'>"
                            + "<div class = 'form-group'>" //Materia
                            + "<label for 'materia'>Actualizar Contraseña: </label>"
                            + "<label for='materia'>Materias:</label>"
                            + "<select class='form-control' id='materia' name='materia'>"
                            + "<option value='matematica'>Matemática</option>"
                            + "<option value='lenguaje'>Lenguaje</option>"
                            + "<option value='sociales'>Sociales</option>"
                            + "<option value='filosofia'>Filosofía</option>"
                            + "</select>"
                            + "</div>" //Fin Materia
                            + "<div class = 'form-group'>"
                            + "<label for 'password'>Actualizar Contraseña: </label>"
                            + "<input type = 'password' id = 'password' name = 'password' class = 'form-control' required>"
                            + "</div>"
                            + "<div class = 'form-group'>"
                            + "<input type = 'submit' value = 'Actualizar' class = 'btn btn-primary'>"
                            + "</div>"
                            + "</form>"
                            + "<button class='btn btn-danger' onclick='cerrarHtml()'>Cerrar</button>"
                            + "</div>"
                            + "<script>"
                            + "function cerrarHtml() {"
                            + "  var dynamicContent = document.getElementById('dynamicContent');"
                            + "  dynamicContent.style.display = 'none';"
                            + "}"
                            + "</script>";

            request.setAttribute("htmlEditResponse", htmlResponse);
            request.getRequestDispatcher("maestro.jsp").forward(request,response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession(false);

        String materia = request.getParameter("materia");
        String password = request.getParameter("password");
        int id = Integer.parseInt(session.getAttribute("ID").toString());

        if (session != null) {
            try{
                conn.conectar();
                conn.updateMaestro(password, materia, id);
                conn.cerrar();
            } catch (Exception e) {
                System.out.println("Error en EditarInfoMaestro");
            }

            session.setAttribute("materia",materia);
            session.setAttribute("password",password);
            session.setAttribute("ID",id);

            response.sendRedirect("maestro.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}