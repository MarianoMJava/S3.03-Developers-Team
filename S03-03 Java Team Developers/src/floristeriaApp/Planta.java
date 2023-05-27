package floristeriaApp;


public class Planta extends Producto{

	 private double altura;

	    public Planta(String nombre, double precio, double altura) {
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
