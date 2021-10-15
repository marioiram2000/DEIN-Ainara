package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Equipo;

public class EquipoDAO {

	ConexionDB conBD;

	public EquipoDAO() {
		this.conBD = new ConexionDB();
	}

	public ArrayList<Equipo> getEquipos() {
		conBD = new ConexionDB();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		try (Connection conexion = conBD.getConexion()) {
			String sql = "SELECT id_equipo, nombre, iniciales FROM Equipo";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Equipo e = new Equipo(rs.getInt("id_equipo"), rs.getString("nombre"), rs.getString("iniciales"));
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

	public void insertEquipo(Equipo equipo) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "insert into Equipo (nombre, iniciales) values (?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setString(2, equipo.getIniciales());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEquipo(Equipo equipo) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "UPDATE Equipo SET nombre = ?, iniciales = ? WHERE id_equipo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setString(2, equipo.getIniciales());
			ps.setInt(3, equipo.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDEquipo(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "DELETE FROM Equipo  WHERE id_equipo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
