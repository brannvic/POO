package principal;

import java.util.Scanner;
import utilerias.Autenticador;


public class Autenticacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        boolean autenticado = Autenticador.autenticar(nombreUsuario, contrasena);

        if (autenticado) {
            System.out.println("Autenticación exitosa.");
        } else {
            System.out.println("Autenticación fallida. Usuario o contraseña incorrectos.");
        }
        
        scanner.close();
    }
}
