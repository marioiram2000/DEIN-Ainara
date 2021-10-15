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
			while (rs.next()) {
				Deportista d = new DeportistaDAO().getDeportista(rs.getInt("id_deportista"));
				Evento ev = new EventoDAO().getEvento(rs.getInt("id_evento"));
				Equipo eq = new EquipoDAO().getEquipo(rs.getInt("id_equipo"));
				Participacion p = new Participacion(d, ev, eq, rs.getInt("edad"), rs.getString("medalla"));
				participaciones.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return participaciones;
	}
	
	public Participacion getParticipacion(int id_deportista, int id_evento) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_deportista, id_evento, id_equipo, edad, medalla FROM Participacion WHERE id_deportista = ? AND id_evento = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id_deportista);
			ps.setInt(1, id_evento);
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
	
	public void insertParticipacion(Participacion participacion) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {			
			String sql = "insert into Participacion (id_deportista, id_evento, id_equipo, edad, medalla) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, participacion.getDeportista().getId());
			ps.setInt(2, participacion.getEvento().getId());
			ps.setInt(3, participacion.getEquipo().getId());
			ps.setInt(4, participacion.getEdad());
			ps.setString(5, participacion.getMedalla());
			ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateParticipacion(Participacion participacion) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {			
			String sql = "UPDATE Participacion SET id_equipo = ?, edad = ?, medalla = ? WHERE id_deportista = ? AND id_evento = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, participacion.getEquipo().getId());
			ps.setInt(2, participacion.getEdad());
			ps.setString(3, participacion.getMedalla());
			ps.setInt(4, participacion.getDeportista().getId());
			ps.setInt(5, participacion.getEvento().getId());
			ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteParticipacion(int id_deportista, int id_evento) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {			
			String sql = "DELETE FROM Participacion  WHERE id_evento = ? AND id_deportista = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id_evento);
			ps.setInt(2, id_deportista);
			ps.executeUpdate();						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
