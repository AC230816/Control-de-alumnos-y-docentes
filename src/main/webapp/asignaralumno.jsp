<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 03/11/2023
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asignar Alumnos a Docentes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<!-- Asignar Alumnos a Docentes -->
<div class="container mt-5">
  <h1 class="mt-4">Asignar Alumnos a Docentes</h1>
  <div class="row">
    <div class="col-md-6">
      <form action="AsignarAlumnoMaestroServlet" method="post">
        <div class="form-group">
          <label for="alumno">Selecciona un Alumno:</label>
          <select class="form-control" id="alumno" name="alumno">
            <% String alumnos = (String) request.getAttribute("alumnos");
              if (alumnos != null) { %>
            <%= alumnos %>
            <% } %>
          </select>
        </div>

        <div class="form-group">
          <label for="docente">Selecciona un Docente:</label>
          <select class="form-control" id="docente" name="docente">
            <% String maestros = (String) request.getAttribute("maestros");
              if (maestros != null) { %>
            <%= maestros %>
            <% } %>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Asignar</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
