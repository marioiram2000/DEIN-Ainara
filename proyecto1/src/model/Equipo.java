package model;

public class Equipo {

	private int id;
	private String nombre;
	private String iniciales;
	
	public Equipo(int id, String nombre, String iniciales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.iniciales = iniciales;
	}

	public Equipo() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"id", "nombre", "iniciales"};
		return c;
	}
	
	public String[] getAll() {
		String[] all = {id+"", nombre, iniciales};
		return all;
	}

	@Override
	public String toString() {
		return nombre + " " + iniciales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIniciales() {
		return iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
	
	
}
