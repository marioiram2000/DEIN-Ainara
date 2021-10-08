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

	@Override
	public String toString() {
		return "Evento [evento=" + id + ", nombre=" + nombre + ", olimpiada=" + olimpiada + ", deporte=" + deporte
				+ "]";
	}
	
	
	
}
