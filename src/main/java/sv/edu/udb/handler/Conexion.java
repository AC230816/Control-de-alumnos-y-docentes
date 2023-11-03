package sv.edu.udb.handler;

import sv.edu.udb.model.Alumno;
import sv.edu.udb.model.Maestro;

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

    public List<Maestro> selectMaestros(){
        List<Maestro> maestros = new ArrayList<>();

        try{
            String query = "SELECT ID, Nombre, Apellido, Edad, Sexo, Materia FROM profesor";
            this.setRs(query);

            while (rs.next()){
                Maestro maestro = new Maestro();
                maestro.setId(rs.getInt("ID"));
                maestro.setNombre(rs.getString("Nombre"));
                maestro.setApellido(rs.getString("Apellido"));
                maestro.setEdad(rs.getInt("Edad"));
                maestro.setSexo(rs.getString("Sexo"));
                maestro.setMateria(rs.getString("Materia"));

                maestros.add(maestro);
            }

            rs.close();
        } catch (Exception e){
            System.out.println("Error al seleccionar todos los maestros");
            e.printStackTrace();
        }

        return maestros;
    }

    public List<Integer> selectIDMaestro(){
        List<Integer> IDS = new ArrayList<>();

        String query = "SELECT ID FROM profesor";
        this.setRs(query);

        try{
            while(rs.next()){
                int id = rs.getInt("ID");
                IDS.add(id);
            }

            rs.close();
        } catch (Exception e){
            System.out.println("Error al seleccionar los ID de maestros");
            e.printStackTrace();
        }

        return IDS;
    }

    public void updateNombreMaestro(String nombre, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE profesor SET Nombre = '" + nombre + "' WHERE ID = " + id;
            st.execute(query);
            System.out.println("Se actualizo el nombre maestro");
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar nombre maestro");
            e.printStackTrace();
        }
    }

    public void updateApellidoMaestro(String apellido, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE profesor SET Apellido = '" + apellido + "' WHERE ID = " + id;
            st.execute(query);
            System.out.println("Se actualizo el apellido maestro");
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar apellido maestro");
            e.printStackTrace();
        }
    }

    public void updateEdadMaestro(int edad, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE profesor SET Edad = " + edad + " WHERE ID = " + id;
            st.execute(query);
            System.out.println("Se actualizo la edad maestro");
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar edad maestro");
            e.printStackTrace();
        }
    }

    public void updatePasswordMaestro(String password, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE profesor SET Password = '" + password + "' WHERE ID = " + id;
            st.execute(query);
            System.out.println("Se actualizo el password maestro");
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar password maestro");
            e.printStackTrace();
        }
    }

    public void updateMateriaMaestro(String materia, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE profesor SET Materia = '" + materia + "' WHERE ID = " + id;
            st.execute(query);
            System.out.println("Se actualizo la materia correctamente");
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar materia maestro");
            e.printStackTrace();
        }
    }

    public Maestro selectMaestroAsignado(int id){
        Maestro maestro = new Maestro();

        String query = "SELECT ID, Nombre, Apellido, Edad, Sexo, Materia FROM profesor WHERE ID = " + id;

        try{
            this.setRs(query);
            if(rs.next()){
                maestro.setMateria(rs.getString("Materia"));
                maestro.setNombre(rs.getString("Nombre"));
                maestro.setApellido(rs.getString("Apellido"));
                maestro.setEdad(rs.getInt("Edad"));
                maestro.setId(rs.getInt("ID"));
                maestro.setSexo(rs.getString("Sexo"));
            }

        } catch (Exception e){
            System.out.println("Error al seleccionar maestro asignado");
            e.printStackTrace();
        }

        return maestro;
    }

    public List<Alumno> selectAlumnosAsignados(int idMaestro){
        List<Alumno> alumnos = new ArrayList<>();

        try{
            String query = "SELECT IDEstudiante, Nombre, Apellido, Edad, Sexo FROM estudiante WHERE IDMaestroAsignado = " + idMaestro;

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
            System.out.println("Error al seleccionar todos los alummnos asignados");
            e.printStackTrace();
        }

        return alumnos;
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

    public List<Integer> selectIDEstudiante(){
        List<Integer> IDS = new ArrayList<>();

        String query = "SELECT IDEstudiante FROM estudiante";
        this.setRs(query);

        try{
            while(rs.next()){
                int id = rs.getInt("IDEstudiante");
                IDS.add(id);
            }

            rs.close();
        } catch (Exception e){
            System.out.println("Error al seleccionar los ID de estudiantes");
            e.printStackTrace();
        }

        return IDS;
    }

    public void updateNombreAlumno(String nombre, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Nombre = '" + nombre + "'" +
                    "WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar nombre alumno");
            e.printStackTrace();
        }
    }

    public void updateApellidoAlumno(String apellido, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Apellido = '" + apellido + "'" +
                    "WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar apellido alumno");
            e.printStackTrace();
        }
    }

    public void updateEdadAlumno(int edad, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Edad = '" + edad + "' WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar edad alumno");
            e.printStackTrace();
        }
    }

    public void updatePasswordAlumno(String password, int id){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET Password = '" + password + "'" +
                    "WHERE IDEstudiante = '" + id + "'";
            st.execute(query);
            st.close();
        } catch (Exception e){
            System.out.println("Error al actualizar password alumno");
            e.printStackTrace();
        }
    }

    public void updateMaestroAsignado(int idMaestro, int idEstudiante){
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE estudiante SET IDMaestroAsignado = '" + idMaestro + "'" +
                    "WHERE IDEstudiante = '" + idEstudiante + "'";
            st.execute(query);
            System.out.println("Maestro asignado con exito");
            st.close();
        } catch (Exception e){
            System.out.println("Error al asignar maestro a alumno");
            e.printStackTrace();
        }
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
