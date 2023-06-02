package floristeriaApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Iniciando Bienvenido. Finde  ");
		Scanner scanner = new Scanner(System.in);

		Floristeria floristeria = crearCargarFloristeria(scanner);
		boolean salir = false;
		System.out.println( floristeria.getNombre());
		//
		// Declararamos Objecto persitencia lectura/escritura   ficheros
		//
		Persistencia  persistencia = new Persistencia( floristeria.getNombre() );

		// Leemos los arboles creados en el fichero  y lo inyectamos en la floristeria

		floristeria.setArboles( persistencia.LeerArbol());
		floristeria.setFlores( persistencia.LeerFlor());
		floristeria.setDecoraciones(persistencia.LeerDecoracion());



		while (!salir) {
			mostrarMenu();

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner


			switch (opcion) {
				case 0:
					floristeria = crearCargarFloristeria(scanner);
					break;
				case 1:
					agregarArbol(scanner, floristeria);
					break;
				case 2:
					agregarFlor(scanner, floristeria);
					break;
				case 3:
					agregarDecoracion(scanner, floristeria);
					break;
				case 4:
					mostrarStock(floristeria);
					break;
				case 5:
					retirarArbol(scanner, floristeria);
					break;
				case 6:
					retirarFlor(scanner, floristeria);
					break;
				case 7:
					retirarDecoracion(scanner, floristeria);
					break;
				case 8:
					mostrarStockConCantidades(floristeria);
					break;
				case 9:
					mostrarValorTotal(floristeria);
					break;
				case 10:
					crearTicketCompra(scanner, floristeria);
					break;
				case 11:
//				mostrarComprasAntiguas();
					System.out.println("hola1");
					break;
				case 12:
//				mostrarGananciasTotales();
					System.out.println("hola12");
					break;
				case 13:
					SerializarGuardar.serializar(floristeria);
//				floristeria = crearCargarFloristeria(scanner);
 
 
					persistencia.GrabarArbol(floristeria.getArboles());
					persistencia.GrabarFlor(floristeria.getFlores());
					persistencia.GrabarDecoracion(floristeria.getDecoraciones());
					persistencia.LeerArbol();		

					break;
				case 14:
					salir = true;
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("OpciÃ³n invÃ¡lida. Introduce un nÃºmero del 1 al 14.");
					break;

			}

		}
		scanner.close();
	}


	private static void mostrarMenu() {
		System.out.println("----- MenÃº -----");
		System.out.println("0. Crear/Cargar floristeria");
		System.out.println("1. AÃ±adir Ã�rbol");
		System.out.println("2. AÃ±adir Flor");
		System.out.println("3. AÃ±adir DecoraciÃ³n");
		System.out.println("4. Mostrar Stock");
		System.out.println("5. Retirar Ã�rbol");
		System.out.println("6. Retirar Flor");
		System.out.println("7. Retirar DecoraciÃ³n");
		System.out.println("8. Mostrar Stock con Cantidades");
		System.out.println("9. Mostrar Valor Total");
		System.out.println("10. Crear Ticket de Compra");
		System.out.println("11. Mostrar Compras Antiguas");
		System.out.println("12. Mostrar Ganancias Totales");
		System.out.println("13. Guardar (Para registrar cambios y cambiar de floristeria)");
		System.out.println("14. Salir");
		System.out.println("Elige una opciÃ³n: ");
	}

	public  static Floristeria crearCargarFloristeria(Scanner scanner) {

		String nombre;

		Boolean existeFloristeria = null;

		System.out.print("Ingrese el nombre de la floristeria: ");

		nombre = scanner.nextLine();

		existeFloristeria = ComprobarExistencia.comprobarFloristeria(nombre);

		Floristeria floristeria = new Floristeria(nombre);

		if (existeFloristeria) {

			try {
				FileInputStream fileIn = new FileInputStream(nombre + ".txt");
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				floristeria = (Floristeria) objectIn.readObject();

				objectIn.close();
				fileIn.close();

				System.out.println("La floristerÃ­a ha sido cargado correctamente.");
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Error al cargar el estado de la floristerÃ­a: " + e.getMessage());
			}
		}

		return floristeria;

	}


	private static void agregarArbol(Scanner scanner, Floristeria floristeria) {

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			floristeria = crearCargarFloristeria(scanner);

		}

		System.out.println("Introduce el nombre del Ã¡rbol: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio del Ã¡rbol: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce la altura del Ã¡rbol: ");
		double altura = scanner.nextDouble();

		System.out.println("Introduce la cantidad de estos arboles: ");
		int cantidad = scanner.nextInt();

		Arbol arbol = new Arbol(nombre, precio, altura, cantidad);

		floristeria.agregarArbol(arbol);

	}

	private static void agregarFlor(Scanner scanner, Floristeria floristeria) {

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			floristeria = crearCargarFloristeria(scanner);

		}
		System.out.println("Introduce el nombre de la flor: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio de la flor: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce el color de la flor: ");
		String color = scanner.next();

		System.out.println("Introduce la cantidad de estas flores: ");
		int cantidad = scanner.nextInt();

		Flor flor = new Flor(nombre, precio, color, cantidad);

		floristeria.agregarFlor(flor);

	}

	private static void agregarDecoracion(Scanner scanner, Floristeria floristeria) {

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			floristeria = crearCargarFloristeria(scanner);

		}
		System.out.println("Introduce el nombre de la decoraciÃ³n: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio de la decoraciÃ³n: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce el material de la decoraciÃ³n (madera o plÃ¡stico): ");
		String material = scanner.next();

		System.out.println("Introduce la cantidad de estas decoraciones: ");
		int cantidad = scanner.nextInt();

		Decoracion decoracion = new Decoracion(nombre, precio, material, cantidad);

		floristeria.agregarDecoracion(decoracion);

	}

	private static void mostrarStock(Floristeria floristeria) {

		Scanner scanner = new Scanner(System.in);

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			floristeria = crearCargarFloristeria(scanner);
			floristeria.mostrarStock();

		} else {
			floristeria.mostrarStock();
		}
	}

	private static void retirarArbol(Scanner scanner, Floristeria floristeria) {

		mostrarStock(floristeria);

		System.out.println("Ingrese el id del producto a retirar: ");
		int idRetirar = scanner.nextInt();

		floristeria.retirarArbol(idRetirar);

		SerializarGuardar.serializar(floristeria);

	}

	private static void retirarFlor(Scanner scanner, Floristeria floristeria) {

		mostrarStock(floristeria);

		System.out.println("Ingrese el id del producto a retirar: ");
		int idRetirar = scanner.nextInt();

		floristeria.retirarFlor(idRetirar);

		SerializarGuardar.serializar(floristeria);

	}

	private static void retirarDecoracion(Scanner scanner, Floristeria floristeria) {

		mostrarStock(floristeria);

		System.out.println("Ingrese el id del producto a retirar: ");
		int idRetirar = scanner.nextInt();

		floristeria.retirarDecoracion(idRetirar);

		SerializarGuardar.serializar(floristeria);
	}

	private static void mostrarStockConCantidades(Floristeria floristeria) {

		Scanner scanner = new Scanner(System.in);

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			crearCargarFloristeria(scanner);

		} else {
			floristeria.mostrarStockConCantidades();
		}
	}

	private static void mostrarValorTotal(Floristeria floristeria) {

		Scanner scanner = new Scanner(System.in);

		if (floristeria == null) {
			System.out.println("Por favor, primero indicar floristeria o crearla: ");
			crearCargarFloristeria(scanner);

		} else {
			floristeria.mostrarValorTotal();
		}
	}

	private static void crearTicketCompra(Scanner scanner, Floristeria floristeria) {

		List<Producto> productosCompra = new ArrayList<>();
		List<Ticket> comprasAntiguas = new ArrayList<>();

		String nombre;
		double precio;
		boolean agregarProductos = true;

		while (agregarProductos) {
			System.out.println("Introduce el producto a comprar (o 'salir' para finalizar): ");
			System.out.println("Nombre producto: ");
			nombre = scanner.nextLine();

			System.out.println("Precio producto: ");
			precio= scanner.nextDouble();

			if (nombre.equalsIgnoreCase("salir")) {
				agregarProductos = false;

			} else {

				Producto producto = floristeria.buscarProducto(nombre, precio);
//				Producto producto = null;
				if (producto != null) {
					productosCompra.add(producto);
					System.out.println("Producto aÃ±adido al carrito de compra.");
				} else {
					System.out.println("No se encontrÃ³ el producto en el stock.");
				}
			}
		}

		Ticket ticket = new Ticket(productosCompra);
		comprasAntiguas.add(ticket);

		System.out.println("Ticket de compra:");
		ticket.mostrarTicket();
	}

	private static void mostrarComprasAntiguas(List<Ticket> comprasAntiguas) {
		System.out.println("Compras antiguas:");
		for (Ticket ticket : comprasAntiguas) {
			ticket.mostrarTicket();
			System.out.println();
		}
	}

	private static void mostrarGananciasTotales(List<Ticket> comprasAntiguas) {
		double gananciasTotales = 0;

		for (Ticket ticket : comprasAntiguas) {
			gananciasTotales += ticket.calcularTotal();
		}

		System.out.println("Ganancias totales: " + gananciasTotales);
	}

}
