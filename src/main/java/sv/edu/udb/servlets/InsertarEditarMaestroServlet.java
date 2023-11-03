package sv.edu.udb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import sv.edu.udb.handler.Conexion;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "InsertarEditarMaestroServlet", urlPatterns = {"/InsertarEditarMaestroServlet","/InsertarMaestro","/EditarMaestro"})
public class InsertarEditarMaestroServlet extends HttpServlet {
    Conexion conn = new Conexion();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("1".equals(action)){
            String adminResponseMaestro =
                    "<div class='row' id ='dynamicContent'>"
                            + "<div class='col-md-12'>"
                            + "<h3>Seleccione una opcion</h3>"
                            + "</div>"
                            + "<div class='col-md-6'>"
                            + "<a href='InsertarMaestro?action=2' class='btn btn-info'>Insertar Maestro</a>"
                            + "</div>"
                            + "<div class='col-md-6'>"
                            + "<a href='EditarMaestro?action=3' class='btn btn-info'>Editar Maestro</a>"
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

            request.setAttribute("adminResponseMaestro",adminResponseMaestro);
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } else if("2".equals(action)){
            response.sendRedirect("insertarmaestro.jsp");
        } else if("3".equals(action)){
            StringBuilder sb = new StringBuilder();
            List<Integer> IDS;

            conn.conectar();
            IDS = conn.selectIDMaestro();
            for(int id : IDS){
                sb.append("<option").append(" value = '").append(id).append("'>");
                sb.append(id);
                sb.append("</option>");
            }

            conn.cerrar();

            request.setAttribute("IDS",sb.toString());
            request.getRequestDispatcher("editarmaestro.jsp").forward(request,response);
        } else if("4".equals(action)){
            response.sendRedirect("admin.jsp");
        } else if("5".equals(action)){
            response.sendRedirect("admin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        conn.conectar();

        if("insertar".equals(action)){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            String materia = request.getParameter("materia");
            String password = request.getParameter("password");

            conn.insertRegistroProfesor(nombre, apellido, edad, sexo, password, materia);

            response.sendRedirect("admin.jsp");
        } else if("editar".equals(action)){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String materia = request.getParameter("materia");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("id"));

            if(!nombre.isEmpty()){
                conn.updateNombreMaestro(nombre, id);
            }
            if(!apellido.isEmpty()){
                conn.updateApellidoMaestro(apellido, id);
            }
            if(!edad.isEmpty()){
                int intEdad = Integer.parseInt(edad);
                conn.updateEdadMaestro(intEdad,id);
            }
            if(!materia.isEmpty()){
                try{
                    conn.updateMateriaMaestro(materia,id);
                } catch (Exception e){
                    System.out.println("pasan cosas");
                }
            }
            if(!password.isEmpty()){
                conn.updatePasswordMaestro(password,id);
            }
            response.sendRedirect("admin.jsp");
        }

        conn.cerrar();
    }
}