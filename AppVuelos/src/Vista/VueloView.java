package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;



/**
 *
 * @author l1ghtm4n
 */
public class VueloView extends JFrame{
    public JTextField txtNumero = new JTextField();
    public JTextField txtOrigen = new JTextField();
    public JTextField txtDestino = new JTextField();
    public JTextField txtFecha = new JTextField();
    public JTextField txtAereolinea = new JTextField();
    public JButton btnCrear = new JButton("Enviar");
    public JButton btnLeer = new JButton("Leer");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLeerTodos = new JButton("Leer todos");
    public JButton btnMostrarAsientosDisponibles = new JButton("Mostrar asientos");
    
    public VueloView(){
        super("Ventana 1");
        
        setSize(1300, 740);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cerrar el programa con el boton de cerral 
        setLocationRelativeTo(null); //La ventana por defecto ya a estar en la mitad de la pantalla
        getContentPane().setBackground(Color.DARK_GRAY);
        setResizable(false);//no deja cambiar el tamaño al usuario

        
        setLayout(null);//deja hacer lo que quiera
        
        
        //Titulo
        JLabel texto1 = new JLabel("Bienvenidos");
        texto1.setBounds(0, 0, 1300,100); //posicion x,y y tamaño
        texto1.setOpaque(true); //fondo
        texto1.setBackground(Color.lightGray);//color fondo
        texto1.setFont(new Font("Arial",Font.BOLD,45));// tipo letra, negrilla, tamaño
        texto1.setForeground(Color.white);//Color letra
        texto1.setHorizontalAlignment(SwingConstants.CENTER);//alinear con centro
        //cambiar center si se quiere diferente
        add(texto1);//añadir a la ventana
        
        //Numero vuelo
        JLabel numeroField = new JLabel("ingrese el numero del vuelo: ");
        numeroField.setBounds(10, 110, 600, 100);
        numeroField.setFont(new Font("Arial",Font.BOLD, 20));
        numeroField.setForeground(Color.white);
        
        add(numeroField);
        
        
        
        txtNumero.setBounds(350, 150, 200, 30);
        txtNumero.setFont(new Font("Arial", Font.ITALIC, 25));
        
        add(txtNumero);
        
        
        
        
        //OrigenVuelo
        JLabel origenField = new JLabel("ingrese origen del vuelo: ");
        origenField.setBounds(10, 210, 600, 100);
        origenField.setFont(new Font("Arial",Font.BOLD, 20));
        origenField.setForeground(Color.white);
        
        add(origenField);
        
       
        
        txtOrigen.setBounds(350, 250, 200, 30);
        txtOrigen.setFont(new Font("Arial", Font.ITALIC, 25));
        
        add(txtOrigen);
        
        
        
        //Destino vuelo
        JLabel destinoField = new JLabel("ingrese el destino del vuelo: ");
        destinoField.setBounds(10, 310, 600, 100);
        destinoField.setFont(new Font("Arial",Font.BOLD, 20));
        destinoField.setForeground(Color.white);
        
        add(destinoField);
        
        
        
        txtDestino.setBounds(350, 350, 200, 30);
        txtDestino.setFont(new Font("Arial", Font.ITALIC, 25));
        
        add(txtDestino);
        
        
        
        //Fecha vuelo
        JLabel fechaField = new JLabel("ingrese la fecha del vuelo: ");
        fechaField.setBounds(10, 410, 600, 100);
        fechaField.setFont(new Font("Arial",Font.BOLD, 20));
        fechaField.setForeground(Color.white);
        
        add(fechaField);
        
        
        
        txtFecha.setBounds(350, 450, 200, 30);
        txtFecha.setFont(new Font("Arial", Font.ITALIC, 25));
        
        add(txtFecha);
        
        
        
        //nombre aereolinea
        JLabel aereolineaField = new JLabel("ingrese la aereolinea: ");
        aereolineaField.setBounds(10, 510, 600, 100);
        aereolineaField.setFont(new Font("Arial",Font.BOLD, 20));
        aereolineaField.setForeground(Color.white);
        
        add(aereolineaField);
        
        
        
        txtAereolinea.setBounds(350, 550, 200, 30);
        txtAereolinea.setFont(new Font("Arial", Font.ITALIC, 25));
        
        add(txtAereolinea);
        
        
        
        ///
        JLabel filaColumna = new JLabel("la fila es: "+ "la culumna es: ");//terminar
        filaColumna.setBounds(650, 110, 600, 100);
        filaColumna.setFont(new Font("Arial", Font.BOLD, 20));
        filaColumna.setForeground(Color.white);
        
        add(filaColumna);
        
        
        btnCrear.setBounds(10,630,150,50);
        //agregar funcionalidad
        btnCrear.setFont(new Font("Arial", Font.BOLD, 30));
        add(btnCrear);
        
        
        btnLeer.setBounds(180, 630, 150, 50);
        btnLeer.setFont(new Font("Arial", Font.BOLD, 30));
        add(btnLeer);
        
        btnActualizar.setBounds(350, 630, 200, 50);
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 30));
        add(btnActualizar);
        
        btnEliminar.setBounds(570, 630, 200, 50);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 30));
        add(btnEliminar);
        
        btnLeerTodos.setBounds(790, 630, 220, 50);
        btnLeerTodos.setFont(new Font("Arial", Font.BOLD, 30));
        add(btnLeerTodos);
        
        btnMostrarAsientosDisponibles.setBounds(1030, 630, 250, 50);
        btnMostrarAsientosDisponibles.setFont(new Font("Arial", Font.BOLD, 25));
        add(btnMostrarAsientosDisponibles);
        
        setVisible(true); // Ultima linea siempre     
    }
}
