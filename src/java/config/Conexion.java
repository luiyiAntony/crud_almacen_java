package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blablabla
 */
public class Conexion {
    //public Connection getConexion() throws ClassNotFoundException {
    public Connection getConexion() {
	    try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "");
		    return conexion;
	    } 
	    catch (SQLException e) {
		    System.out.println(e.toString());
		    return null;
	    } 
	    catch (ClassNotFoundException ex) {
		    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		    return null;
	    }
    }
}
