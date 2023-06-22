package mariano.floristeria.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import mariano.floristeria.persistencia.mysqJdbc.ConnectionConfig;

 

public class ConfiguracionPropiedades {

	Properties props = new Properties();
	
	public String getPersistencia() {
		return persistencia;
	}

	String persistencia = "";
	public ConfiguracionPropiedades() {
		// TODO Auto-generated constructor stub
	}

	
	public void LeePropiedades(String file) throws IOException {
	 	
		InputStream is = ConfiguracionPropiedades.class.getClassLoader().getResourceAsStream(file);
		
		//Cargamos las propiedades que vienene del archivo
		 props.load(is);

		 persistencia  = props.getProperty("persistencia");
	}
	
	public ConnectionConfig ConectionDBMysql () {
		
		ConnectionConfig  connectionconfig = new ConnectionConfig();
		
		connectionconfig.setDRIVER(props.getProperty("driver"));
		connectionconfig.setURL(props.getProperty("url"));
		connectionconfig.setPASS(props.getProperty("password"));
		connectionconfig.setUSER(props.getProperty("user"));
		
		return connectionconfig;
		
		
		
	}
	
	
	
}
