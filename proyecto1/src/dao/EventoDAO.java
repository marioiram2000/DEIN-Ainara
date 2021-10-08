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

public class EventoDAO {

	ConexionDB conBD;

	public EventoDAO() {
		conBD = new ConexionDB();
	}

	public ArrayList<Evento> getEventos() {
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_evento, nombre, id_olimpiada, id_deporte FROM Evento";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_deporte"));
			}
			for (Integer id : ids) {
				Evento e = getEvento(id);
				eventos.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return eventos;
	}
	
	public Evento getEvento(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_evento, nombre, id_olimpiada, id_deporte FROM Evento WHERE id_evento = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Olimpiada o = new OlimpiadaDAO().getOlimpiada(rs.getInt("id_olimpiada"));
			Deporte d = new DeporteDAO().getDeporte(rs.getInt("id_deporte"));
			Evento e = new Evento(id,rs.getString("nombre"),o,d);
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
}
