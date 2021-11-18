package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import config.MessageReader;
import dao.DAOUbicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Ubicacion;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndexController implements Initializable {
	@FXML
	private TableView<Ubicacion> table;
	@FXML
	private ImageView imagen;
	@FXML
	private TableColumn<Ubicacion, String> tcSecction;
	@FXML
	private TableColumn<Ubicacion, String> tcUbication;

	private Ubicacion ubicacionSeleccionada;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ponerIconos();
		ArrayList<Ubicacion> ubicaciones = new DAOUbicacion().selectUbicaciones();
		if (ubicaciones == null || ubicaciones.size() < 1) {
			mostrarAlertError(MessageReader.getString("bd.error"));
			System.exit(0);
		}
		rellenarTabla(ubicaciones);
		gestionarEventos();
	}

	@FXML
	private void mostrarAlertError(String error) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(error);
		alert.showAndWait();
	}

	private void rellenarTabla(ArrayList<Ubicacion> ubicaciones) {
		ObservableList<Ubicacion> data = FXCollections.observableArrayList();

		for (Ubicacion ubicacion : ubicaciones) {
			data.add(ubicacion);
		}
		table.setItems(data);
		tcSecction.setCellValueFactory(new PropertyValueFactory<Ubicacion, String>("seccion"));
		tcUbication.setCellValueFactory(new PropertyValueFactory<Ubicacion, String>("ubicacion"));
	}

	private void gestionarEventos() {
		table.setRowFactory(tv -> {
			TableRow<Ubicacion> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
					ubicacionSeleccionada = row.getItem();
					ponerImagen(ubicacionSeleccionada.getImagen());
				}
			});
			return row;
		});

		imagen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				verImagenEnGrande(ubicacionSeleccionada.getImagen());
			}
		});
	}

	private void ponerImagen(String ruta) {
		try {
			File fichero = new File("src/images/" + ruta);
			InputStream image;
			image = (InputStream) new FileInputStream(fichero);
			imagen.setImage(new Image(image));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void verImagenEnGrande(String ruta) {
		System.out.println(ruta);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/imagen.fxml"));
			ImagenController imagenController = new ImagenController();
			imagenController.setRuta(ruta);
			loader.setController(imagenController);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.setTitle(MessageReader.getString("imagen.title"));
			stage.setResizable(false);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ponerIconos() {
		try {
			File fichero1 = new File("src/images/secciones.png");
			InputStream image1 = (InputStream) new FileInputStream(fichero1);
			ImageView img1 = new ImageView();
			img1.setImage(new Image(image1));
			
			Label label1 = new Label(tcSecction.getText());
			label1.setStyle("-fx-padding: 8px;");
			label1.setWrapText(true);
			label1.setAlignment(Pos.CENTER);
			label1.setTextAlignment(TextAlignment.CENTER);
			label1.setGraphic(img1);

			AnchorPane stack1 = new AnchorPane();
			stack1.getChildren().add(label1);
			stack1.prefWidthProperty().bind(tcSecction.widthProperty().subtract(5));
			tcSecction.setGraphic(stack1);
			
			File fichero2 = new File("src/images/location.png");
			InputStream image2 = (InputStream) new FileInputStream(fichero2);
			ImageView img2 = new ImageView();
			img2.setImage(new Image(image2));
			
			Label label2 = new Label(tcSecction.getText());
			label2.setStyle("-fx-padding: 8px;");
			label2.setWrapText(true);
			label2.setAlignment(Pos.CENTER);
			label2.setTextAlignment(TextAlignment.CENTER);
			label2.setGraphic(img2);

			AnchorPane stack2 = new AnchorPane();
			stack2.getChildren().add(label2);
			stack2.prefWidthProperty().bind(tcSecction.widthProperty().subtract(5));
			tcUbication.setGraphic(stack2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
