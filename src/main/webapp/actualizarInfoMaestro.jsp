<%-- Actualizacion de informacion de maestros --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Usuarios</title>
    <!-- referencias a Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1>Actualizar informacion - Maestros</h1>
            <form action="maestro.jsp" method="post">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                </div>

                <div class="form-group">
                    <label for="ocupacion">Ocupación:</label>
                    <select class="form-control" id="ocupacion" name="ocupacion" required>
                        <option value="maestro">Maestro</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="materia">Materias:</label>
                    <select class="form-control" id="materia" name="materia">
                        <option value="matematica">Matemática</option>
                        <option value="lenguaje">Lenguaje</option>
                        <option value="sociales">Sociales</option>
                        <option value="filosofia">Filosofía</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="edad">Edad:</label>
                    <input type="number" class="form-control" id="edad" name="edad" required>
                </div>

                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <select class="form-control" id="sexo" name="sexo" required>
                        <option value="masculino">Masculino</option>
                        <option value="femenino">Femenino</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div class="form-group">
                    <label for="confirm_password">Confirmar Contraseña:</label>
                    <input type="password" class="form-control" id="confirm_password" name="confirm_password" required>
                </div>

                <button type="submit" class="btn btn-primary">Actualizar Datos</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
