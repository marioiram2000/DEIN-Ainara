package dao;

import java.sql.*;
import java.util.ArrayList;

import application.ConexionDB;
import modelo.Persona;

public class DAO {

	public static Connection cn = new ConexionDB().getConexion();

	public ArrayList<Persona> getPersonas() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			String sql = "Select * from persona";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Persona p = new Persona();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personas;
	}

}
