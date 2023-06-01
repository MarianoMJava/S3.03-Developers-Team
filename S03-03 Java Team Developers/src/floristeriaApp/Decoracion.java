package floristeriaApp;

import java.io.Serializable;

public class Decoracion extends Producto implements Serializable {
	
	private String material;

    public Decoracion(String nombre, double precio, String material, int cantidad) {
        super(nombre, precio, getContadorId(), cantidad);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "\nId: "+getCantidad()+" Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Material: " + material;
    }

}
