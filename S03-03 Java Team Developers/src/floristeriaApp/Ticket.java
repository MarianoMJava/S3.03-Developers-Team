package floristeriaApp;

import java.util.List;

public class Ticket {
	
	private List<Producto> productos;

    public Ticket(List<Producto> productos) {
        this.productos = productos;
    }

    public void mostrarTicket() {
        System.out.println("Ticket de compra:");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio());
        }
        System.out.println("Total: " + calcularTotal());
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

}
