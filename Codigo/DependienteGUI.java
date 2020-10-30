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

public class DependienteGUI extends JFrame implements ActionListener
{
    private JTextField tfNombre, tfNoSS, tfParentesco, tfSexo, tfFechaNacimiento;
    private JButton    bCapturar, bConsultar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
	private CompanyAD company = new CompanyAD();
    
    public DependienteGUI()
    {
        super("Dependiente");
        
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfNombre = new JTextField();
        tfNoSS = new JTextField();
        tfParentesco = new JTextField();
       	tfSexo= new JTextField();
       	tfFechaNacimiento= new JTextField();
        
        bCapturar = new JButton("Capturar");
        bConsultar= new JButton("Consulta General");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bSalir.addActionListener(this);
        
        taDatos   = new JTextArea(15,40);
        
        panel1    = new JPanel();
        panel2   = new JPanel();
        
        // 2. Definir el Layout los JPanels
        panel1.setLayout(new GridLayout(8,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los JPanels
        panel1.add(new JLabel("DEPENDIENTES DE EMPLEADOS"));
        panel1.add(new JLabel());
        panel1.add(new JLabel("No. de SS: "));
        panel1.add(tfNoSS);
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Parentesco: "));
        panel1.add(tfParentesco);
        panel1.add(new JLabel("Sexo: "));
        panel1.add(tfSexo);
        panel1.add(new JLabel("Fecha de nacimiento"));
        panel1.add(tfFechaNacimiento);
        
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
//      private JTextField tfNombre, tfNoSS, tfParentesco, tfSexo, tfFechaNacimiento;
        String nombreD = tfNombre.getText();        
        String fecha = tfFechaNacimiento.getText();
        String nss  = tfNoSS.getText();
        String parentesco= tfParentesco.getText();
        String sexo= tfSexo.getText();
        
        if(nombreD.equals("") || fecha.isEmpty() || nss.equals("") || parentesco.isEmpty() || sexo.isEmpty())
            datos = "VACIO";
        else
        {
           datos = nss+"_"+nombreD+"_"+fecha+"_"+sexo+"_"+parentesco;
        }
        return datos;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        String datos="";
        String respuesta="";
        
         if(event.getSource() == bCapturar)
        {
//       	 // 1. Obtener datos
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
                else
                	respuesta=company.capturar("dependiente", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        	
        }
        
        if (event.getSource()== bConsultar)
        {
        	datos=company.consultarD();
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
        DependienteGUI dependiente = new DependienteGUI();
    }
}
