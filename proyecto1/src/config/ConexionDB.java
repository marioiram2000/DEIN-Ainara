package config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.TimeZone;

public class ConexionDB {
    private static Connection conexion;
    
    public ConexionDB() {}

    public Connection getConexion() {
    	try {
    		GetPropertyValues pv = new GetPropertyValues();
    		HashMap<String, String> data = pv.getDBInformation();
    		String host = data.get("host");
    		String baseDatos = data.get("baseDatos");
    		String usuario = data.get("usuario");
    		String password = data.get("password");
    		String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
    		conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
    		conexion.setAutoCommit(true);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conexion;
    }

}