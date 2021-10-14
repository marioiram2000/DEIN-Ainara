package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;
import model.Deportista;

public class DeportistaDAO {

	ConexionDB conBD;
	
	public DeportistaDAO() {
		this.conBD = new ConexionDB();
	}

	public ArrayList<Deportista> getDeportistas() {
		//conBD = new ConexionDB();
		ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
		try (Connection conexion = conBD.getConexion()){
			String sql = "SELECT id_deportista, nombre, sexo, peso, altura FROM Deportista";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt("id_deportista"));
			}
			for (Integer id : ids) {
				Deportista d = getDeportista(id);
				deportistas.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return deportistas;
	}
	
	public Deportista getDeportista(int id) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {
			String sql = "SELECT id_deportista, nombre, sexo, peso, altura FROM Deportista WHERE id_deportista = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Deportista d = new Deportista(
					rs.getInt("id_deportista"),
					rs.getString("nombre"),
					rs.getString("sexo"),
					rs.getInt("peso"),
					rs.getInt("altura"));
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return null;
	}
	
	public void insertDeportista(Deportista deportista) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {			
			String sql = "insert into Deporte (nombre, sexo, peso, altura) values (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, deportista.getNombre());
			ps.setString(2, deportista.getSexo());
			ps.setInt(3, deportista.getPeso());
			ps.setInt(4, deportista.getAltura());
			ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateDeportista(Deportista deportista) {
		conBD = new ConexionDB();
		try (Connection conexion = conBD.getConexion();) {			
			String sql = "UPDATE Deportista SET nombre = ?, sexo = ?, peso = ?, altura = ? WHERE id_deportista = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, deportista.getNombre());
			ps.setString(2, deportista.getSexo());
			ps.setInt(3, deportista.getPeso());
			ps.setInt(4, deportista.getAltura());
			ps.setInt(5, deportista.getId());
			System.out.println(ps);
			//ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
