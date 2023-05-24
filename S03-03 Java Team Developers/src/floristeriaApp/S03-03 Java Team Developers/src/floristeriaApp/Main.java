package floristeriaApp;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		Floristeria floristeria = null;
		
		boolean salir = false;

		while (!salir) {
			mostrarMenu();

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 0:
				floristeria = crearFloristeria(scanner);
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
		/*	case 10:
				crearTicketCompra(scanner, floristeria);
				break;
			case 11:
				mostrarComprasAntiguas();
				break;
			case 12:
				mostrarGananciasTotales();
				break;*/
			case 13:
				salir = true;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida. Introduce un número del 1 al 13.");
				break;
			
			}
		}

		scanner.close();

	}

	private static void mostrarMenu() {
		System.out.println("----- Menú -----");
		System.out.println("0. Crear/Cargar floristeria");
		System.out.println("1. Añadir Árbol");
		System.out.println("2. Añadir Flor");
		System.out.println("3. Añadir Decoración");
		System.out.println("4. Mostrar Stock");
		System.out.println("5. Retirar Árbol");
		System.out.println("6. Retirar Flor");
		System.out.println("7. Retirar Decoración");
		System.out.println("8. Mostrar Stock con Cantidades");
		System.out.println("9. Mostrar Valor Total");
		System.out.println("10. Crear Ticket de Compra");
		System.out.println("11. Mostrar Compras Antiguas");
		System.out.println("12. Mostrar Ganancias Totales");
		System.out.println("13. Salir");
		System.out.println("Elige una opción: ");
	}
	
private static Floristeria crearFloristeria(Scanner scanner) {
		
		String nombre;

		System.out.print("Ingrese el nombre de la floristeria: ");

		nombre = scanner.nextLine();

		Floristeria floristeria = new Floristeria(nombre);
		
		return floristeria;
		
	}

	private static void agregarArbol(Scanner scanner, Floristeria floristeria) {
		System.out.println("Introduce el nombre del árbol: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio del árbol: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce la altura del árbol: ");
		double altura = scanner.nextDouble();

		Arbol arbol = new Arbol(nombre, precio, altura);

		floristeria.agregarArbol(arbol);
	}

	private static void agregarFlor(Scanner scanner, Floristeria floristeria) {
		System.out.println("Introduce el nombre de la flor: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio de la flor: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce el color de la flor: ");
		String color = scanner.next();

		Flor flor = new Flor(nombre, precio, color);

		floristeria.agregarFlor(flor);
	}

	private static void agregarDecoracion(Scanner scanner, Floristeria floristeria) {
		System.out.println("Introduce el nombre de la decoración: ");
		String nombre = scanner.nextLine();

		System.out.println("Introduce el precio de la decoración: ");
		double precio = scanner.nextDouble();

		System.out.println("Introduce el material de la decoración (madera o plástico): ");
		String material = scanner.next();

		Decoracion decoracion = new Decoracion(nombre, precio, material);
		
		floristeria.agregarDecoracion(decoracion);
	}

	private static void mostrarStock(Floristeria floristeria) {
		floristeria.mostrarStock();
	}

	private static void retirarArbol(Scanner scanner, Floristeria floristeria) {

		System.out.println("Nombre de arbol a retirar: ");
		String nombre = scanner.nextLine();
		System.out.println("Precio arbol: ");
		double precio = scanner.nextDouble();
		System.out.println("Altura arbol: ");
		double altura = scanner.nextDouble();
		Arbol arbolBuscar = new Arbol(nombre, precio, altura);

		floristeria.retirarArbol(arbolBuscar);

	}

	private static void retirarFlor(Scanner scanner, Floristeria floristeria) {

		System.out.println("Nombre de la flor a retirar: ");
		String nombre = scanner.nextLine();
		System.out.println("Precio flor: ");
		double precio = scanner.nextDouble();
		System.out.println("Color flor: ");
		String color = scanner.nextLine();
		Flor florBuscar = new Flor(nombre, precio, color);

		floristeria.retirarFlor(florBuscar);
	}

	private static void retirarDecoracion(Scanner scanner, Floristeria floristeria) {
		System.out.println("Nombre de la decoracion a retirar: ");
		String nombre = scanner.nextLine();
		System.out.println("Precio decoracion: ");
		double precio = scanner.nextDouble();
		System.out.println("Material decoracion: ");
		String material = scanner.nextLine();
		Decoracion decoracionBuscar = new Decoracion(nombre, precio, material);

		floristeria.retirarDecoracion(decoracionBuscar);
	}

	private static void mostrarStockConCantidades(Floristeria floristeria) {
		floristeria.mostrarStockConCantidades();
	}

	private static void mostrarValorTotal(Floristeria floristeria) {
		floristeria.mostrarValorTotal();
	}
/*
	private static void crearTicketCompra(Scanner scanner, Floristeria floristeria) {
		List<Producto> productosCompra = new ArrayList<>();

		boolean agregarProductos = true;

		while (agregarProductos) {
			System.out.println("Introduce el nombre del producto a comprar (o 'salir' para finalizar): ");
			String nombre = scanner.nextLine();

			if (nombre.equalsIgnoreCase("salir")) {
				agregarProductos = false;
			} else {

				Producto producto = floristeria.buscarProducto(nombre);

				if (producto != null) {
					productosCompra.add(producto);
					System.out.println("Producto añadido al carrito de compra.");
				} else {
					System.out.println("No se encontró el producto en el stock.");
				}
			}
		}

		Ticket ticket = new Ticket(productosCompra);
		comprasAntiguas.add(ticket);

		System.out.println("Ticket de compra:");
		ticket.mostrarTicket();
	}

	private static void mostrarComprasAntiguas() {
		System.out.println("Compras antiguas:");
		for (Ticket ticket : comprasAntiguas) {
			ticket.mostrarTicket();
			System.out.println();
		}
	}

	private static void mostrarGananciasTotales() {
		double gananciasTotales = 0;

		for (Ticket ticket : comprasAntiguas) {
			gananciasTotales += ticket.calcularTotal();
		}

		System.out.println("Ganancias totales: " + gananciasTotales);
	}

*/
}
