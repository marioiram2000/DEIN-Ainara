package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Alumno;

public class AlumnoDao {
	
	private Connection conexion;
	
	public ArrayList<Alumno> selectAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "SELECT dni, nombre, apellido1, apellido2 FROM Alumno;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno a = new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"));
				alumnos.add(a);
			}
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public Alumno getAlumno(String dni) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "SELECT dni, nombre, apellido1, apellido2 FROM Alumno WHERE dni = ?;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Alumno a = new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"));
				return a;
			}
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Alumno alumno) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "INSERT INTO Alumno (dni, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?);";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, alumno.getDni());
			ps.setString(2, alumno.getNombre());
			ps.setString(3, alumno.getApellido1());
			ps.setString(4, alumno.getApellido2());
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public boolean update(Alumno alumno) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "UPDATE Alumno SET nombre = ?, apellido1 = ?, apellido2 = ? WHERE dni = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido1());
			ps.setString(3, alumno.getApellido2());
			ps.setString(4, alumno.getDni());
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}