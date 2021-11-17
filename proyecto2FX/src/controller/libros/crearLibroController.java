package controller.libros;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;

public class crearLibroController implements Initializable{
	@FXML
	private TextArea textAreaCodigo;
	@FXML
	private TextArea textAreaTitulo;
	@FXML
	private TextArea textAreaAutor;
	@FXML
	private TextArea textAreaEditorial;
	@FXML
	private Button button;
	@FXML
	private ComboBox<String> comboBoxEstado;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Nuevo", "Usado nuevo", "Usado seminuevo", "Usado estropeado", "Restaurado");
		comboBoxEstado.setItems(items);
		comboBoxEstado.setValue(items.get(0));
	}

}
