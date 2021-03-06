package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

public class Controller implements Initializable {

	@FXML
	private TableView<Persona> tabla;
	@FXML
	private TableColumn<Persona, String> colNombre;
	@FXML
	private TableColumn<Persona, String> colApellidos;
	@FXML
	private TableColumn<Persona, Integer> colEdad;
	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnModificar;
	@FXML
	private Button btnEliminar;
	@FXML
	private TextField filter;

	private ObservableList<Persona> data;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		tabla.setItems(data);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));

		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Persona> filteredData = new FilteredList<>(data, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		filter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();

				if (person.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Persona> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(tabla.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		tabla.setItems(sortedData);
	}

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Formulario.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo Usuario");
			stage.showAndWait();
			FormularioController formularioController = loader.getController();
			Persona p = formularioController.getPersona();
			this.guardar(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificar() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Formulario.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo Usuario");
			Persona pInit = (Persona) tabla.getSelectionModel().getSelectedItem();
			FormularioController formularioController = loader.getController();
			formularioController.setPersona(pInit);
			stage.showAndWait();
			Persona pChanged = formularioController.getPersona();
			if (!data.contains(pChanged)) {
				data.set(data.indexOf(pInit), pChanged);
			}

			tabla.refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Selecciona alg??n campo");
			alert.showAndWait();
		}

	}

	// Event Listener on Button[#btnEliminar].onAction
	@FXML
	public void eliminar() {
		data.remove(tabla.getSelectionModel().getSelectedItem());
		tabla.refresh();
	}

	private void guardar(Persona p) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error en la inserci??n de datos");
		if (p != null) {
			if (!data.contains(p)) {
				data.add(p);
			} else {
				alert.setContentText("Entrada duplicada");
				alert.showAndWait();
			}
		}
	}

}
