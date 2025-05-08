import java.util.*;

class DriverProgram {
    public static void main(String[] driver) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Eliminar producto del carrito");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Vaciar carrito");
            System.out.println("5. Mostrar costo hasta el momento");
            System.out.println("6. Subtotal de un producto");
            System.out.println("7. Obtener ID de un producto");
            System.out.println("8. Realizar una venta");
            System.out.println("9. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nProductos disponibles:");
                    System.out.println("1. Camiseta - Precio: $140.0");
                    System.out.println("2. Zapatos - Precio: $300.0");
                    System.out.println("3. Gorra - Precio: $25.0");
                    System.out.println("4. Pantalón - Precio: $250.0");

                    System.out.print("Seleccione un producto (1/4): ");
                    int productoSeleccionado = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    carrito.agregarProducto(carrito.crearProducto(productoSeleccionado, cantidad));
                    break;
                case 2:
                    System.out.println("\n¿Qué producto desea eliminar? (Se eliminarán todos los productos de este tipo)");
                    System.out.println("1. Camiseta");
                    System.out.println("2. Zapatos");
                    System.out.println("3. Gorra");
                    System.out.println("4. Pantalón");

                    System.out.print("Seleccione un producto (1/4): ");
                    int productoAEliminar = scanner.nextInt();
                    switch(productoAEliminar){
                        case 1:
                            carrito.eliminarProducto("Camiseta");
                            break;
                        case 2:
                            carrito.eliminarProducto("Zapatos");
                            break;
                        case 3:
                            carrito.eliminarProducto("Gorra");
                            break;
                        case 4: 
                            carrito.eliminarProducto("Pantalón");
                            break;
                        default:
                                System.out.println("Opción no válida.");
                                break;
                    }
                    break;
                case 3:
                    carrito.mostrarProductos();
                    break;
                case 4:
                    carrito.vaciarCarrito();
                    break;
                case 5:
                    carrito.mostrarPrecioTotal();
                    break;
                case 6:
                    System.out.println("\n¿De qué producto desea calcular el subtotal?");
                    System.out.println("1. Camiseta");
                    System.out.println("2. Zapatos");
                    System.out.println("3. Gorra");
                    System.out.println("4. Pantalón");

                    System.out.print("Seleccione un producto (1/4): ");
                    int productoSubtotal = scanner.nextInt();
                    switch(productoSubtotal){
                        case 1:
                            carrito.calcularSubDeProd("Camiseta");
                            break;
                        case 2:
                            carrito.calcularSubDeProd("Zapatos");
                            break;
                        case 3:
                            carrito.calcularSubDeProd("Gorra");
                            break;
                        case 4: 
                            carrito.calcularSubDeProd("Pantalón");
                            break;
                        default:
                                System.out.println("Opción no válida.");
                                break;
                    }
                    break;
                case 7:
                    System.out.println("\n¿De qué producto desea obtener el ID?");
                    System.out.println("1. Camiseta");
                    System.out.println("2. Zapatos");
                    System.out.println("3. Gorra");
                    System.out.println("4. Pantalón");

                    System.out.print("Seleccione un producto (1/4): ");
                    int productoPrecio = scanner.nextInt();
                    switch(productoPrecio){
                        case 1:
                            carrito.obtenerIDProducto("Camiseta");
                            break;
                        case 2:
                            carrito.obtenerIDProducto("Zapatos");
                            break;
                        case 3:
                            carrito.obtenerIDProducto("Gorra");
                            break;
                        case 4: 
                            carrito.obtenerIDProducto("Pantalón");
                            break;
                        default:
                                System.out.println("Opción no válida.");
                                break;
                    }
                    break;
                case 8:
                    // Realizar una venta
                    Venta venta = carrito.realizarVenta();
                    venta.mostrarProductosVendidos();
                    break;
                case 9:
                    System.out.println("Gracias por usar el sistema de carrito de compras.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

class CarritoDeCompras {
    private ArrayList<Producto> listaProductos;
    private int numProductos;
    private float precioTotalProductos;

    CarritoDeCompras() {
        listaProductos = new ArrayList<Producto>();
    }

    Producto crearProducto(int opcion, int cantidad) {
        while(true) {
            switch(opcion){
                case 1:
                    return new Camiseta(cantidad);
                case 2:
                    return new Zapatos(cantidad);
                case 3:
                    return new Gorra(cantidad);
                case 4: 
                    return new Pantalon(cantidad);
                default:
                        System.out.println("Opción no válida.");
                        break;
            }
        }
    }

    void agregarProducto(Producto productoNuevo) {
        listaProductos.add(productoNuevo);
        precioTotalProductos += productoNuevo.getPrecio();
        numProductos += productoNuevo.getCantidad();
    }

    void eliminarProducto(String productoEliminar) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(productoEliminar)) {
                precioTotalProductos -= producto.getPrecio();
                numProductos -= producto.getCantidad();
                listaProductos.remove(producto);
                System.out.println("El/los producto/s "+productoEliminar+" ha/n sido eliminado/s.");
                return;
            }
        }
        System.out.println("El producto no se encontró en el carrito: " + productoEliminar);
    }

    void mostrarProductos() {
        System.out.println("Productos en el carrito:");
        for (Producto producto : listaProductos) {
            System.out.println(producto.toString());
        }
        System.out.println("Precio total: "+precioTotalProductos+"$");
        System.out.println("Número de productos: "+numProductos);
    }

    public void vaciarCarrito() {
        listaProductos.clear();
        numProductos = 0;
        precioTotalProductos = 0;
        System.out.println("Carrito vaciado.");
    }

    void mostrarPrecioTotal() {
        System.out.println("Precio total: "+precioTotalProductos+"$");
    }

    void calcularSubDeProd(String productoSub) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(productoSub)) {
                producto.calcularSubtotal();
                return;
            }
        }
        System.out.println("El producto no se encontró en el carrito: " + productoSub);
    }

    void obtenerIDProducto(String productoID) {
        Random random = new Random();
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(productoID)) {
                producto.setID(random.nextInt(1000001));
                System.out.println("El ID obtenido para este producto fue: "+producto.getID());
                return;
            }
        }
        System.out.println("El producto no se encontró en el carrito: " + productoID);
    }

    Venta realizarVenta() {
        Venta venta = new Venta();
        for (Producto producto : listaProductos) {
            venta.agregarProducto(producto);
        }
        vaciarCarrito(); // Vaciamos el carrito después de la venta
        return venta;
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private int id;

    Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    void verificarPrecio() {
        System.out.println("Este producto (" + this.getNombre() + ") cuesta $" + this.precio);
    }

    public void calcularSubtotal() {
        System.out.println("El subtotal de "+nombre+"/s es de "+precio * cantidad+"$");
    }

    public String toString() {
        return cantidad + " - " + nombre + " - "  + precio*cantidad + "$" ;
    }

    // Getters y setters

    public double getPrecio() {
        return precio * cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getID() {
        return id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setID(int id) {
        this.id = id;
    }
}

class Ropa extends Producto {
    Ropa(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }
}

class Calzado extends Producto {
    Calzado(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }
}

class Camiseta extends Ropa {
    Camiseta(int cantidad) {
        super("Camiseta", 140.0, cantidad);
    }
}

class Gorra extends Ropa {
    Gorra(int cantidad) {
        super("Gorra", 25.0, cantidad);
    }
}

class Zapatos extends Calzado {
    Zapatos(int cantidad) {
        super("Zapatos", 300.0, cantidad);
    }
}

class Pantalon extends Ropa {
    Pantalon(int cantidad) {
        super("Pantalón", 250.0, cantidad);
    }
}

class Venta {
    private ArrayList<Producto> productosVendidos;

    Venta() {
        productosVendidos = new ArrayList<>();
    }

    void agregarProducto(Producto producto) {
        productosVendidos.add(producto);
    }

    void mostrarProductosVendidos() {
        System.out.println("Productos vendidos en la venta:");
        for (Producto producto : productosVendidos) {
            System.out.println(producto.toString());
        }
        // Calcular y mostrar el precio total de la venta
        double precioTotal = productosVendidos.stream().mapToDouble(Producto::getPrecio).sum();
        System.out.println("Precio total de la venta: $" + precioTotal);
    }
} 