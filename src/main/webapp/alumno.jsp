<%-- Vista de Alumno (alumno.jsp) --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
  <title>Panel de Alumno</title>
  <!-- Referencias a Bootstrap y estilos personalizados -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    .selected-row {
      background-color: #cce5ff;
    }
  </style>
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
      <a href="EditarInfoAlumnoServlet" id="editarInfoButton" class="btn btn-success">Actualizar Mi Información</a>
    </div>
    <div id="info-alumno-response" class="col-md-6" style="margin-top: 10px">
      <% String htmlViewResponse = (String) request.getAttribute("htmlResponse");
        if (htmlViewResponse != null) { %>
      <%= htmlViewResponse %>
      <% } %>
    </div>
    <div id="editar-info-alumno-response" class="col-md-6" style="margin-top: 10px">
      <% String htmlEditResponse = (String) request.getAttribute("htmlResponse");
        if (htmlEditResponse != null) { %>
      <%= htmlEditResponse %>
      <% } %>
    </div>
  </div>
</div>

</body>
</html>
