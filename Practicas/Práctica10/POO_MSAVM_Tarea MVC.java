import java.io.*;
import java.util.HashMap;

class UsuarioYaExistenteException extends Exception {
    public UsuarioYaExistenteException(String mensaje) {
        super(mensaje);
    }
}

class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

class ContraseñaIncorrectaException extends Exception {
    public ContraseñaIncorrectaException(String mensaje) {
        super(mensaje);
    }
}

class Registro implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<String, String> usuarios;
    private String archivoUsuarios = "usuarios.ser";

    public Registro() {
        usuarios = cargarUsuarios();
    }

    public void registrarUsuario(String usuario, String contraseña) throws UsuarioYaExistenteException {
        if (usuarios.containsKey(usuario)) {
            throw new UsuarioYaExistenteException("El usuario ya existe.");
        }
        usuarios.put(usuario, contraseña);
        guardarUsuarios();
    }

    private HashMap<String, String> cargarUsuarios() {
        HashMap<String, String> loadedUsuarios = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoUsuarios))) {
            loadedUsuarios = (HashMap<String, String>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de usuarios no existe. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedUsuarios;
    }




    private void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoUsuarios))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }
}

class Ingreso {
    private HashMap<String, String> usuarios;

    public Ingreso(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean verificarUsuario(String usuario) throws UsuarioNoEncontradoException {
        if (!usuarios.containsKey(usuario)) {
            throw new UsuarioNoEncontradoException("El usuario no se encontró.");
        }
        return true;
    }
}

class Autenticacion {
    private HashMap<String, String> usuarios;

    public Autenticacion(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean autenticarUsuario(String usuario, String contraseña) throws ContraseñaIncorrectaException {
        if (!usuarios.containsKey(usuario)) {
            throw new ContraseñaIncorrectaException("La contraseña es incorrecta.");
        }
        String contraseñaAlmacenada = usuarios.get(usuario);
        if (!contraseñaAlmacenada.equals(contraseña)) {
            throw new ContraseñaIncorrectaException("La contraseña es incorrecta.");
        }
        return true;
    }
}

class MainApp {
    public static void main(String[] args) {
        Registro registro = new Registro();
        HashMap<String, String> usuarios = registro.getUsuarios(); // Obtén la lista de usuarios registrados

        try {
            //Registro de usuarios
            registro.registrarUsuario("usuario1", "contrasena1");
            registro.registrarUsuario("usuario2", "contrasena2");

            // Intento de ingresar y autenticar usuarios
            Ingreso ingreso = new Ingreso(usuarios);
            Autenticacion autenticacion = new Autenticacion(usuarios);

            String usuarioIngresar = "usuario1";
            String contraseñaCorrecta = "contrasena1";
            String contraseñaIncorrecta = "contrasenaIncorrecta";

            if (ingreso.verificarUsuario(usuarioIngresar)) {
                if (autenticacion.autenticarUsuario(usuarioIngresar, contraseñaCorrecta)) {
                    System.out.println("Autenticación exitosa para " + usuarioIngresar);
                } else {
                    System.out.println("La contraseña es incorrecta.");
                }
            }
        } catch (UsuarioYaExistenteException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Error al ingresar usuario: " + e.getMessage());
        } catch (ContraseñaIncorrectaException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
        }
    }
}