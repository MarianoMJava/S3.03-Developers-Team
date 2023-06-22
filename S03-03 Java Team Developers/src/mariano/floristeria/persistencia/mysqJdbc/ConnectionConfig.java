package mariano.floristeria.persistencia.mysqJdbc;

/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */


 
 
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionConfig {


	private static  String DRIVER ;
	private static  String URL ;
	private static  String USER ;
	private static  String PASS ;
	
    public  ConnectionConfig() {

    }
 
    
	public static String getDRIVER() {
		return DRIVER;
	}

	public static void setDRIVER(String dRIVER) {
		DRIVER = dRIVER;
	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}

	public static String getUSER() {
		return USER;
	}

	public static void setUSER(String uSER) {
		USER = uSER;
	}

	public static String getPASS() {
		return PASS;
	}

	public static void setPASS(String pASS) {
		PASS = pASS;
	}

}