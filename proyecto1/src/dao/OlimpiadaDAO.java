package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Evento;
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
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_olimpiada"));
			}
			for (Integer id : ids) {
				Olimpiada o = getOlimpiada(id);
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
			Olimpiada o = new Olimpiada(
									id,
									rs.getString("nombre"),
									rs.getInt("anio"),
									rs.getString("temporada"),
									rs.getString("ciudad")
								); 
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
}
