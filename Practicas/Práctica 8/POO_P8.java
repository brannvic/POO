/*Barrera Treviño José Gerardo
Muñoz San Agustin Victoria Monserrat
Olvera Bravo Cynthia Carolina
Leocadio Chávez Rodrigo
Velasco Garcia Santiago*/

import java.util.*;
// generar un sistema que permita conocer la cantidad de usuarios sistema de transporte


interface Vehiculo {
    void mover();
    void detener();

}

class Transporte implements Vehiculo {
    int capacidad;
    int pasajeros;
    String fuenteEner;

    public Transporte(int capacidad, int pasajeros, String fuente) {
        this.capacidad = capacidad;
        this.fuenteEner = fuente;
        this.pasajeros = pasajeros;
    }

    public void mover() {
        System.out.println("El transporte comienza a moverse.");
    }

    public void detener() {
            System.out.println("El transporte se detiene...");
    }

    public int getPasajeros() {
        return this.pasajeros;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public String getFuente() {
        return this.fuenteEner;
    }

}

abstract class Colectivo extends Transporte {
    private float costoPasaje;
    private float costoCombustible;

    public Colectivo(int capacidad, int pasajeros, String fuente, float costoPasaje, float costoCombustible) {
        super(capacidad, pasajeros, fuente);
        this.costoPasaje = costoPasaje;
        this.costoCombustible = costoCombustible;
    }

    public String cobrar(float dinero) {
        float cambio = dinero - getCostoPasaje();
        if (cambio >= 0) {
            return "Gracias! Su cambio es de " + cambio;
        } else {
            return "Te faltan $" + cambio*-1;
        }
    }

    float getCostoPasaje() {
        return this.costoPasaje;
    }

    public void mover() {
        System.out.println("El colectivo comienza a moverse.");
    }

    public void detener() {
            System.out.println("El colectivo se detiene...");
    }
}

abstract class Particular extends Transporte {
    private int cilindros;
    private String motor;

    public Particular(int capacidad, int pasajeros, String fuente, int cilindros, String motor) {
        super(capacidad, pasajeros, fuente);
        this.cilindros = cilindros;
        this.motor = motor;
    }

    public void mover() {
        System.out.println("El transporte particular comienza a moverse.");
    }

    public void detener() {
            System.out.println("El transporte particular se detiene...");
    }
}

class Taxi extends Particular {
    private String placas;
    private double gasolina;
    private double base;

    public Taxi(int capacidad, int pasajeros, String fuente, int cilindros, String motor, String placas, double gasolina, double base) {
        super(capacidad, pasajeros, fuente, cilindros, motor);
        this.placas = placas;
        this.gasolina = gasolina;
        this.base = base;
    }

    public String VerificarGasolina() {
        if (gasolina > 0) {
            return "El taxi tiene suficiente gasolina.";
        } else {
            return "El taxi necesita recargar gasolina.";
        }
    }

    public String PagarSitio(double monto) {
        if (monto >= base) {
            return "El taxista ha pagado $" + monto + " por el servicio de la base.";
        } else {
            return "El monto pagado es insuficiente.";
        }
    }

    public String getPlacas() {
        return placas;
    }

    public double getGasolina() {
        return gasolina;
    }

    public double getBase() {
        return base;
    }

}

class Avion extends Colectivo {
    String destino;
	String origen;
	Boolean retraso;

	public Avion(int capacidad, int pasajeros, String fuente, float costoPasaje, float costoCombustible, String destino, String origen, Boolean retraso) {
        super(capacidad, pasajeros, fuente, costoPasaje, costoCombustible);
        this.destino = destino;
        this.origen = origen;
        this.retraso = retraso;
    }

	void Abordar(){
		System.out.println("¿Ya realizaste el check in?");
		System.out.println("1.Sí, realice el check in");
		System.out.println("2. No, no realice check in");
		System.out.println("Ingresa el número de la opcion");

		// int opcion = scanner.nextInt();
		
		// switch (opcion){
		// 	case 1: 
		// 		System.out.println("Puedes abordar  ¡Disfruta el viaje!");
		// 	case 2:
		// 		System.out.println("Debes de realizar el check in para poder abordar");


		// }

	}

	void InformacionVuelo() {
        System.out.println("Información del vuelo:");
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Estado del vuelo: " + (retraso ? "Retrasado" : "Puntual"));
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

    public boolean isRetraso() {
        return retraso;
    }
}

class Metro extends Colectivo {
    private String linea;
    private String direccion;
    private boolean funcionamiento;

