package controller.prestamos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Libro;
import modelo.Prestamo;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.AlumnoDao;
import dao.LibroDao;
import dao.PrestamoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class prestamosController implements Initializable{
	@FXML
	private TextField tfDNI;
	@FXML
	private TextField filtroLibros;
	@FXML
	private TableView<Libro> tableLibros;
	@FXML
	private TableColumn<Libro, Integer> colLibrosCodigo;
	@FXML
	private TableColumn<Libro, String> colLibrosTitulo;
	@FXML
	private TableColumn<Libro, String> colLibrosAutor;
	@FXML
	private Button btnPrestar;
	@FXML
	private TableView<Prestamo> tablePrestamos;
	@FXML
	private TableColumn<Prestamo, Integer> colPrestamosPrestamo;
	@FXML
	private TableColumn<Prestamo, Alumno> colPrestamosAlumno;
	@FXML
	private TableColumn<Prestamo, Libro> colPrestamosLibro;
	@FXML
	private TableColumn<Prestamo, Date> colPrestamosFecha;
	@FXML
	private TextField filtroPrestamos;
	@FXML
	private Button btnDevolver;

	private ObservableList<Libro> dataLibros;
	private ObservableList<Prestamo> dataPrestamos;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataLibros = FXCollections.observableArrayList();
		dataPrestamos = FXCollections.observableArrayList();
		rellenarLibros();
		rellenarPrestamos();		
	}
	
	private void rellenarLibros() {
		ArrayList<Libro> libros = new LibroDao().select();
		for (Libro libro : libros) {
			dataLibros.add(libro);
		}
		tableLibros.setItems(dataLibros);
		colLibrosCodigo.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("codigo"));
		colLibrosTitulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
		colLibrosAutor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));

		FilteredList<Libro> filteredData = new FilteredList<>(dataLibros, p -> true);

		filtroLibros.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(libro -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if ((libro.getCodigo()+"").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Libro> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tableLibros.comparatorProperty());

		tableLibros.setItems(sortedData);
	}
	
	private void rellenarPrestamos() {
		Prestamo pr = new Prestamo(1, new Alumno("52154", "nombre", "aaaaaaaa", "aaaaaaaaaaaa"), new Libro(1225, "el libro", "aaaa", "aaaaaaaaaa", "aaaaaa", false));
		dataPrestamos.add(pr);
		ArrayList<Prestamo> prestamos = new PrestamoDao().select();
		for (Prestamo prestamo : prestamos) {
			dataPrestamos.add(prestamo);
		}
		tablePrestamos.setItems(dataPrestamos);
		colPrestamosPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Integer>("id_prestamo"));
		colPrestamosAlumno.setCellValueFactory(new PropertyValueFactory<Prestamo, Alumno>("alumno"));
		colPrestamosLibro.setCellValueFactory(new PropertyValueFactory<Prestamo, Libro>("libro"));
		colPrestamosFecha.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fecha_prestamo"));

		FilteredList<Prestamo> filteredData = new FilteredList<>(dataPrestamos, p -> true);

		filtroLibros.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if ((prestamo.getId_prestamo()+"").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		
		SortedList<Prestamo> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tablePrestamos.comparatorProperty());

		tablePrestamos.setItems(sortedData);
	}
	
	// Event Listener on Button[#btnPrestar].onAction
	@FXML
	public void prestar(ActionEvent event) {
		String dni = tfDNI.getText();
		Alumno alumno = new AlumnoDao().getAlumno(dni);
		if (alumno == null) {
			mostrarAlertErrorDNI();
			}else {
			Libro libro = tableLibros.getSelectionModel().getSelectedItem();
			if(libro==null) {								
				mostrarAlertErrorRequired();
			}else {
				Prestamo p = new Prestamo();
				p.setAlumno(alumno);
				p.setLibro(libro);
				p.setFecha_prestamo(new java.sql.Date(new java.util.Date().getTime()));
				new PrestamoDao().insert(p);
			}
		}
	}
	// Event Listener on Button[#btnDevolver].onAction
	@FXML
	public void devolver(ActionEvent event) {
		// TODO Autogenerated
	}
	
	
	@FXML
	private void mostrarAlertErrorDNI() {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setHeaderText(null);
	    alert.setTitle("Error");
	    alert.setContentText("DNI incorrecto");
	    alert.showAndWait();
	}

	@FXML
	private void mostrarAlertErrorRequired() {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setHeaderText(null);
	    alert.setTitle("Error");
	    alert.setContentText("Seleccione algún libro");
	    alert.showAndWait();
	}
}
