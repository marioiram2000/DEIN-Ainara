package model;

public class Deportista {
	private int id;
	private String nombre;
	private String sexo;
	private int peso;
	private int altura;
	
	public Deportista(int id, String nombre, String sexo, int peso, int altura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public Deportista() {
		super();
	}
	
	public static String[] campos() {
		String[] c = {"id", "nombre", "sexo", "peso", "altura"};
		return c;
	}

	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", peso=" + peso + ", altura="
				+ altura + "]";
	}
	
	

}
