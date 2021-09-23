package ej5.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import ej5.conexion.ConexionDB;

public class DAO {

	private ConexionDB con;
	
	
	public ResultSet getCireccion(String id) throws SQLException {
		ResultSet rs = con.ejecutarConsulta("Select id, pais, ciudad, calle, numero from direccion where id = '"+id+"'");
		return rs;
	}
	
	public ResultSet getAeropuertosPublicos() throws SQLException {
		ResultSet rs = con.ejecutarConsulta(
				"SELECT * \n" + 
				"FROM aeropuertos, aeropuertos_publicos, direcciones \n" + 
				"where aeropuertos.id = aeropuertos_publicos.id_aeropuerto \n" + 
				"AND direcciones.id = aeropuertos.id_direccion;");
		return rs;
	}
	
	public ResultSet getAeropuertosPrivados() throws SQLException {
		ResultSet rs = con.ejecutarConsulta(
				"SELECT * \n" + 
				"FROM aeropuertos, aeropuertos_privados, direcciones \n" + 
				"where aeropuertos.id = aeropuertos_privados.id_aeropuerto \n" + 
				"AND direcciones.id = aeropuertos.id_direccion;");
		return rs;
	}
	
	
	
}
