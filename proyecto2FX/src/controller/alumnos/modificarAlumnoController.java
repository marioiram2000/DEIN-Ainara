package controller.alumnos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Alumno;

import java.net.URL;
import java.util.ResourceBundle;

import dao.AlumnoDao;
import javafx.event.ActionEvent;

public class modificarAlumnoController implements Initializable {
	@FXML
	private TextField textFieldDNI;
	@FXML
	private TextField textFieldNombre;
	@FXML
	private TextField textFieldAp1;
	@FXML
	private TextField textFieldAp2;
	@FXML
	private Button button;

	private Alumno alumno;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (alumno != null)
			rellenarCampos();
	}

	// Event Listener on Button[#button].onAction
	@FXML
	public void modificarAlumno(ActionEvent event) {
		String dni = textFieldDNI.getText();
		String nombre = textFieldNombre.getText();
		String ap1 = textFieldAp1.getText();
		String ap2 = textFieldAp2.getText();

		Alumno alumno = new Alumno(dni, nombre, ap1, ap2);
		if (new AlumnoDao().update(alumno)) {
			Stage stage = (Stage) button.getScene().getWindow();
			stage.close();
		} else {
			mostrarAlertError();
		}
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	private void rellenarCampos() {
		textFieldDNI.setText(alumno.getDni());
		textFieldNombre.setText(alumno.getNombre());
		textFieldAp1.setText(alumno.getApellido1());
		textFieldAp2.setText(alumno.getApellido2());
	}

	@FXML
	private void mostrarAlertError() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText("Ha habido algún error en la inserción de datos.");
		alert.showAndWait();
	}

}
