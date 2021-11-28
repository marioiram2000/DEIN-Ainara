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

public class modificarLibroController implements Initializable{
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
		int codigo = 0;
		try {
			codigo = Integer.parseInt(tfCodigo.getText());
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String editorial = tfEditorial.getText();
		String estado = comboBoxEstado.getValue();
		Libro libro = new Libro(codigo, titulo, autor, editorial, estado, false);
		if(new LibroDao().update(libro)) {
			Stage stage = (Stage) btnAgregar.getScene().getWindow();
		    stage.close();
		}else {
			mostrarAlertError();
		}
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	private void rellenarCampos() {
		tfCodigo.setText(libro.getCodigo()+"");
		tfTitulo.setText(libro.getTitulo());
		tfAutor.setText(libro.getAutor());
		tfEditorial.setText(libro.getEditorial());
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
