package sv.edu.udb.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maestro implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private int id;
    private String materia;
    private String password;
    private String query;

    public Maestro(){}

    //Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getPassword(){
        return this.password;
    }
    public String getMateria(){
        return this.materia;
    }
    public String getQuery(){
        return this.query;
    }
    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setQuery(){
        this.query = "SELECT * FROM profesor WHERE Nombre = '"+ this.nombre + "' AND Password = '" + this.password + "'";
    }
    public void setMateria(String materia){
        this.materia = materia;
    }
}

