package mariano.floristeria.beans;

import java.io.Serializable;

public class Decoracion extends Producto{
	
	private String material;

    public Decoracion(String nombre, double precio, String material, int cantidad) {
        super(nombre, precio, cantidad);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "\nId: "+getId()+" / Nombre: " + getNombre() + " / Precio: " + getPrecio() + " / Material: " + material +" / Cantidad Stock: "+getCantidad();
    }

}
