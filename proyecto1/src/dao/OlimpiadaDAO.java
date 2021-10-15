package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Olimpiada;

public class OlimpiadaDAO {

	ConexionDB conBD;

	public OlimpiadaDAO() {
		this.conBD = new ConexionDB();
	}

	public ArrayList<Olimpiada> getOlimpiadas() {
		conBD = new ConexionDB();
		ArrayList<Olimpiada> olimpiadas = new ArrayList<Olimpiada>();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_olimpiada, nombre, anio, temporada, ciudad FROM Olimpiada";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Olimpiada o = new Olimpiada(rs.getInt("id_olimpiada"), rs.getString("nombre"), rs.getInt("anio"),
						rs.getString("temporada"), rs.getString("ciudad"));
				olimpiadas.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olimpiadas;
	}

	public Olimpiada getOlimpiada(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_olimpiada, nombre, anio, temporada, ciudad FROM Olimpiada WHERE id_olimpiada = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Olimpiada o = new Olimpiada(id, rs.getString("nombre"), rs.getInt("anio"), rs.getString("temporada"),
					rs.getString("ciudad"));
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertOlimpiada(Olimpiada olimpiada) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "insert into Olimpiada (nombre, anio, temporada, ciudad) values (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, olimpiada.getNombre());
			ps.setInt(2, olimpiada.getAnio());
			ps.setString(3, olimpiada.getTemporada());
			ps.setString(4, olimpiada.getCiudad());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOlimpiada(Olimpiada olimpiada) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "UPDATE Olimpiada SET nombre = ?, anio = ?, temporada = ?, ciudad = ? WHERE id_olimpiada = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, olimpiada.getNombre());
			ps.setInt(2, olimpiada.getAnio());
			ps.setString(3, olimpiada.getTemporada());
			ps.setString(4, olimpiada.getCiudad());
			ps.setInt(5, olimpiada.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOlimpiada(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "DELETE FROM Olimpiada WHERE id_olimpiada = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
