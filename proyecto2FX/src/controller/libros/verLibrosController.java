package controller.libros;

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

import dao.LibroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class verLibrosController implements Initializable {
	@FXML
	private TextField filter;
	@FXML
	private TableView<Libro> table;
	@FXML
	private TableColumn<Libro, Integer> colCodigo;
	@FXML
	private TableColumn<Libro, String> colTitulo;
	@FXML
	private TableColumn<Libro, String> colAutor;
	@FXML
	private TableColumn<Libro, String> colEditorial;
	@FXML
	private TableColumn<Libro, String> colEstado;
	@FXML
	private TableColumn<Libro, Boolean> colBaja;
	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnModificar;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("messages.messages");
	
	ObservableList<Libro> data;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		ArrayList<Libro> libros = new LibroDao().select();
		for (Libro libro : libros) {
			data.add(libro);
		}
		table.setItems(data);
		colCodigo.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("codigo"));
		colTitulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
		colAutor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
		colEditorial.setCellValueFactory(new PropertyValueFactory<Libro, String>("editorial"));
		colEstado.setCellValueFactory(new PropertyValueFactory<Libro, String>("estado"));
		colBaja.setCellValueFactory(new PropertyValueFactory<Libro, Boolean>("baja"));

		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Libro> filteredData = new FilteredList<>(data, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		filter.textProperty().addListener((observable, oldValue, newValue) -> {
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

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Libro> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(table.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
	}

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/libros/crearLibro.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo alumno");
			stage.showAndWait();
			ArrayList<Libro> libros = new LibroDao().select();
			for (Libro libro : libros) {
				if(!data.contains(libro))
					data.add(libro);
			}
			table.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificar(ActionEvent event) {
		Libro libro = table.getSelectionModel().getSelectedItem();
		if(libro != null) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/libros/modificarLibro.fxml"), bundle);
				modificarLibroController mlc = new modificarLibroController();
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
	
}
