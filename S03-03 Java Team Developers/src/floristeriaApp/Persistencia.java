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
	
	private   String nombre;
	public Persistencia(String nombre) {
		this.nombre = nombre;
		this.arbolfile  = nombre + "arbol.txt";
		this.florfile   = nombre + "flor.txt";	
		this.decoracionfile   = nombre + "decoracion.txt";	
	}


  public static void GrabarArbol( List<Arbol>  arbol ) {

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(arbolfile) );
     
      for( Arbol a : arbol ) {
    	  System.out.println(a.toString());
          bw.write( a.getNombre() + ";"  + a.getAltura() + ";" +  a.getPrecio() + ";" + a.getCantidad() + "\n");
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
          bw.write( a.getNombre() + ";" + a.getColor() + ";" + a.getPrecio() +  ";" + a.getCantidad() +  "\n");
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
	          bw.write(  a.getNombre() + ";" + a.getMaterial() + ";" + a.getPrecio() +  ";" + a.getCantidad()  +  "\n");
      }
      bw.close();
		    
	 } catch (IOException ioe) {
		      System.out.println("Se ha producido un error de lectura/escritura");
		      System.err.println(ioe.getMessage());
     }
  }
public  static List<Arbol>  LeerArbol() {
		System.out.println("leyendo archivos ");
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
    	  flor.add(  new Flor(nombre ,  precio,color, cantidad ));
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
    	  decoracion.add(  new Decoracion(nombre , precio, material, cantidad ));
    	  linea1 = bf1.readLine();
    
      }
    }
    catch (IOException ioe) {
      System.out.println("Se ha producido un error de lectura/escritura");
      System.err.println(ioe.getMessage());
    }

    return  decoracion;
} 
}


 