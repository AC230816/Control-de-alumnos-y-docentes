<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 03/11/2023
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Información de Maestros</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Modificar Información de Maestro</h1>
    <form action = "EditarMaestro" method="post">
        <div class="form-group">
            <label for="seleccionar-id">Seleccione un ID</label>
            <select id="seleccionar-id" name="id" class="form-control" required>
                <% String id = (String) request.getAttribute("IDS");
                    if (id != null) { %>
                <%= id %>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="campos">Seleccione el campo a modificar</label>
            <select id="campos" name="campos" class="form-control" required>
                <option value="nombre">Nombre</option>
                <option value="apellido">Apellido</option>
                <option value="edad">Edad</option>
                <option value="password">Contraseña</option>
                <option value = "materia">Materia</option>
                <option value="todos">Modificar todos los campos</option>
            </select>
        </div>
        <div class="form-group" id="div-nombre">
            <label for="nombre">Digite el nuevo nombre: </label>
            <input type="text" class="form-control" name = "nombre" id = "nombre">
        </div>
        <div class="form-group" id="div-apellido">
            <label for="apellido">Digite el nuevo apellido: </label>
            <input type="text" class="form-control" name = "apellido" id = "apellido">
        </div>
        <div class="form-group" id="div-edad">
            <label for="edad">Digite la nueva edad: </label>
            <input type="number" class="form-control" name = "edad" id = "edad">
        </div>
        <div class="form-group" id="div-materia">
            <label for="materia">Materias:</label>
            <select class="form-control" id="materia" name="materia">
                <option value="matematica">Matemática</option>
                <option value="lenguaje">Lenguaje</option>
                <option value="sociales">Sociales</option>
                <option value="filosofia">Filosofía</option>
            </select>
        </div>
        <div class="form-group" id="div-password">
            <label for="password">Digite la nueva contraseña: </label>
            <input type="text" class="form-control" name = "password" id = "password">
        </div>

        <input type="hidden" name="action" value="editar">

        <div class="d-flex justify-content-between">
            <input type="submit" value="modificar" class="btn btn-success">
            <a href="InsertarEditarAlumnoServlet?action=5" class="btn btn-danger">Volver</a>
        </div>
    </form>
</div>
<script src="js/editar-maestros.js"></script>
</body>
</html>
