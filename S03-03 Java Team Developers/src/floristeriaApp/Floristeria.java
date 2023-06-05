package floristeriaApp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floristeria implements Serializable {
    private List<Arbol> arboles;
    private List<Flor> flores;
    private List<Decoracion> decoraciones;
    private double valorTotal;
    private String nombre;
    MensajesFloristeria mensajesFloristeria = new MensajesFloristeria();

    public List<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(List<Arbol> arboles) {
        this.arboles = arboles;
    }

    public void setFlores(List<Flor> flores) {
        this.flores = flores;
    }

    public List<Flor> getFlores() {
        return flores;
    }

    public void setDecoraciones(List<Decoracion> decoraciones) {
        this.decoraciones = decoraciones;
    }

    public List<Decoracion> getDecoraciones() {
        return decoraciones;
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
        for (int i = 0; i< arboles.size(); i++) {

            if (arboles.get(i).getId() == idRetirar) {

                valorTotal -= this.arboles.get(i).getPrecio();

                System.out.print("Ingrese cantidad a retirar de " + arboles.get(i).getNombre() + " :");
                int cantidadRetirar = sc.nextInt();
                this.arboles.get(i).setCantidad(this.arboles.get(i).getCantidad() - cantidadRetirar);

                System.out.println("Arbol eliminado");
                System.out.println("Quedan restantes en stock: " + this.arboles.get(idRetirar).getCantidad());

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El arbol no existe en la base de datos");
        }

    }

    public void retirarFlor(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;

        for (int i=0; i< flores.size(); i++) {
            if (flores.get(i).getId() == idRetirar) {

                valorTotal -= this.flores.get(i).getPrecio();

                System.out.print("Ingrese cantidad a retirar de " + flores.get(i).getNombre() + " :");
                int cantidadRetirar = sc.nextInt();
                this.flores.get(i).setCantidad(this.flores.get(i).getCantidad() - cantidadRetirar);

                System.out.println("Flores eliminadas");
                System.out.println("Quedan restantes en stock: " + this.flores.get(i).getCantidad());

                encontrado = true;

            }
        }
        if (!encontrado) {
            System.out.println("El articulo ingresado no existe en la base de datos");
        }
    }

    public void retirarDecoracion(int idRetirar) {

        Scanner sc = new Scanner(System.in);

        Boolean encontrado = false;
        for (int i = 0; i< decoraciones.size(); i++) {
            if (decoraciones.get(i).getId() == idRetirar) {

                valorTotal -= this.arboles.get(i).getPrecio();

                System.out.print("Ingrese cantidad a retirar de " + decoraciones.get(i).getNombre() + " :");
                int cantidadRetirar = sc.nextInt();
                this.decoraciones.get(i).setCantidad(this.decoraciones.get(i).getCantidad() - cantidadRetirar);

                System.out.println("Decoraciones eliminadas");
                System.out.println("Quedan restantes en stock: " + this.decoraciones.get(i).getCantidad());

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El articulo no existe en la base de datos");
        }

    }


    // MOSTRAR

    public void mostrarStock() {

        Scanner sc = new Scanner(System.in);

        try {

            String linea, extension = "";
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    System.out.println("ARBOLES");
                    extension = "arbol.txt";
                } else if (i == 1) {
                    System.out.println("FLORES");
                    extension = "flor.txt";
                } else {
                    System.out.println("DECORACIONES");
                    extension = "decoracion.txt";
                }

                FileReader fileIn = new FileReader(this.nombre + extension);


                BufferedReader objectIn = new BufferedReader(fileIn);

                while ((linea = objectIn.readLine()) != null) {
                    System.out.println(linea);
                }
                objectIn.close();
                fileIn.close();
            }


        } catch (IOException e) {
            System.out.println("Error al cargar el estado de la floristeria: " + e.getMessage());
        }
    }

    public void mostrarStockConCantidades() {
        System.out.println("Stock de la floristeria:");
        System.out.println("Arboles: " + arboles.size() + " unidades");
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

    public MensajesFloristeria buscarProductoId(int productoID, int productoCant) {
//        private List<Arbol> arboles;
//        private List<Flor> flores;
//        private List<Decoracion> decoraciones;

        String mensaje = "KO";
        mensajesFloristeria.setMensaje("");
        mensajesFloristeria.setCodigoerrores(0);

        System.out.println("floristeria BuscarProducto por id ----> " + productoID);
        Producto productoTicket = null;


        for (Producto producto : arboles) {
            System.out.println("mis arboles :  " + producto.getId());
            if (producto.getId() == productoID) {
                mensaje = this.Validaciones(producto, productoCant);
            }
        }
        for (Producto producto : flores) {
            if (producto.getId() == productoID) {
                mensaje = this.Validaciones(producto, productoCant);
            }
        }
        for (Producto producto : decoraciones) {
            if (producto.getId() == productoID) {
                mensaje = this.Validaciones(producto, productoCant);
            }
        }
        if (mensaje == "KO") {
            mensajesFloristeria.setMensaje("producto no encontrado.Liste el Stock para ver el catalogo disponible");
            mensajesFloristeria.setCodigoerrores(1);
        }
        return mensajesFloristeria;
    }

    public String Validaciones(Producto producto, int cantidades) {
        String mensajes = "";
        if (producto.getCantidad() == 0) {
            mensajesFloristeria.setMensaje("Disculpe actualmente no hay stock de este producto.");
            mensajesFloristeria.setCodigoerrores(2);

        }
        if (producto.getCantidad() < cantidades) {
            mensajesFloristeria.setMensaje("Solo tenemos " + producto.getCantidad() + " disponibles en Stock");
            mensajesFloristeria.setCodigoerrores(3);

        }
        if (producto.getCantidad() >= cantidades) {
            mensajes = "OK";

        }
        return mensajes;
    }

    public Producto AñadirTickedProductoId(int Id, int cantidades) {
//      private List<Arbol> arboles;
//      private List<Flor> flores;
//      private List<Decoracion> decoraciones;

        String mensaje = "KO";
        mensajesFloristeria.setMensaje("");
        mensajesFloristeria.setCodigoerrores(0);

        System.out.println("floristeria BuscarProducto por id ----> " + Id);
        Producto productoTicket = null;


        for (Producto producto : arboles) {
            System.out.println("mis arboles :  " + producto.getId());
            if (producto.getId() == Id) {

                System.out.println(" encontrado  " + Id + producto.getCantidad());
                producto.setCantidad(producto.getCantidad() - cantidades);
                productoTicket = new Producto(producto.getNombre(), producto.getPrecio(), cantidades);
            }
        }

        return productoTicket;
    }

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
