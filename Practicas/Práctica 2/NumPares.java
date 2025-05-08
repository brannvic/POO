//Ejercicio2
import java.util.Scanner;
class NumPares{
    public static void main(String [] d){
        Scanner scanner =new Scanner(System.in);

        System.out.println("Ingrese un número el cual va a ser nuestro número máximo: ");
        int num = scanner.nextInt();
        System.out.println("Los números pares entre 0 y "+num+" son: ");
        for (int i=0; i<=num; i++){
        if (i%2 == 0){
            System.out.println(""+i);
            }
        } 
    }
}
