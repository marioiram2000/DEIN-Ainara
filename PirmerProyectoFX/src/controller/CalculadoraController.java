package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import modelo.Operaciones;
import javafx.scene.control.TextField;

import javafx.scene.control.RadioButton;

public class CalculadoraController {
	@FXML
	private Button btnCalcular;
	@FXML
	private RadioButton rbSumar;
	@FXML
	private ToggleGroup radiosGroup;
	@FXML
	private RadioButton rbRestar;
	@FXML
	private RadioButton rbMultiplicar;
	@FXML
	private RadioButton rbDividir;
	@FXML
	private TextField tfOperador1;
	@FXML
	private TextField tfOperador2;
	@FXML
	private TextField tfResultado;
	
	@FXML
	public void calcular(ActionEvent event) {
		try {
			double op1 = Double.parseDouble(this.tfOperador1.getText());
			double op2 = Double.parseDouble(this.tfOperador2.getText());
			
			Operaciones operaciones = new Operaciones(op1, op2);
			String resultado = "";
			
			if(this.rbSumar.isSelected()) {
				resultado = ""+operaciones.sumar();
			}else if(this.rbRestar.isSelected()) {
				resultado = ""+operaciones.restar();
			}else if(this.rbMultiplicar.isSelected()) {
				resultado = ""+operaciones.multiplicar();
			}else if(this.rbDividir.isSelected()) {
				if(op2 == 0) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("No se puede dividir entre 0");
					alert.showAndWait();
				}else {
					resultado = ""+operaciones.dividir();
				}
			}
			
			this.tfResultado.setText(resultado);
		}catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Formato incorrecto");
			alert.showAndWait();
		}
	}

}
