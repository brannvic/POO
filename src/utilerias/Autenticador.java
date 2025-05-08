package utilerias;

import basedatos.Usuario;

public class Autenticador {
    /**
     * @param nombreUsuario
     * @param contrasena
     * @return
     */
    public static boolean autenticar(String nombreUsuario, String contrasena) {
        for (Usuario usuario : basedatos.BaseDatosUsuarios.obtenerUsuarios()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
