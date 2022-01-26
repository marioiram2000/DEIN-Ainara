package controller.alumnos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.Libro;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.AlumnoDao;
import dao.LibroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class verAlumnosController implements Initializable {
	@FXML
	private TextField filter;
	/*
	 * @FXML private TextField filter1;
	 * 
	 * @FXML private TextField filter2;
	 */
	@FXML
	private TableView<Alumno> tabla;
	@FXML
	private TableColumn<Alumno, String> colDNI;
	@FXML
	private TableColumn<Alumno, String> colNombre;
	@FXML
	private TableColumn<Alumno, String> colApellidos;
	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnModificar;

	private ResourceBundle bundle = ResourceBundle.getBundle("messages.messages");

	ObservableList<Alumno> data;

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnos/crearAlumno.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo alumno");
			stage.showAndWait();
			ArrayList<Alumno> alumnos = new AlumnoDao().selectAlumnos();
			for (Alumno alumno : alumnos) {
				if (!data.contains(alumno))
					data.add(alumno);
			}
			tabla.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificar(ActionEvent event) {// https://dev.to/devtony101/javafx-3-ways-of-passing-information-between-scenes-1bm8
		Alumno alumno = tabla.getSelectionModel().getSelectedItem();
		if (alumno != null) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnos/modificarAlumno.fxml"),
						bundle);
				modificarAlumnoController mac = new modificarAlumnoController();
				mac.setAlumno(alumno);
				loader.setController(mac);
				Parent root = loader.load();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		ArrayList<Alumno> alumnos = new AlumnoDao().selectAlumnos();
		for (Alumno alumno : alumnos) {
			data.add(alumno);
		}
		tabla.setItems(data);
		colDNI.setCellValueFactory(new PropertyValueFactory<Alumno, String>("dni"));
		colNombre.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellido1"));

		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Alumno> filteredData = new FilteredList<>(data, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		filter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(alumno -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if (alumno.getDni().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});
		/*
		 * filter1.textProperty().addListener((observable, oldValue, newValue) -> {
		 * filteredData.setPredicate(alumno -> { if (newValue == null ||
		 * newValue.isEmpty()) { return true; } return filter(alumno); }); });
		 * 
		 * filter2.textProperty().addListener((observable, oldValue, newValue) -> {
		 * filteredData.setPredicate(alumno -> { if (newValue == null ||
		 * newValue.isEmpty()) { return true; } return filter(alumno); }); });
		 */
		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Alumno> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tabla.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		tabla.setItems(sortedData);
	}

	/*
	 * private boolean filter(Alumno alumno) { if
	 * (alumno.getDni().toLowerCase().contains(filter.getText().toLowerCase())) { if
	 * (alumno.getNombre().toLowerCase().contains(filter1.getText().toLowerCase()))
	 * { if
	 * (alumno.getApellido1().toLowerCase().contains(filter2.getText().toLowerCase()
	 * ) ||
	 * alumno.getApellido2().toLowerCase().contains(filter2.getText().toLowerCase())
	 * ) { return true;
	 * 
	 * } } }
	 * 
	 * if (filter.getText().equals("")) { if
	 * (alumno.getNombre().toLowerCase().contains(filter1.getText().toLowerCase()))
	 * { if
	 * (alumno.getApellido1().toLowerCase().contains(filter2.getText().toLowerCase()
	 * )) { if
	 * (alumno.getApellido2().toLowerCase().contains(filter2.getText().toLowerCase()
	 * )) { return true; } } } }
	 * 
	 * if (filter1.getText().equals("")) { if
	 * (alumno.getNombre().toLowerCase().contains(filter1.getText().toLowerCase()))
	 * { if
	 * (alumno.getApellido1().toLowerCase().contains(filter2.getText().toLowerCase()
	 * )) { if
	 * (alumno.getApellido2().toLowerCase().contains(filter2.getText().toLowerCase()
	 * )) { return true; } } } }
	 * 
	 * if (filter2.getText().equals("")) { if
	 * (alumno.getDni().toLowerCase().contains(filter.getText().toLowerCase())) { if
	 * (alumno.getNombre().toLowerCase().contains(filter1.getText().toLowerCase()))
	 * { return true; } } } return false; }
	 */
}
