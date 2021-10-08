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

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", iniciales=" + iniciales + "]";
	}
	
	
	
}
