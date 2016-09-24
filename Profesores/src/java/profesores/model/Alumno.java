package profesores.model;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class Alumno {
    private int idAlumno;
    private String nombreEscuela;
    private String alumno;
    private String profesor;
    private String proyecto;
    private String activo;

    public Alumno(int idAlumno, String nombreEscuela, String alumno, String profesor, String proyecto, String activo) {
        this.idAlumno = idAlumno;
        this.nombreEscuela = nombreEscuela;
        this.alumno = alumno;
        this.profesor = profesor;
        this.proyecto = proyecto;
        this.activo = activo;
    }   
    
    public Alumno(){
        this(0, "","", "", "", "");
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombreEscuela=" + nombreEscuela + ", alumno=" + alumno + ", profesor=" + profesor + ", proyecto=" + proyecto + ", activo=" + activo + '}';
    }
}
