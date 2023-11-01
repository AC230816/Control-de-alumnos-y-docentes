package sv.edu.udb.model;

import sv.edu.udb.handler.Conexion;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String password;
    private String query;
    private int id;

    public Alumno(){
        this.setQuery();
    }

    //Getters
    public String getPassword(){
        return this.password;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getSexo(){
        return this.sexo;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getQuery(){
        return this.query;
    }
    public int getId(){
        return this.id;
    }
    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    private void setQuery(){
        this.query = "SELECT * FROM estudiante WHERE Nombre = '" + this.nombre + "' AND Password = '" + this.password + "'";
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setId(int id){
        this.id = id;
    }
}
