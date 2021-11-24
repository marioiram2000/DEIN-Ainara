package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Ubicacion;

public class DAOUbicacion {

	public ArrayList<Ubicacion> selectUbicaciones(){
		ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "SELECT id_ubic, seccion, ubicacion, imagen FROM ubicacion;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ubicacion ubicacion = new Ubicacion(rs.getInt("id_ubic"), rs.getString("seccion"), rs.getString("ubicacion"), rs.getString("imagen"));
				ubicaciones.add(ubicacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ubicaciones;
	}
}
