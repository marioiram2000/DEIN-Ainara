module JasperReportsEj01 {
	requires javafx.controls;
	requires jasperreports;
	requires java.sql;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
