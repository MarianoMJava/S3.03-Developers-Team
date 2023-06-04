package floristeriaApp;

import java.io.Serializable;

 

 
public class Producto implements Serializable {

    private String nombre;
    private double precio;
    private static int contadorId = 0;
    private int cantidad;
    private int id = 0;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

 
    public Producto(String nombre, double precio, int contadorId, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;

        this.cantidad = cantidad;
        this.id = contadorId;
        
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static int getContadorId() {         contadorId += 1; return contadorId;  }

    public int getCantidad() {  return cantidad;  }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
