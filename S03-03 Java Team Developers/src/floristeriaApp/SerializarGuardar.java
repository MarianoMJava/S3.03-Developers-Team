package floristeriaApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarGuardar {

	public static void serializar(Floristeria floristeria) {
		try {
			FileOutputStream fileOut = new FileOutputStream(floristeria.getNombre() + ".txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(floristeria);
			objectOut.close();
			fileOut.close();
			System.out.println("El estado de la floristería ha sido guardado correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar el estado de la floristería: " + e.getMessage());
		}

	}
	
}
