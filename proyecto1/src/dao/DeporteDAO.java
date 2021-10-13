package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;
import model.Evento;
import model.Olimpiada;

public class DeporteDAO {
	
	ConexionDB conBD;

	public ArrayList<Deporte> getDeportes() {
		ConexionDB conBD = new ConexionDB();
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deporte, nombre FROM Deporte";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_deporte"));
			}
			for (Integer id : ids) {
				Deporte d = getDeporte(id);
				deportes.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deportes;
	}
	
	public Deporte getDeporte(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_deporte, nombre FROM Deporte WHERE id_deporte = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Deporte d = new Deporte(id, rs.getString("nombre"));
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
	
	public int existDeporte(String name) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_deporte, nombre FROM Deporte WHERE nombre = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("id_deporte");
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return -1;
	}

	public void insertDeporte(String nombre) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			if(0<existDeporte(nombre)) {
				String sql = "insert into olimpiadas.Deporte (nombre) values ('?')";
				PreparedStatement ps = conexion.prepareStatement(sql);
				ps.executeUpdate();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateDeporte(String nombre) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			int id = existDeporte(nombre);
			if(0<id) {
				String sql = "UPDATE Deporte SET nombre = 'Futbol' WHERE id_deporte = ?";
				PreparedStatement ps = conexion.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
