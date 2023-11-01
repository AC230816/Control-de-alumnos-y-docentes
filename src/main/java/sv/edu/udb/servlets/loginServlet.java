package sv.edu.udb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Alumno;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);

        conn.conectar();
        if (conn.verificarInicioSesion(nombre,password)){
            session.setAttribute("usuario",nombre);
            session.setAttribute("password",password);

            Alumno alumno = new Alumno();

            alumno.setNombre(nombre);
            alumno.setPassword(password);
            alumno.setQuery();

            try{
                conn.setRs(alumno.getQuery());
                ResultSet rs = conn.getRs();

                while(rs.next()){
                    session.setAttribute("apellido",rs.getString("Apellido"));
                    session.setAttribute("edad",rs.getInt("Edad"));
                    session.setAttribute("sexo",rs.getString("Sexo"));
                    session.setAttribute("ID",rs.getInt("IDEstudiante"));
                }

                rs.close();
            } catch (Exception e){
                System.out.println("Error en log in");
                e.printStackTrace();
            }

            response.sendRedirect("alumno.jsp?exito=1");
        } else {
            session.setAttribute("usuario",nombre);
            session.setAttribute("password",password);
            response.sendRedirect("maestro.jsp?exito=1");
        }
        conn.cerrar();
    }
}
