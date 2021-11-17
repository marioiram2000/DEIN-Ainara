package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Alumno;
import modelo.Libro;

public class LibroDao {
private Connection conexion;
	
	public ArrayList<Libro> select() {	
		ArrayList<Libro> libros = new ArrayList<>();
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "SELECT codigo, titulo, autor, editorial, estado, baja FROM Libro;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro a = new Libro();
				libros.add(a);
			}
			
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public boolean insert(Libro libro) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "INSERT INTO Libro (codigo, titulo, autor, editorial, estado, baja) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, libro.getCodigo());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getAutor());
			ps.setString(4, libro.getEditorial());
			ps.setString(5, libro.getEstado());
			ps.setBoolean(6, libro.isBaja());
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Libro libro) {
		try {
			conexion = new ConexionDB().getConexion();
			String sql = "UPDATE Libro SET titulo=?, autor=?, editorial=?, estado=?, baja=? WHERE codigo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getEditorial());
			ps.setString(4, libro.getEstado());
			ps.setBoolean(5, libro.isBaja());
			ps.setInt(6, libro.getCodigo());
			
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
