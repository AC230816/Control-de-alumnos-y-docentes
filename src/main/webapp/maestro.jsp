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
      <a href="VerInfoMaestroServlet" class="btn btn-primary">Visualizar Mi Información</a>
    </div>
    <div class="col-md-6">
      <a href="EditarInfoMaestroServlet" class="btn btn-success">Actualizar Mi Información</a>
    </div>
  </div>
  <div class="row">
    <div id="info-maestro-response" class="col-md-12" style="margin-top: 10px">
      <% String htmlViewResponse = (String) request.getAttribute("htmlResponse");
        if (htmlViewResponse != null) { %>
      <%= htmlViewResponse %>
      <% } %>
    </div>
    <div id="editar-info-maestro-response" class="col-md-6" style="margin-top: 10px">
      <% String htmlEditResponse = (String) request.getAttribute("htmlEditResponse");
        if (htmlEditResponse != null) { %>
      <%= htmlEditResponse %>
      <% } %>
    </div>
  </div>

  <!-- Visualizar Alumnos Asignados -->
  <h2 class="mt-4">Alumnos Asignados</h2>
  <div class="row">
    <div class="col-md-12">
      <a href="AlumnosAsignadosServlet" class="btn btn-primary">Visualizar Alumnos Asignados</a>
    </div>
    <div id="tabla-alumnos" class="col-md-12" style="margin-top: 10px">
      <% String alumnos = (String) request.getAttribute("alumnos");
        if (alumnos != null) { %>
      <%= alumnos %>
      <% } %>
    </div>
  </div>
</div>
</body>
</html>