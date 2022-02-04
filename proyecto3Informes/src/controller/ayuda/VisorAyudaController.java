package controller.ayuda;

import java.net.URL;
import java.util.ResourceBundle;

import application.Help;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class VisorAyudaController implements Initializable {
	@FXML
	private TreeView<Help> arbol;
	@FXML
	private WebView visor;
	private WebEngine webEngine;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//Creamos el árbol del panel de la izquierda, el índice
		TreeItem<Help> rItem = new TreeItem<Help>(new Help("Raiz", ""));
		
		TreeItem<Help> r1Item = new TreeItem<Help>(new Help("Alumnos", "alumnos.html"));
		rItem.getChildren().add(r1Item);
		
		TreeItem<Help> r2Item = new TreeItem<Help>(new Help("Libros", "libros.html"));
		rItem.getChildren().add(r2Item);
		
		TreeItem<Help> r3Item = new TreeItem<Help>(new Help("Prestamos", "prestamos.html"));
		rItem.getChildren().add(r3Item);
		
		TreeItem<Help> r4Item = new TreeItem<Help>(new Help("Historico", "historico.html"));
		rItem.getChildren().add(r4Item);
		
		TreeItem<Help> r5Item = new TreeItem<Help>(new Help("Informes", "informes.html"));
		rItem.getChildren().add(r5Item);
		
		
		
		arbol.setRoot(rItem);
		arbol.setShowRoot(false);
//Mostramos el contenido inicial en el visor de la derecha
		webEngine = visor.getEngine();
		webEngine.load(getClass().getResource("/help/html/alumnos.html").toExternalForm());
//Añadimos un evento para cambiar de html al pinchar en el árbol
		arbol.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (arbol.getSelectionModel().getSelectedItem() != null) {
					Help elemento = (Help) arbol.getSelectionModel().getSelectedItem().getValue();
					if (elemento.getHtml() != null) {
						loadHelp(elemento.getHtml(), elemento.isLocal());
					}
				}
			}
		});
	}

	private void loadHelp(String file, boolean local) {
		if (visor != null) {
			if (local) {
				webEngine.load(getClass().getResource("/help/html/" + file).toExternalForm());
			} else {
				webEngine.load(file);
			}
		}
	}
}