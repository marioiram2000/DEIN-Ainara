package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;

public class IndexController implements Initializable{
	@FXML
	private MenuItem miNuevoAlumno;
	@FXML
	private MenuItem miBuscarAlumno;
	@FXML
	private MenuItem miNuevoLibro;
	@FXML
	private MenuItem miBuscarLibro;
	@FXML
	private Menu mPrestamos;
	@FXML
	private Menu mHistorico;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("messages.messages");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	// Event Listener on MenuItem[#miNuevoAlumno].onAction
	@FXML
	public void nuevoAlumno(ActionEvent event) {		
		try {			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnos/crearAlumno.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo alumno");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Event Listener on MenuItem[#miBuscarAlumno].onAction
	@FXML
	public void buscarAlumno(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnos/verAlumnos.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Ver alumnos");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on MenuItem[#miNuevoLibro].onAction
	@FXML
	public void nuevoLibro(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/libros/crearLibro.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Nuevo libro");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on MenuItem[#miBuscarLibro].onAction
	@FXML
	public void buscarLibro(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/libros/verLibros.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Ver libros");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Menu[#miPrestamos].onAction
	@FXML
	public void verPrestamos(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/prestamos/prestamos.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Prestamos");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Menu[#miHistorico].onAction
	@FXML
	public void verHistorico(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/historico/historico.fxml"), bundle);
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle("Prestamos");
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
