package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenController implements Initializable{
	@FXML
	private ImageView imagenGrande;
	private String ruta;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			File fichero = new File("src/images/"+ruta);
			InputStream image;
			image = (InputStream) new FileInputStream(fichero);
			imagenGrande.setImage(new Image(image));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
