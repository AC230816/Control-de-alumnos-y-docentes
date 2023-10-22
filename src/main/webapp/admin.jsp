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
            <a href="InsertarEditarAlumnoServlet" class="btn btn-success">Insertar o Editar Información de Alumnos</a>
        </div>
    </div>

    <!-- Acciones para Docentes -->
    <h2 class="mt-4">Acciones para Docentes</h2>
    <div class="row">
        <div class="col-md-6">
            <a href="VerInfoDocentesServlet" class="btn btn-primary">Visualizar Información de Docentes</a>
        </div>
        <div class="col-md-6">
            <a href="InsertarEditarDocenteServlet" class="btn btn-success">Insertar o Editar Información de Docentes</a>
        </div>
    </div>
    <!-- Asignar Alumnos a Docentes -->
    <h2 class="mt-4">Asignar Alumnos a Docentes</h2>
    <div class="row">
        <div class="col-md-6">
            <form action="AsignarAlumnoDocenteServlet" method="post">
                <div class="form-group">
                    <label for="alumno">Selecciona un Alumno:</label>
                    <select class="form-control" id="alumno" name="alumno">
                        <!-- Lista de alumnos desde la base de datos -->
                        <option value="1">Alumno 1</option>
                        <option value="2">Alumno 2</option>
                        <!-- Agrega más opciones según la base de datos -->
                    </select>
                </div>

                <div class="form-group">
                    <label for="docente">Selecciona un Docente:</label>
                    <select class="form-control" id="docente" name="docente">
                        <!-- Lista de docentes desde la base de datos -->
                        <option value="1">Docente 1</option>
                        <option value="2">Docente 2</option>
                        <!-- Agrega más opciones según la base de datos -->
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Asignar</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

