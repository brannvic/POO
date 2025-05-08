//importamos las librerías que utilizaremos
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
//Vamos a escribir el nombre de nuestra clase
public class Licencia extends JFrame implements ActionListener, ChangeListener{
  //creamos los componntes de nuestra clase
  private JLabel label1, label2;
  private JCheckBox check1;
  private JButton boton1, boton2;
  private JScrollPane scrollpane1;
  private JTextArea textarea1;
  String nombre = "";
   //creamos nuestr constructor 
  public Licencia(){
       //agregamos el método setlayout
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
       //agregamos imagen al ícono
        setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;
        //creamos el objeto y agregamos dimensiones, coordenadas y tipoi de fuente
        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215,5,200,30);
        label1.setFont(new Font("Arial", 2, 14));
        label1.setForeground(new Color(0,0,0));
        add(label1);
        //agregamos el componente jtextarea
        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Arial", 0, 9));
        textarea1.setText("\n\n       TÉRMINOS Y CONDICIONES" +
                    "\n\n            A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUROTIZACIÓN DEL ESTADIO AZTECA" +
                    "\n            B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS." +
                    "\n            C. EL ESTADIO AZTECA NO SE HACE RESPONDABLE DEL MAL USO DE ESTE SOFTWARE" +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUCACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (EL ESTADIO AZTECA Y EL AUTOR GERARDO TREVIÑO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS  SERVICIOS, POR FAVOR VISITE" + 
                    "\n          https://www.estadioazteca.com.mx/");
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,10,575,200);
        add(scrollpane1);
        //agregamos el componente checkbox
        check1 = new JCheckBox("Yo, " + nombre + " acepto");
        check1.setBounds(10,240,300,30);
        check1.addChangeListener(this);
        add(check1);
        //agregamos el boton1
        boton1 = new JButton("Continuar");
        boton1.setBounds(10,280,100,30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);
        //agregamos el boton2
        boton2 = new JButton("No acepto");
        boton2.setBounds(120,280,100,30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);
        //agregamos el label2
        ImageIcon imagen = new ImageIcon("images/logotipo.png");
        label2 = new JLabel(imagen);
        //damos dimensiones y coordenadas
        label2.setBounds(315,75,330,420);      
        add(label2);
  }
  //ponemos las estructuras de donde iran los eventos
  public void stateChanged(ChangeEvent e){
      if(check1.isSelected() == true){
          boton1.setEnabled(false);
          boton1.setEnabled(true);
        }else{
          boton1.setEnabled(false);
          boton1.setEnabled(false);
        }
        }
public void actionPerformed(ActionEvent e){
      if(e.getSource() == boton1){
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0,0,640,535);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
        this.setVisible(false);
        } else if(e.getSource() == boton2){
        Bienvenida ventanabienvenida = new Bienvenida();
        ventanabienvenida.setBounds(0,0,350,450);
        ventanabienvenida.setVisible(false);
        ventanabienvenida.setResizable(true);
        ventanabienvenida.setLocationRelativeTo(null);
        this.setVisible(false);   
      } 
    }
//agregamos el metodo main
public static void main(String args []){
     Licencia ventanalicencia = new Licencia();
     ventanalicencia.setBounds(0,0,600,360);
     ventanalicencia.setVisible(true);
     ventanalicencia.setResizable(false);
     ventanalicencia.setLocationRelativeTo(null);
}
}