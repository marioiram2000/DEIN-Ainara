package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConexionDB {
    private static Connection conexion;
    
    public ConexionDB() {}

    public Connection getConexion() {
    	try {
    		String host = GetPropertyValues.getValor("host");
    		String baseDatos = GetPropertyValues.getValor("baseDatos");
    		String usuario = GetPropertyValues.getValor("usuario");
    		String password = GetPropertyValues.getValor("password");
    		String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
    		conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
    		conexion.setAutoCommit(true);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
        return conexion;
    }

}