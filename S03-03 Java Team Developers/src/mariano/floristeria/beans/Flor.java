package mariano.floristeria.beans;

public class Flor extends Producto{

	   private String color;

	    public Flor(String nombre, double precio, String color, int cantidad) {
	        super(nombre, precio, cantidad);
	        this.color = color;
	    }

	    public String getColor() {
	        return color;
	    }

	    @Override
	    public String toString() {
	        return "\nId: "+getId()+" / Nombre: " + getNombre() + " / Precio: " + getPrecio() + " / Color: " + color + " / Cantidad Stock: "+getCantidad();
	    }
	
}
