<%-- 
    Document   : profesor
    Created on : 21-sep-2016, 10:34:22
    Author     : David Salazar Mejia davidsm54@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de profesores</title>
    </head>
    <body style="font-family: helvetica 14px b" >
        
        <form action="ProfesorController" method="post">  
            <fieldset>
                <legend>Registro de profesores</legend>
            </fieldset>
            <div>
                <label for="idProfesor">Id Profesor</label>
                <input type="text" name="idProfesor" value="${profesor.idProfesor}"
                       placeholder="Id de profesor" readonly="readonly">
            </div>

            <div>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${profesor.nombre}"
                       placeholder="Nombre de profesor">
            </div>

            <div>
                <label for="experiencia">Experiencia</label>
                <input type="number" name="experiencia" value="${profesor.experiencia}"
                       placeholder="Experiencia en años">
            </div>

            <div>
                <label for="carrera">Carrera</label>
                <input type="text" name="carrera" value="${profesor.carrera}"
                       placeholder="carrera de abscripción" >
            </div>

            <div> 
                <input type="submit" value="Guardar"
            </div>
        </form>
    </body>
</html>
