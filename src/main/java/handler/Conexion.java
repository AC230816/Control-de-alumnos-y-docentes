package handler;

import javax.sql.DataSource;
import java.sql.*;
public class Conexion {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/";
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
