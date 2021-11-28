module proyecto2FX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;

	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens controller.alumnos to javafx.graphics, javafx.fxml;
	opens controller.libros to javafx.graphics, javafx.fxml;
	opens controller.prestamos to javafx.graphics, javafx.fxml;
	opens controller.historico to javafx.graphics, javafx.fxml;
	opens modelo to javafx.base;
}
