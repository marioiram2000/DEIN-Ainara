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
	
	public String[] getAll() {
		String[] all = {deportista.getNombre(), evento.getNombre(), equipo.getNombre(), edad+"", medalla};
		return all;
	}

	@Override
	public String toString() {
		return "Participacion [deportista=" + deportista + ", evento=" + evento + ", equipo=" + equipo + ", edad="
				+ edad + ", medalla=" + medalla + "]";
	}

	public Deportista getDeportista() {
		return deportista;
	}

	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMedalla() {
		return medalla;
	}

	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	
	
}
