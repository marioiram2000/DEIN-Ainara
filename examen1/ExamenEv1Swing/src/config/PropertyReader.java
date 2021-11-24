package config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	private static Properties props = new Properties();

	static {
		try (FileInputStream input = new FileInputStream("config.properties")) {
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
}
