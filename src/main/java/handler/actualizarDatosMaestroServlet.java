package handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import handler.Conexion;


@WebServlet("/actualizarDatosMaestroServlet")
public class actualizarDatosMaestroServlet extends HttpServlet{


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String confirm_password = request.getParameter("confirm_password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");
        String sexo = request.getParameter("sexo");
        String password = request.getParameter("password");
        String materia = request.getParameter("materia");

        // Asegúrate de obtener el ID del maestro que deseas actualizar (puedes pasarlo como parámetro desde el formulario).
        int idMaestro = Integer.parseInt(request.getParameter("idMaestro"));

        Conexion conexion = new Conexion();
        conexion.conectar();

        Maestro maestro = new Maestro(conexion.getConnection());

        try {
            // Validación básica (puedes agregar más validaciones según tus necesidades)
            if (!password.equals(confirm_password)) {
                response.sendRedirect("error.jsp"); // Redirige a una página de error al docente
                return;
            }

            // Actualización de datos del maestro
            boolean actualizado = maestro.actualizarMaestro(idMaestro, nombre, apellido, Integer.parseInt(edad), sexo, materia);

            if (actualizado) {
                response.sendRedirect("exito.jsp"); // Redirige a una página de éxito al docente
            } else {
                response.sendRedirect("error.jsp"); // Redirige a una página de error en caso de fallo en la actualización de datos del docente
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirige a una página de error en caso de que el error este en la DB
        } finally {
            conexion.cerrar();
        }
    }

}
