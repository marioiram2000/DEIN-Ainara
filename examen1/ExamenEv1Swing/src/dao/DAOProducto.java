package dao;

import java.util.ArrayList;

import config.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Producto;

public class DAOProducto {

	public ArrayList<Producto> selectProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();		
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "SELECT codigo, nombre, precio, disponible FROM examen1.productos;";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precio"), rs.getInt("disponible"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
	}
	
	public ArrayList<Producto> selectProductos(String filter){
		ArrayList<Producto> productos = new ArrayList<Producto>();		
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "SELECT codigo, nombre, precio, disponible FROM examen1.productos WHERE codigo LIKE ? OR nombre LIKE ? OR precio LIKE ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, "%"+filter+"%");
			ps.setString(2, "%"+filter+"%");
			ps.setString(3, "%"+filter+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getFloat("precio"), rs.getInt("disponible"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
	}
	
	public boolean insertProducto(Producto p) {
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "INSERT INTO productos (codigo, nombre, precio, disponible) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, p.getPrecio());
			ps.setInt(4, p.getDisponible());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateProducto(Producto p) {
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "UPDATE productos SET nombre = ?, precio = ?, disponible = ? WHERE codigo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setFloat(2, p.getPrecio());
			ps.setInt(3, p.getDisponible());
			ps.setString(4, p.getCodigo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteProducto(String codigo) {
		try (Connection conexion = new ConexionDB().getConexion();) {//Al hacer la conexión en el try, se cierra sola
			String sql = "DELETE FROM productos WHERE codigo = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
