package sv.edu.udb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sv.edu.udb.handler.Conexion;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        conn.conectar();
        if (conn.verificarInicioSesion(nombre,password)){
            response.sendRedirect("index.jsp?exito=1");
        } else {
            response.sendRedirect("registro.jsp?exito=1");
        }

    }
}
