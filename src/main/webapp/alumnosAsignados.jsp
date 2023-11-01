<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alumnos Asignados</title>
    <!-- Enlace a Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="display-4">Alumnos Asignados</h1>
    <div class="row">
        <div class="col-md-6">
            <ul class="list-group">
                <c:forEach items="${alumnosAsignados}" var="alumno">
                    <li class="list-group-item">${alumno}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
