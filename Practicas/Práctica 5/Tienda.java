import java.util.*;

class Producto {
    private String nombre;
    private double precio;
    private int disponibilidad;
    private String categoria;

    public Producto(String nombre, double precio, int disponibilidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getdisponibilidad() {
        return disponibilidad;
    }

    public void restarCantidad(int cantidad) {
        disponibilidad -= cantidad;
    }

    public String toString() {
        return nombre + " (" + categoria + ") - Precio: $" + precio + " - Disponibles: " + disponibilidad;
    }
}

class Carrito {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad > producto.getdisponibilidad()) {
            System.out.println("No hay suficientes productos disponibles.");
        } else {
            productos.add(producto);
            producto.restarCantidad(cantidad);
            System.out.println(cantidad + " " + producto.getNombre() + " agregado(s) al carrito.");
        }
    }

    public void mostrarCarrito() {
        System.out.println("Carrito de Compras:");
        double total = 0;
        for (Producto producto : productos) {
            System.out.println(producto.toString());
            total += producto.getPrecio();
        }
        System.out.println("Total del carrito: $" + total);
    }

    public void vaciarCarrito() {
        productos.clear();
        System.out.println("Carrito vaciado.");
    }
}

class Tienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();

        Producto producto1 = new Producto("Camiseta", 140.0, 50, "Ropa");
        Producto producto2 = new Producto("Zapatos", 300.0, 26, "Calzado");
        Producto producto3 = new Producto("Gorra", 25.0, 9, "Ropa");
        Producto producto4 = new Producto("Pantalón", 250.0, 67, "Ropa");


        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Mostrar carrito");
            System.out.println("3. Vaciar carrito");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Productos disponibles:");
                    System.out.println("1. " + producto1.toString());
                    System.out.println("2. " + producto2.toString());
                    System.out.println("3. " + producto3.toString());
                    System.out.println("4. " + producto4.toString());

                    System.out.print("Seleccione un producto (1/4): ");
                    int productoSeleccionado = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    if (productoSeleccionado == 1) {
                        carrito.agregarProducto(producto1, cantidad);
                    } else if (productoSeleccionado == 2) {
                        carrito.agregarProducto(producto2, cantidad);
                    } else if (productoSeleccionado == 3) {
                        carrito.agregarProducto(producto3, cantidad);
                    } else if (productoSeleccionado == 4) {
                        carrito.agregarProducto(producto4, cantidad);
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    carrito.mostrarCarrito();
                    break;
                case 3:
                    carrito.vaciarCarrito();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema de carrito de compras.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}