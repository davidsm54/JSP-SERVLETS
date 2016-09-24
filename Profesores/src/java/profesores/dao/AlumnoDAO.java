package profesores.dao;

import java.util.List;
import profesores.model.Alumno;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public interface AlumnoDAO {
    void agregarAlumno(Alumno alumno);
    void borrarAlumno(int idAlumno);
    void cambiarAlumno (Alumno alumno);
    
    List<Alumno> desplegarAlumnos();
    Alumno elegirAlumno (int idAlumno);
}
