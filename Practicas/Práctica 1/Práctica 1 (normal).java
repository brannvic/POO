//Barrera Treviño Jose Gerardo
//Muñoz San Agustin Victoria Monserrat

//ESTE CÓDIGO IMPRIME LAS VARIABLES EN TIPO LISTA

import java.util.Scanner; 
class PrimerPractica {
    public static void main(String[] d) {
        Scanner scanner = new Scanner(System.in);

        int rango0_19 = 0;
        int rango20_39 = 0;
        int hombres = 0;
        int mujeres = 0;
        float totalCalificacion = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Persona " + i + ":");

            System.out.print("Ingrese la edad: ");
            int edad = scanner.nextInt();

            // Clasificar la edad en rangos
            if (edad >= 0 && edad < 20) {
                rango0_19++;
            } else if (edad < 40) {
                rango20_39++;
            }

            System.out.print("Ingrese el género (Solo ponga la inicial del género H/M): ");
            char genero = scanner.next().charAt(0);
            if (genero == 'H' || genero == 'h') {
                hombres++;
            } else if (genero == 'M' || genero == 'm') {
                mujeres++;
            }

            System.out.print("Ingrese el promedio: ");
            float calificacion = scanner.nextFloat();
            totalCalificacion += calificacion;

            scanner.nextLine();

        }

        float promedioCalificacion = totalCalificacion / 5;

        System.out.println("ESTE CÓDIGO IMPRIME LAS VARIABLES EN TIPO LISTA");
        System.out.println("Clasificación de edades:");
        System.out.println("0-19 años: " + rango0_19);
        System.out.println("20-39 años: " + rango20_39);
        System.out.println("Cantidad de hombres: " + hombres);
        System.out.println("Cantidad de mujeres: " + mujeres);
        System.out.println("Promedio de los promedios: " + promedioCalificacion);

    }
}