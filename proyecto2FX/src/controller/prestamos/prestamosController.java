package controller.prestamos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.Libro;
import modelo.Prestamo;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.libros.modificarEstadoLibroController;
import controller.libros.modificarLibroController;
import dao.AlumnoDao;
import dao.HistoricoDao;
import dao.LibroDao;
import dao.PrestamoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class prestamosController implements Initializable {
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
	
	private ResourceBundle bundle = ResourceBundle.getBundle("messages.messages");

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
		dataLibros = FXCollections.observableArrayList();
		
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

				if ((libro.getCodigo() + "").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Libro> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tableLibros.comparatorProperty());

		tableLibros.setItems(sortedData);
		tableLibros.refresh();
	}

	private void rellenarPrestamos() {
		dataPrestamos = FXCollections.observableArrayList();
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

				if ((prestamo.getId_prestamo() + "").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Prestamo> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tablePrestamos.comparatorProperty());

		tablePrestamos.setItems(sortedData);
		tablePrestamos.refresh();
	}

	// Event Listener on Button[#btnPrestar].onAction
	@FXML
	public void prestar(ActionEvent event) {
		String dni = tfDNI.getText();
		Alumno alumno = new AlumnoDao().getAlumno(dni);
		if (alumno == null) {
			mostrarAlertErrorDNI();
			return;
		}

		Libro libro = tableLibros.getSelectionModel().getSelectedItem();
		if (libro == null) {
			mostrarAlertErrorRequired();
			return;

		}
		Prestamo p = new Prestamo();
		p.setAlumno(alumno);
		p.setLibro(libro);
		p.setFecha_prestamo(new java.sql.Date(new java.util.Date().getTime()));
		new PrestamoDao().insert(p);
		
		rellenarLibros();
		rellenarPrestamos();
	}

	// Event Listener on Button[#btnDevolver].onAction
	@FXML
	public void devolver(ActionEvent event) {
		Prestamo prestamo = tablePrestamos.getSelectionModel().getSelectedItem();
		if (prestamo == null) {
			mostrarAlertErrorRequired();
			return;
		}
		Libro libro = prestamo.getLibro();
		new LibroDao().devolver(libro);
		
		prestamo.setFecha_devolucion(new java.sql.Date(new java.util.Date().getTime()));
		new HistoricoDao().insert(prestamo);
		
		new PrestamoDao().delete(prestamo);
		rellenarLibros();
		rellenarPrestamos();

		if(libro != null) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/libros/modificarEstadoLibro.fxml"), bundle);
				modificarEstadoLibroController mlc = new modificarEstadoLibroController();
				mlc.setLibro(libro);
				loader.setController(mlc);
				Parent root = loader.load();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
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
		alert.setContentText("Seleccione algún campo");
		alert.showAndWait();
	}
}
