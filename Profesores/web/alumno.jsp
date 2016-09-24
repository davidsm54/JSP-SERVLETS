<%-- 
    Document   : alumno
    Created on : 23-sep-2016, 12:36:12
    Author     : David Salazar Mejia davidsm54@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de profesores</title>
    </head>

        <form action="controller" method="Post">  
            <fieldset>
                <legend>Bienvenido al Registro de alumnos </legend>

                <div>
                    <label>Id Alumno</label>
                    <input type="text" name="idalumno" value="${alumno.idAlumno}"
                           placeholder="Id del alumno" readonly="readonly">
                </div>

                <div>
                    <label>Alumno</label>
                    <input type="text" name="alumno" value="${alumno.alumno}"
                           placeholder="Nombre de alumno">
                </div>

                <div>
                    <label>Profesor</label>
                    <input type="text" name="maestro" value="${alumno.profesor}"
                           placeholder="Nombre del profesor">
                </div>

                <div>
                    <label>Nombre de la escuela</label>
                    <input type="text" name="nombreEscuela" value="${alumno.nombreEscuela}"
                           placeholder="Escuela">
                </div>

                <div>
                    <label>Proyecto</label>
                    <input type="text" name="proyecto" value="${alumno.proyecto}"
                           placeholder="Proyecto" >
                </div>

                <div>
                    <label>Activo</label>
                    <input type="text" name="activo" value="${alumno.activo}"
                           placeholder="Activo" >
                </div>

                <div> 
                    <input type="submit" value="Guardar">
                    </fieldset>          
                </div>
        </form>
    </body>
</html>
