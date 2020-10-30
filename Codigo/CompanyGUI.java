import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.util.StringTokenizer;
import java.util.Date;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyGUI extends JFrame implements ActionListener
{
	private JMenuBar mbPrincipal;
	private JMenu menuCompany, menuRepCons;
	private JMenu menuEmpleados, menuDepto, menuProyecto;
	private JMenuItem miEmpleados, miDepto, miProyecto;
	private JMenuItem miTrabajaEP, miTrabajaPE, miLocalidad, miDependiente, miSalir;
	
	private JMenuItem miED, miEP, miPE, miPD, miFE;
	private JTextArea  taDatos;
	
	private JButton bReporte1,bReporte2,bReporte3,bReporte4,bReporte5,bReporteSalir;
	private JTextField tfReporte1,tfReporte2,tfReporte3,tfReporte4,tfReporte5;
	
	private DepartamentoGUI depto= new DepartamentoGUI();
	private LocalidadGUI localidad= new LocalidadGUI();
	
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	
	
	private EmpleadoGUI empleados= new EmpleadoGUI();
	private ProyectoGUI proyecto= new ProyectoGUI();
	private TrabajaEPGUI trabajaep= new TrabajaEPGUI();
	private TrabajaPEGUI trabajape= new TrabajaPEGUI();

	
	private DependienteGUI dependiente= new DependienteGUI();
	private CompanyAD company = new CompanyAD();
	
	

    public CompanyGUI()
    {
    	super("Sistema BD de Company");
       	mbPrincipal = new JMenuBar();
		menuCompany = new JMenu("Administracion de Catalogos");
		menuRepCons = new JMenu("Reportes y Consultas");
		
		menuEmpleados = new JMenu("Empleados");
		menuDepto = new JMenu("Departamentos"); 
		menuProyecto = new JMenu("Proyectos");
		
		miEmpleados = new JMenuItem("Catalogo de Empleados");
		miDepto = new JMenuItem("Catalogo de Departamentos"); 
		miProyecto = new JMenuItem("Catalogo de Proyectos");
		miLocalidad = new JMenuItem("Localidad: ");
		
		miTrabajaEP= new JMenuItem("Asignacion de Empleados a Proyectos");
		miTrabajaPE= new JMenuItem("Asignacion de Proyectos a Empleados");
		miLocalidad= new JMenuItem("Localidad");
		miDependiente= new JMenuItem("Dependientes de Empleados");
		
		miED= new JMenuItem("1.Empleados de un Departamento");
		miEP= new JMenuItem("2.Empleados asignados a un proyecto");
		miPE= new JMenuItem("3.Proyectos de un Empleado");
		miPD= new JMenuItem("4.Proyectos de un Departamento");
		miFE= new JMenuItem("5.Familiares de un Empleado");
		
		miSalir= new JMenuItem("Exit");
		
		bReporte1 = new JButton("Reporte");
		bReporte2 = new JButton("Reporte");
		bReporte3 = new JButton("Reporte");
		bReporte4 = new JButton("Reporte");
		bReporte5 = new JButton("Reporte");
        bReporteSalir= new JButton("Salir");
        tfReporte1= new JTextField();
        tfReporte2= new JTextField();
        tfReporte3= new JTextField();
        tfReporte4= new JTextField();
        tfReporte5= new JTextField();
		
		miEmpleados.addActionListener(this);
		miDepto.addActionListener(this);
		miProyecto.addActionListener(this);
		miTrabajaEP.addActionListener(this);
		miTrabajaPE.addActionListener(this);
		miLocalidad.addActionListener(this);
		miDependiente.addActionListener(this);
		miLocalidad.addActionListener(this);
		
		miED.addActionListener(this);
		miEP.addActionListener(this);
		miPE.addActionListener(this);
		miPD.addActionListener(this);
		miFE.addActionListener(this);
		
		bReporte1.addActionListener(this);
		bReporte2.addActionListener(this);
		bReporte3.addActionListener(this);
		bReporte4.addActionListener(this);
		bReporte5.addActionListener(this);

		
		
		miSalir.addActionListener(this);
		bReporteSalir.addActionListener(this);
		panel=new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
	
		
		taDatos   = new JTextArea(15,40);
		panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());
        
		
		menuEmpleados.add(miEmpleados);
		menuEmpleados.add(miDependiente);
		menuEmpleados.add(miTrabajaEP);
		menuDepto.add(miDepto);
		menuDepto.add(miLocalidad);
		menuProyecto.add(miProyecto);
		menuProyecto.add(miTrabajaPE);
	
//		2. Colocar los JMenuItems en le menu correspondiente
		menuCompany.add(menuEmpleados);
		menuCompany.add(menuDepto);
		menuCompany.add(menuProyecto);
		menuCompany.add(miSalir);
		
		menuRepCons.add(miED);
		menuRepCons.add(miEP);
		menuRepCons.add(miPE);
		menuRepCons.add(miPD);
		menuRepCons.add(miFE);
		
		mbPrincipal.add(menuCompany);
		mbPrincipal.add(menuRepCons);		
		
		//colocar JMenuBar en el JFrame y hacer visible el JFrame
		//Cada menu se crea conforme el orden en el que lo escribo
		setJMenuBar(mbPrincipal);
		setSize(500,700);
		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    { 	
       	if (event.getSource()== miDepto)
		{
			panel.setVisible(false);
			panel=depto.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
	
        if (event.getSource()== miEmpleados)
		{
			panel.setVisible(false);
			panel=empleados.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if (event.getSource()== miProyecto)
		{
//			new GCGF();
			panel.setVisible(false);
			panel=proyecto.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if (event.getSource()== miLocalidad)
		{
			panel.setVisible(false);
			panel=localidad.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if (event.getSource()== miDependiente)
		{
			panel.setVisible(false);
			panel=dependiente.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if (event.getSource()== miTrabajaEP)
		{
//			new GFGC();
			panel.setVisible(false);
			panel=trabajaep.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		if (event.getSource()== miTrabajaPE)
		{
//			new GFGC();
			panel.setVisible(false);
			panel=trabajape.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
           	if(event.getSource()==miSalir)
           	{
           		System.exit(0);
           	}
        
        
        if(event.getSource() == miED)
        {
        	panel.setVisible(false);
        	panel2.setVisible(false);
        
        	panel1.removeAll();
       		panel2.removeAll();
       		
        	taDatos.setText("");
        	
        	panel1.add(new JLabel("Clave de de departamento:"));
        	panel1.add(tfReporte1);
        	panel1.add(bReporte1);
        	panel1.add(bReporteSalir);
        	panel2.add(panel1);
        	panel2.add(new JScrollPane(taDatos));
        
            panel=panel2;
            
        	panel.setVisible(true);
        	add(panel);
        	setSize(500,700);
        	setVisible(true);
        
        	
        }
        
       	 if(event.getSource() == bReporte1)
        	{
        
        	String no = "" , respuesta = "";
        	no = tfReporte1.getText();
        	
        	if(no.equals("")){
        	no=JOptionPane.showInputDialog("Clave de departamento para consulta");	
        	}
        
         	respuesta = company.reporte1(no);
         		if(respuesta.equals("")){
         		respuesta = "No tiene empleados";
         		}
         	System.out.println(respuesta);
        	taDatos.setText("Reporte:Empleados de un Departamento \n"+ respuesta);
    		}
    		
    	/////////////////////////////////////////////////////////////
    		
    	    if(event.getSource() == miEP)
        {
        	panel.setVisible(false);
        	panel2.setVisible(false);
        
        	panel1.removeAll();
       		panel2.removeAll();
       		
        	taDatos.setText("");
        	
        	panel1.add(new JLabel("No. Proyecto a consultar:"));
        	panel1.add(tfReporte2);
        	panel1.add(bReporte2);
        	panel1.add(bReporteSalir);
        	panel2.add(panel1);
        	panel2.add(new JScrollPane(taDatos));
        
            panel=panel2;
            
        	panel.setVisible(true);
        	add(panel);
        	setSize(500,700);
        	setVisible(true);
        
        	
        }	
    		
    	   if(event.getSource() == bReporte2)
        	{
        
        
        	String dep = "" , respuesta = "";
        		dep = tfReporte2.getText();
        	if(dep.equals("")){
        	dep=JOptionPane.showInputDialog("No. Proyecto a consultar:");	
        		}
         	respuesta = company.reporte2(dep);
         	
         		if(respuesta.equals("")){
         		respuesta = "No tiene empleados";
         		}
         	System.out.println(respuesta);
        	taDatos.setText("Reporte:Empleados asignados a un proyecto \n"+respuesta);
    		}
    		/////////////////////////////////////////////////////////////////////
    	
    			
    	  if(event.getSource() == miPE)
        {
        	panel.setVisible(false);
        	panel2.setVisible(false);
        
        	panel1.removeAll();
       		panel2.removeAll();
       		
        	taDatos.setText("");
        	
        	panel1.add(new JLabel("Empleado a consultar:"));
        	panel1.add(tfReporte3);
        	panel1.add(bReporte3);
        	panel1.add(bReporteSalir);
        	panel2.add(panel1);
        	panel2.add(new JScrollPane(taDatos));
        
            panel=panel2;
            
        	panel.setVisible(true);
        	add(panel);
        	setSize(500,700);
        	setVisible(true);
        
        	
        }	
    		
    		
    		 if(event.getSource() == bReporte3)
        	{
        
        	String proy = "" , respuesta = "";
        	
        	proy = tfReporte3.getText();
        		if(proy.equals("")){
        	proy=JOptionPane.showInputDialog("Empleado a consultar:");
        		}	
         	respuesta = company.reporte3(proy);
         	
         		if(respuesta.equals("")){
         		respuesta = "No tiene proyectos";
         		}
         	System.out.println(respuesta);
        	taDatos.setText("Reporte:Proyectos de un Empleado \n"+respuesta);
    		}
    		//////////////////////////////////////////////////////////
    			
    	 if(event.getSource() == miPD)
        {
        	panel.setVisible(false);
        	panel2.setVisible(false);
        
        	panel1.removeAll();
       		panel2.removeAll();
       		
        	taDatos.setText("");
        	
        	panel1.add(new JLabel("Departamento a Consultar:"));
        	panel1.add(tfReporte4);
        	panel1.add(bReporte4);
        	panel1.add(bReporteSalir);
        	panel2.add(panel1);
        	panel2.add(new JScrollPane(taDatos));
        
            panel=panel2;
            
        	panel.setVisible(true);
        	add(panel);
        	setSize(500,700);
        	setVisible(true);
        
        	
        }	
    		
    		
    		if(event.getSource() == bReporte4)
        	{
        	
        
        	String dep = "" , respuesta = "";
        		dep = tfReporte4.getText();
        		if(dep.equals("")){
        	dep=JOptionPane.showInputDialog("Departamento a Consultar:");	
        		}
         	respuesta = company.reporte4(dep);
         	
         		if(respuesta.equals("")){
         		respuesta = "No tiene proyectos";
         		}
         	System.out.println(respuesta);
        	taDatos.setText("Reporte:Proyectos de un Departamento\n"+respuesta);
    		}
    		
    		/////////////////////////////////////////
    		
    		
    		
    		if(event.getSource() == miFE)
        {
        	panel.setVisible(false);
        	panel2.setVisible(false);
        
        	panel1.removeAll();
       		panel2.removeAll();
       		
        	taDatos.setText("");
        	
        	panel1.add(new JLabel("Empleado a consultar:"));
        	panel1.add(tfReporte5);
        	panel1.add(bReporte5);
        	panel1.add(bReporteSalir);
        	panel2.add(panel1);
        	panel2.add(new JScrollPane(taDatos));
        
            panel=panel2;
            
        	panel.setVisible(true);
        	add(panel);
        	setSize(500,700);
        	setVisible(true);
        
        	
        }
        
        	if(event.getSource() == bReporte5)
        	{
       	
        	String emp = "" , respuesta = "";
        		 emp = tfReporte5.getText();
        		if(emp.equals("")){
        	emp=JOptionPane.showInputDialog("Empleado a consultar:");	
        		}
        		
         	respuesta = company.reporte5(emp);
         	
         	if(respuesta.equals("")){
         		respuesta = "No tiene dependientes";
         	}
         	
         	System.out.println(respuesta);
        	taDatos.setText("Reporte:Familiares de un Empleado\n"+respuesta);
    		}
    			
    		   if(event.getSource() == bReporteSalir)
        {
				panel2.setVisible(false);
        }
    
       
        
        
        
    }
    public static void main(String args[])
    {
        new CompanyGUI();
    }
}