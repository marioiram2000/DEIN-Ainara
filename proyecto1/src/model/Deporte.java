package model;

public class Deporte {

	private int id;
	private String nombre;
	
	public Deporte(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Deporte() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"id", "nombre"};
		return c;
	}
	
	public String[] getAll() {
		String[] all = {id+"", nombre};
		return all;
	}

	@Override
	public String toString() {
		return "Deporte [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
