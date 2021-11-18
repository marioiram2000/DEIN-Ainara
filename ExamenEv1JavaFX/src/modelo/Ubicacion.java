package modelo;

public class Ubicacion {

	private int id_ubic;
	private String seccion;
	private String ubicacion;
	private String imagen;
	
	public Ubicacion(int id_ubic, String seccion, String ubicacion, String imagen) {
		super();
		this.id_ubic = id_ubic;
		this.seccion = seccion;
		this.ubicacion = ubicacion;
		this.imagen = imagen;
	}

	public int getId_ubic() {
		return id_ubic;
	}

	public void setId_ubic(int id_ubic) {
		this.id_ubic = id_ubic;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Ubicacion [id_ubic=" + id_ubic + ", seccion=" + seccion + ", ubicacion=" + ubicacion + ", imagen="
				+ imagen + "]";
	}
	
	
	
}
