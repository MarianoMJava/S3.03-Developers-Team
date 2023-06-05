package floristeriaApp;

public class Producto {

    private String nombre;
    private double precio;
    private static int contadorId = 0;
    private int cantidad;
    private int id;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id =generarIdUnico();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
/*
    public static int getContadorId() {
        return contadorId;
    }
*/
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private static synchronized int generarIdUnico(){
        return contadorId++;
    }
}
