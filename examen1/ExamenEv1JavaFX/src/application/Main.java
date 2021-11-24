package application;
	
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import config.PropertyReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Locale locale = new Locale(PropertyReader.getProperty("language"), PropertyReader.getProperty("country"));
			ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
			GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/fxml/index.fxml"), bundle);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
