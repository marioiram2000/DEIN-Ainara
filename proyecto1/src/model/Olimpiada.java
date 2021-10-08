package model;

public class Olimpiada {

	private int id;
	private String nombre;
	private int anio;
	private String temporada;
	private String ciudad;
	
	public Olimpiada(int id, String nombre, int anio, String temporada, String ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}

	public Olimpiada() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"id", "nombre", "anio", "temporada", "ciudad"};
		return c;
	}

	@Override
	public String toString() {
		return "Olimpiada [id=" + id + ", nombre=" + nombre + ", anio=" + anio + ", temporada=" + temporada
				+ ", ciudad=" + ciudad + "]";
	}
	
	
	
}
