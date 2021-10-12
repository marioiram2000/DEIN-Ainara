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
	
	public String[] getAll() {
		String[] all = {id+"", nombre, anio+"", temporada, ciudad};
		return all;
	}

	@Override
	public String toString() {
		return "Olimpiada [id=" + id + ", nombre=" + nombre + ", anio=" + anio + ", temporada=" + temporada
				+ ", ciudad=" + ciudad + "]";
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
}
