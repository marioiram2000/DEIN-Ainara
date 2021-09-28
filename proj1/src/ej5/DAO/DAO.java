package ej5.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ej5.conexion.ConexionDB;
import ej5.model.AeropuertoPrivado;
import ej5.model.AeropuertoPublico;

public class DAO {

	private ConexionDB con;

	
	public DAO() throws SQLException {
		con = new ConexionDB();
	}

	public ArrayList<AeropuertoPublico> getAeropuertosPublicos() throws SQLException {
		//System.out.println("on getAeropuertosPublicos");
		ResultSet rs = con.ejecutarConsulta(
				"SELECT * \n" + 
				"FROM aeropuertos, aeropuertos_publicos, direcciones \n" + 
				"WHERE aeropuertos.id = aeropuertos_publicos.id_aeropuerto \n" + 
				"AND direcciones.id = aeropuertos.id_direccion;");
		ArrayList<AeropuertoPublico> data = new ArrayList();
		while(rs.next()) {
			AeropuertoPublico aeropuerto = new AeropuertoPublico
					(rs.getInt("aeropuertos.id"),
					rs.getString("aeropuertos.nombre"),
					rs.getInt("aeropuertos.anio_inauguracion"),
					rs.getInt("aeropuertos.capacidad"),
					rs.getInt("aeropuertos.id_direccion"),
					rs.getFloat("aeropuertos_publicos.financiacion"),
					rs.getInt("aeropuertos_publicos.num_trabajadores"),
					rs.getString("direcciones.pais"),
					rs.getString("direcciones.ciudad"),
					rs.getString("direcciones.calle"),
					rs.getInt("direcciones.numero"));
			data.add(aeropuerto);
		}
		return data;
	}
	
	public ArrayList<AeropuertoPrivado> getAeropuertosPrivados() throws SQLException {
		ResultSet rs = con.ejecutarConsulta(
				"SELECT * \n" + 
				"FROM aeropuertos, aeropuertos_privados, direcciones\n" + 
				"where aeropuertos.id = aeropuertos_privados.id_aeropuerto\n" + 
				"AND direcciones.id = aeropuertos.id_direccion;");

		ArrayList<AeropuertoPrivado> data = new ArrayList();

		while(rs.next()) {
			AeropuertoPrivado aeropuerto = new AeropuertoPrivado
					(rs.getInt("aeropuertos.id"),
					rs.getString("aeropuertos.nombre"),
					rs.getInt("aeropuertos.anio_inauguracion"),
					rs.getInt("aeropuertos.capacidad"),
					rs.getInt("aeropuertos.id_direccion"),
					rs.getFloat("aeropuertos_privados.numero_socios"),
					rs.getString("direcciones.pais"),
					rs.getString("direcciones.ciudad"),
					rs.getString("direcciones.calle"),
					rs.getInt("direcciones.numero"));
			data.add(aeropuerto);
		}
		
		return data;
	}
	
	public ResultSet getDireccion(String id) throws SQLException {
		ResultSet rs = con.ejecutarConsulta("Select id, pais, ciudad, calle, numero from direccion where id = '"+id+"'");
		return rs;
	}
	
	
	
	
}
