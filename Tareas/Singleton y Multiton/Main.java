//Muñoz San Agustin Victoria Monserrat
class Main {
    public static void main(String[] args) {
        // Singleton
        Singleton singletonInstance1 = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();

        // Multiton
        Multiton instance1 = Multiton.getInstance("Key1");
        Multiton instance2 = Multiton.getInstance("Key2");

        System.out.println("Singleton Instances are the same: " + (singletonInstance1 == singletonInstance2));
        System.out.println("Multiton Instances are the same: " + (instance1 == instance2));
    }
}