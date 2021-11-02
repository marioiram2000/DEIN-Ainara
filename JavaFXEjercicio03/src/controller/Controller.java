package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import modelo.Persona;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

public class Controller implements Initializable {
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellidos;
	@FXML
	private TextField tfEdad;
	@FXML
	private TableView<Persona> tabla;
	@FXML
	private TableColumn<Persona, String> colNombre;
	@FXML
	private TableColumn<Persona, String> colApellidos;
	@FXML
	private TableColumn<Persona, Integer> colEdad;
	@FXML
	private Button button;
	@FXML
	private Button btnModificar;
	@FXML
	private Button btnEliminar;

	private ObservableList<Persona> data;

	private Persona personaSeleccionada;

	// Event Listener on Button[#button].onAction
	@FXML
	public void agregar(ActionEvent event) {
		String nombre = tfNombre.getText();
		String apellidos = tfApellidos.getText();
		int edad = -1;
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error en la inserción de datos");

		try {
			edad = Integer.parseInt(tfEdad.getText());
			Persona p = new Persona(nombre, apellidos, edad);
			if(!data.contains(p)) {
				data.add(p);
			}else {
				alert.setContentText("Entrada duplicada");
				alert.showAndWait();
			}
			tfNombre.clear();
			tfApellidos.clear();
		}catch (NumberFormatException e) {
			alert.setContentText("Tienes que introducir un número");			
			alert.showAndWait();
		}		
		tfEdad.clear();
	}

	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificar() {		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error en la inserción de datos");
		try {
			Persona p = tabla.getSelectionModel().getSelectedItem();
			String nombre = tfNombre.getText();
			String apellidos = tfApellidos.getText();
			int edad = Integer.parseInt(tfEdad.getText());
			Persona aux = new Persona(nombre, apellidos, edad);
			if(data.contains(aux)) {
				alert.setContentText("Entrada duplicada");
				alert.showAndWait();
			}else if(nombre.equals("") || apellidos.equals("")){
				alert.setContentText("No puede haber datos vacios");
				alert.showAndWait();
			}else {
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setEdad(edad);
				tfNombre.clear();
				tfApellidos.clear();
				tfEdad.clear();
			}
		} catch (NumberFormatException e) {
			alert.setContentText("Tienes que introducir un número");
			alert.showAndWait();
			tfEdad.clear();
		}
		
		tabla.refresh();

	}

	// Event Listener on Button[#btnEliminar].onAction
	@FXML
	public void eliminar() {
		data.remove(tabla.getSelectionModel().getSelectedItem());
		tabla.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		tabla.setItems(data);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));

		gestionarEventos();
	}

	private void gestionarEventos() {
		tabla.setRowFactory(tv -> {
			TableRow<Persona> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					personaSeleccionada = row.getItem();
					rellenarCampos();
				}
			});
			return row;
		});
	}

	private void rellenarCampos() {
		tfNombre.setText(personaSeleccionada.getNombre());
		tfApellidos.setText(personaSeleccionada.getApellidos());
		tfEdad.setText(personaSeleccionada.getEdad() + "");
	}
}
