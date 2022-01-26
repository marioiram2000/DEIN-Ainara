package modelo;

public class Telefono {

	private int id;
	private String dni;
	private String telefono;
	
	public Telefono() {
		super();
	}
	
	public Telefono(int id, String dni, String telefono) {
		super();
		this.id = id;
		this.dni = dni;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", dni=" + dni + ", telefono=" + telefono + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
