package profesores.model;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class Profesor {
    private int idProfesor;
    private String nombre;
    private int experiencia;
    private String carrera;

    public Profesor(int idProfesor, String nombre, int experiencia, String carrera) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.carrera = carrera;
    }
    
    public Profesor(){
        this(0, "", 0, "");
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", experiencia=" + experiencia + ", carrera=" + carrera + '}';
    }
}
