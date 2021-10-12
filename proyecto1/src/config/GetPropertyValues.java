package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

public class GetPropertyValues {

	InputStream inputStream;

	public GetPropertyValues() {
		super();
	}

	public Locale getLocale() throws IOException {

		Locale locale;

		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			locale = new Locale(prop.getProperty("language"), prop.getProperty("country"));
			return locale;

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}

		return null;
	}

	public HashMap<String, String> getDBInformation() throws IOException {

		HashMap<String, String> data = new HashMap<String, String>();

		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			data.put("host", prop.getProperty("host"));
			data.put("baseDatos", prop.getProperty("baseDatos"));
			data.put("usuario", prop.getProperty("usuario"));
			data.put("password", prop.getProperty("password"));
			return data;

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}

		return data;
	}
}
