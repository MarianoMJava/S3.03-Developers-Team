package s0303javateamdevelopers;

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

public class Floristeria implements Serializable{

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
		
			try {
				File myTxt = new File(nombre+".txt");
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
    // AGREGAR

	public void agregarArbol(Arbol arbol) {
		
		Floristeria floristeria;
		
		try {
			InputStream file = new FileInputStream(this.nombre+".txt");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			
			floristeria = (Floristeria)input.readObject();
			
			System.out.println(floristeria);
		      
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
        
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
    
    //  RETIRAR

    public void retirarArbol(Arbol arbolBuscar) {
    	
    	Boolean encontrado = false;
    	
    	for(int i = 0 ; i<arboles.size() && encontrado == false; i++) {
    		if (arbolBuscar.equals(arboles.get(i))) {
    			arboles.remove(arboles.get(i));
    			valorTotal -= arboles.get(i).getPrecio();
    			encontrado=true;
    		}
    	}
    	
    	if(encontrado == true) {
    		System.out.println("Arbol eliminado");
    	}else {
    		System.out.println("El arbol no existe en la base de datos");
    	}
    	
    }

    public void retirarFlor(Flor florBuscar) {
  	
    	Boolean encontrado = false;
    	
    	for(int i = 0 ; i<flores.size() && encontrado == false; i++) {
    		if (florBuscar.equals(flores.get(i))) {
    			flores.remove(flores.get(i));
    			valorTotal -= flores.get(i).getPrecio();
    			encontrado=true;
    		}
    	}
    	
    	if(encontrado == true) {
    		System.out.println("Flor eliminada");
    	}else {
    		System.out.println("La flor no existe en la base de datos");
    	}
    }

    public void retirarDecoracion(Decoracion decoracionBuscar) {
    	
    	Boolean encontrado = false;
    	
    	for(int i = 0 ; i<decoraciones.size() && encontrado == false; i++) {
    		if (decoracionBuscar.equals(decoraciones.get(i))) {
    			decoraciones.remove(decoraciones.get(i));
    			valorTotal -= decoraciones.get(i).getPrecio();
    			encontrado=true;
    		}
    	}
    	
    	if(encontrado == true) {
    		System.out.println("Decoracion eliminada");
    	}else {
    		System.out.println("La decoracion no existe en la base de datos");
    	}
    }
    
    //  MOSTRAR

    public void mostrarStock() {
        System.out.println("Árboles:");
        for (Arbol arbol : arboles) {
            System.out.println(arbol);
        }
        System.out.println("Flores:");
        for (Flor flor : flores) {
            System.out.println(flor);
        }
        System.out.println("Decoraciones:");
        for (Decoracion decoracion : decoraciones) {
            System.out.println(decoracion);
        }
    }

    public void mostrarStockConCantidades() {
        System.out.println("Stock de la floristería:");
        System.out.println("Árboles: " + arboles.size());
        System.out.println("Flores: " + flores.size());
        System.out.println("Decoraciones: " + decoraciones.size());
    }

    public void mostrarValorTotal() {
        System.out.println("Valor total del stock: " + valorTotal);
    }

    
    //   TICKET
    
    public void crearTicketCompra(List<Producto> productos) {
        Ticket ticket = new Ticket(productos);
        ticket.mostrarTicket();
    }
    
    
    //  HISTORICO COMPRAS

    public void mostrarComprasAntiguas(List<Ticket> tickets) {
        System.out.println("Compras antiguas:");
        for (Ticket ticket : tickets) {
            ticket.mostrarTicket();
        }
    }
    
    //   GANANCIAS

    public double calcularGanancias(List<Ticket> tickets) {
        double ganancias = 0;
        for (Ticket ticket : tickets) {
            ganancias += ticket.calcularTotal();
        }
        return ganancias;
    }
	
}
