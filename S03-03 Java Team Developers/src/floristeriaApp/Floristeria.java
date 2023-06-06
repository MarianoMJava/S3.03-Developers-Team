package floristeriaApp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	MensajesFloristeria  mensajesFloristeria = new MensajesFloristeria();
    public List<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(List<Arbol> arboles) {
        this.arboles = arboles;
    }

    public void setFlores(List<Flor> flores) {
        this.flores = flores;
    }
    
    public List<Flor>  getFlores() {
        return  flores;
    }
    
    public void setDecoraciones(List<Decoracion> decoraciones) {
        this.decoraciones = decoraciones;
    }
    public List<Decoracion>  getDecoraciones() {
        return decoraciones;
    }
    public Floristeria(String nombre) {
        this.nombre = nombre;
        this.arboles = new ArrayList<>();
        this.flores = new ArrayList<>();
        this.decoraciones = new ArrayList<>();
        this.valorTotal = 0;

    }

    // AGREGAR
    public List<Arbol> getArbol() {
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

    public void retirarArbol(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.arboles.get(idRetirar).getPrecio();

            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.arboles.get(idRetirar).setCantidad(this.arboles.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }


        if (encontrado) {
            System.out.println("Arbol eliminado");
            System.out.println("Quedan restantes en stock: "+this.arboles.get(idRetirar).getCantidad());
        } else {
            System.out.println("El arbol no existe en la base de datos");
        }

    }

    public void retirarFlor(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.flores.get(idRetirar).getPrecio();

            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.flores.get(idRetirar).setCantidad(this.flores.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }


        if (encontrado) {
            System.out.println("Flores eliminadas");
            System.out.println("Quedan restantes en stock: "+this.flores.get(idRetirar).getCantidad());
        } else {
            System.out.println("El articulo ingresado no existe en la base de datos");
        }
    }

    public void retirarDecoracion(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.arboles.get(idRetirar).getPrecio();
            
            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.decoraciones.get(idRetirar).setCantidad(this.decoraciones.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }

        if (encontrado) {
            System.out.println("Decoraciones eliminadas");
            System.out.println("Quedan restantes en stock: "+this.decoraciones.get(idRetirar).getCantidad());
        } else {
            System.out.println("El articulo no existe en la base de datos");
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

        sc.close();
    }

    public void mostrarStockConCantidades() {
    	Arbol arbol;
    	Flor  flor;
    	Decoracion decoracion;
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
    	
       	System.out.println(" 	");
    	System.out.println("Stock de la floristeria:");
       	System.out.println(" 	");

    	System.out.println("Arboles: " + arboles.size() + " unidades");
        for(Arbol a : arboles ) {
        	System.out.println(a.toString());
        }
       	System.out.println(" 	");
        System.out.println("\nFlores: " + flores.size() + " unidades");
        for(Flor  a : flores  ) {
        	System.out.println(a.toString());
        }
       	System.out.println(" 	");
        System.out.println("\nDecoraciones: " + decoraciones.size() + " unidades");
        for(Decoracion  a :  decoraciones  ) {
        	System.out.println(a.toString());
        }

    
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
    
    public Producto buscarProducto(String nombre, double precio) {
        System.out.println("floristeria.BuscarProducto " + nombre + " " + precio);
        Producto p = null;
        for (Producto producto : arboles) {
            System.out.println("mis arboles :  " + producto.getNombre());
            if (producto.getNombre().equals(nombre)) {
                p = producto;
            }
        }
        return p;
    }

    public MensajesFloristeria buscarProductoId(int productoID ,int productoCant ) {
 
    	String mensaje = "KO";
    	mensajesFloristeria.setMensaje("");
    	mensajesFloristeria.setCodigoerrores(0);
 
 
        Producto productoTicket = null;
        
        // Mejorara ---> Hacer un método genérico o la clase 

        for (int i=0;i<arboles.size() && mensaje.equals("KO") ;i++ ) {
            if (arboles.get(i).getId() ==  productoID ) {
            	mensaje = this.Validaciones(arboles.get(i), productoCant);
            }	
         }
        for (int i=0;i<flores.size() && mensaje.equals("KO");i++ ) {
            if (flores.get(i).getId() ==  productoID ) {
            	mensaje = this.Validaciones(flores.get(i), productoCant);
            }
        }
        for (int i=0;i<decoraciones.size() && mensaje.equals("KO") ;i++ ) {
            if (decoraciones.get(i).getId() ==  productoID ) {
            	mensaje = this.Validaciones(decoraciones.get(i), productoCant);
            }
        }
        if ( mensaje  == "KO" ) {
        	mensajesFloristeria.setMensaje("producto no encontrado.Liste el Stock para ver el catalogo disponible");
        	mensajesFloristeria.setCodigoerrores(1);
        }
        return mensajesFloristeria;   
    }
    
    public String  Validaciones(Producto producto, int cantidades) {
    	String mensajes = "";        
    	if ( producto.getCantidad()  == 0 ) {
        	mensajesFloristeria.setMensaje("Disculpe actualmente no hay stock de este producto.");
        	mensajesFloristeria.setCodigoerrores(2);

        }
        if ( producto.getCantidad() <  cantidades ) {
        	mensajesFloristeria.setMensaje("Solo tenemos " +  producto.getCantidad() + " disponibles en Stock");
        	mensajesFloristeria.setCodigoerrores(3);
   
        }
        if ( producto.getCantidad() >=  cantidades ) {
        	mensajes =  "OK";

        }
		return mensajes;
      }
    
    public Producto AñadirTickedProductoId(int productoID ,int productoCant ) {

	  	String mensaje = "KO";
	  	mensajesFloristeria.setMensaje("");
	  	mensajesFloristeria.setCodigoerrores(0);
  	
	  	System.out.println("floristeria BuscarProducto por id ----> " + productoID);
	  	Producto productoTicket = null;
	  	
	    for (int i=0;i<arboles.size() && mensaje.equals("KO") ;i++ ) {
 	          if (arboles.get(i).getId() ==  productoID) {
	        	    mensaje = "OK";
	        	    // *** Actualizamos el Stock ***
 	        	  	arboles.get(i).setCantidad( arboles.get(i).getCantidad() - productoCant    );
	                productoTicket = new Producto(arboles.get(i).getNombre(), arboles.get(i).getPrecio() , arboles.get(i).getId() , productoCant  ); 
	          }	
	    }
	    for (int i=0;i<flores.size() && mensaje.equals("KO");i++ ) {
	          if (flores.get(i).getId() ==  productoID ) {
	        	   mensaje = "OK";
          	       // *** Actualizamos el Stock ***
	        	  flores.get(i).setCantidad( flores.get(i).getCantidad() - productoCant   );
	              productoTicket = new Producto(flores.get(i).getNombre(), flores.get(i).getPrecio() , flores.get(i).getId() , productoCant  ); 
	          }
	    }
	    for (int i=0;i<decoraciones.size() && mensaje.equals("KO") ;i++ ) {
	          if (decoraciones.get(i).getId() ==  productoID) {
	        	  mensaje = "OK";
	        	  // *** Actualizamos el Stock ***
	        	  decoraciones.get(i).setCantidad( decoraciones.get(i).getCantidad() - productoCant   );
                  productoTicket = new Producto(decoraciones.get(i).getNombre(), decoraciones.get(i).getPrecio() , decoraciones.get(i).getId() , productoCant ); 
	          }
	    }
 
 
      return productoTicket;
  }  
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
