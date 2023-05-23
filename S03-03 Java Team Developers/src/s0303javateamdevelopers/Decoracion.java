package s0303javateamdevelopers;

public class Decoracion extends Producto {
	
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
        return "Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Material: " + material;
    }

}
