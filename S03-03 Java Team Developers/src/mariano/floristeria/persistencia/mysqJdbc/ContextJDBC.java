package mariano.floristeria.persistencia.mysqJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class ContextJDBC.
 * 
 * Clase que permite obtener una conexión a la base de datos y asegura que si ya
 * existe una conexión no la vuelva a crear utilizando el patrón de diseño
 * Singleton. Además, implementa los métodos para poder enviar sentencias SQL como
 * INSERT, DELETE, UPDATE y SELECT.
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 * 
 * @see https://www.arquitecturajava.com/ejemplo-de-java-singleton-patrones-classloaders/
 * @version 1.0
 *
 */
public class ContextJDBC {
//	
//	<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
//	<property name="connection.url">jdbc:mysql://localhost:3306/pruebas</property>
//	<property name="connection.username">root</property>
//	<property name="connection.password"></property>
//	<property name="show_sql">true</property>
	
//	private static  String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static  String URL = "jdbc:mysql://localhost:3306/negocio?autoReconnect=true&useSSL=false&serverTimezone=UTC";
//	private static  String USER = "root";
//	private static  String PASS = "point2020";
	
	
	
	private static  String DRIVER = "";
	private static  String URL = "";
	private static  String USER = "";
	private static  String PASS = "";
	
	
	private static ContextJDBC jdbc1 = null;
 
	private Statement statement = null;

	
	// Patrron singleton.  Sólo llamaremos al constructor una sola vez.
	private ContextJDBC() {
	 
		this.connect();
	}
	/**
	 * Método connect.
	 * 
	 * Realiza una conexión a la base de datos a través de jdbc
	 */
	public void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD\n" + e.getMessage());
		}
	}

	/**
	 * Método query.
	 * 
	 * Realiza una sentencia SELECT a la base de datos.
	 */
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): ---" + sql + "---" + e);
		}
		return null;
	}

	/**
	 * Método update.
	 * 
	 * Realiza una sentencia INSERT, UDPDATE, DELETE, CREATE, entre otras a la base
	 * de datos.
	 */
	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:update)... actualizacion: ---" + sql + "---" + e);
			System.out.println("   ErrorCode : " + e.getErrorCode() + " state " + e.getSQLState()) ; 
			System.out.println("   ErrorCode : " + e.getMessage() 		);	
			return false;
		}
	}

	/**
	 * Método getJDBC.
	 * 
	 * Obtiene una conexión activa a la base de datos
	 * 
	 * @return jdbc
	 */
	public static ContextJDBC getJDBC1() {
		// creación de la conexión a la base de datos solo si no ha sido creada patrón
		// de diseño singleton
		
		if (jdbc1 == null) {
			jdbc1 = new ContextJDBC();
		}
		return jdbc1;

	}

	public static ContextJDBC getJDBC1(ConnectionConfig  connectionconfig  ) {
		// creación de la conexión a la base de datos solo si no ha sido creada patrón
		// de diseño singleton
		
		DRIVER =	 connectionconfig.getDRIVER();
		URL = 		connectionconfig.getURL();
		USER = connectionconfig.getUSER();
		PASS = connectionconfig.getPASS();
		
		if (jdbc1 == null) {
			jdbc1 = new ContextJDBC();
		}
		return jdbc1;

	}
 
}
