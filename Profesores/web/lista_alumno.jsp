<%-- 
    Document   : lista_alumno
    Created on : 23-sep-2016, 12:38:21
    Author     : David Salazar Mejia davidsm54@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de profesores</title>
    </head>
       
        <table style="background-color: #5cf7b1" style="text-align: center">
            <thead>
                <tr> 
                    <th> ID</th> <th>Nombre</th> <th> Profesor </th> <th> Escuela </th> <th> Proyecto </th> <th> Activo </th>
               </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${alumnos}" var="alumno">
                    <tr>
                        <td> ${alumno.idAlumno}</td>
                        <td> ${alumno.alumno}</td>
                        <td> ${alumno.profesor}</td>
                        <td> ${alumno.nombreEscuela}</td>
                        <td> ${alumno.proyecto}</td>
                        <td> ${alumno.activo}</td>
                        <td>
                            <a href="controller?action=cambiar&idAlumno=${alumno.idAlumno}">Modificar</a>
                        </td>
                        <td>
                            <a href="controller?action=borrar&idAlumno=${alumno.idAlumno}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <p>
            <a href="alumno.jsp">Agregar nuevo alumno</a>
        </p>
        
    </body>
</html>
