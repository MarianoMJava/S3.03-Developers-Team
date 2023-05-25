package floristeriaApp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Floristeria implements Serializable {

	private String nombre;
	private List<Arbol> arboles;
	private List<Flor> flores;
	private List<Decoracion> decoraciones;
	private double valorTotal;

	public Floristeria(String nombre) {
		this.nombre = nombre;
		this.arboles = new ArrayList<>();
		this.flores = new ArrayList<>();
		this.decoraciones = new ArrayList<>();
		this.valorTotal = 0;

	}
	// AGREGAR

	public void agregarArbol(Arbol arbol) {

		arboles.add(arbol);
		valorTotal += arbol.getPrecio();
		
	}

	public void agregarFlor(Flor flor) {

		flores.add(flor);
		valorTotal += flor.getPrecio();

	}

	public void agregarDecoracion(Decoracion decoracion) {

		decoraciones.add(decoracion);
		valorTotal += decoracion.getPrecio();

	}

	// RETIRAR

	public void retirarArbol(Arbol arbolBuscar) {

		Boolean encontrado = false;

		for (int i = 0; i < this.arboles.size(); i++) {
			if (arbolBuscar.equals(this.arboles.get(i))) {
				this.arboles.remove(this.arboles.get(i));
				valorTotal -= this.arboles.get(i).getPrecio();
				encontrado = true;
			}
		}

		if (encontrado == true) {
			System.out.println("Arbol eliminado");
		} else {
			System.out.println("El arbol no existe en la base de datos");
		}

	}

	public void retirarFlor(Flor florBuscar) {

		Boolean encontrado = false;

		for (int i = 0; i < flores.size() && encontrado == false; i++) {
			if (florBuscar.equals(flores.get(i))) {
				flores.remove(flores.get(i));
				valorTotal -= flores.get(i).getPrecio();
				encontrado = true;
			}
		}

		if (encontrado == true) {
			System.out.println("Flor eliminada");
		} else {
			System.out.println("La flor no existe en la base de datos");
		}
	}

	public void retirarDecoracion(Decoracion decoracionBuscar) {

		Boolean encontrado = false;

		for (int i = 0; i < decoraciones.size() && encontrado == false; i++) {
			if (decoracionBuscar.equals(decoraciones.get(i))) {
				decoraciones.remove(decoraciones.get(i));
				valorTotal -= decoraciones.get(i).getPrecio();
				encontrado = true;
			}
		}

		if (encontrado == true) {
			System.out.println("Decoracion eliminada");
		} else {
			System.out.println("La decoracion no existe en la base de datos");
		}
	}

	// MOSTRAR

	public void mostrarStock() {

		Scanner sc = new Scanner(System.in);

		/*String nombreFloristeria;

		System.out.println("Ingrese el nombre de la floristeria que quiere ver stock: ");
		nombreFloristeria = sc.nextLine();*/
	

		try {
			FileInputStream fileIn = new FileInputStream(this.nombre + ".txt");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Floristeria floristeriaMostrar = (Floristeria) objectIn.readObject();

			System.out.println(floristeriaMostrar);

			objectIn.close();
			fileIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar el estado de la floristería: " + e.getMessage());
		}
	}

	public void mostrarStockConCantidades() {
		System.out.println("Stock de la floristería:");
		System.out.println("Árboles: " + arboles.size() +" unidades");
		System.out.println("Flores: " + flores.size()+" unidades");
		System.out.println("Decoraciones: " + decoraciones.size()+" unidades");
	}

	public void mostrarValorTotal() {
		System.out.println("Valor total del stock: " + valorTotal);
	}

	// TICKET

	public void crearTicketCompra(List<Producto> productos) {
		Ticket ticket = new Ticket(productos);
		ticket.mostrarTicket();
	}

	// HISTORICO COMPRAS

	public void mostrarComprasAntiguas(List<Ticket> tickets) {
		System.out.println("Compras antiguas:");
		for (Ticket ticket : tickets) {
			ticket.mostrarTicket();
		}
	}

	// GANANCIAS

	public double calcularGanancias(List<Ticket> tickets) {
		double ganancias = 0;
		for (Ticket ticket : tickets) {
			ganancias += ticket.calcularTotal();
		}
		return ganancias;
	}
	
	@Override
	public String toString() {
		return "Floristeria [nombre=" + nombre + ", arboles=" + arboles + ", flores=" + flores + ", decoraciones="
				+ decoraciones + ", valorTotal=" + valorTotal + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
