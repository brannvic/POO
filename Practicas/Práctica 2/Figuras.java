//Ejercicio4
import java.util.Scanner;
class Figuras{
    public static void main (String [] d){
        Scanner scanner = new Scanner(System.in);
        int opc;
        boolean volver = true;

        do{
            if(volver){
        System.out.println(" Programa para cacular el área y el perimetro de 3 figuras geometricas ");
        System.out.println(" Menú principal: ");
        System.out.println("1. Triangulo");
        System.out.println("2. Cuadrado ");
        System.out.println("3. Circulo ");
        System.out.println("4. Salir");
        opc = scanner.nextInt();
        }else{
            opc = 4;
        }

        switch(opc){
            case 1:
            calTri();
            break;
            case 2:
            calCua();
            break;
            case 3:
            calCir();
            break;
            case 4:
            System.out.println("Nos vemos luego ");
            break;
            default:
            System.out.println("No conozco esa opción, por favor introduce una opciíon valida");
        }
        if (opc !=4){
            System.out.println("" + "Quieres regresar al menú? (true/false) ");
            volver = scanner.nextBoolean();
    }
    }while (opc !=4);
    }

    public static void calTri(){
      Scanner scanner = new Scanner(System.in);
      System.out.println(" Introduce la base (también llamado lado 1) del triangulo: ");
      float basTri = scanner.nextFloat();
      System.out.println("Introduce la altura del triangulo: ");
      float altTri = scanner.nextFloat();
      System.out.println(" Introduce la longitud del lado 2 del triangulo: ");
      float lad2Tri = scanner.nextFloat();
      System.out.println(" Introduce la longitud del lado 3 del triangulo: ");
      float lad3Tri = scanner.nextFloat();

      float areaTri = (basTri * altTri)/2;
      float periTri = (basTri+lad2Tri+lad3Tri);

      System.out.println("El area del triangulo es: " + areaTri);
      System.out.println(" El perimetro del triangulo es: " + periTri);
      }

      public static void calCua(){
      Scanner scanner = new Scanner(System.in);
      System.out.println(" Introduce la longitud de un lado del cuadrado: ");
      float longCua = scanner.nextFloat();

      float areaCua = (longCua * longCua);
      float periCua = (longCua+longCua+longCua+longCua);

      System.out.println("El area del cuadrado es: " + areaCua);
      System.out.println(" El perimetro del cuadrado es: " + periCua);
      }

      public static void calCir(){
      Scanner scanner = new Scanner(System.in);

      System.out.println("Introduce el radio de tu circulo: ");
      double radCir = scanner.nextDouble();

      double areaCir = Math.PI * Math.pow (radCir, 2);
      double periCir = 2 * Math.PI * radCir;

      System.out.println("El area del circulo es: " + areaCir);
      System.out.println(" El perimetro del circulo es: " + periCir);
      }
    }
