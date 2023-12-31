<%-- Vista de Administrador (admin.jsp) --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel de Administrador</title>
    <!-- referencias a Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="display-4">Panel de Administrador</h1>

    <!-- Acciones para Alumnos -->
    <h2 class="mt-4">Acciones para Alumnos</h2>
    <div class="row">
        <div class="col-md-6">
            <a href="VerInfoAlumnosServlet" class="btn btn-primary">Visualizar Información de Alumnos</a>
        </div>
        <div class="col-md-6">
            <a href="InsertarEditarAlumnoServlet?action=1" class="btn btn-success">Insertar o Editar Información de Alumnos</a>
        </div>
    </div>

    <div id = "alumnos" class="row">
        <div id="tabla-alumnos" class="col-md-12" style="margin-top: 10px">
            <% String alumnos = (String) request.getAttribute("alumnos");
                if (alumnos != null) { %>
            <%= alumnos %>
            <% } %>
        </div>
        <div  id = "editar-insertar-alumno" class="col-md-12" style = "margin-top: 10px">
            <% String alumnoResponse = (String) request.getAttribute("adminResponseAlumno");
                if (alumnoResponse != null) { %>
            <%= alumnoResponse %>
            <% } %>
        </div>
    </div>

    <!-- Acciones para Docentes -->
    <h2 class="mt-4">Acciones para Docentes</h2>
    <div class="row">
        <div class="col-md-6">
            <a href="VerInfoMaestrosServlet" class="btn btn-primary">Visualizar Información de Docentes</a>
        </div>
        <div class="col-md-6">
            <a href="InsertarEditarMaestroServlet?action=1" class="btn btn-success">Insertar o Editar Información de Docentes</a>
        </div>
    </div>

    <div id = "maestros" class="row">
        <div id="tabla-maestros" class="col-md-12" style="margin-top: 10px">
            <% String maestros = (String) request.getAttribute("maestros");
                if (maestros != null) { %>
            <%= maestros %>
            <% } %>
        </div>
        <div  id = "editar-insertar-maestro" class="col-md-12" style = "margin-top: 10px">
            <% String maestroResponse = (String) request.getAttribute("adminResponseMaestro");
                if (maestroResponse != null) { %>
            <%= maestroResponse %>
            <% } %>
        </div>
    </div>

    <div>
        <h2 class="mt-4">Asignar Alumnos a Docentes</h2>
        <div class="row">
            <div class="col-md-6">
                <a href="AsignarAlumnoMaestroServlet" class="btn btn-success">Asignar Alumnos a Docentes</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

