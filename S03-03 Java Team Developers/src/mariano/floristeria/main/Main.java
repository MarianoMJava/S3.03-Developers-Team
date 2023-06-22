package mariano.floristeria.main;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

 
import mariano.floristeria.beans.Arbol;
import mariano.floristeria.beans.Decoracion;
import mariano.floristeria.beans.Flor;
import mariano.floristeria.beans.Producto;
import mariano.floristeria.beans.Ticket;
import mariano.floristeria.persistencia.mysqJdbc.*;
import mariano.floristeria.persistencia.service.*;
import mariano.floristeria.proceso.ComprobarExistencia;
import mariano.floristeria.proceso.Floristeria;
import mariano.floristeria.proceso.MensajesFloristeria;
import mariano.floristeria.persistencia.mysqJdbc.ContextJDBC;
import mariano.floristeria.persistencia.mysqJdbc.*;
public class Main {
	
	
	static  List<Ticket> comprasAntiguas = new ArrayList<>();
	

	
	public static void main(String[] args) throws IOException {
		
		System.out.	println("------Iniciando Floristeria  3.0 ---------  ");

		System.out.	println("Introduzca el nombre de la floristeria :  ");
		Scanner scanner = new Scanner(System.in);
		   
		Floristeria floristeria = crearCargarFloristeria(scanner);
		boolean salir = false;
		System.out.println( floristeria.getNombre() );

 
		ConfiguracionPropiedades  configuracionpropiedades = new ConfiguracionPropiedades();

		try {
			  configuracionpropiedades.LeePropiedades("Config.properties");
		}
		catch (IOException  e) {
			// TODO: handle exception
			System.out.println( "error propiedades " + e.getMessage());
		}
			
 	  	//
		// Cargamos la aplicacion segun la persistencia 
		//
		Persistencia  persistencia = null;
		PersistenciaJDBC  persistenciaMysql  = null;

		// Leemos los arboles creados en el fichero  y lo inyectamos en la floristeria
		if (configuracionpropiedades.getPersistencia().equals("fichero") ) {
			persistencia = new Persistencia( floristeria.getNombre() );
			floristeria.setArboles( persistencia.LeerArbol());
			floristeria.setFlores( persistencia.LeerFlor());
			floristeria.setDecoraciones(persistencia.LeerDecoracion());
			comprasAntiguas  = persistencia.LeerTicket();
		}
		if (configuracionpropiedades.getPersistencia().equals("mysql") ) {
			persistenciaMysql = new PersistenciaJDBC( configuracionpropiedades.ConectionDBMysql()  , floristeria.getNombre() );
 
			floristeria.setArboles( persistenciaMysql.LeerArbol());
//			floristeria.setFlores( persistencia.LeerFlor());
//			floristeria.setDecoraciones(persistencia.LeerDecoracion());
//			comprasAntiguas  = persistencia.LeerTicket();
		}		
		
		while (!salir) {
			System.out.println("Pulse enter para continuar");
			String  pausa = scanner.nextLine();
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
						comprasAntiguas.add(crearTicketCompra(scanner, floristeria));
						break;
					case 11:
						mostrarComprasAntiguas(comprasAntiguas);
						break;
					case 12:
						mostrarGananciasTotales(comprasAntiguas);
						break;
					case 13:

						switch(configuracionpropiedades.getPersistencia() ) {
						  case "ficheros":
								guardarfloristeriaFile(persistencia , floristeria);

						    break;
						  case "mysql":
						    // code block
							  
							  
   							    persistenciaMysql.GrabarArbol(floristeria.getArboles());
//								persistencia.GrabarFlor(floristeria.getFlores());
//								persistencia.GrabarDecoracion(floristeria.getDecoraciones());
//								persistencia.GrabarTicket(comprasAntiguas);  
							  
							  
							  
						    break;
						  default:
						    // code block
						}
						break;
 					case 14:
						salir = true;
						System.out.println("Saliendo...");
						break;
					default:
            System.out.println("Opcion invalida. Introduce un numero del 1 al 14.");
            break;
						
					}
					
				}
				scanner.close();

		

	}
			
			
    private static void mostrarMenu() {
        System.out.println("----- Menu -----");
        System.out.println("0. Crear/Cargar floristeria");
        System.out.println("1. Anadir Arbol");
        System.out.println("2. Anadir Flor");
        System.out.println("3. Anadir Decoracion");
        System.out.println("4. Mostrar Stock");
        System.out.println("5. Retirar Arbol");
        System.out.println("6. Retirar Flor");
        System.out.println("7. Retirar Decoracion");
        System.out.println("8. Mostrar Stock con Cantidades");
        System.out.println("9. Mostrar Valor Total");
        System.out.println("10. Crear Ticket de Compra");
        System.out.println("11. Mostrar Compras Antiguas");
        System.out.println("12. Mostrar Ganancias Totales");
        System.out.println("13. Guardar (Para registrar cambios y cambiar de floristeria)");
        System.out.println("14. Salir)");
        System.out.println("Elige una opcion: ");
    }
			

		    public static Floristeria crearCargarFloristeria(Scanner scanner) {

            String nombre;

            Boolean existeFloristeria = null;

            System.out.print("Ingrese el nombre de la floristeria: ");

            nombre = scanner.nextLine();

            existeFloristeria = ComprobarExistencia.comprobarFloristeria(nombre);

            Floristeria floristeria = new Floristeria(nombre);

            if (existeFloristeria) {

                System.out.println("La floristeria ha sido cargado correctamente.");

            }

            return floristeria;

    }
 
