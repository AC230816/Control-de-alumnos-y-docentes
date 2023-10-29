<%--
  Created by IntelliJ IDEA.
  User: Mini penis
  Date: 28/10/2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Información de Estudiantes</title>
</head>
<body>
<h1>Información de Estudiantes</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Edad</th>
        <th>Sexo</th>
    </tr>
    <c:forEach var="estudiante" items="${estudiantes}">
        <tr>
            <td><c:out value="${estudiante.IDEstudiante}" /></td>
            <td><c:out value="${estudiante.Nombre}" /></td>
            <td><c:out value="${estudiante.Apellido}" /></td>
            <td><c:out value="${estudiante.Edad}" /></td>
            <td><c:out value="${estudiante.Sexo}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
