package model;

public class Participacion {

	private Deportista deportista;
	private Evento evento;
	private Equipo equipo;
	private int edad;
	private String medalla;
	
	public Participacion(Deportista deportista, Evento evento, Equipo equipo, int edad, String medalla) {
		super();
		this.deportista = deportista;
		this.evento = evento;
		this.equipo = equipo;
		this.edad = edad;
		this.medalla = medalla;
	}

	public Participacion() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"deportista", "evento", "equipo", "edad", "medalla"};
		return c;
	}

	@Override
	public String toString() {
		return "Participacion [deportista=" + deportista + ", evento=" + evento + ", equipo=" + equipo + ", edad="
				+ edad + ", medalla=" + medalla + "]";
	}
	
}
