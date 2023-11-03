package sv.edu.udb.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private String nombre;
    private String apellido;
    private String sexo;
    private String password;
    private int edad;
    private int id;
    private String query;

    public Admin(){}

    //Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getSexo(){
        return this.sexo;
    }
    public String getPassword(){
        return this.password;
    }
    public int getEdad(){
        return this.edad;
    }
    public int getId(){
        return this.id;
    }
    public String getQuery(){
        return this.query;
    }
    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setQuery(){
        this.query = "SELECT * FROM admin WHERE Nombre = '"+ this.nombre + "' AND Password = '" + this.password + "'";
    }
}
