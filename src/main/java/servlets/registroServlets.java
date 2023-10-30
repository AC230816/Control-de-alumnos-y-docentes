package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "RegistrosuarioServlet", value = "/RegistrosuarioServlet")
public class registroServlets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ocupacion = request.getParameter("ocupacion");
        String materia = request.getParameter("materia");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        System.out.println(nombre);

        response.sendRedirect("login.jsp");
    }
}
