package floristeriaApp;

import java.io.Serializable;

public class Decoracion extends Producto implements Serializable {
	
	private String material;

    public Decoracion(String nombre, double precio, String material) {
        super(nombre, precio);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "\nNombre: " + getNombre() + ", Precio: " + getPrecio() + ", Material: " + material;
    }

}
