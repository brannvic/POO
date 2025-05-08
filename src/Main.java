public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Ejemplo: Agregar usuarios a la base de datos
        basedatos.BaseDatosUsuarios.agregarUsuario(new basedatos.Usuario("usuario1", "contrasena1"));
        basedatos.BaseDatosUsuarios.agregarUsuario(new basedatos.Usuario("usuario2", "contrasena2"));

        // Ejecutar la autenticación desde el paquete 'principal'
        principal.Autenticacion.main(args);
    }
}
