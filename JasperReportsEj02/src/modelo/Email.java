package modelo;

public class Email {
	
	private int id;
	private String dni;
	private String email;
	public Email() {
		super();
	}
	public Email(int id, String dni, String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Email [id=" + id + ", dni=" + dni + ", email=" + email + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
