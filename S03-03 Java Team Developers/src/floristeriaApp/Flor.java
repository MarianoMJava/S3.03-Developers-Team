package floristeriaApp;

import java.io.Serializable;

public class Flor extends Producto implements Serializable{

	   private String color;

	    public Flor(String nombre, double precio, String color, int cantidad) {
	        super(nombre, precio, getContadorId(), cantidad);
	        this.color = color;
	    }

	    public String getColor() {
	        return color;
	    }

	    @Override
	    public String toString() {
	        return "\nId: "+getCantidad()+" Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Color: " + color;
	    }
	
}
