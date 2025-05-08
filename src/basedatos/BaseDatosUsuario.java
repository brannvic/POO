package basedatos;

import java.util.ArrayList;
import java.util.List;

class BaseDatosUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
