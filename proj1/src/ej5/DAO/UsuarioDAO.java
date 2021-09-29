package ej5.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ej5.conexion.ConexionDB;
import ej5.model.Usuario;

public class UsuarioDAO {

	private ConexionDB con;

	public UsuarioDAO() {
		super();
	}
	
	public boolean validLogin(Usuario u) {
		String sql = ""
				+ "Select * "
				+ "from usuarios "
				+ "where usuario = '"+u.getUsuario()+"' "
				+ "and password = '"+u.getPassword()+"'";
		try {
			con = new ConexionDB();
			ResultSet rs = con.ejecutarConsulta(sql);
			rs.last();    // moves cursor to the last row
			int size = rs.getRow();
			if(size>0) {
				con.cerrarConexion();
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}
}
