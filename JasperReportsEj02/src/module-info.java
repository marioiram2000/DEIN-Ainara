module JasperReportsEj02 {
	requires javafx.controls;
	requires java.sql;
	requires jasperreports;
	requires javafx.fxml;
	requires mysql.connector.java;
	
	opens application to javafx.graphics, javafx.fxml;
}
