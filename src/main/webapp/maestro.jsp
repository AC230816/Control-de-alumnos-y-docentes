<%-- Vista de Maestro (maestro.jsp) --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Panel de Maestro</title>
  <!-- referencias a Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="display-4">Panel de Maestro</h1>

  <!-- Visualizar información del Maestro -->
  <h2 class="mt-4">Información del Maestro</h2>
  <div class="row">
    <div class="col-md-6">
      <a href="verInfoMaestro.jsp" class="btn btn-primary">Visualizar Mi Información</a>
    </div>
    <div class="col-md-6">
      <a href="actualizarInfoMaestro.jsp" class="btn btn-success">Actualizar Mi Información</a>
    </div>
  </div>

  <!-- Visualizar Alumnos Asignados -->
  <h2 class="mt-4">Alumnos Asignados</h2>
  <div class="row">
    <div class="col-md-12">
      <a href="alumnosAsignados.jsp" class="btn btn-primary">Visualizar Alumnos Asignados</a>
    </div>
  </div>
</div>
</body>
</html>