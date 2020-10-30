import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalidadGUI extends JFrame implements ActionListener
{
    private JTextField tfNoDepto, tfNombre, tfDireccion, tfTelefono;
    private JButton    bCapturar,bConsultar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
	private CompanyAD company = new CompanyAD();
    
    public LocalidadGUI()
    {
        super("Localidad");
        
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfNoDepto = new JTextField();
        tfNombre = new JTextField();
        tfDireccion = new JTextField();
        tfTelefono = new JTextField();
        
        bCapturar = new JButton("Capturar");
        bConsultar = new JButton("Consulta general");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bSalir.addActionListener(this);
        
        taDatos   = new JTextArea(15,40);
        
        panel1    = new JPanel();
        panel2   = new JPanel();
        
        // 2. Definir el Layout los JPanels
        panel1.setLayout(new GridLayout(7,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los JPanels
        panel1.add(new JLabel("LOCALIDAD"));
        panel1.add(new JLabel());
        panel1.add(new JLabel("No. de Depto: "));
        panel1.add(tfNoDepto);
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Direccion: "));
        panel1.add(tfDireccion);
        panel1.add(new JLabel("Telefono: "));
        panel1.add(tfTelefono);
    
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bSalir);
        
        // 4. Adicionar panel1 y taDatos al panel2
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 5. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(400,450);
//        setVisible(true);
    }
    public JPanel getPanel2()
    {
    	return this.panel2;
    }
    
	private String obtenerDatos()
    {
        String datos;
//      private JTextField tfNoDepto, tfNombre, tfDireccion, tfTelefono;
        String numerod = tfNoDepto.getText();
        String nombred = tfNombre.getText();
        String direccion1  = tfDireccion.getText();
        String telefono= tfTelefono.getText();
       
        if(numerod.equals("") || nombred.isEmpty() || direccion1.equals("") || telefono.isEmpty())
            datos = "VACIO";
        else
        {
           datos = numerod+"_"+nombred+"_"+direccion1+"_"+telefono;
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent event)
    {
    		String respuesta ="",datos="";
        
        
               if(event.getSource()== bCapturar)
        {
        	 // 1. Obtener datos
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";  
                else
                	respuesta=company.capturar("localidad", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        	
        	
        }
        
        if (event.getSource()== bConsultar)
        {
        	datos=company.consultarL();
        	taDatos.setText(datos);
        }
        
        
        if(event.getSource() == bSalir)
        {
//            System.exit(0);
				panel2.setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        LocalidadGUI localidad = new LocalidadGUI();
    }
}
