import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.*;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProyectoGUI extends JFrame implements ActionListener
{
    private JTextField tfNoProyecto, tfNombre, tfLugar, tfNoDepto;
    private JButton    bCapturar, bConsultar, bConsultarNoProy, bModificar, bCancelar, bActualizar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    private CompanyAD company = new CompanyAD();
//    private ProyectoDP ecuacion = new ProyectoDP();
    
    public ProyectoGUI()
    {
        super("Proyecto");
        
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfNoProyecto = new JTextField();
        tfNombre = new JTextField();
        tfLugar = new JTextField();
        tfNoDepto = new JTextField();
        
        bCapturar = new JButton("Captura Proyecto");
        bConsultar= new JButton("Consulta General");
        bConsultarNoProy= new JButton("Consulta No. Proyecto: ");
        bModificar= new JButton("Modificar datos: ");
        bCancelar= new JButton("Cancelar Transaccion");
        bActualizar= new JButton("Actualizar datos");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarNoProy.addActionListener(this);
        bModificar.addActionListener(this);
        bCancelar.addActionListener(this);
        bActualizar.addActionListener(this);
        bSalir.addActionListener(this);
        
        bCancelar.setEnabled(false);
        bActualizar.setEnabled(false);
        
        taDatos   = new JTextArea(15,40);
        
        panel1    = new JPanel();
        panel2   = new JPanel();
        
        // 2. Definir el Layout los JPanels
        panel1.setLayout(new GridLayout(11,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los JPanels
        panel1.add(new JLabel("CATALOGO DE PROYECTOS"));
        panel1.add(new JLabel());
        panel1.add(new JLabel("No. de Proyecto: "));
        panel1.add(tfNoProyecto);
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Lugar: "));
        panel1.add(tfLugar);
        panel1.add(new JLabel("No. de Departamento"));
        panel1.add(tfNoDepto);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarNoProy); 
        panel1.add(bModificar);
        panel1.add(bCancelar);
        panel1.add(bActualizar);
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
        String datos;
//      private JTextField tfNoProyecto, tfNombre, tfLugar, tfNoDepto;
        String numeroP = tfNoProyecto.getText();
        String nombreP = tfNombre.getText();
        String localidad  = tfLugar.getText();
        String numerod = tfNoDepto.getText();
       
        if(numeroP.equals("") || nombreP.isEmpty() || localidad.equals("") || numerod.isEmpty())
            datos = "VACIO";
        else
        {
           datos = numeroP+"_"+nombreP+"_"+localidad+"_"+numerod;
        }
        return datos;
    }
    
    private void inactivarBotones()
    {
    	bCapturar.setEnabled(false);
    	bConsultar.setEnabled(false);
    	bConsultarNoProy.setEnabled(false);
    	bModificar.setEnabled(false);
    	
    	bCancelar.setEnabled(true);
        bActualizar.setEnabled(true);
       	
    }
    
      private void activarBotones()
    {
    	bCapturar.setEnabled(true);
    	bConsultar.setEnabled(true);
    	bConsultarNoProy.setEnabled(true);
    	bModificar.setEnabled(true);
    	
    	bCancelar.setEnabled(false);
        bActualizar.setEnabled(false);
    }
    
    private void desplegar(String datos)
    {
    	StringTokenizer st = new StringTokenizer(datos, "_");
        tfNoProyecto.setText(st.nextToken());
        tfNombre.setText(st.nextToken());
    	tfLugar.setText(st.nextToken());
        tfNoDepto.setText(st.nextToken());
    }
    
    private void borrar()
    {
        tfNoProyecto.setText(null);
        tfNombre.setText(null);
    	tfLugar.setText(null);
        tfNoDepto.setText(null);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	String respuesta="", datos="";
       if(event.getSource()==bCapturar) 
       {
       	datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
                else
                	respuesta=company.capturar("proyecto", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
       }
       
           if (event.getSource()== bConsultar)
        {
        	datos=company.consultarP();
        	taDatos.setText(datos);
        }
        
          if (event.getSource()== bConsultarNoProy)
        {
        	String no = tfNoProyecto.getText();
//        	System.out.println(no);
            // 1. Realizar consulta de clientes
            
            datos = company.consultarNoP(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el proyecto: "+no);
           else{
            // 2. Desplegar datos
            desplegar(datos); // para que los ponga en los textfields
            taDatos.setText(datos);
           }
        }
        
         if(event.getSource() == bModificar)
       	 {
           String no = tfNoProyecto.getText();
            // 1. Realizar consulta de clientes
            datos = company.consultarNoP(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el proyecto: "+no);
            	
           else{
            // 2. Desplegar datos
            desplegar(datos); // para que los ponga en los textfields
            taDatos.setText(datos);
         	inactivarBotones();
           }
         }
           
         if(event.getSource() == bActualizar)
        {
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
                else
                	respuesta=company.actualizarProyecto(datos);
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
            activarBotones();
            borrar();
        }
           
           
         if(event.getSource() == bCancelar)
       	{
       		borrar();
           activarBotones();
           }
           
        if(event.getSource() == bSalir)
        {
//            System.exit(0);
				borrar();
				panel2.setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        ProyectoGUI proyecto = new ProyectoGUI();
    }
}
