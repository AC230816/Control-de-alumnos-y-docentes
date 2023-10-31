package sv.edu.udb.handler;

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
            System.out.println("Error en db");
            ex.printStackTrace();
        }
    }

    public void insertRegistroProfesor(String nombre, String apellido, int edad, String sexo, String password,  String materia) {
        try {
            Statement st = conn.createStatement();

            String query = "INSERT INTO profesor (Nombre, Apellido, Edad, Sexo, Password, Materia) VALUES\n" +
                    "('" + nombre + "', '" + apellido + "','" + edad + "', '" + sexo + "','" + password + "','" + materia + "')";
            st.execute(query);
        } catch (Exception ex) {
            System.out.println("Error en db");
            ex.printStackTrace();

        }
    }

    public boolean verificarInicioSesion(String usuario, String contraseña) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;

            String query = "SELECT * FROM usuario WHERE Nombre = '" + usuario + "' AND Password = '" + contraseña + "'";

            rs = st.executeQuery(query);

            if (rs.next()) {
                return true;
            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("Error en la base de datos");
            ex.printStackTrace();
        }

        return false;
    }


    public void cerrar() {
        try {
            conn.close();

            System.out.println("Coneccion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error en db");
            ex.printStackTrace();
        }
    }
}
