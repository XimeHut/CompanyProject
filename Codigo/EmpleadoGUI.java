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

import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpleadoGUI extends JFrame implements ActionListener
{
    private JTextField tfNoDepto, tfNombre, tfNoSS, tfDomicilio, tfSalario, tfFechaNacimiento, tfSexo, tfNSSSupervisor;
    private JButton    bCapturar, bConsultar, bConsultarNSS, bModificar, bCancelar, bActualizar, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
	private CompanyAD company = new CompanyAD();
    
    public EmpleadoGUI()
    {
        super("Empleado");
        
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfNoDepto = new JTextField();
        tfNombre = new JTextField();
        tfNoSS = new JTextField();
        tfDomicilio = new JTextField();
       	tfSalario= new JTextField();
       	tfFechaNacimiento= new JTextField();
       	tfSexo=new JTextField();
       	tfNSSSupervisor=new JTextField();
        
        bCapturar = new JButton("Capturar");
        bConsultar= new JButton("Consultar");
        bConsultarNSS= new JButton("Consultar por NSS");
        bModificar= new JButton("Modificar datos");
        bCancelar= new JButton("Cancelar Transaccion");
        bActualizar= new JButton("Actualizar datos");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bConsultar.addActionListener(this);
        bConsultarNSS.addActionListener(this);
        bModificar.addActionListener(this);
        bCancelar.addActionListener(this);
        bActualizar.addActionListener(this);
        bCapturar.addActionListener(this);
        bSalir.addActionListener(this);
        
        bCancelar.setEnabled(false);
        bActualizar.setEnabled(false);
        
        taDatos   = new JTextArea(15,40);
        
        panel1    = new JPanel();
        panel2   = new JPanel();
        
        // 2. Definir el Layout los JPanels
        panel1.setLayout(new GridLayout(13,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los JPanels
        panel1.add(new JLabel("CATALOGO DE EMPLEADOS"));
        panel1.add(new JLabel());
        panel1.add(new JLabel("No. de SS: "));
        panel1.add(tfNoSS);
        panel1.add(new JLabel("Nombre: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Domicilio"));
        panel1.add(tfDomicilio);
        panel1.add(new JLabel("Salario: "));
        panel1.add(tfSalario);
        panel1.add(new JLabel("Fecha de nacimiento"));
        panel1.add(tfFechaNacimiento);
        panel1.add(new JLabel("Sexo: "));
        panel1.add(tfSexo);
        panel1.add(new JLabel("NSS del Supervisor: "));
        panel1.add(tfNSSSupervisor);
        panel1.add(new JLabel("No. Depto del Empleado: "));
        panel1.add(tfNoDepto);
      
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarNSS); 
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
//         private JTextField tfNoDepto, tfNombre, tfNoSS, tfDomicilio, tfSalario, tfFechaNacimiento, tfSexo, tfNSSSupervisor;
        String nss  = tfNoSS.getText();
        String nombre = tfNombre.getText();
        String direccion   = tfDomicilio.getText();
        String fecha_n= tfFechaNacimiento.getText();
        String sexoe= tfSexo.getText();
        String salario = tfSalario.getText();
        String admin= tfNSSSupervisor.getText();
        String numerod = tfNoDepto.getText();
//        System.out.println(salario);
        if(nss.equals("") || nombre.isEmpty() || direccion.isEmpty() || fecha_n.isEmpty() || sexoe.isEmpty() || salario.isEmpty() || admin.isEmpty() || numerod.isEmpty())
            datos = "VACIO";
        else
        {
            try
            {
            	float n = Float.parseFloat(salario);
                datos = nss+"_"+nombre+"_"+direccion+"_"+fecha_n+"_"+sexoe+"_"+salario+"_"+admin+"_"+numerod;
//                System.out.println(datos);
            }
            catch(NumberFormatException nfe)
            {
                datos = "NO_NUMERICO";
            }
        }
        
        return datos;
    }
    
    private void inactivarBotones()
    {
    	bCapturar.setEnabled(false);
    	bConsultar.setEnabled(false);
    	bConsultarNSS.setEnabled(false);
    	bModificar.setEnabled(false);
    	
    	bCancelar.setEnabled(true);
        bActualizar.setEnabled(true);
       	
    }
    
      private void activarBotones()
    {
    	bCapturar.setEnabled(true);
    	bConsultar.setEnabled(true);
    	bConsultarNSS.setEnabled(true);
    	bModificar.setEnabled(true);
    	
    	bCancelar.setEnabled(false);
        bActualizar.setEnabled(false);
    }
    
    private void desplegar(String datos)
    {
    	StringTokenizer st = new StringTokenizer(datos,"_");
    	tfNoSS.setText(st.nextToken());
        tfNombre.setText(st.nextToken());
        tfDomicilio.setText(st.nextToken());
        tfFechaNacimiento.setText(st.nextToken());
        tfSexo.setText(st.nextToken());
        tfSalario.setText(st.nextToken());
        tfNSSSupervisor.setText(st.nextToken());
        tfNoDepto.setText(st.nextToken());
    }
    
    private void borrar()
    {
    	tfNoSS.setText(null);
        tfNombre.setText(null);
        tfDomicilio.setText(null);
        tfFechaNacimiento.setText(null);
        tfSexo.setText(null);
        tfSalario.setText(null);
        tfNSSSupervisor.setText(null);
        tfNoDepto.setText(null);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	String respuesta ="",datos="";
    
        
        if(event.getSource() == bSalir)
        {
//            System.exit(0);
				borrar();
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
                if(datos.equals("NO_NUMERICO"))
                    respuesta = "Saldo debe ser numerico...";
                else
                	respuesta=company.capturar("empleado", datos);
                   
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
        }
        
        if (event.getSource()== bConsultar)
        {
        	datos=company.consultarE();
            if(datos.equals("NOT_FOUND"))
            	  taDatos.setText("No hay datos para mostrar");
           	else
            	taDatos.setText(datos);
        }
        
          if (event.getSource()== bConsultarNSS)
        {
        	String no = tfNoSS.getText();
        	
            // 1. Realizar consulta de clientes
            
            datos = company.consultarNss(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el nss: "+no);
            	
           else{
           
            // 2. Desplegar datos
            desplegar(datos); // para que los ponga en los textfields
            taDatos.setText(datos);
         
           }
        }
        
         if(event.getSource() == bModificar)
       	{
       		String no = tfNoSS.getText();
        	
            // 1. Realizar consulta de clientes
            
            datos = company.consultarNss(no);
            if(datos.equals("NOT_FOUND"))
            	taDatos.setText("No se localizo el nss: "+no);
            	
           else{
            // 2. Desplegar datos
            inactivarBotones();
            desplegar(datos); // para que los ponga en los textfields
            taDatos.setText(datos);
           }
           	
        }
           
        if(event.getSource() == bActualizar)
        {
            datos = obtenerDatos();
            
            // 2. Checar datos: datos no vacios y saldo numerico, y realizar la captura de datos
            if(datos.equals("VACIO"))
                respuesta = "Algun campo esta vacio...";
                else
                	respuesta=company.actualizarEmpleado(datos);
            
            // 3. Desplegar esultado de transaccion
            taDatos.setText(respuesta);
            borrar();
            activarBotones();
        }
           
           
         if(event.getSource() == bCancelar)
       		 {
       		 	borrar();
           		activarBotones();
           }
           
        
    }
    
    
    public static void main(String args[])
    {
        EmpleadoGUI empleado = new EmpleadoGUI();
    }
}
