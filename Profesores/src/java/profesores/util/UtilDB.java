package profesores.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author David Salazar Mejia davidsm54@gmail.com
 */
public class UtilDB {
    private static Connection connection;

    public static Connection getConnection() {
        if(connection != null){
            return connection;
        }
        InputStream is = UtilDB.class.getClassLoader().getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        
        try {
            properties.load(is);
            Class.forName(properties.getProperty("driver"));
            
            connection = DriverManager.getConnection(properties.getProperty("url"),
                            properties.getProperty("user"),
                            properties.getProperty("password")
                    );
            
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public static void closeConnection (Connection connection){
        if(connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
