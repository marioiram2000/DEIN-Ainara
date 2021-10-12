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
	
	public String[] getAll() {
		String[] all = {id+"", nombre, sexo, peso+"", altura+""};
		return all;
	}

	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", peso=" + peso + ", altura="
				+ altura + "]";
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	

}
