package model;

public class Evento {

	private int id;
	private String nombre;
	private Olimpiada olimpiada;
	private Deporte deporte;
	
	public Evento(int id, String nombre, Olimpiada olimpiada, Deporte deporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.olimpiada = olimpiada;
		this.deporte = deporte;
	}

	public Evento() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"id", "nombre", "olimpiada", "deporte"};
		return c;
	}
	
	public String[] getAll() {
		String[] all = {id+"", nombre, olimpiada.toString(), deporte.toString()};
		return all;
	}

	@Override
	public String toString() {
		return nombre + " " + olimpiada + " " + deporte;
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

	public Olimpiada getOlimpiada() {
		return olimpiada;
	}

	public void setOlimpiada(Olimpiada olimpiada) {
		this.olimpiada = olimpiada;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	
	
}
