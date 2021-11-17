package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Prestamo;

public class HistoricoDao {
private Connection conexion;
	
	public ArrayList<Prestamo> select() {	
		ArrayList<Prestamo> prestamos = new ArrayList<>();
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "SELECT id_prestamo, dni_alumno, codigo_libro, fecha_prestamo, fecha_devolucion FROM Historico_prestamo;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prestamo a = new Prestamo();
				prestamos.add(a);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamos;
	}

	public boolean insert(Prestamo prestamo) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "INSERT INTO Historico_prestamo (id_prestamo, dni_alumno, codigo_libro, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, prestamo.getId_prestamo());
			ps.setString(2, prestamo.getAlumno().getDni());
			ps.setInt(3, prestamo.getLibro().getCodigo());
			ps.setDate(4, prestamo.getFecha_prestamo());
			ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
