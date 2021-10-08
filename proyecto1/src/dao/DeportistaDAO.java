package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;
import model.Deportista;

public class DeportistaDAO {

	ConexionDB conBD;
	
	public DeportistaDAO() {
		this.conBD = new ConexionDB();
	}

	public ArrayList<Deportista> getDeportistas() {
		//conBD = new ConexionDB();
		ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deportista, nombre, sexo, peso, altura FROM Deportista";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_deporte"));
			}
			for (Integer id : ids) {
				Deportista d = getDeportista(id);
				deportistas.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportistas;
	}
	
	public Deportista getDeportista(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "ELECT id_deportista, nombre, sexo, peso, altura FROM Deportista WHERE id_deportista = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Deportista d = new Deportista(
					rs.getInt("id_deportista"),
					rs.getString("nombre"),
					rs.getString("sexo"),
					rs.getInt("peso"),
					rs.getInt("altura"));
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
	
	
	
	
}
