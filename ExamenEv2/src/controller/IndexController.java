package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import config.ConexionDB;
import dao.DAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import modelo.Email;
import modelo.Persona;
import modelo.Telefono;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class IndexController implements Initializable {
	@FXML
	private Label titleLabel;
	@FXML
	private ListView<Telefono> listViewTelefonos;
	@FXML
	private ListView<Email> listViewEmails;
	@FXML
	private Button btnNuevoTelefono;
	@FXML
	private Button btnBorrarTelefono;
	@FXML
	private Button btnNuevoEmail;
	@FXML
	private Button btnBorrarEmail;
	@FXML
	private Button anteriorPersona;
	@FXML
	private Button siguientePersona;
	@FXML
	private Label labelPosicion;
	@FXML
	private MenuItem miInforme1;
	@FXML
	private MenuItem miInforme2;
	@FXML
	private MenuItem miAyuda;
	@FXML
	private MenuItem miAyudaOnline;

	private final DAO dao = new DAO();
	private ArrayList<Persona> personas;

	private int pos;
	private Persona persona;
	private ObservableList<Telefono> listTelefonos;
	private ObservableList<Email> listEmails;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		personas = dao.getpersonas();
		if (personas.size() == 0) {
			mostrarAlertError("No hemos encontrado personas en la base de datos");
		}
		pos = 1;
		persona = personas.get(pos - 1);

		actualizarPosicion();

		listViewEmails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Email>() {
			@Override
			public void changed(ObservableValue<? extends Email> observable, Email oldvalue, Email newValue) {
				btnBorrarEmail.setDisable(false);
			}
		});

		listViewTelefonos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Telefono>() {
			@Override
			public void changed(ObservableValue<? extends Telefono> observable, Telefono oldvalue, Telefono newValue) {
				btnBorrarTelefono.setDisable(false);
			}
		});
	}

	private void actualizarPosicion() {
		try {
			persona = personas.get(pos - 1);
			titleLabel.setText(persona.toString());
			labelPosicion.setText(pos + "/" + personas.size());

			listEmails = FXCollections.observableArrayList();
			listViewEmails.setItems(listEmails);
			ArrayList<Email> emails = dao.getEmailsPersona(persona);
			for (Email email : emails) {
				listEmails.add(email);
			}

			listTelefonos = FXCollections.observableArrayList();
			listViewTelefonos.setItems(listTelefonos);
			ArrayList<Telefono> telefonos = dao.getTelefonosPersona(persona);
			for (Telefono tel : telefonos) {
				listTelefonos.add(tel);
			}
		} catch (IndexOutOfBoundsException e) {
			pos = personas.indexOf(persona) + 1;
			mostrarAlertError("No hay más alumnos");
		}

	}

	// Event Listener on Button[#btnNuevoTelefono].onAction
	@FXML
	public void nuevoTelefono(ActionEvent event) {
		String tel = mostrarTextInputDialog("teléfono");
		boolean valido = true;
		if (tel.length() != 9) {
			mostrarAlertError("La longitud del teléfono tiene que ser de 9");
			valido = false;
		} else {
			for (Telefono telefono : listTelefonos) {
				if (telefono.getTelefono().equals(tel)) {
					mostrarAlertError("Telefono repetido");
					valido = false;
				}
			}
		}

		if (valido) {
			dao.insertTelefono(tel, persona.getDni());
			actualizarPosicion();
			mostrarAlertInformation("Teléfono añadido");
		}
	}

	// Event Listener on Button[#btnBorrarTelefono].onAction
	@FXML
	public void borrarTelefono(ActionEvent event) {
		Telefono tel = listViewTelefonos.getSelectionModel().getSelectedItem();
		if (dao.deleteTelefono(tel.getTelefono(), tel.getPersona().getDni())) {
			actualizarPosicion();
			mostrarAlertInformation("Telefono eliminado");
		} else {
			mostrarAlertError("Error al eliminar el telefono");
		}
	}

	// Event Listener on Button[#btnNuevoEmail].onAction
	@FXML
	public void nuevoEmail(ActionEvent event) {
		String email = mostrarTextInputDialog("teléfono");
		boolean valido = true;
		if (!email.contains("@")) {
			mostrarAlertError("Email inválido");
			valido = false;
		}

		if (valido) {
			dao.insertEmail(email, persona.getDni());
			actualizarPosicion();
			mostrarAlertInformation("Email añadido");
		}
	}

	// Event Listener on Button[#btnBorrarEmail].onAction
	@FXML
	public void borrarEmail(ActionEvent event) {
		Email email = listViewEmails.getSelectionModel().getSelectedItem();
		if (dao.deleteEmail(email.getEmail(), email.getPersona().getDni())) {
			actualizarPosicion();
			mostrarAlertInformation("Email eliminado");
		} else {
			mostrarAlertError("Error al eliminar el email");
		}
	}

	// Event Listener on Button[#anteriorPersona].onAction
	@FXML
	public void anteriorPersona(ActionEvent event) {
		pos--;
		actualizarPosicion();
	}

	// Event Listener on Button[#siguientePersona].onAction
	@FXML
	public void siguientePersona(ActionEvent event) {
		pos++;
		actualizarPosicion();
	}

	@FXML
	private void mostrarAlertError(String text) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(text);
		alert.showAndWait();
	}

	@FXML
	private void mostrarAlertInformation(String text) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(text);
		alert.showAndWait();
	}

	private String mostrarTextInputDialog(String parametro) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo " + parametro);
		dialog.setHeaderText(null);
		dialog.setContentText("Introduce el nuevo " + parametro);
		Optional<String> dato = dialog.showAndWait();
		if (dato.isPresent()) {
			String dato_sin_optional = dato.get();
			return dato_sin_optional;
		}
		return "";
	}

	// Event Listener on MenuItem[#miInforme1].onAction
	@FXML
	public void abrirInforme1(ActionEvent event) {
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe1.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, parameters, new ConexionDB().getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on MenuItem[#miInforme2].onAction
	@FXML
	public void abrirInforme2(ActionEvent event) {
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			JasperReport report = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/informes/informe2.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, parameters, new ConexionDB().getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on MenuItem[#miAyuda].onAction
	@FXML
	public void abrirAyuda(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisorAyuda.fxml"));
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

	// Event Listener on MenuItem[#miAyudaOnline].onAction
	@FXML
	public void abrirAyudaOnline(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisorAyudaOnline.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Ayuda");
			stage.show();
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
}
