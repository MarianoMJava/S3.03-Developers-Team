package floristeriaApp;

import java.io.File;
import java.io.IOException;

public class ComprobarExistencia {

	public static Boolean comprobarFloristeria(String nombre) {

		Boolean existeFloristeria = false;

		try {
			File myTxt = new File(nombre + ".txt");
			
			if (myTxt.createNewFile()) {
				
				System.out.println("Fichero creado " + myTxt.getName());
				
				
			} else {
				
				existeFloristeria = true;

				System.out.println("El archivo ya existe. Ingresando a fichero de floristeria " + nombre);
			}
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}

		return existeFloristeria;

	}

}
