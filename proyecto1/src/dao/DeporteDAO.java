package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;

public class DeporteDAO {

	ConexionDB conBD;

	public ArrayList<Deporte> getDeportes() {
		conBD = new ConexionDB();
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		try (Connection conexion = conBD.getConexion()) {
			String sql = "SELECT id_deporte, nombre FROM Deporte";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Deporte d = new Deporte(rs.getInt("id_deporte"), rs.getString("nombre"));
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
	/*
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
	 */
	public void insertDeporte(String nombre) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {

			String sql = "insert into Deporte (nombre) values (?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDeporte(Deporte deporte) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "UPDATE Deporte SET nombre = ? WHERE id_deporte = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, deporte.getNombre());
			ps.setInt(2, deporte.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDeporte(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "DELETE FROM Deporte  WHERE id_deporte = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
