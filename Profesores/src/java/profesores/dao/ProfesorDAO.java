package profesores.dao;

import java.util.List;
import profesores.model.Profesor;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public interface ProfesorDAO {
    void agregarProfesor(Profesor profesor);
    void borrarProfesor(int idProfesor);
    void cambiarProfesor (Profesor profesor);
    
    List<Profesor> desplegarProfesores();
    Profesor elegirProfesor (int idProfesor);
}
