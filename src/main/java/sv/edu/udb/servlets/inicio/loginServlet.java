package sv.edu.udb.servlets.inicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sv.edu.udb.handler.Conexion;
import sv.edu.udb.model.Admin;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Maestro;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
        session.setAttribute("usuario",nombre);
        session.setAttribute("password",password);

        conn.conectar();
        if (conn.verificarInicioSesion(nombre,password) == 1){

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
                    session.setAttribute("IDMaestroAsignado",rs.getString("IDMaestroAsignado"));
                }

                rs.close();
            } catch (Exception e){
                System.out.println("Error en log in estudiante");
                e.printStackTrace();
            }

            response.sendRedirect("alumno.jsp");
        } else if(conn.verificarInicioSesion(nombre,password) == 2){

            Maestro maestro = new Maestro();

            maestro.setNombre(nombre);
            maestro.setPassword(password);
            maestro.setQuery();

            try{
                conn.setRs(maestro.getQuery());
                ResultSet rs = conn.getRs();

                while(rs.next()){
                    session.setAttribute("apellido",rs.getString("Apellido"));
                    session.setAttribute("edad",rs.getInt("Edad"));
                    session.setAttribute("sexo",rs.getString("Sexo"));
                    session.setAttribute("ID",rs.getInt("ID"));
                    session.setAttribute("materia",rs.getString("Materia"));
                }

                rs.close();
            } catch (Exception e){
                System.out.println("Error en log in maestro");
                e.printStackTrace();
            }

            response.sendRedirect("maestro.jsp");
        } else if(conn.verificarInicioSesion(nombre, password) == 3){

            Admin admin = new Admin();

            admin.setNombre(nombre);
            admin.setPassword(password);
            admin.setQuery();

            try{
                conn.setRs(admin.getQuery());
                ResultSet rs = conn.getRs();

                while(rs.next()){
                    session.setAttribute("apellido",rs.getString("Apellido"));
                    session.setAttribute("edad",rs.getInt("Edad"));
                    session.setAttribute("sexo",rs.getString("Sexo"));
                    session.setAttribute("ID",rs.getInt("IDAdmin"));
                }

                rs.close();
            } catch (Exception e){
                System.out.println("Error en log in admin");
                e.printStackTrace();
            }

            response.sendRedirect("admin.jsp?exito=1");
        } else {
            response.sendRedirect("login.jsp?exito=0");
        }
        conn.cerrar();
    }
}
