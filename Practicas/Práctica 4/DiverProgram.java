import java.util.Random;
import java.util.Scanner;

class DriverProgram{
    public static void main(String[] main){
        Random rand = new Random();
        //Directorio de ciudades
        String[] ciudades = {"CDMX", "GDL", "MTY", "GTO", "TJN"};

        //Creación de asistentes
        Asistente[] asistentes = new Asistente[200];
        for(int i=0; i<200; i++){
            int edadrandom = rand.nextInt(100) + 1;
            int ciudadrandom = rand.nextInt(5);
            asistentes[i] = new Asistente(edadrandom, ciudades[ciudadrandom]);
        }

        //Creación de lugares
        LugarEvento lugar1 = new LugarEvento(300, "Matanzas 472", "CDMX");
        LugarEvento lugar2 = new LugarEvento(450, "Manizales 30", "EDOMEX");
        LugarEvento lugar3 = new LugarEvento(200, "Matamoros 95", "GDL");

        //Creación de eventos
        Evento evento1 = new Evento("Boda", lugar1, asistentes);
        Evento evento2 = new Evento("Quinceañera", lugar2, asistentes);
        Evento evento3 = new Evento("Fiesta", lugar3, asistentes);

        //Clasificador
        Clasificador clasificador = new Clasificador();
        Scanner scan = new Scanner(System.in);
        int opc;

         do {
            System.out.println("Menú:");
            System.out.println("1. Boda");
            System.out.println("2. Quinceañera");
            System.out.println("3. Fiesta");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Boda seleccionado:");
                    clasificador.clasificaAsistentes(evento1);
                    clasificador.clasificaCiudad(evento1);
                    System.out.println("El porcentaje de asistencia fue de " + clasificador.porcentajeAsistencia(evento1) + "%");
                    break;
                case 2:
                    System.out.println("Quinceañera seleccionado:");
                    clasificador.clasificaAsistentes(evento2);
                    clasificador.clasificaCiudad(evento2);
                    System.out.println("El porcentaje de asistencia fue de " + clasificador.porcentajeAsistencia(evento2) + "%");
                    break;
                case 3:
                    System.out.println("Fiesta seleccionado:");
                    clasificador.clasificaAsistentes(evento3);
                    clasificador.clasificaCiudad(evento3);
                    System.out.println("El porcentaje de asistencia fue de " + clasificador.porcentajeAsistencia(evento3) + "%");
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 4.");
            }
        } while (opc != 4);
    }
}

class Asistente{
    String nombre;
    String correo;
    long telefono;
    String ciudad;
    int edad;

    Asistente(){}

    Asistente(int edad, String ciudad){
        this.edad = edad;
        this.ciudad = ciudad;
    }

}

class Evento{
    String nombre;
    LugarEvento lugar;
    String fecha;
    Asistente[] asistencia;

    Evento(){}

    Evento(String nombre, LugarEvento lugar, Asistente[] asistentes){
        this.nombre = nombre;
        this.lugar = lugar;
        asistencia = asistentes;
    }
}

class LugarEvento{
    int capacidad;
    String direccion;
    String ciudad;

    LugarEvento(){}

    LugarEvento(int capacidad, String direccion, String ciudad){
        this.capacidad = capacidad;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

}

class Clasificador{

    void clasificaAsistentes(Evento evento){
    int rango_15_18 = 0;
    int rango_18_20 = 0;
    int mayor_20 = 0;
    
    int asistentes = evento.asistencia.length;
    for (int i = 0; i < asistentes; i++) {
        int edad = evento.asistencia[i].edad;

        if (edad >= 15 && edad <= 18) {
            rango_15_18++;
        } else if (edad > 18 && edad <= 20) {
            rango_18_20++;
        } else if (edad > 20) {
            mayor_20++;
        }
    }

    System.out.println("Personas en el rango de edad 15-18: " + rango_15_18);
    System.out.println("Personas en el rango de edad 18-20: " + rango_18_20);
    System.out.println("Personas con edad mayor a 20: " + mayor_20);

    }

    float porcentajeAsistencia(Evento evento){
        int asistentes = evento.asistencia.length;
        int capacidad = evento.lugar.capacidad;

        return ((float)asistentes/(float)capacidad)*100;
    }

    void clasificaCiudad(Evento evento){
        int cdmx, gdl, mty, gto, tjn;
        cdmx = gdl = mty = gto = tjn = 0;
        int numasist = evento.asistencia.length;

        for(int i=0; i<numasist; i++){
            if(evento.asistencia[i].ciudad.equals("CDMX")){
                cdmx+=1;
            }
            if(evento.asistencia[i].ciudad.equals("GDL")){
                gdl+=1;
            }
            if(evento.asistencia[i].ciudad.equals("MTY")){
                mty+=1;
            }
            if(evento.asistencia[i].ciudad.equals("GTO")){
                gto+=1;
            }
            if(evento.asistencia[i].ciudad.equals("TJN")){
                tjn+=1;
            }
        }
        System.out.println("Hay "+cdmx+" asistentes de CDMX");
        System.out.println("Hay "+gdl+" asistentes de GDL");
        System.out.println("Hay "+mty+" asistentes de MTY");
        System.out.println("Hay "+gto+" asistentes de GTO");
        System.out.println("Hay "+tjn+" asistentes de TJN");

        }


    }