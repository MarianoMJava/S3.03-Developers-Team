package floristeriaApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Persistencia {
	private static String arbolfile;
	private static String florfile;
	private static String decoracionfile;
	private static String listaTicketsfile;
	
	private   String nombre;
	public Persistencia(String nombre) {
		this.nombre = nombre;
		this.arbolfile  = nombre + "arbol.txt";
		this.florfile   = nombre + "flor.txt";	
		this.decoracionfile   = nombre + "decoracion.txt";	
		this.listaTicketsfile   = nombre + "listatikets.txt";	
	}


	  public static void GrabarArbol( List<Arbol>  arbol ) {
	
	    try {
	      BufferedWriter bw = new BufferedWriter(new FileWriter(arbolfile) );
	     
	      for( Arbol a : arbol ) {
	    	  System.out.println(a.toString());
	          bw.write(  a.getNombre() + ";"  + a.getAltura() + ";" +  a.getPrecio() + ";" + a.getCantidad() + ";" + a.getId() +  "\n");
	      }
	      bw.close();
	    
	    } catch (IOException ioe) {
	      System.out.println("Se ha producido un error de lectura/escritura");
	      System.err.println(ioe.getMessage());
	    }
	  }
	 
	  public static void GrabarFlor( List<Flor>  flor ) {
	
	    try {
	      BufferedWriter bw = new BufferedWriter(new FileWriter(florfile) );
	
	      for( Flor  a :  flor  ) {
	    	  System.out.println(a.toString());
	          bw.write(   a.getNombre() + ";" + a.getColor() + ";" + a.getPrecio() +  ";" + a.getCantidad() +  ";" +  a.getId() + "\n");
	      }
	      bw.close();
		    
		 } catch (IOException ioe) {
		      System.out.println("Se ha producido un error de lectura/escritura");
		      System.err.println(ioe.getMessage());
	     }
	  }
	  public static void GrabarDecoracion( List<Decoracion>  decoracion ) {
	
	    try {
	      BufferedWriter bw = new BufferedWriter(new FileWriter(decoracionfile ));
	
	      for( Decoracion  a :  decoracion  ) {
	    	  System.out.println(a.toString());
		          bw.write(  a.getNombre() + ";" + a.getMaterial() + ";" + a.getPrecio() +  ";" + a.getCantidad() +  ";" +  a.getId() +  "\n");
	      }
	      bw.close();
			    
		 } catch (IOException ioe) {
			      System.out.println("Se ha producido un error de lectura/escritura");
			      System.err.println(ioe.getMessage());
	     }
	  }
	public  static List<Arbol>  LeerArbol() {
 
	        List<Arbol>  arbollista =   new ArrayList<>();
		    try (BufferedReader bf1 = new BufferedReader(new FileReader(arbolfile ))) {
	
		      String linea1 = "";
	          linea1 = bf1.readLine();	      
		      while ( linea1 != null  ) {
		    	  String[] camposlinea  = linea1.split(";");
		    	  
		    	  String nombre = camposlinea[0];
		    	  double precio  =  Double.parseDouble(camposlinea[1]);    
		    	  double altura  =  Double.parseDouble(camposlinea[2]);    
		    	  int  cantidad  =  Integer.parseInt(camposlinea[3]);    
	
		    	  Arbol a =  new Arbol(nombre , precio, altura , cantidad);
		    	  a.setId(Integer.parseInt(camposlinea[4]));
		    	  arbollista.add(a);
		    	  
		    	  linea1 = bf1.readLine();
		    
		      }
		    }
		    catch (IOException ioe) {
		      System.out.println("Se ha producido un error de lectura/escritura");
		      System.err.println(ioe.getMessage());
		      
		    }
	 
		    return arbollista;
	} 
	public  static List<Flor>  LeerFlor() {
	 
	    List<Flor>  flor =   new ArrayList<>();
	    try (BufferedReader bf1 = new BufferedReader(new FileReader(florfile ))) {
	      String linea1 = "";
	      linea1 = bf1.readLine();	      
	      while ( linea1 != null  ) {
	    	  String[] camposlinea  = linea1.split(";");
	
	    	  String nombre = camposlinea[0];
	    	  String color  = camposlinea[1];    
	    	  double precio =  Double.parseDouble(camposlinea[2]);    
	    	  int  cantidad  =  Integer.parseInt(camposlinea[3]);   
	    	  Flor florNueva  =   new Flor(nombre ,  precio,color, cantidad );
	    	  florNueva.setId(Integer.parseInt(camposlinea[4]) );
	    	  flor.add(florNueva);
	    	  linea1 = bf1.readLine();
	    
	      }
	    }
	    catch (IOException ioe) {
	      System.out.println("Se ha producido un error de lectura/escritura");
	      System.err.println(ioe.getMessage());
	    }
	
	    return  flor;
	}
	
		public static  List<Decoracion>  LeerDecoracion() {
			 
		    List<Decoracion>  decoracion =   new ArrayList<>();
		    try (BufferedReader bf1 = new BufferedReader(new FileReader(decoracionfile ))) {
		      String linea1 = "";
		      linea1 = bf1.readLine();	      
		      while ( linea1 != null  ) {
		    	  String[] camposlinea  = linea1.split(";");
		
		    	  String nombre = camposlinea[0];
		    	  String material = camposlinea[1];    
		    	  double precio =  Double.parseDouble(camposlinea[2]);    
		      	  int  cantidad  =  Integer.parseInt(camposlinea[3]);   
		      	  Decoracion decoracionNueva =   new Decoracion(nombre , precio, material, cantidad );
		
		      	  decoracionNueva.setId(Integer.parseInt(camposlinea[4]) );
		      	  decoracion.add( decoracionNueva);
		    	  
		    	  linea1 = bf1.readLine();
		    
		      }
		    }
		    catch (IOException ioe) {
		      System.out.println("Se ha producido un error de lectura/escritura");
		      System.err.println(ioe.getMessage());
		    }
		
		    return  decoracion;
		} 
	
		public  List<Ticket>  LeerTicket() {
 
		    List<Ticket>    listaTickets   =   new ArrayList<>();
        	List<Producto>  producto = new ArrayList<>();

		    System.out.println( "Metodo leer fichero de tickets");
		    try (
		    	
//	           		   System.out.println( a.getNombre() + ";"  + a.getPrecio() +  ";" + a.getCantidad() +  ";" +  a.getId() + "\n") ;	    		
		      BufferedReader bf1 = new BufferedReader(new FileReader(listaTicketsfile))) {
		      String linea1 = "";
		      linea1 = bf1.readLine();	 
		      Ticket tickeId = new Ticket(producto);
	    	  double precio 	=  0;    
	      	  int  cantidad 	=  0;   
	      	  int   productoId  =  0;
		      while ( linea1 != null  ) {
		    	  String[] camposlinea  = linea1.split(";");
		
		    	  String nombre = camposlinea[0];
 
		      	  if ( nombre.equals("Ticket") ) {

		        		productoId	=  Integer.parseInt(camposlinea[1]);    
			      		System.out.println("ticket numero " + productoId);
			      		listaTickets.add(new Ticket( producto, productoId ));  
			        	producto = new ArrayList<>();
		      	  }else {

		      		  
			    	  precio 	    =  Double.parseDouble(camposlinea[1]);    
			      	  cantidad    	=  Integer.parseInt(camposlinea[2]);   
			      	  productoId    =  Integer.parseInt(camposlinea[3]);
			      	  System.out.println("Producto -->" + precio + "  " + cantidad + "  " +  productoId );
			      	  Producto p  = new Producto(nombre, precio, productoId, cantidad);
			      	  producto.add(p);
		      	  }
 
		    	  linea1 = bf1.readLine();
		    	
		    
		      }
		    }
		    catch (IOException ioe) {
		      System.out.println("Se ha producido un error de lectura/escritura");
		      System.err.println(ioe.getMessage());
		    }
		 
		    
		    return  listaTickets;
		} 
 
	
	public static  void  GrabarTicket( List<Ticket>  listaticket ) {
		 
    	System.out.println(" grabar ticket N : "+ listaticket.size() );
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter(listaTicketsfile) );
	
	        for( Ticket ticket :  listaticket  ) {
	  
	        	List<Producto>  productos   = ticket.getProductos();

	        	System.out.println("Ticket :  " + ticket.getIdTicket()  );
	        	for( Producto a :  productos) {
	  	        		bw.write(   a.getNombre() + ";"  + a.getPrecio() +  ";" + a.getCantidad() +  ";" +  a.getId() + "\n");

	           		   System.out.println( a.getNombre() + ";"  + a.getPrecio() +  ";" + a.getCantidad() +  ";" +  a.getId() + "\n") ;
	        	}
	     		bw.write( "Ticket" + ";" + ticket.getIdTicket() + "\n" );       	
	        }
	        bw.close();
	  	    
	  	 } catch (IOException ioe) {
	  	      System.out.println("Se ha producido un error de lectura/escritura");
	  	      System.err.println(ioe.getMessage());
	     }
	}
	
	}




 