package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class ConexionDB {
    private Connection conexion;
    
    public ConexionDB() {
    	try {
    		String host = "localhost";
            String baseDatos = "olimpiadas";
            String usuario = "admin";
            String password = "password";
            String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
            conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            conexion.setAutoCommit(true);
    	}catch (SQLException e) {
			System.out.println("ConexionDB.SQLException: "+e);
		}
        
    }

    public Connection getConexion() {
        return conexion;
    }

}