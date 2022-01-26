package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConexionDB {
	private Connection conexion;

	public ConexionDB() {
	}

	public Connection getConexion() {
		try {
			String host = PropertyReader.getProperty("host");
			String baseDatos = PropertyReader.getProperty("baseDatos");
			String usuario = PropertyReader.getProperty("usuario");
			String password = PropertyReader.getProperty("password");
			String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos + "?serverTimezone="
					+ TimeZone.getDefault().getID();
			conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

}