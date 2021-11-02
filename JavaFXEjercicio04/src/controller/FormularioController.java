package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Persona;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class FormularioController implements Initializable{
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellidos;
	@FXML
	private TextField tfEdad;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnCancelar;

	private Persona persona;
	
	private Stage stage;
	
	public Persona getPersona() {
		return persona;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		persona = null;
		
	}
	
	// Event Listener on Button[#btnGuardar].onAction
	@FXML
	public void guardar(ActionEvent event) {
		String nombre = tfNombre.getText();
		String apellidos = tfApellidos.getText();
		int edad = -1;		
		try {
			edad = Integer.parseInt(tfEdad.getText());
			persona = new Persona(nombre, apellidos, edad);		
			stage = (Stage) btnGuardar.getScene().getWindow();
			stage.close();
		}catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en la inserción de datos");
			alert.setContentText("Tienes que introducir un número");			
			alert.showAndWait();
		}		
		tfEdad.clear();
	}
	
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		stage = (Stage) btnGuardar.getScene().getWindow();
	    stage.close();
	}
}
