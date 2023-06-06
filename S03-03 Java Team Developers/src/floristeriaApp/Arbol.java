package floristeriaApp;

import java.io.Serializable;

public class Arbol extends Producto{

	 private double altura;

	    public Arbol(String nombre, double precio, double altura, int cantidad) {
			super(nombre, precio, cantidad);
	        this.altura = altura;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    @Override
	    public String toString() {
	        return "\nId: "+getId()+" / Nombre: " + getNombre() + " / Precio: " + getPrecio() + " / Altura: " + altura +" / Cantidad Stock: "+getCantidad();
	    }
	
}
