package floristeriaApp;

import java.io.Serializable;

public class Arbol extends Producto implements Serializable{

	 private double altura;

	    public Arbol(String nombre, double precio, double altura, int cantidad) {
	        super(nombre, precio, getContadorId() , cantidad);
	        this.altura = altura;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    @Override
	    public String toString() {
	        return "\nId: "+getCantidad()+"Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Altura: " + altura;
	    }
	
}
