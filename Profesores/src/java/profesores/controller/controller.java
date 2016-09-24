package profesores.controller;

import profesores.dao.AlumnoDAOImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import profesores.model.Alumno;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class controller extends HttpServlet {
private final String LISTA_ALUMNO = "/lista_alumno.jsp";
    private final String AGREGAR_CAMBIAR = "/alumno.jsp";
    private AlumnoDAOImp dao;

    public controller() {
        dao = new AlumnoDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";

        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_ALUMNO;

            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            dao.borrarAlumno(idAlumno);

            request.setAttribute("alumnos", dao.desplegarAlumnos());
            
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;

            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            Alumno alumno = dao.elegirAlumno(idAlumno);

            request.setAttribute("alumno", alumno);
        } else {
            if (action.equalsIgnoreCase("Agregar")) {
                forward = AGREGAR_CAMBIAR;
            } else {
                forward = LISTA_ALUMNO;
                request.setAttribute("alumnos", dao.desplegarAlumnos());
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Alumno alumno = new Alumno();

        alumno.setAlumno(request.getParameter("alumno"));
        alumno.setNombreEscuela(request.getParameter("nombreEscuela"));
        alumno.setProfesor(request.getParameter("maestro"));
        alumno.setProyecto(request.getParameter("proyecto"));
        alumno.setActivo(request.getParameter("activo"));

        String idAlumno = request.getParameter("idalumno");

        if (idAlumno == null || idAlumno.isEmpty()) {
            dao.agregarAlumno(alumno);
        } else {
            alumno.setIdAlumno(Integer.parseInt(idAlumno));
            dao.cambiarAlumno(alumno);
          }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_ALUMNO);
        request.setAttribute("alumnos", dao.desplegarAlumnos());

        view.forward(request, response);
    }
}
