package floristeriaApp;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private double precio;
    private static int contadorId = 0;
    private int cantidad;

    public Producto(String nombre, double precio, int contadorId, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        contadorId += 1;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static int getContadorId() {  return contadorId;  }

    public int getCantidad() {  return cantidad;  }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}


