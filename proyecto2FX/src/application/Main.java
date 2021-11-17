package application;
	
import java.util.Locale;

import config.PropertyReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Locale.setDefault(new Locale(PropertyReader.getProperty("language"), PropertyReader.getProperty("country")));
		try {
			GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/fxml/index.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("BIBLIOTECA");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}