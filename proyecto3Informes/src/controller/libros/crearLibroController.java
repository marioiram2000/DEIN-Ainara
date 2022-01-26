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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class crearLibroController implements Initializable {
	@FXML
	private Button btnAgregar;
	@FXML
	private ComboBox<String> comboBoxEstado;
	@FXML
	private TextField tfCodigo;
	@FXML
	private TextField tfTitulo;
	@FXML
	private TextField tfAutor;
	@FXML
	private TextField tfEditorial;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Nuevo", "Usado nuevo", "Usado seminuevo", "Usado estropeado", "Restaurado");
		comboBoxEstado.setItems(items);
		comboBoxEstado.setValue(items.get(0));

		tfCodigo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					tfCodigo.setText(newValue.replaceAll("[^\\d]", ""));
				}
				if (tfCodigo.getText().length() > 6) {
					String s = tfCodigo.getText().substring(0, 6);
					tfCodigo.setText(s);
				}
			}
		});
	}

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregar(ActionEvent event) {
		int codigo = 0;
		try {
			codigo = Integer.parseInt(tfCodigo.getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String editorial = tfEditorial.getText();
		String estado = comboBoxEstado.getValue();
		Libro libro = new Libro(codigo, titulo, autor, editorial, estado, false);
		if (new LibroDao().insert(libro)) {
			Stage stage = (Stage) btnAgregar.getScene().getWindow();
			stage.close();
		} else {
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
