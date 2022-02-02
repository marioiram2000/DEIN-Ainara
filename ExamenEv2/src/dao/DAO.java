package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import modelo.Email;
import modelo.Persona;
import modelo.Telefono;

public class DAO {

	public ArrayList<Persona> getpersonas(){
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try(Connection conexion = new ConexionDB().getConexion();){
			
			String sql = "select * from persona";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = new Persona(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"),rs.getString("apellido2"), rs.getInt("anio_nacimiento"));
				personas.add(p);
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personas;
	}
	
	public Persona getPersona(String dni) {
		try(Connection conexion = new ConexionDB().getConexion();) {
			
			String sql = "select * from persona where dni = '"+dni+"'";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Persona p = new Persona(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"),rs.getString("apellido2"), rs.getInt("anio_nacimiento"));
				return p;
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Email> getEmails(){
		ArrayList<Email> emails = new ArrayList<Email>();
		try(Connection conexion = new ConexionDB().getConexion();){
			String sql = "select * from email";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = getPersona(rs.getString("dni"));
				Email e = new Email(rs.getInt("id"), p, rs.getString("email"));
				emails.add(e);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emails;
	}
	
	public ArrayList<Email> getEmailsPersona(Persona p){
		ArrayList<Email> emails = new ArrayList<Email>();
		try(Connection conexion = new ConexionDB().getConexion();){
			String dni = p.getDni();
			String sql = "select * from email where dni = '"+dni+"'";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Email e = new Email(rs.getInt("id"), p, rs.getString("email"));
				emails.add(e);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emails;
	}
	

	public ArrayList<Telefono> getTelefonos(){
		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
		try(Connection conexion = new ConexionDB().getConexion();){
			String sql = "select * from telefono";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = getPersona(rs.getString("dni"));
				Telefono t = new Telefono(rs.getInt("id"), p, rs.getString("telefono"));
				telefonos.add(t);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return telefonos;
	}
	


	public ArrayList<Telefono> getTelefonosPersona(Persona p){
		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
		try(Connection conexion = new ConexionDB().getConexion();){
			String dni = p.getDni();
			String sql = "select * from telefono where dni = '"+dni+"'";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Telefono t = new Telefono(rs.getInt("id"), p, rs.getString("telefono"));
				telefonos.add(t);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return telefonos;
	}
	
	public boolean insertTelefono(String telefono, String dni) {
		try(Connection conexion = new ConexionDB().getConexion();){
			String sql = "Insert into telefono (dni, telefono) values (?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, dni);
			ps.setString(2, telefono);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertEmail(String email, String dni) {
		try(Connection conexion = new ConexionDB().getConexion();){
			String sql = "Insert into email (dni, email) values (?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, dni);
			ps.setString(2, email);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean deleteTelefono(String telefono, String dni) {
		try(Connection conexion = new ConexionDB().getConexion();){
			System.out.println("llega");
			String sql = "delete from telefono where telefono = ? and dni = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, telefono);
			ps.setString(2, dni);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteEmail(String email, String dni) {
		try(Connection conexion = new ConexionDB().getConexion();){
			String sql = "delete from email where email = ? and dni = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, dni);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
