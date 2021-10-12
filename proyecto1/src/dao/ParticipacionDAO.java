package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deportista;
import model.Equipo;
import model.Evento;
import model.Olimpiada;
import model.Participacion;

public class ParticipacionDAO {

	ConexionDB conBD;
	
	public ParticipacionDAO() {
		this.conBD = new ConexionDB();
	}


	public ArrayList<Participacion> getParticipaciones() {
		conBD = new ConexionDB();
		ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deportista, id_evento, id_equipo, edad, medalla FROM Participacion";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_deporte"));
			}
			for (Integer id : ids) {
				Participacion p = getParticipacion(rs.getInt("id_deportista"));
				participaciones.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return participaciones;
	}
	
	public Participacion getParticipacion(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_deportista, id_evento, id_equipo, edad, medalla FROM Participacion WHERE id_deportista = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Deportista d = new DeportistaDAO().getDeportista(rs.getInt("id_deportista"));
			Evento ev = new EventoDAO().getEvento(rs.getInt("id_evento"));
			Equipo eq = new EquipoDAO().getEquipo(rs.getInt("id_equipo"));
			Participacion p = new Participacion(d, ev, eq, rs.getInt("edad"), rs.getString("medalla"));
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
}
