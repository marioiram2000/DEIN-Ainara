package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

public class GetPropertyValues {

	private static Properties props = new Properties();
	
	static {
		try (FileInputStream input = new FileInputStream("config.properties")) {
			props.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValor(String clave) {
		String valor = props.getProperty(clave);
		if (valor != null) {
			return valor;
		}
		throw new RuntimeException("La clave solicitada en configuration.properties no está disponible");
	}
}