    public Metro(int capacidad, int pasajeros, String fuente, float costoPasaje, float costoCombustible, String linea, String direccion,boolean funcionamiento){
        super(capacidad, pasajeros, fuente, costoPasaje, costoCombustible);
        this.linea=linea;
        this.direccion=direccion;
        this.funcionamiento=funcionamiento;
    }
    public void recargarTarjeta(double cantidad){
        if(funcionamiento){
            double saldo = 0;
            saldo+=cantidad;
            System.out.println("Tarjeta recargada. Nuevo saldo: "+saldo);
        } else {
            System.out.println("No se pudo recargar la tarjeta");
        }
    }
    
    public void detectarFallas(){
        if(Math.random()<0.1){
            funcionamiento=false;

        }else{
            System.out.println("El metro no funciona");
        }
    }

    public String getLinea() {
        return linea;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isFuncionamiento() {
        return funcionamiento;
    }
}

class AutoParticular extends Particular {
    private String marca;
    private String modelo;
    private int añoFabricacion;

    public AutoParticular(int capacidad, int pasajeros, String fuente, int cilindros, String motor, String marca, String modelo, int añoFabricacion) {
        super(capacidad, pasajeros, fuente, cilindros, motor);
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void arrancar() {
        System.out.println("El automóvil particular ha arrancado.");
    }

    public void apagar() {
        System.out.println("El automóvil particular se ha apagado.");
    }
}

class SistemaTransportes {
    public static void main(String [] d) {
        ArrayList<Transporte> pool = new ArrayList<Transporte>();
        Taxi t1 = new Taxi(5,3,"gasolina",2,"motor1", "234234", 24.5, 5);
        AutoParticular t2 = new AutoParticular(5,3,"gasolina",2,"motor2", "Nissan", "March", 2010);
        Avion t3 = new Avion(120, 100, "gasolina", 1000, 120_000, "CDMX", "Tijuana", true);
        Metro t4 = new Metro(500, 400, "gasolina", 5, 100_000, "3", "Universidad", true);

        pool.add(t1);
        pool.add(t2);
        pool.add(t3);
        pool.add(t4);

        SistemaTransportes system = new SistemaTransportes();
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nBienvenido al Sistema de Transportes (pool)");
            System.out.println("Elige una opción:");
            System.out.println("1) Ver pool");
            System.out.println("2) Ver información de un transporte");
            System.out.println("3) Agregar un transporte");
            System.out.println("4) Ver tipos de transporte");
            System.out.println("5) Salir");
            
            int op = sc.nextInt();
            switch(op) {
                case 1:
                    system.darInformacion(pool);
                    break;
                case 2:
                    System.out.println("Selecciona el índice del transporte que deseas ver:");
                    for (int i = 0; i < pool.size(); i++) {
                        System.out.println(i + ") " + pool.get(i).getClass().getSimpleName());
                    }
                    int indice = sc.nextInt();
                    if (indice >= 0 && indice < pool.size()) {
                        Transporte transporte = pool.get(indice);
                        system.darInformacionEspecifica(transporte);
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;
                case 3:
                    Taxi t5 = new Taxi(5,3,"gasolina",2,"motor1", "234234", 24.5, 5);
                    AutoParticular t6 = new AutoParticular(5,3,"gasolina",2,"motor2", "Nissan", "March", 2010);
                    Avion t7 = new Avion(120, 100, "gasolina", 1000, 120_000, "CDMX", "Tijuana", true);
                    Metro t8 = new Metro(500, 400, "gasolina", 5, 100_000, "3", "Universidad", true);
                    System.out.println("Selecciona el tipo de transporte que deseas agregar:");
                    System.out.println("1) Taxi");
                    System.out.println("2) Auto Particular");
                    System.out.println("3) Avión");
                    System.out.println("4) Metro");
                    int tipoTransporte = sc.nextInt();
                    if (tipoTransporte >= 1 && tipoTransporte <= 4) {
                        switch (tipoTransporte) {
                            case 1:
                                system.agregarTransporte(pool, t5);
                                break;
                            case 2:
                                system.agregarTransporte(pool, t6);
                                break;
                            case 3:
                                system.agregarTransporte(pool, t7);
                                break;
                            case 4:
                                system.agregarTransporte(pool, t8);
                                break;
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 4:
                    system.mostrarSubtipos(Colectivo.class);
                    system.mostrarSubtipos(Particular.class);
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

    }

    public void darInformacion(ArrayList<Transporte> pool) {
        int ptaxi = 0;
        int pavion = 0;
        int pmetro = 0;
        for (Transporte t : pool) {
            if(t instanceof Taxi) {
                ptaxi += t.getPasajeros();
            }
            if(t instanceof Avion) {
                pavion += t.getPasajeros();
            }
            if(t instanceof Metro) {
                pmetro += t.getPasajeros();
            }
        }
        System.out.println("Taxi: "+ptaxi+" pasajeros");
        System.out.println("Avión: "+pavion+" pasajeros");
        System.out.println("Metro: "+pmetro+" pasajeros");
    }

/*- Crear un método que al recibir una referencia genérica de medio de transporte, me muestre todas las
características del medio de transporte específico, ejemplo: Recibe una referencia de Transporte -> me
muestra los datos de metrobus, si el objeto fue creado como metrobus
*/
    public void darInformacionEspecifica(Transporte transporte) {
        System.out.println("Capacidad: "+ transporte.getCapacidad());
        System.out.println("Pasajeros: "+ transporte.getPasajeros());
        System.out.println("Fuente de Energía: "+ transporte.getFuente());
        if (transporte instanceof Taxi) {
            Taxi taxi = (Taxi) transporte;
            System.out.println("Taxi - Placas: " + taxi.getPlacas());
            System.out.println("Taxi - Gasolina: " + taxi.getGasolina());
            System.out.println("Taxi - Base: " + taxi.getBase());
        } else if (transporte instanceof Avion) {
            Avion avion = (Avion) transporte;
            System.out.println("Avión - Destino: " + avion.getDestino());
            System.out.println("Avión - Origen: " + avion.getOrigen());
            System.out.println("Avión - Retraso: " + avion.isRetraso());
        } else if (transporte instanceof Metro) {
            Metro metro = (Metro) transporte;
            System.out.println("Metro - Línea: " + metro.getLinea());
            System.out.println("Metro - Dirección: " + metro.getDireccion());
            System.out.println("Metro - Funcionamiento: " + metro.isFuncionamiento());
        } else if (transporte instanceof AutoParticular) {
            AutoParticular auto = (AutoParticular) transporte;
            System.out.println("Auto Particular - Marca: " + auto.getMarca());
            System.out.println("Auto Particular - Modelo: " + auto.getModelo());
            System.out.println("Auto Particular - Año: " + auto.getAñoFabricacion());
        } else {
            System.out.println("Transporte no reconocido.");
        }
    }

/*- Crear los método necesarios, que me permitan agregar un objeto de transporte especifico (taxi,
metrobus,cablebus, ecobus, etc) a su pool de medios de transporte, este método deberá presentar 
sobrecarga para cada tipo específico
*/
    void agregarTransporte(ArrayList<Transporte> pool, Taxi tn) {
        pool.add(tn);
        System.out.println("Se ha agregado un Taxi al pool de medios de transporte.");
    }

    void agregarTransporte(ArrayList<Transporte> pool, Avion tn) {
        pool.add(tn);
        System.out.println("Se ha agregado un Avión al pool de medios de transporte.");
    }

    void agregarTransporte(ArrayList<Transporte> pool, Metro tn) {
        pool.add(tn);
        System.out.println("Se ha agregado un Metro al pool de medios de transporte.");
    }

    void agregarTransporte(ArrayList<Transporte> pool, AutoParticular tn) {
        pool.add(tn);
        System.out.println("Se ha agregado un Auto Particular al pool de medios de transporte.");
    }

/*- Crear un método que me muestre todos los subtipos de datos asociados a un tipo de dato generico.
Ejemplo, recibe una referencia de tipo Hibrido, mostrara, ecobus,trolebus,taxi hibrido
*/
    public void mostrarSubtipos(Class<?> clasePadre) {
        List<Class<?>> clases = new ArrayList<>();
        clases.add(Taxi.class);
        clases.add(Avion.class);
        clases.add(Metro.class);
        clases.add(AutoParticular.class);
        
        List<String> subclases = new ArrayList<>();

        for (Class<?> clase : clases) {
            if (clasePadre.isAssignableFrom(clase) && !clase.equals(clasePadre)) {
                subclases.add(clase.getSimpleName());
            }
        }

        if (!subclases.isEmpty()) {
            System.out.println("Tipos de transporte " + clasePadre.getSimpleName() + ":");
            for (String subclase : subclases) {
                System.out.println(subclase);
            }
        } else {
            System.out.println(clasePadre.getSimpleName() + " no tiene subclases.");
        }
    }

}