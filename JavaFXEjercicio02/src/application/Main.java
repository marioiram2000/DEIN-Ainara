package application;
	
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private static Properties props = new Properties();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			try {
				Locale locale = new Locale(getProperty("language"), getProperty("country"));
				ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
				GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/fxml/Personas.fxml"), bundle);
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static {
		try (FileInputStream input = new FileInputStream("resources/config.properties")) {
			props.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String clave) {
		String valor = props.getProperty(clave);
		if (valor != null) {
			return valor;
		}
		throw new RuntimeException("La clave solicitada en configuration.properties no está disponible");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
