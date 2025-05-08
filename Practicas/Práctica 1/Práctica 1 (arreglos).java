//Barrera Treviño Jose Gerardo
//Muñoz San Agustin Victoria Monserrat

//ESTE CÓDIGO IMPRIME LAS VARIABLES COMO ARREGLOS

//biblioteca para leer variables
import java.util.Scanner;
class Practica1{
    public static void main(String[] d){//es public porque depende varios de esta clase
        // declarar lo que se leera
        Scanner sc=new Scanner(System.in); //leer las entradas de datos
        String[] nombre=new String[5];
        int[] edad=new int[5];
        char [] genero=new char[5];
        double[] promedio=new double[5];

        //un for que recorra los datos de las 5 personas e imprima en arreglos
        for (int i=0; i<5; i++){
            System.out.println("Ingrese su nombre: ");
            nombre[i]=sc.next();
            System.out.println("Ingrese su edad " +nombre[i]+": ");
            edad[i]=sc.nextInt();
            System.out.println("Ingrese su genero " +nombre[i]+"(M/F/O): ");
            genero[i]=sc.next().charAt(0);
            System.out.println("Ingrese su promedio " +nombre[i]+": ");
            promedio[i]=sc.nextDouble();
        }
        
        //clasificación de las edades
        String [] niños=new String[5];
        String [] adolescentes=new String[5];
        String [] adulto=new String [5];
        String [] ancianos=new String [5];
        //count define de que grupo sera la persona
        int niñosCount=0, adolescentesCount=0, adultoCount=0, ancianoCount=0;
        
        //recorre las edades ingresadas y clasifica conforme al if
        for (int i=0; i<5; i++){
            if (edad[i]<15){
                niños[niñosCount++]=nombre[i];
            } else if (edad[i]<=21){
                adolescentes[adolescentesCount++]=nombre[i];
            } else if (edad[i]<=65){
                adulto[adultoCount++]=nombre[i];
            } else {
                ancianos[ancianoCount++]=nombre[i];
            }
        }

        //clasificacion de genero
        String [] masculino=new String[5];
        String [] femenino=new String[5];
        String [] otro=new String [5];

        int masculinoCount=0, femeninoCount=0, otroCount=0;

        //for que mediante una literal define en que genero se guarda la persona
        for (int i=0; i<5; i++){
            if (genero[i]=='M'||genero[i]=='m'){
                masculino[masculinoCount++]=nombre[i];
            } else if (genero[i]=='F'||genero[i]=='f'){
                femenino[femeninoCount++]=nombre[i];
            } else {
                otro[otroCount++]=nombre[i];
            }
        }

        //calcular promedios
        double promedioTotal=0;

        for(double promedios:promedio){
            promedioTotal+=promedios;
        }
        promedioTotal/=promedio.length;

        //impresion final de varias cadenas a una sola (arrayToString)
    System.out.println("\nESTE CÓDIGO IMPRIME COMO ARREGLOS");
    System.out.println("Alumnos que son niños "+arrayToString(niños));
    System.out.println("Alumnos que son adolescentes "+arrayToString(adolescentes));
    System.out.println("Alumnos que son adultos "+arrayToString(adulto));
    System.out.println("Alumnos que son ancianos "+arrayToString(ancianos));
    System.out.println("\nAlumnos masculinos "+arrayToString(masculino));
    System.out.println("Alumnas femeninos "+arrayToString(femenino));
    System.out.println("Alumnos que son otro genero "+arrayToString(otro));
    System.out.println("\nPromedio total de los promedios "+promedioTotal);
    }
    //convertimos de una impresion normal a un arreglo
    private static String arrayToString(String[] array){//es private porque es una clase especifica para crear el array
        StringBuilder arreglo=new StringBuilder("[");//crear cadenas de strings sin nuevas instancias

        for(int i=0; i<array.length;i++){//length tamaño 
            if(array[i]!=null){
                arreglo.append(array[i]);
                if(i<array.length-1){
                    arreglo.append(", ");
                }
            }
        }
        arreglo.append("]");//append agrega contenido a cadenas
        return arreglo.toString();
    }
}