package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import config.ConexionDB;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;

public class IndexController implements Initializable {
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
	@FXML
	private ImageView fondo;

	private ResourceBundle bundle = ResourceBundle.getBundle("messages.messages");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			File fichero = new File("images/biblioteca.jpg");
			InputStream image = (InputStream) new FileInputStream(fichero);
			fondo.setImage(new Image(image));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// Event Listener on Menu[#miInformeListado].onAction
	@FXML
	public void informeListadoLibros(ActionEvent event) {
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe_listado_libros.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, parameters, new ConexionDB().getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Menu[#miInformeGraficos].onAction
	@FXML
	public void informeGraficos(ActionEvent event) {
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe_graficos.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, parameters, new ConexionDB().getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Menu[#miInformeAlumnos].onAction
	@FXML
	public void informeAlumnos(ActionEvent event) {
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe_alumnos.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, parameters, new ConexionDB().getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Menu[#miAyuda].onAction
	@FXML
	public void ayuda(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ayuda/VisorAyuda.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ayuda");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

}
