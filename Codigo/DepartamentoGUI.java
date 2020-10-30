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

public class DepartamentoGUI extends JFrame implements ActionListener
{
    private JTextField tfNoDepto, tfNombre, tfNoSS, tfFechaInicio;
    private JButton    bCapturar, bConsultar, bConsultarDepto, bModificar, bCancelar, bActualizar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
private CompanyAD company = new CompanyAD();
    
    public DepartamentoGUI()
    {
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfFechaInicio = new JTextField();
        tfNoDepto = new JTextField();
        tfNombre = new JTextField();
        tfNoSS = new JTextField();
        
        bCapturar = new JButton("Capturar");
        bConsultar= new JButton("Consulta General");
        bConsultarDepto= new JButton("Consultar no. depto: ");
        bModificar= new JButton("Modificar datos: ");
        bCancelar= new JButton("Cancelar Transaccion");
        bActualizar= new JButton("Actualizar datos");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarDepto.addActionListener(this);
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
        panel1.add(new JLabel("CATALOGO DE DEPARTAMENTOS"));
        panel1.add(new JLabel());
        panel1.add(new JLabel("No. de departamento: "));
        panel1.add(tfNoDepto);
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("No. de SS Administrador: "));
        panel1.add(tfNoSS);
        panel1.add(new JLabel("Fecha de inicio: "));
        panel1.add(tfFechaInicio);
    
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarDepto); 
        panel1.add(bModificar);
        panel1.add(bCancelar);
        panel1.add(bActualizar);
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
//      private JTextField tfNoDepto, tfNombre, tfNoSS, tfFechaInicio;
        String ndepto = tfNoDepto.getText();
        String nombred = tfNombre.getText();
        String admin  = tfNoSS.getText();
        String fechai= tfFechaInicio.getText();
       
        if(ndepto.equals("") || nombred.isEmpty() || admin.isEmpty() || fechai.isEmpty())
            datos = "VACIO";
        else
        {
           datos = ndepto+"_"+nombred+"_"+admin+"_"+fechai;
        }
        return datos;
    }
    
    private void inactivarBotones()
    {
    	bCapturar.setEnabled(false);
    	bConsultar.setEnabled(false);
    	bConsultarDepto.setEnabled(false);
    	bModificar.setEnabled(false);
    	
    	bCancelar.setEnabled(true);
        bActualizar.setEnabled(true);
    }
    
      private void activarBotones()
    {
    	bCapturar.setEnabled(true);
    	bConsultar.setEnabled(true);
    	bConsultarDepto.setEnabled(true);
    	bModificar.setEnabled(true);
    	
    	bCancelar.setEnabled(false);
        bActualizar.setEnabled(false);
    }
    
    private void desplegar(String datos)
    {
    	StringTokenizer st = new StringTokenizer(datos, "_");
        tfNoDepto.setText(st.nextToken());
        tfNombre.setText(st.nextToken());
    	tfNoSS.setText(st.nextToken());
        tfFechaInicio.setText(st.nextToken());
    }
    
    private void borrar()
    {
        tfNoDepto.setText(null);
        tfNombre.setText(null);
    	tfNoSS.setText(null);
        tfFechaInicio.setText(null);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
        String respuesta ="",datos="";
    
        
        if(event.getSource() == bSalir)
        {
//            System.exit(0);
				panel2.setVisible(false);
        }
        
        if(event.getSource()== bCapturar)
        {
        	 // 1. Obtener datos
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
                else
                	respuesta=company.capturar("departamento", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        }
        
         if (event.getSource()== bConsultarDepto)
        {
        	String no = tfNoDepto.getText();
        	
            // 1. Realizar consulta de clientes
            
            datos = company.consultarNdepto(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el numero de departamento: "+no);
            	
           else{
           
            // 2. Desplegar datos
            desplegar(datos); // para que los ponga en los textfields
            taDatos.setText(datos);
         
           }
        }
        
        
        if (event.getSource()== bConsultar)
        {
        	datos=company.consultarDepto();
        	taDatos.setText(datos);
        }
        
        if(event.getSource() == bModificar)
       	{
           String no = tfNoDepto.getText();
        	
            // 1. Realizar consulta de clientes
            
            datos = company.consultarNdepto(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el numero de departamento: "+no);
            	
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
                	respuesta=company.actualizarDepto(datos);
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
            activarBotones();
            borrar();
        }
           
           
        if(event.getSource() == bCancelar)
       	{
          activarBotones();
          borrar();
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
        DepartamentoGUI localidad = new DepartamentoGUI();
    }
}
