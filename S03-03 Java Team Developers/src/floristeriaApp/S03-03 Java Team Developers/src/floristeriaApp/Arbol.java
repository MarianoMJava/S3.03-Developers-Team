package floristeriaApp;

import java.io.Serializable;

public class Arbol extends Producto implements Serializable{

	 private double altura;

	    public Arbol(String nombre, double precio, double altura) {
	        super(nombre, precio);
	        this.altura = altura;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    @Override
	    public String toString() {
	        return "Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Altura: " + altura;
	    }
	
}
