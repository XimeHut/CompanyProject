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

public class TrabajaEPGUI extends JFrame implements ActionListener
{
    private JTextField tfNoProyecto, tfNoSS, tfHoras;
    private JButton    bCapturar, bConsultar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
private CompanyAD company = new CompanyAD();
    
    public TrabajaEPGUI()
    {
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfNoProyecto = new JTextField();
        tfNoSS = new JTextField();
        tfHoras = new JTextField();
        
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
        panel1.add(new JLabel("ASIGNACION DE EMPLEADOS"));
        panel1.add(new JLabel(" A PROYECTOS"));
        panel1.add(new JLabel("No. de proyecto: "));
        panel1.add(tfNoProyecto);
        panel1.add(new JLabel("No. de SS:"));
        panel1.add(tfNoSS);
    	panel1.add(new JLabel("Horas:"));
        panel1.add(tfHoras);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bSalir);
        
        // 4. Adicionar panel1 y taDatos al panel2
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 5. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(350,350);
//        setVisible(true);
    }
    public JPanel getPanel2()
    {
    	return this.panel2;
    }
    
    private String obtenerDatos()
    {
        String datos="";
//      private JTextField tfNoProyecto, tfNoSS, tfHoras;
             
        String nproy = tfNoProyecto.getText();
        String numeroe = tfNoSS.getText(); 
        String horas  = tfHoras.getText();
        if(numeroe.equals("") || nproy.isEmpty() || horas.equals(""))
            datos = "VACIO";
        else
        {
           try
            {
                int n = Integer.parseInt(horas);
                datos = nproy+"_"+numeroe+"_"+horas;
            }
            catch(NumberFormatException nfe)
            {
                datos = "NO_NUMERICO";
            }
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	String datos="",respuesta="";
    	if(event.getSource()== bCapturar)
    	{
    		 // 1. Obtener datos
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
            else
                if(datos.equals("NO_NUMERICO"))
                    respuesta = "Saldo debe ser numerico...";
                else
                	respuesta=company.capturar("trabaja", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
    	}
    	
    	    if (event.getSource()== bConsultar)
        {
        	datos=company.consultarT();
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
        TrabajaEPGUI localidad = new TrabajaEPGUI();
    }
}
