//Ejercicio3
import java.util.Scanner;
class Tablas{
    public static void main(String [] d){
        Scanner scanner =new Scanner(System.in);

        System.out.println("Ingrese el numero que quiere ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();
        System.out.println("La tabla de multiplicar de : " +numero+ " es: ");
        for (int i=1; i<=10; i++){
            int res = numero * i;
            System.out.println("El resultado de "+ numero +" x "+i+ " es: "+ res);
        } 
    }
}
