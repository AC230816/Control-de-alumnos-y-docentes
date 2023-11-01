<%@ page import="sv.edu.udb.handler.Conexion" %>
<%@ page import="sv.edu.udb.model.Alumno" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 31/10/2023
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mi Información</title>
</head>
<body>
    <p>Nombre: ${empty alumno ? 'N/A' : alumno.nombre}</p>
    <p>Apellido: ${empty alumno ? 'N/A' : alumno.apellido}</p>
    <p>Sexo: ${empty alumno ? 'N/A' : alumno.sexo}</p>
    <p>Edad: ${empty alumno ? 'N/A' : alumno.edad}</p>
    <p>Contraseña: ${empty alumno ? 'N/A' : alumno.password}</p>
</body>
</html>
