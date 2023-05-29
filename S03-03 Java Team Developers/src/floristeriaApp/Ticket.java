package floristeriaApp;

import java.util.List;

public class Ticket {
	
	private List<Producto> productos;
	private static int nroTicket;

    public Ticket(List<Producto> productos) {
        this.productos = productos;
        Ticket.nroTicket += 1;
    }

    public void mostrarTicket() {
        System.out.println("Ticket de compra numero " + Ticket.nroTicket +":");
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
