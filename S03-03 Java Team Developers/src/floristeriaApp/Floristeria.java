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

	private List<Arbol> arboles;
	private List<Flor> flores;
	private List<Decoracion> decoraciones;
	private double valorTotal;
	private String nombre;

	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<Flor> getFlores() {
		return flores;
	}
	public List<Decoracion> getDecoraciones() {
		return decoraciones;
	}

	public List<Arbol> getArboles() {
		return arboles;
	}
	public void setArboles(List<Arbol> arboles) {
		this.arboles = arboles;
	}
 
	public void setFlores(List<Flor> flores) {
		this.flores = flores;
	}
 
	public void setDecoraciones(List<Decoracion> decoraciones) {
		this.decoraciones = decoraciones;
	}



	public Floristeria(String nombre) {
		this.nombre = nombre;
		this.arboles = new ArrayList<>();
		this.flores = new ArrayList<>();
		this.decoraciones = new ArrayList<>();
		this.valorTotal = 0;

	}
	// AGREGAR
	public  List<Arbol>  getArbol(){
		return arboles;
	}
	
	
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

		for (int i = 0; i < this.arboles.size() && encontrado == false; i++) {

			if (arbolBuscar.getNombre().equals(this.arboles.get(i).getNombre())
					&& arbolBuscar.getAltura() == this.arboles.get(i).getAltura()) {

				valorTotal -= this.arboles.get(i).getPrecio();

				this.arboles.remove(this.arboles.get(i));

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

		for (int i = 0; i < this.flores.size() && encontrado == false; i++) {

			if (florBuscar.getNombre().equals(this.flores.get(i).getNombre())
					&& florBuscar.getColor().equals(this.flores.get(i).getColor())) {

				valorTotal -= this.flores.get(i).getPrecio();
				this.flores.remove(this.flores.get(i));

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

		for (int i = 0; i < this.decoraciones.size() && encontrado == false; i++) {

			if (decoracionBuscar.getNombre().equals(this.decoraciones.get(i).getNombre())
					&& decoracionBuscar.getMaterial().equals(this.decoraciones.get(i).getMaterial())) {

				valorTotal -= this.decoraciones.get(i).getPrecio();
				this.decoraciones.remove(this.decoraciones.get(i));

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

		try {

			FileInputStream fileIn = new FileInputStream(this.nombre + ".txt");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Floristeria floristeriaMostrar = (Floristeria) objectIn.readObject();

			System.out.println(floristeriaMostrar);

			objectIn.close();
			fileIn.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar el estado de la floristerÃ­a: " + e.getMessage());
		}
	}

	public void mostrarStockConCantidades() {
		System.out.println("Stock de la floristerÃ­a:");
		System.out.println("Ã�rboles: " + arboles.size() + " unidades");
		System.out.println("Flores: " + flores.size() + " unidades");
		System.out.println("Decoraciones: " + decoraciones.size() + " unidades");
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
    public Producto buscarProducto(String nombre, double precio ) {
    	System.out.println("floristeria.BuscarProducto " + nombre + " " + precio);
    	Producto p = null;
    	for(Producto producto:  arboles) {
    		System.out.println("mis arboles :  " + producto.getNombre());
    		if( producto.getNombre().equals(nombre) ) {
    			p = producto;
    		};
    	}
    	return p;
    }
	@Override
	public String toString() {
		return "Floristeria\n" + nombre + "\nArboles " + arboles + "\nFlores=" + flores + "\nDecoraciones "
				+ decoraciones + "\nValor Total=" + valorTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
 }
