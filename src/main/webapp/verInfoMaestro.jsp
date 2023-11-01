<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Información del Maestro</title>
  <!-- Enlace a Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="display-4">Información del Maestro</h1>
  <div class="row">
    <div class="col-md-6">
      <table class="table">
        <tr>
          <th>ID:</th>
          <td>${idMaestro}</td>
        </tr>
        <tr>
          <th>Nombre:</th>
          <td>${nombre}</td>
        </tr>
        <tr>
          <th>Apellido:</th>
          <td>${apellido}</td>
        </tr>
        <tr>
          <th>Edad:</th>
          <td>${edad}</td>
        </tr>
        <tr>
          <th>Sexo:</th>
          <td>${sexo}</td>
        </tr>
        <tr>
          <th>Contraseña:</th>
          <td>${contraseña}</td>
        </tr>
        <tr>
          <th>Materia:</th>
          <td>${materia}</td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
</html>
