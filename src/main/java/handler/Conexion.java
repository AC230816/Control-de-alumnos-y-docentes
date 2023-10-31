package handler;

import javax.sql.DataSource;
import java.sql.*;
public class Conexion {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/controludb";
    private String username = "root";
    private String password = "";
    private Connection conn = null;

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(jdbcUrl, username, password);

            if (conn != null) {
                System.out.println("Conectamos");

            } else {
                System.out.println("Error no se conecto");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error en db 1");
            ex.printStackTrace();
        }
    }

    public boolean insertRegistroProfesor(String nombre, String apellido, int edad, String sexo, String password,  String materia) {
        try {
            Statement st = conn.createStatement();

            String query = "INSERT INTO profesor (Nombre, Apellido, Edad, Sexo, Password, Materia) VALUES\n" +
                    "('" + nombre + "', '" + apellido + "','" + edad + "', '" + sexo + "','" + password + "','" + materia + "')";
            st.execute(query);
            System.out.println("Se Inserto en profesor correctamente");
        } catch (Exception ex) {
            System.out.println("Error en db 2");
            ex.printStackTrace();

        }
        return true;
    }

    public boolean insertRegistroAlumno(String nombre, String apellido, int edad, String sexo, String password) {
        try {
            Statement st = conn.createStatement();

            String query = "INSERT INTO estudiante (Nombre, Apellido, Edad, Sexo, Password) VALUES\n" +
                    "('" + nombre + "', '" + apellido + "','" + edad + "', '" + sexo + "','" + password + "')";
            st.execute(query);
            System.out.println("Se Inserto en alumno correctamente");
        } catch (Exception ex) {
            System.out.println("Error en db 2");
            ex.printStackTrace();

        }
        return true;
    }

    public boolean insertlogin(String nombre, String password) {
        try {
            Statement st = conn.createStatement();

            String query = "INSERT INTO login (Usuario, Password) VALUES\n" +
                    "('" + nombre + "', '" + password + "')";
            st.execute(query);
            System.out.println("Se Inserto en el login correctamente");
        } catch (Exception ex) {
            System.out.println("Error en db 2");
            ex.printStackTrace();

        }
        return true;
    }

    public boolean verificarInicioSesion(String usuario, String contraseña) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;

            String query = "SELECT * FROM login WHERE Usuario = '" + usuario + "' AND Password = '" + contraseña + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {
                return true;
            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("Error en la base de datos 4");
            ex.printStackTrace();
        }

        return false;
    }

    public void selectAlumno(String nombre, String Apellido){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;

            String query = "SELECT * FROM estudiante WHERE Usuario = '" + nombre + "' AND apellido = '" + Apellido + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {
                String usuario = rs.getString("Usuario");
                String apellido = rs.getString("Apellido");
            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("Error en la base de datos 5");
            ex.printStackTrace();
        }
    }

    public void modificarAlumno(String nombre, String nuevoNombre, String apellido, int edad, String sexo, String nuevaNombre, String nuevoApellido, int nuevaEdad, String nuevoSexo, String nuevaPassword) {
        try {
            Statement st = conn.createStatement();

            String Query = "SELECT * FROM estudiante WHERE Usuario = '" + nombre + "' AND Apellido = '" + apellido + "'";
            ResultSet rs = st.executeQuery(Query);

            if (rs.next()) {
                String updateQuery = "UPDATE estudiante SET Usuario = '" + nuevoNombre + "', Apellido = '" + nuevoApellido + "', Edad = " + nuevaEdad + ", Sexo = '" + nuevoSexo + "', Password = '" + nuevaPassword + "' WHERE Usuario = '" + nombre + "'";
                st.executeUpdate(updateQuery);
            } else {
                System.out.println("El estudiante no existe en la base de datos.");
            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("Error en la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void cerrar() {
        try {
            conn.close();

            System.out.println("Coneccion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error en db 6");
            ex.printStackTrace();
        }
    }
}
