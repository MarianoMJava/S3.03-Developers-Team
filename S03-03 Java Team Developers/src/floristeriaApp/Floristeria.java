package floristeriaApp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floristeria implements Serializable {
    private List<Arbol> arboles;
    private List<Flor> flores;
    private List<Decoracion> decoraciones;
    private double valorTotal;
    private String nombre;

    public List<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(List<Arbol> arboles) {
        this.arboles = arboles;
    }

    public void setFlores(List<Flor> flores) {
        this.flores = flores;
    }

    public void setDecoraciones(List<Decoracion> decoraciones) {
        this.decoraciones = decoraciones;
    }

    public Floristeria(String nombre) {
        this.nombre = nombre;
        this.arboles = new ArrayList<>();
        this.flores = new ArrayList<>();
        this.decoraciones = new ArrayList<>();
        this.valorTotal = 0;

    }

    // AGREGAR
    public List<Arbol> getArbol() {
        return arboles;
    }


    public void agregarArbol(Arbol arbol) {

        arboles.add(arbol);
        valorTotal += arbol.getPrecio();

    }

    public void agregarFlor(Flor flor) {

        flores.add(flor);
        valorTotal += flor.getPrecio();

    }

    public void agregarDecoracion(Decoracion decoracion) {

        decoraciones.add(decoracion);
        valorTotal += decoracion.getPrecio();

    }

    // RETIRAR

    public void retirarArbol(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.arboles.get(idRetirar).getPrecio();

            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.arboles.get(idRetirar).setCantidad(this.arboles.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }


        if (encontrado) {
            System.out.println("Arbol eliminado");
            System.out.println("Quedan restantes en stock: "+this.arboles.get(idRetirar).getCantidad());
        } else {
            System.out.println("El arbol no existe en la base de datos");
        }

    }

    public void retirarFlor(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.flores.get(idRetirar).getPrecio();

            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.flores.get(idRetirar).setCantidad(this.flores.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }


        if (encontrado) {
            System.out.println("Flores eliminadas");
            System.out.println("Quedan restantes en stock: "+this.flores.get(idRetirar).getCantidad());
        } else {
            System.out.println("El articulo ingresado no existe en la base de datos");
        }
    }

    public void retirarDecoracion(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        if (Producto.getContadorId() <= idRetirar) {

            valorTotal -= this.arboles.get(idRetirar).getPrecio();

            System.out.print("Ingrese cantidad a retirar de " + arboles.get(idRetirar).getNombre() + " :");
            int cantidadRetirar = sc.nextInt();
            this.decoraciones.get(idRetirar).setCantidad(this.decoraciones.get(idRetirar).getCantidad() - cantidadRetirar);

            encontrado = true;
        }

        if (encontrado) {
            System.out.println("Decoraciones eliminadas");
            System.out.println("Quedan restantes en stock: "+this.decoraciones.get(idRetirar).getCantidad());
        } else {
            System.out.println("El articulo no existe en la base de datos");
        }
    }


    // MOSTRAR

    public void mostrarStock() {

        Scanner sc = new Scanner(System.in);

        try {

            FileInputStream fileIn = new FileInputStream(this.nombre + ".txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Floristeria floristeriaMostrar = (Floristeria) objectIn.readObject();

            System.out.println(floristeriaMostrar);

            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el estado de la floristerÃ­a: " + e.getMessage());
        }

        sc.close();
    }

    public void mostrarStockConCantidades() {
        System.out.println("Stock de la floristerÃ­a:");
        System.out.println("Ã�rboles: " + arboles.size() + " unidades");
        System.out.println("Flores: " + flores.size() + " unidades");
        System.out.println("Decoraciones: " + decoraciones.size() + " unidades");
    }

    public void mostrarValorTotal() {
        System.out.println("Valor total del stock: " + valorTotal);
    }

    // TICKET

    public void crearTicketCompra(List<Producto> productos) {
        Ticket ticket = new Ticket(productos);
        ticket.mostrarTicket();
    }

    // HISTORICO COMPRAS

    public void mostrarComprasAntiguas(List<Ticket> tickets) {
        System.out.println("Compras antiguas:");
        for (Ticket ticket : tickets) {
            ticket.mostrarTicket();
        }
    }

    // GANANCIAS

    public double calcularGanancias(List<Ticket> tickets) {
        double ganancias = 0;
        for (Ticket ticket : tickets) {
            ganancias += ticket.calcularTotal();
        }
        return ganancias;
    }

    public Producto buscarProducto(String nombre, double precio) {
        System.out.println("floristeria.BuscarProducto " + nombre + " " + precio);
        Producto p = null;
        for (Producto producto : arboles) {
            System.out.println("mis arboles :  " + producto.getNombre());
            if (producto.getNombre().equals(nombre)) {
                p = producto;
            }
        }
        return p;
    }

    @Override
    public String toString() {
        return "Floristeria\n" + nombre + "\nArboles " + arboles + "\nFlores=" + flores + "\nDecoraciones "
                + decoraciones + "\nValor Total=" + valorTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