//			private static void agregarArbol(Scanner scanner, Floristeria floristeria) {

				public static  void agregarArbol(Scanner scanner , Floristeria floristeria) {
				
				if (floristeria == null) {
					System.out.println("Por favor, primero indicar floristeria o crearla: ");
					floristeria = crearCargarFloristeria(scanner);
					
				}
				
				System.out.println("Introduce el nombre del ÃƒÂ¡rbol: ");
				String nombre = "";
				try {
					nombre = scanner.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Introduce el precio del ÃƒÂ¡rbol: ");
				double precio = scanner.nextDouble();
				
				System.out.println("Introduce la altura del ÃƒÂ¡rbol: ");
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
				System.out.println("Introduce el nombre de la decoraciÃƒÂ³n: ");
				String nombre = scanner.nextLine();
				
				System.out.println("Introduce el precio de la decoraciÃƒÂ³n: ");
				double precio = scanner.nextDouble();
				
				System.out.println("Introduce el material de la decoraciÃƒÂ³n (madera o plÃƒÂ¡stico): ");
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
				
//				SerializarGuardar.serializar(floristeria);
				
			}
			
			private static void retirarFlor(Scanner scanner, Floristeria floristeria) {
				
				mostrarStock(floristeria);
				
				System.out.println("Ingrese el id del producto a retirar: ");
				int idRetirar = scanner.nextInt();
				
				floristeria.retirarFlor(idRetirar);
				
//				SerializarGuardar.serializar(floristeria);
				
			}
			
			private static void retirarDecoracion(Scanner scanner, Floristeria floristeria) {
				
				mostrarStock(floristeria);
				
				System.out.println("Ingrese el id del producto a retirar: ");
				int idRetirar = scanner.nextInt();
				
				floristeria.retirarDecoracion(idRetirar);
				
//				SerializarGuardar.serializar(floristeria);
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
			
 
			public  static Ticket  crearTicketCompra(Scanner scanner, Floristeria floristeria) {
 
				List<Producto> productosCompra = new ArrayList<>();
				
				Producto  productoTicket = null; 
				int productoID;
				boolean agregarProductos = true;

				MensajesFloristeria  mensajesFloristeria = new MensajesFloristeria();
				mensajesFloristeria.setCodigoerrores(0);
				mensajesFloristeria.setMensaje("");
				while (agregarProductos) {

					mostrarStock(floristeria);

					System.out.println("Introduce el ID del producto a comprar ( 0 para finalizar): ");
					System.out.println("Id del producto: ");
					productoID = scanner.nextInt();
					int productoCantidad = 0;
					if (productoID !=  0   ) {
						System.out.println("Cantidad  producto: ");
						productoCantidad = scanner.nextInt();
					}
					if (productoID  == 0   )	{
						agregarProductos = false;
		
					} else {
		
						 mensajesFloristeria =  floristeria.buscarProductoId(productoID, productoCantidad);
		 
						if ( mensajesFloristeria.getCodigoerrores() == 0 ) {
						    productoTicket  =  floristeria.AñadirTickedProductoId(productoID, productoCantidad);
				  			productosCompra.add(productoTicket); 
							System.out.println("Producto añadido al carrito de compra.");
						} else {
							System.out.println("\nMensaje   n : " + mensajesFloristeria.getCodigoerrores());
							System.out.println(mensajesFloristeria.getMensaje() ) ;
						}
					}
				}

	 
		LocalDateTime myDateObj = LocalDateTime.now();
   	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
 	    String formattedDate = myDateObj.format(myFormatObj);
	 
		Ticket ticket = new Ticket(productosCompra);
		ticket.setFechaHoraAlta( formattedDate.toString());

		System.out.println("Ticket de compra:");
		ticket.mostrarTicket();
		return ticket;
		
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
	public static  void guardarfloristeriaFile(Persistencia persistencia, Floristeria floristeria ){
 
				persistencia.GrabarArbol(floristeria.getArboles());
				persistencia.GrabarFlor(floristeria.getFlores());
				persistencia.GrabarDecoracion(floristeria.getDecoraciones());
				persistencia.GrabarTicket(comprasAntiguas);  
	}
	
}
