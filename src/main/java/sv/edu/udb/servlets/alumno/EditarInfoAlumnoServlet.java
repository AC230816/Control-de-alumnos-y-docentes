package sv.edu.udb.servlets.alumno;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "EditarInfoAlumnoServlet", urlPatterns = {"/EditarInfoAlumnoServlet","/EditarInfo"})
public class EditarInfoAlumnoServlet extends HttpServlet {
    Conexion conn = new Conexion();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession(false);
        if (session != null) {
            String htmlResponse =
                    "<div id='dynamicContent' class='alert alert-info'>"
                    + "<h3>Actualizar Mi Información</h3>"
                    + "<form action = 'EditarInfo' method = 'post'>"
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
            request.getRequestDispatcher("alumno.jsp").forward(request,response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession(false);

        String password = request.getParameter("password");
        int id = Integer.parseInt(session.getAttribute("ID").toString());

        if (session != null) {
            conn.conectar();
            conn.updatePasswordAlumno(password, id);
            conn.cerrar();

            session.setAttribute("password",password);
            session.setAttribute("ID",id);

            response.sendRedirect("alumno.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}