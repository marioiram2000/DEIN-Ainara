package controller.historico;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.HistoricoDao;
import dao.PrestamoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Libro;
import modelo.Prestamo;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class historicoController implements Initializable {
	@FXML
	private TextField filterAlumno;
	@FXML
	private TextField filterLibro;
	@FXML
	private TableView<Prestamo> table;
	@FXML
	private TableColumn<Prestamo, Integer> coplPrestamo;
	@FXML
	private TableColumn<Prestamo, Alumno> colDNI;
	@FXML
	private TableColumn<Prestamo, Libro> colLibro;
	@FXML
	private TableColumn<Prestamo, Date> colFechaPrestamo;
	@FXML
	private TableColumn<Prestamo, Date> colFechaDevolucion;

	private ObservableList<Prestamo> dataPrestamos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rellenarTabla();
	}

	private void rellenarTabla() {
		dataPrestamos = FXCollections.observableArrayList();
		ArrayList<Prestamo> prestamos = new HistoricoDao().select();
		for (Prestamo prestamo : prestamos) {
			dataPrestamos.add(prestamo);
		}
		table.setItems(dataPrestamos);
		coplPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Integer>("id_prestamo"));
		colDNI.setCellValueFactory(new PropertyValueFactory<Prestamo, Alumno>("alumno"));
		colLibro.setCellValueFactory(new PropertyValueFactory<Prestamo, Libro>("libro"));
		colFechaPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fecha_prestamo"));

		FilteredList<Prestamo> filteredData = new FilteredList<>(dataPrestamos, p -> true);

		filterLibro.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if ((prestamo.getLibro().getTitulo() + "").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		filterAlumno.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(prestamo -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if ((prestamo.getAlumno().getNombre() + "").contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Prestamo> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(table.comparatorProperty());

		table.setItems(sortedData);
		table.refresh();
	}

}
