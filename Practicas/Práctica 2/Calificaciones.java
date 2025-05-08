import java.util.Scanner; 
class Calificaciones{ 
    public static void main(String[] d) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Introduce la nota que hayas obtenido este semestre: "); 
        float calif = sc.nextFloat(); 
        
        if (calif < 0 || calif > 10) { 
            System.out.println
            ("La calificación que ingresaste es incorrecta, debe ingresar una nota entre 0 y 10."); 
        } else if (calif < 5) { 
            System.out.println("SUSPENDIDO"); 
        } else if (calif < 7) { System.out.println("APROBADO"); 
        } else if (calif < 9) { System.out.println("NOTABLE"); 
        } else if (calif < 10) { System.out.println("SOBRESALIENTE"); 
        } else { System.out.println("HONORABLE"); 
        } 
    } 
}
