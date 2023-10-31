package sv.edu.udb.servlets;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sv.edu.udb.handler.Conexion;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "RegistroUsuarioServlet", value = "/RegistroUsuarioServlet")
public class registroServlets extends HttpServlet {
    boolean exito = false, exito2 = false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        conn.conectar();
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ocupacion = request.getParameter("ocupacion");
        String materia = request.getParameter("materia");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        System.out.println("iniciamos el servlet");
        if (ocupacion.equalsIgnoreCase("maestro")){
               exito = conn.insertRegistroProfesor(nombre, apellido, edad, sexo, password, materia);
               conn.insertlogin(nombre, password);
        }
        else {
               exito2 = conn.insertRegistroAlumno(nombre, apellido, edad, sexo, password);
               conn.insertlogin(nombre, password);
        }
        if (exito || exito2) {
            response.sendRedirect("login.jsp?exito=1");
        } else {
            response.sendRedirect("registro.jsp?error=1");
        }
        conn.cerrar();
    }
}
