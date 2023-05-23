package floristeriaApp;

import java.util.Scanner;

import s0303javateamdevelopers.Floristeria;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		boolean salir = false;

		while (!salir) {
			mostrarMenu();

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 0:
				crearFloristeria(scanner);
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
				mostrarComprasAntiguas();
				break;
			case 12:
				mostrarGananciasTotales();
				break;
			case 13:
				salir = true;
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
	
	public static void crearFloristeria(Scanner scanner) {
		
		String nombre;

		System.out.print("Ingrese el nombre de la floristeria: ");

		nombre = scanner.nextLine();

		Floristeria floristeria = new Floristeria(nombre);
				
	}
	

	}


