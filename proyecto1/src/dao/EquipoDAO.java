package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deportista;
import model.Equipo;

public class EquipoDAO {

	ConexionDB conBD;

	public EquipoDAO() {
		this.conBD = new ConexionDB();
	}
	
	public ArrayList<Equipo> getEquipos() {
		conBD = new ConexionDB();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_equipo, nombre, iniciales FROM Equipo";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_equipo"));
			}
			for (Integer id : ids) {
				Equipo e = getEquipo(id);
				equipos.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return equipos;
	}
	
	public Equipo getEquipo(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_equipo, nombre, iniciales FROM Equipo WHERE id_equipo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Equipo e = new Equipo(rs.getInt("id_equipo"), rs.getString("nombre"), rs.getString("iniciales"));
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
}
