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
import profesores.model.Profesor;
import profesores.util.UtilDB;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class ProfesorDAOImp implements ProfesorDAO{
    private Connection connection;
    
    public ProfesorDAOImp (){
        connection = UtilDB.getConnection();
    }
   
    //Metodo con el cual se hace inserccion de datos a la base de datos.
    @Override
    public void agregarProfesor(Profesor profesor) {
        String sql = "INSERT INTO Profesores (nombre, experiencia, carrera)"
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
        ps.setString(1, profesor.getNombre());
        ps.setInt(2, profesor.getExperiencia());
        ps.setString(3, profesor.getCarrera());
        
        ps.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void borrarProfesor(int idProfesor) {
        String sql = "DELETE from profesores where idProfesor = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProfesor);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarProfesor(Profesor profesor) {
        String SQL = "UPDATE Profesores set nombre =?"
                + " , experiencia = ?,"
                + "carrera = ?"
                + "where idProfesor = ? ";
        
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setString(1, profesor.getNombre());
            ps.setInt(2, profesor.getExperiencia());
            ps.setString(3, profesor.getCarrera());
            ps.setInt(4, profesor.getIdProfesor());
            ps.executeUpdate();    
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Profesor> desplegarProfesores() {
        List<Profesor> profesores = new ArrayList<Profesor>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Profesores");
            
            while(rs.next()){
                Profesor profesor = new Profesor(rs.getInt("idProfesor"), rs.getString("nombre"), 
                        rs.getInt("experiencia"), rs.getString("carrera"));
                profesores.add(profesor);
            }
        } catch (Exception e) {
        }
        
        return profesores;
    }

    @Override
    public Profesor elegirProfesor(int idProfesor) {
        
        Profesor profesor = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Profesores where idProfesor = ?");
            ps.setInt(1, idProfesor);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                profesor  = new Profesor(rs.getInt("idProfesor"), rs.getString("nombre"), 
                        rs.getInt("experiencia"), rs.getString("carrera"));
            }
        } catch (Exception e) {
        }
        
        return profesor;
    }
    
    
}
