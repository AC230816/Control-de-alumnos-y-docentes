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
      <button id="editarInfoButton" class="btn btn-success">Actualizar Mi Información</button>
    </div>
  </div>

<%--  <!-- Tabla de Alumnos -->--%>
<%--  <h2 class="mt-4">Tabla de Alumnos</h2>--%>
<%--  <table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--      <th>ID</th>--%>
<%--      <th>Nombre</th>--%>
<%--      <th>Apellido</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <tr>--%>
<%--      <td>1</td>--%>
<%--      <td>Zankuno</td>--%>
<%--      <td>messi</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--      <td>2</td>--%>
<%--      <td>Nombre2</td>--%>
<%--      <td>Apellido2</td>--%>
<%--    </tr>--%>
<%--
<%--    </tbody>--%>
<%--  </table>--%>

<%--  <!-- Información Seleccionada -->--%>
<%--  <h2 class="mt-4">Información Seleccionada</h2>--%>
<%--  <div class="row">--%>
<%--    <div class="col-md-12">--%>
<%--      <div class="card" id="selectedInfo" style="display: none;">--%>
<%--        <div class="card-body">--%>
<%--          <h5 class="card-title">Información del Alumno Seleccionado</h5>--%>
<%--          <p class="card-text" id="selectedInfoContent"></p>--%>
<%--          <div class="form-group">--%>
<%--            <label for="newName">Nuevo Nombre:</label>--%>
<%--            <input type="text" class="form-control" id="newName">--%>
<%--          </div>--%>
<%--          <button id="updateNameButton" class="btn btn-primary">Actualizar Nombre</button>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>

<%--<script>--%>
<%--  const editarInfoButton = document.getElementById('editarInfoButton');--%>
<%--  const selectedInfo = document.getElementById('selectedInfo');--%>
<%--  const selectedInfoContent = document.getElementById('selectedInfoContent');--%>
<%--  const newNameInput = document.getElementById('newName');--%>
<%--  const updateNameButton = document.getElementById('updateNameButton');--%>

<%--  editarInfoButton.addEventListener('click', function() {--%>
<%--
<%--    const selectedRow = document.querySelector('table tbody tr.selected');--%>

<%--    if (selectedRow) {--%>
<%--
<%--      selectedInfoContent.textContent = `ID: ${selectedRow.cells[0].textContent}, Nombre: ${selectedRow.cells[1].textContent}, Apellido: ${selectedRow.cells[2].textContent}`;--%>
<%--      selectedInfo.style.display = 'block';--%>
<%--    } else {--%>
<%--      alert('Por favor, seleccione un dato de la tabla para modificar.');--%>
<%--    }--%>
<%--  });--%>

<%--
<%--  document.querySelectorAll('table tbody tr').forEach(row => {--%>
<%--    row.addEventListener('click', function() {--%>
<%--      document.querySelectorAll('table tbody tr').forEach(row => {--%>
<%--        row.classList.remove('selected');--%>
<%--      });--%>
<%--      this.classList.add('selected');--%>
<%--    });--%>
<%--  });--%>

<%--  updateNameButton.addEventListener('click', function() {--%>
<%--
<%--    const newStudentName = newNameInput.value;--%>

<%--
<%--    const selectedRow = document.querySelector('table tbody tr.selected');--%>
<%--    if (selectedRow) {--%>
<%--      selectedRow.cells[1].textContent = newStudentName;--%>
<%--      selectedInfo.style.display = 'none'; // Oculta la tarjeta de presentación--%>
<%--    } else {--%>
<%--      alert('Por favor, seleccione un dato de la tabla para modificar.');--%>
<%--    }--%>
<%--  });--%>
<%--</script>--%>

</body>
</html>
