package modelo;

import java.sql.Date;

public class Prestamo {
	
	private int id_prestamo;
	private Alumno alumno;
	private Libro libro;
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	
	public Prestamo() {
		super();
	}

	public Prestamo(int id_prestamo, Alumno alumno, Libro libro) {
		super();
		this.id_prestamo = id_prestamo;
		this.alumno = alumno;
		this.libro = libro;
		this.fecha_prestamo =  new java.sql.Date(new java.util.Date().getTime());
		this.fecha_devolucion = null;
	}
	
	@Override
	public String toString() {
		return "Prestamo [id_prestamo=" + id_prestamo + ", dni_alumno=" + alumno.getDni() + ", libro=" + libro.getCodigo()
				+ ", fecha_prestamo=" + fecha_prestamo + "]";
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	
	
}
