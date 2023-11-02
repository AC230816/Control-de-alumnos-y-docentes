package sv.edu.udb.handler;

import sv.edu.udb.model.Alumno;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/controldb";
    private String username = "root";
    private String password = "";
    private ResultSet rs;
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
            System.out.println("Error en db Conectar");
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
            System.out.println("Error en db Profesor");
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
            System.out.println("Error en db Alumno");
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
            System.out.println("Error en db Login");
            ex.printStackTrace();

        }
        return true;
    }

    public int verificarInicioSesion(String usuario, String password) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = null;

            String query = "SELECT * FROM estudiante WHERE Nombre = '" + usuario + "' AND Password = '" + password + "'";
            rs = st.executeQuery(query);

            if(rs.next()){
                return 1;
            }

            query = "SELECT * FROM profesor WHERE Nombre = '" + usuario + "' AND Password = '" + password + "'";
            rs = st.executeQuery(query);

            if(rs.next()){
                return 2;
            }

            query = "SELECT * FROM admin WHERE Nombre = '" + usuario + "' AND Password = '" + password + "'";
            rs = st.executeQuery(query);

            if(rs.next()){
                return 3;
            }

            rs.close();
            st.close();
        } catch (Exception ex) {
            System.out.println("Error en la base de datos verificarInicioSesion");
            ex.printStackTrace();
        }

        return 0;
    }

    public void updateAlumno(int edad, String password, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Edad = '" + edad + "', Password = '" + password + "'" +
                    "WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar alumno");
            e.printStackTrace();
        }
    }

    public void updateMaestro(String password, String materia, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Materia = '" + materia + "', Password = '" + password + "'"
                    + "WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar maestro");
            e.printStackTrace();
        }
    }

    public List<Alumno> selectAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();

        try{
           String query = "SELECT IDEstudiante, Nombre, Apellido, Edad, Sexo FROM estudiante";
           this.setRs(query);

           while (rs.next()){
               Alumno alumno = new Alumno();
               alumno.setId(rs.getInt("IDEstudiante"));
               alumno.setNombre(rs.getString("Nombre"));
               alumno.setApellido(rs.getString("Apellido"));
               alumno.setEdad(rs.getInt("Edad"));
               alumno.setSexo(rs.getString("Sexo"));

               alumnos.add(alumno);
           }

           rs.close();
        } catch (Exception e){
            System.out.println("Error al seleccionar todos los alummnos");
            e.printStackTrace();
        }

        return alumnos;
    }

    public void cerrar() {
        try {
            conn.close();

            System.out.println("Coneccion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error en db cerrar");
            ex.printStackTrace();
        }
    }

    //Getters
    public ResultSet getRs(){
        return this.rs;
    }
    //Setters
    public void setRs(String query){
        try{
            Statement st = conn.createStatement();
            this.rs = st.executeQuery(query);
        } catch (Exception e){
            System.out.println("Error en rs");
            e.printStackTrace();
        }
    }
}
