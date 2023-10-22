<%-- Vista de Alumno (alumno.jsp) --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Panel de Alumno</title>
  <!-- referencias a Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="display-4">Panel de Alumno</h1>

  <!-- Visualizar Información -->
  <h2 class="mt-4">Mi Información</h2>
  <div class="row">
    <div class="col-md-6">
      <a href="VerInfoAlumnoServlet" class="btn btn-primary">Visualizar Mi Información</a>
    </div>
    <div class="col-md-6">
      <a href="EditarInfoAlumnoServlet" class="btn btn-success">Actualizar Mi Información</a>
    </div>
  </div>

  <!-- Visualizar la Información del Docente Asignado -->
  <h2 class="mt-4">Información del Docente Asignado</h2>
  <div class="row">
    <div class="col-md-12">
      <a href="VerInfoDocenteAsignadoServlet" class="btn btn-primary">Visualizar Información del Docente Asignado</a>
    </div>
  </div>
</div>
</body>
</html>
