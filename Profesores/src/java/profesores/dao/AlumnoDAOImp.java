package profesores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import profesores.model.Alumno;
import profesores.util.UtilDB;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class AlumnoDAOImp implements AlumnoDAO {

    private Connection connection;

    public AlumnoDAOImp() {
        connection = UtilDB.getConnection();
    }

    //Metodo con el cual se hace inserccion de datos a la base de datos.
    @Override
    public void agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (alumno, maestro, nombreEscuela, proyecto, activo) "
                + "Values (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);            
            
            ps.setString(1, alumno.getAlumno());            
            ps.setString(2, alumno.getProfesor());
            ps.setString(3, alumno.getNombreEscuela());
            ps.setString(4, alumno.getProyecto());
            ps.setString(5, alumno.getActivo());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void borrarAlumno(int idAlumno) {
        String sql = "DELETE from alumno where idAlumno = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarAlumno(Alumno alumno) {
        String SQL = "UPDATE alumno set alumno =?"
                + " , maestro = ?,"
                + " nombreescuela = ?,"
                + " proyecto = ?, "
                + "activo = ?"
                + "where idAlumno = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
           

            ps.setString(1, alumno.getAlumno());
            ps.setString(2, alumno.getProfesor());
            ps.setString(3, alumno.getNombreEscuela());
            ps.setString(4, alumno.getProyecto());
            ps.setString(5, alumno.getActivo());
            ps.setInt(6, alumno.getIdAlumno());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Alumno> desplegarAlumnos() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumno");

            while (rs.next()) {
                Alumno alumno = new Alumno(rs.getInt("idalumno"), rs.getString("nombreescuela"),
                        rs.getString("alumno"), rs.getString("maestro"), rs.getString("proyecto"), rs.getString("activo"));
                alumnos.add(alumno);
            }
        } catch (Exception e) {
        }

        return alumnos;
    }

    @Override
    public Alumno elegirAlumno(int idAlumno) {

        Alumno alumno = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM alumno where idAlumno = ?");
            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                alumno = new Alumno(rs.getInt("idAlumno"), rs.getString("nombreEscuela"),
                        rs.getString("alumno"), rs.getString("maestro"), rs.getString("proyecto"), rs.getString("activo"));
            }
        } catch (Exception e) {
        }

        return alumno;
    }

}
