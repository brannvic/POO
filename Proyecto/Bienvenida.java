//importamos las librerías que utilizaremos
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Vamos a escribir el nombre de nuestra clase
public class Bienvenida extends JFrame implements ActionListener{
  //creamos los componentes de nuestra clase
  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;
  public static String texto = "";
    //creamos nuestr constructor 
  public Bienvenida(){
        //agregamos el método setlayout
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        //indicmos el color de la interfaz
        getContentPane().setBackground(new Color(255,255,255));
        //agregamos imagen al ícono
        setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());
        //creamos un objeto imageIcon ara agfregar el logo de nuestra interfaz
        ImageIcon imagen = new ImageIcon("images/logotipo.png");
        label1 = new JLabel(imagen);
        //damos dimensiones y coordenadas
        label1.setBounds(25,15,300,150);
        add(label1);
        //creamos el objeto y agregamos dimensiones, coordenadas y tipoi de fuente
        label2 = new JLabel("Sistema de Control Vacacional");
        label2.setBounds(50,165,300,30);
        label2.setFont(new Font("Arial", 2, 16));
        label2.setForeground(new Color(0,0,0));
        add(label2);
        //diseñamos las siguientes etiquetas
        label3 = new JLabel("Ingrese su nombre");
        label3.setBounds(45,212,200,30);
        label3.setFont(new Font("Arial", 2, 12));
        label3.setForeground(new Color(0,0,0));
        add(label3);
        
        label4 = new JLabel("®2022 Estadio Azteca");
        label4.setBounds(100,375,300,30);
        label4.setFont(new Font("Arial", 2, 12));
        label4.setForeground(new Color(0,0,0));
        add(label4);
        //ingresamos el componente de textfield
        textfield1 = new JTextField ();
        textfield1.setBounds(45,240,255,25);
        textfield1.setBackground(new Color(224,224,224));
        label4.setFont(new Font("Arial", 2, 14));
        label4.setForeground(new Color(0,0,0));
        add(textfield1);
        //agregamos el boton ingresar, le damos dimensiones y color
        boton1 = new JButton("Ingresar");
        boton1.setBounds(125,300,100,30);
        boton1.setBackground(new Color(255,255,255));
        boton1.setFont(new Font("Arial", 2, 14));
        boton1.setForeground(new Color(0,0,0));
        boton1.addActionListener(this);
        add(boton1);
    }
     //creamos el evento al boton
    public void actionPerformed(ActionEvent e){
     //creamos la estructura condicional if
     if(e.getSource() == boton1){
         //damos funcion al boton
         texto = textfield1.getText().trim();
         //creamos otra estructura if
     if(texto.equals("")){
     JOptionPane.showMessageDialog(null, "Debe ingresar tu nombre");
     }else {
     Licencia ventanalicencia = new Licencia();
     ventanalicencia.setBounds(0,0,600,360);
     ventanalicencia.setVisible(true);
     ventanalicencia.setResizable(false);
     ventanalicencia.setLocationRelativeTo(null);
     this.setVisible(false);
     }
    }
   }
   //creamos el metodo main y damos dimensiones y coordenadas al interfaz
   public static void main(String args[]){
     Bienvenida ventanabienvenida = new Bienvenida();
     ventanabienvenida.setBounds(0,0,350,450);
     ventanabienvenida.setVisible(true);
     ventanabienvenida.setResizable(false);
     ventanabienvenida.setLocationRelativeTo(null);
   }
}