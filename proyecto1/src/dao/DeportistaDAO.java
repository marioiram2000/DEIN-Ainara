package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deportista;

public class DeportistaDAO {

	ConexionDB conBD;


	public ArrayList<Deportista> getDeportistas() {
		conBD = new ConexionDB();
		ArrayList<Deportista> deportes = new ArrayList<Deportista>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT * FROM olimpiadas.Deportista";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return deportes;
	}
}
