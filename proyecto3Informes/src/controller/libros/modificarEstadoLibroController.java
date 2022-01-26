package controller.libros;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Libro;

import java.net.URL;
import java.util.ResourceBundle;

import dao.LibroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class modificarEstadoLibroController implements Initializable {
	@FXML
	private Button btnModificar;
	@FXML
	private ComboBox<String> comboBoxEstado;
	@FXML
	private TextField tfTitulo;

	private Libro libro;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Nuevo", "Usado nuevo", "Usado seminuevo", "Usado estropeado", "Restaurado");
		comboBoxEstado.setItems(items);
		comboBoxEstado.setValue(items.get(0));
		rellenarCampos();
	}

	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificar(ActionEvent event) {
		String estado = comboBoxEstado.getValue();
		libro.setEstado(estado);
		if (new LibroDao().update(libro)) {
			Stage stage = (Stage) btnModificar.getScene().getWindow();
			stage.close();
		} else {
			mostrarAlertError();
		}
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	private void rellenarCampos() {
		tfTitulo.setText(libro.getTitulo());
		comboBoxEstado.getSelectionModel().select(libro.getEstado());
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
