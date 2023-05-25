package floristeriaApp;

import java.io.Serializable;

public class Producto implements Serializable{
	
	   private String nombre;
	    private double precio;

	    public Producto(String nombre, double precio) {
	        this.nombre = nombre;
	        this.precio = precio;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public double getPrecio() {
	        return precio;
	    }
	}


