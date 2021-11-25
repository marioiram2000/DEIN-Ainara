package controller.alumnos;

import java.net.URL;
import java.util.ResourceBundle;

import dao.AlumnoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modelo.Alumno;

public class crearAlumnoController implements Initializable{
	@FXML
	private TextArea textAreaDNI;
	@FXML
	private TextArea textAreaNombre;
	@FXML
	private TextArea textAreaAp1;
	@FXML
	private TextArea textAreaAp2;
	@FXML
	private Button button;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	// Event Listener on Button[#button].onAction
	@FXML
	public void nuevoAlumno(ActionEvent event) {
		String dni = textAreaDNI.getText();
		String nombre = textAreaNombre.getText();
		String ap1 = textAreaAp1.getText();
		String ap2 = textAreaAp2.getText();
		
		Alumno alumno = new Alumno(dni, nombre, ap1, ap2);
		if(new AlumnoDao().insert(alumno)) {
			Stage stage = (Stage) button.getScene().getWindow();
		    stage.close();
		}else {
			mostrarAlertError();
		}		
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
