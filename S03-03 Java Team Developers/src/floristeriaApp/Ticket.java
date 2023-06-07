package floristeriaApp;

import java.util.List;

public class Ticket {
	

	private List<Producto> productos;
	private static int nroTicket = 0;
	private int IdTicket;
	
	public Ticket(List<Producto> productos) {
        this.productos = productos;
        IdTicket = generarNroTicket();
    }	
	public Ticket(List<Producto> productos, int Id) {
        this.productos = productos;
        IdTicket = Id;
    }
	public int getIdTicket() {
		return IdTicket;
	}
	public void setIdTicket(int idTicket) {
		IdTicket = idTicket;
	};

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public static int getNroTicket() {
		return nroTicket;
	}

	public static void setNroTicket(int nroTicket) {
		Ticket.nroTicket = nroTicket;
	}
    private static synchronized int generarNroTicket(){
        return    Ticket.nroTicket += 1;
    }

    public void mostrarTicket() {
        System.out.println("Ticket de compra numero " + this.IdTicket +":");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Cantidad " + producto.getCantidad() );
        }
        System.out.println("Total: " + calcularTotal());
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

}
