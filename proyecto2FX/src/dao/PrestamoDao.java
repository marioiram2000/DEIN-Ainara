package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Alumno;
import modelo.Prestamo;

public class PrestamoDao {
private Connection conexion;
	
	public ArrayList<Prestamo> select() {	
		ArrayList<Prestamo> prestamos = new ArrayList<>();
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "SELECT id_prestamo, dni_alumno, codigo_libro, fecha_prestamo FROM Prestamo;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prestamo a = new Prestamo();
				a.setId_prestamo(rs.getInt("id_prestamo"));
				a.setAlumno(new AlumnoDao().getAlumno(rs.getString("dni_alumno")));
				a.setLibro(new LibroDao().getLibro(rs.getInt("codigo_libro")));
				a.setFecha_prestamo(rs.getDate("fecha_prestamo"));
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
			String sql = "INSERT INTO Prestamo (id_prestamo, dni_alumno, codigo_libro, fecha_prestamo) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, prestamo.getId_prestamo());
			ps.setString(2, prestamo.getAlumno().getDni());
			ps.setInt(3, prestamo.getLibro().getCodigo());
			ps.setDate(4, prestamo.getFecha_prestamo());
			ps.executeUpdate();
			conexion.close();
			
			new LibroDao().prestar(prestamo.getLibro());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Prestamo prestamo) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "UPDATE Prestamo SET dni_alumno=?, codigo_libro=?, fecha_prestamo=? WHERE id_prestamo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, prestamo.getAlumno().getDni());
			ps.setInt(2, prestamo.getLibro().getCodigo());
			ps.setDate(3, prestamo.getFecha_prestamo());
			ps.setInt(4, prestamo.getId_prestamo());
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean delete(Prestamo prestamo) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "DELETE FROM Prestamo WHERE id_prestamo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, prestamo.getId_prestamo());
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
