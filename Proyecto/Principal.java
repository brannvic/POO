//importamos las librerías que utilizaremos
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Vamos a escribir el nombre de nuestra clase
public class Principal extends JFrame implements ActionListener{
  //creamos los componntes de nuestra clase
    private JMenuBar mb;
    private JMenu menuOpciones,menuCalcular,menuAcercaDe,menuColorFondo;
    private JMenuItem miCalculo,miRojo,miAzul,miMorado,miElCreador,miSalir,miNuevo;
    private JLabel labelLogo,labelBienvenido,labelTitle,labelNombre,labelAPaterno,labelAMaterno,
                   labelDepartamento,labelAntiguedad,labelResultado,labelfooter;
    private JTextField txtNombreTrabajador,txtAPaternoTrabajador,txtAMaternoTrabajador;
    private JComboBox comboDepartamento,comboAntiguedad;
    private JScrollPane scrollpane1; 
    private JTextArea textarea1;
    String nombreAdministrador = "";
  //creamos el constructor
  public Principal() {
      //agregamso el setlayout
      setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Pantalla principal");
      getContentPane().setBackground(new Color(255,255,255));
      setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
      Bienvenida ventanaBienvenida = new Bienvenida();
      nombreAdministrador = ventanaBienvenida.texto;
      //le damos diseño a los comonentes menubar
      mb = new JMenuBar();
      mb.setBackground(new Color(255, 255, 255));
      setJMenuBar(mb);
      //comenzamos a agregar nustro menu de opciones
      menuOpciones = new JMenu("Opciones");
      menuOpciones.setBackground(new Color(255, 255, 255));
      menuOpciones.setFont(new Font("Arial", 1, 14));
      menuOpciones.setForeground(new Color(0, 0, 0));
      mb.add(menuOpciones);
      //comenzamos a agregar nustro menu de calcular
      menuCalcular = new JMenu("Calcular");
      menuCalcular.setBackground(new Color(255, 255, 255));
      menuCalcular.setFont(new Font("Arial", 1, 14));
      menuCalcular.setForeground(new Color(0, 0, 0));
      mb.add(menuCalcular);
      //comenzamos a agregar nustro menu de acerca de
      menuAcercaDe = new JMenu("Acerca de");
      menuAcercaDe.setBackground(new Color(255, 255, 255));
      menuAcercaDe.setFont(new Font("Arial", 1, 14));
      menuAcercaDe.setForeground(new Color(0, 0, 0));
      mb.add(menuAcercaDe);
      //haremos que se puyedan desplegar las opciones
      //agregamos la opcion de cambiar el fondo
      menuColorFondo = new JMenu("Color de fondo");
      menuColorFondo.setFont(new Font("Arial", 1, 14));
      menuColorFondo.setForeground(new Color(0, 0, 0));
      menuOpciones.add(menuColorFondo);
      //agregamos la opcion de vacaciones
      miCalculo = new JMenuItem("Vacaciones");
      miCalculo.setFont(new Font("Arial", 1, 14));
      miCalculo.setForeground(new Color(0, 0, 0));
      menuCalcular.add(miCalculo);
      miCalculo.addActionListener(this);
      //agregamos los colores por los que se podrá cambiar el fondo
      miRojo = new JMenuItem("Rojo");
      miRojo.setFont(new Font("Arial", 1, 14));
      miRojo.setForeground(new Color(0, 0, 0));
      menuColorFondo.add(miRojo);
      miRojo.addActionListener(this);

      miAzul = new JMenuItem("Azul");
      miAzul.setFont(new Font("Arial", 1, 14));
      miAzul.setForeground(new Color(0, 0, 0));
      menuColorFondo.add(miAzul);
      miAzul.addActionListener(this);

      miMorado = new JMenuItem("Morado");
      miMorado.setFont(new Font("Arial", 1, 14));
      miMorado.setForeground(new Color(0, 0, 0));
      menuColorFondo.add(miMorado);
      miMorado.addActionListener(this);
      //Agregamos los 3 ultimos items, nuevo, datos y salir
      miNuevo = new JMenuItem("Nuevo");
      miNuevo.setFont(new Font("Arial", 1, 14));
      miNuevo.setForeground(new Color(0, 0, 0));
      menuOpciones.add(miNuevo);
      miNuevo.addActionListener(this);

      miElCreador = new JMenuItem("El creador");
      miElCreador.setFont(new Font("Arial", 1, 14));
      miElCreador.setForeground(new Color(0, 0, 0));
      menuAcercaDe.add(miElCreador);
      miElCreador.addActionListener(this);

      miSalir = new JMenuItem("Salir");
      miSalir.setFont(new Font("Arial", 1, 14));
      miSalir.setForeground(new Color(0, 0, 0));
      menuOpciones.add(miSalir);
      miSalir.addActionListener(this);
      //agregamos el label que contendrá la imagen
      ImageIcon imagen = new ImageIcon("images/logotipo.png");
      labelLogo = new JLabel(imagen);  
      labelLogo.setBounds(5,5,250,142);
      add(labelLogo);
      //agregamos el label que da l bienvenida al usuario
      labelBienvenido = new JLabel("Bienvenido " + nombreAdministrador);  
      labelBienvenido.setBounds(280,30,300,50);
      labelBienvenido.setFont(new Font("Arial", 1, 32));
      labelBienvenido.setForeground(new Color(0, 0, 0));
      add(labelBienvenido);
      //agregamos el label que dice datos del trabajador
      labelTitle = new JLabel("Datos del trabajador para el cálculo de vacaciones");
      labelTitle.setBounds(45,160,900,25);
      labelTitle.setFont(new Font("Arial", 0, 24));
      labelTitle.setForeground(new Color(0, 0, 0));
      add(labelTitle);
      //agregamos el diseño de cada label
      //agregamos label y jtextfield que dice nombre completo
      labelNombre = new JLabel("Nombre(s):");
      labelNombre.setBounds(25,188,180,25);
      labelNombre.setFont(new Font("Arial", 1, 12));
      labelNombre.setForeground(new Color(0, 0, 0));
      add(labelNombre);
      txtNombreTrabajador = new JTextField();
      txtNombreTrabajador.setBounds(25,213,150,25);
      txtNombreTrabajador.setBackground(new java.awt.Color(224, 224, 224));
      txtNombreTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
      txtNombreTrabajador.setForeground(new java.awt.Color(0, 0, 0));
      add(txtNombreTrabajador);
      //agregamos label y jtextfield que dice apellido paterno
      labelAPaterno = new JLabel("Apellido Paterno:");
      labelAPaterno.setBounds(25,248,180,25);
      labelAPaterno.setFont(new Font("Arial", 1, 12));
      labelAPaterno.setForeground(new Color(0, 0, 0));
      add(labelAPaterno);
      txtAPaternoTrabajador = new JTextField();
      txtAPaternoTrabajador.setBounds(25,273,150,25);
      txtAPaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
      txtAPaternoTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
      txtAPaternoTrabajador.setForeground(new java.awt.Color(0, 0, 0));
      add(txtAPaternoTrabajador);
      //agregamos label y jtextfield que dice apellido materno
      labelAMaterno = new JLabel("Apellido Materno:");
      labelAMaterno.setBounds(25,308,180,25);
      labelAMaterno.setFont(new Font("Arial", 1, 12));
      labelAMaterno.setForeground(new Color(0, 0, 0));
      add(labelAMaterno);
      txtAMaternoTrabajador = new JTextField();
      txtAMaternoTrabajador.setBounds(25,334,150,25);
      txtAMaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
      txtAMaternoTrabajador.setFont(new java.awt.Font("Arial", 1, 14));
      txtAMaternoTrabajador.setForeground(new java.awt.Color(0, 0, 0));
      add(txtAMaternoTrabajador);
      //agregamos label y combobox para departamento
      labelDepartamento = new JLabel("Selecciona el Departamento:");
      labelDepartamento.setBounds(220,188,180,25);
      labelDepartamento.setFont(new Font("Arial", 1, 12));
      labelDepartamento.setForeground(new Color(0, 0, 0));
      add(labelDepartamento);
      comboDepartamento = new JComboBox();
      comboDepartamento.setBounds(220,213,220,25);
      comboDepartamento.setBackground(new java.awt.Color(224, 224, 224));
      comboDepartamento.setFont(new java.awt.Font("Arial", 1, 14));
      comboDepartamento.setForeground(new java.awt.Color(0, 0, 0));
      add(comboDepartamento);
      comboDepartamento.addItem("");
      comboDepartamento.addItem("Atención al Cliente");
      comboDepartamento.addItem("Departamento de Logística");
      comboDepartamento.addItem("Departamento de Gerencia");
      //agregamos label y combobox para aniguedad
      labelAntiguedad = new JLabel("Selecciona la Antigüedad:");
      labelAntiguedad.setBounds(220,248,180,25);
      labelAntiguedad.setFont(new Font("Arial", 1, 12));
      labelAntiguedad.setForeground(new Color(0, 0, 0));
      add(labelAntiguedad);
      comboAntiguedad = new JComboBox();
      comboAntiguedad.setBounds(220,273,220,25);
      comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224));
      comboAntiguedad.setFont(new java.awt.Font("Arial", 1, 14));
      comboAntiguedad.setForeground(new java.awt.Color(0, 0, 0));
      add(comboAntiguedad);
      comboAntiguedad.addItem("");
      comboAntiguedad.addItem("1 año de servicio");
      comboAntiguedad.addItem("2 a 6 años de servicio");
      comboAntiguedad.addItem("7 años o más de servicio");
      //agregamos label y combobox para resultado del calculo
      labelResultado = new JLabel("Resultado del Cálculo:");
      labelResultado.setBounds(220,307,180,25);
      labelResultado.setFont(new Font("Arial", 1, 12));
      labelResultado.setForeground(new Color(0, 0, 0));
      add(labelResultado);
      textarea1 = new JTextArea();
      textarea1.setEditable(false);
      textarea1.setBackground(new Color(224, 224, 224));
      textarea1.setFont(new Font("Arial", 1, 11));
      textarea1.setForeground(new Color(0, 0, 0));
      textarea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");
      scrollpane1 = new JScrollPane(textarea1);
      scrollpane1.setBounds(220,333,385,90);
      add(scrollpane1); 
      //agregamos la leyenda del inferior y utilizaremos un label
      labelfooter = new JLabel("©2022 Estadio Azteca | Todos los derechos reservados");
      labelfooter.setBounds(135,445,500,30);
      labelfooter.setFont(new java.awt.Font("Arial", 1, 12));
      labelfooter.setForeground(new java.awt.Color(0, 0, 0));
      add(labelfooter);
    }
    //agregamos las estructuras correspondientes a nuestros eventos
    public void actionPerformed(ActionEvent e) {
    //agregamos las condicionales if
if (e.getSource() == miCalculo) {    
    //declaramos las 5 variables
    String nombreTrabajador = txtNombreTrabajador.getText();
    String AP = txtAPaternoTrabajador.getText();
    String AM = txtAMaternoTrabajador.getText();
    String Departamento = comboDepartamento.getSelectedItem().toString();
    String Antiguedad = comboAntiguedad.getSelectedItem().toString();
    //agregamos una estructura condicional if else
if(nombreTrabajador.equals("") || AP.equals("") || AM.equals("") ||
        Departamento.equals("") || Antiguedad.equals("")){
            JOptionPane.showMessageDialog(null,"Debes de llenar todos los campos.");
} else {
if(Departamento.equals("Atención al Cliente")){
    //escribimos 3 if anidados
if(Antiguedad.equals("1 año de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 6 días de vacaciones.");
}
if(Antiguedad.equals("2 a 6 años de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 14 días de vacaciones.");
}
if(Antiguedad.equals("7 años o más de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 20 días de vacaciones.");
}
  }
//escribimos la condicional para el departamento de logistica
if(Departamento.equals("Departamento de Logística")){
if(Antiguedad.equals("1 año de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                    "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                    "\n   recibe 7 días de vacaciones.");
}
if(Antiguedad.equals("2 a 6 años de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 15 días de vacaciones.");
}
if(Antiguedad.equals("7 años o más de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 22 días de vacaciones.");
}
  }
//aplicamos las condicionales if pra el departamento de gerencia
if(Departamento.equals("Departamento de Gerencia")){
if(Antiguedad.equals("1 año de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 10 días de vacaciones.");
}
if(Antiguedad.equals("2 a 6 años de servicio")){
   textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                     "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                     "\n   recibe 20 días de vacaciones.");
}
if(Antiguedad.equals("7 años o más de servicio")){
  textarea1.setText("\n   El trabajador " + nombreTrabajador + " " + AP + " " + AM + 
                    "\n   quien labora en " + Departamento + " con " + Antiguedad + 
                    "\n   recibe 30 días de vacaciones.");
}
  }
    }
}
    //agregamos el rgb de los colores de fondo
if (e.getSource() == miRojo){
    getContentPane().setBackground(new Color(220,0,0));
        }
if (e.getSource() == miAzul){
    getContentPane().setBackground(new Color(0,0,150));
        }
if (e.getSource() == miMorado){
     getContentPane().setBackground(new Color(51,0,51));
        }
        //hacemos el mecanismo de nuevo y salir
if (e.getSource() == miNuevo){
    txtNombreTrabajador.setText(""); 
    txtAPaternoTrabajador.setText("");
    txtAMaternoTrabajador.setText("");
    comboDepartamento.setSelectedIndex(0);
    comboAntiguedad.setSelectedIndex(0);
    textarea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");	 
        }
if (e.getSource() == miSalir){
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setBounds(0,0,350,450);
    ventanabienvenida.setVisible(true);
    ventanabienvenida.setResizable(false);
    ventanabienvenida.setLocationRelativeTo(null);
    this.setVisible(false);
    }
    //agregamos la información del creador del programa
        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null,"Desarrollado por Gerardo Treviño\n"+
                                               "       https://www.estadioazteca.com.mx");
}
}

//agregamos el metodo main
  public static void main(String args[]) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0,0,640,535);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
}
}