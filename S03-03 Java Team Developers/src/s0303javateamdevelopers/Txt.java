package s0303javateamdevelopers;

import java.io.File;
import java.io.IOException;

public class Txt {

	public static void crearTxt() {

		try {
			File myTxt = new File("FloristeriaTxt.txt");
			if (myTxt.createNewFile()) {
				System.out.println("Archivo creado " + myTxt.getName());
			} else {
				System.out.println("El archivo ya existe.");
			}
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}
}
}
