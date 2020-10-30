import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Date;


public class CompanyAD {

	private BufferedReader archivoIn;
	private PrintWriter archivoOut;

	private Connection conexion; //definiendo pero no creando
	private Statement statement;

	private EmpleadoDP empleadodp;  // obejto con mayuscula
	private DepartamentoDP departamentodp;
	private TrabajoDP trabajodp;
	private DependienteDP dependientedp;
	private ProyectoDP proyectodp;
	private LocalidadDP localidaddp;


    public CompanyAD() {

    try
		{
		 //Class.forName("com.mysql.jdbc.Driver").newInstance(); //a que base de datos me voy a conectar
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //a que base de datos me voy a conectar 
		conexion =  DriverManager.getConnection("jdbc:mysql://localhost/Company?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); //?pasar el parametro // hacer la conexion

		System.out.println("Conexion exitosa a la DB");

		}

		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe);

		}
		catch(InstantiationException ie)
		{
			System.out.println("Error 2: "+ie);

		}
		catch(IllegalAccessException iae)
		{
			System.out.println("Error 3: "+iae);

		}
			catch(SQLException se)
		{
			System.out.println("Error 4: "+se);
		}
    }

	  public String capturar (String tabla , String datos) {

    	String resultado="";
    	String strInsert = "";
    	String linea="";
		 //clientedp = new ClienteDP(datos);

		 if(tabla.equals("departamento"))
		 {
		 	departamentodp=new DepartamentoDP(datos);
		 	linea=departamentodp.toStringSql();
		 }

			if(tabla.equals("empleado"))
		 {
		 	empleadodp=new EmpleadoDP(datos);
		 	linea=empleadodp.toStringSql();
		 }

		 	 if(tabla.equals("proyecto"))
		 {
		 	proyectodp=new ProyectoDP(datos);
		 	linea=proyectodp.toStringSql();
		 }

    		 if(tabla.equals("dependiente"))
		 {
		 	dependientedp=new DependienteDP(datos);
		 	linea=dependientedp.toStringSql();
		 }


    		 if(tabla.equals("localidad"))
		 {
		 	localidaddp=new LocalidadDP(datos);
		 	linea=localidaddp.toStringSql();
		 }

    		 if(tabla.equals("trabaja"))
		 {
		 	trabajodp=new TrabajoDP(datos);
		 	linea=trabajodp.toStringSql();
		 }


    	 strInsert = "INSERT INTO "+tabla+" Values ("+linea+")";
    	 //System.out.println(linea);

    	try
    	{
    	//1. Abrir el archivo

    	statement =	conexion.createStatement();


    	//2. Escribir o almacener los datos en el archivo O TABLA CORRESPONDIENTE
    	statement.executeUpdate(strInsert);

    	//3.Cerrar archivo
    	//archivoOut.close();
    	statement.close();

    	resultado ="Datos capturados correctamente: " +datos;
    	}
    //	catch(IOException ioe)
    	catch(SQLException ioe)
    	{
    		resultado = "Error no existe";

    	}
    	return resultado;
    }

      public String consultarE()
      {
   		String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM empleado";
    	empleadodp = new EmpleadoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{
    		empleadodp.setNss(tr.getString("nss")); //para agarrarlas de la base de datos
    		empleadodp.setNombre(tr.getString("nombree")); //puedo poner el nombre o el numero de campo
    		empleadodp.setDireccion(tr.getString("direccion")); //campo tres
    		empleadodp.setFecha_n(tr.getString("fecha_n"));
    		empleadodp.setSexo(tr.getString("sexoe"));
    		empleadodp.setSalario(tr.getInt("salario"));
    		empleadodp.setAdmin(tr.getString("admin"));
    		empleadodp.setNumeroD(tr.getString("numerod"));



    		datos = datos + empleadodp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    		catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}

    	return datos;

}

	  public String consultarNss(String no)
	  {
	  	String datos="";

    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;
    	boolean encontrado = false;

    	strQuery = "SELECT * FROM empleado WHERE nss='"+no+"'";
    	empleadodp = new EmpleadoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{
    		empleadodp.setNss(tr.getString("nss")); //para agarrarlas de la base de datos
    		empleadodp.setNombre(tr.getString("nombree")); //puedo poner el nombre o el numero de campo
    		empleadodp.setDireccion(tr.getString("direccion")); //campo tres
    		empleadodp.setFecha_n(tr.getString("fecha_n"));
    		empleadodp.setSexo(tr.getString("sexoe"));
    		empleadodp.setSalario(tr.getInt("salario"));
    		empleadodp.setAdmin(tr.getString("admin"));
    		empleadodp.setNumeroD(tr.getString("numerod"));


    		datos = datos + empleadodp.toString() + "\n";
    		encontrado = true;

    	}


    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();
    	if (!encontrado)
    		datos="NOT_FOUND";

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    		catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}


    	return datos;

	  }

	  public String consultarD()
      {
   		String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM dependiente";
    	dependientedp = new DependienteDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{

    		dependientedp.setNombreD(tr.getString("nombreD")); //puedo poner el nombre o el numero de campo
    		dependientedp.setFecha(tr.getString("fecha")); //campo tres
    		dependientedp.setSexo(tr.getString("sexo"));
    		dependientedp.setParentesco(tr.getString("parentesco"));
    		dependientedp.setNss(tr.getString("nss"));



    		datos = datos + dependientedp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    	catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}

    	return datos;

}

	 public String consultarT()
	 {
	 	String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM trabaja";
    	trabajodp = new TrabajoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{

    		trabajodp.setNss(tr.getString("numeroe")); //puedo poner el nombre o el numero de campo
    		trabajodp.setNproy(tr.getString("nproyecto")); //campo tres
    		trabajodp.setHoras(tr.getInt("horas"));



    		datos = datos + trabajodp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    	catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}

    	return datos;
	 }

	 public String consultarDepto()
	 {
	 	String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM departamento";
    	departamentodp = new DepartamentoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{

    		departamentodp.setNdepto(tr.getString("ndepto")); //puedo poner el nombre o el numero de campo
    		departamentodp.setNombre(tr.getString("nombred"));
    		departamentodp.setAdmin(tr.getString("admin"));
    		departamentodp.setFechai(tr.getString("fechai"));



    		datos = datos + departamentodp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    	catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;
		 }

		 return datos;
	 }

	 public String consultarNdepto(String no)

	 {
	 	String datos="";

    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;
    	boolean encontrado = false;

    	strQuery = "SELECT * FROM departamento WHERE ndepto='"+no+"'";
    	departamentodp = new DepartamentoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{
			departamentodp.setNdepto(tr.getString("ndepto")); //puedo poner el nombre o el numero de campo
    		departamentodp.setNombre(tr.getString("nombred"));
    		departamentodp.setAdmin(tr.getString("admin"));
    		departamentodp.setFechai(tr.getString("fechai"));



    		datos = datos + departamentodp.toString() + "\n";
    		encontrado = true;

    	}


    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();
    	if (!encontrado)
    		datos="NOT_FOUND";

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    	catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}


    	return datos;

	 }

	 public String consultarP()
	 {
		String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM proyecto";
    	proyectodp = new ProyectoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{   proyectodp.setNumeroP(tr.getString("numeroP"));
    		proyectodp.setNombreP(tr.getString("nombreP")); //para agarrarlas de la base de datos
    		proyectodp.setLocalidadP(tr.getString("localidadP")); //campo tres
    		proyectodp.setNumeroD(tr.getString("numeroD"));



    		datos = datos + proyectodp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strInsert);
    	System.out.println(strQuery);

    	}
    		//catch(FileNotFoundException ioe)
    		catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}

    	return datos;

	 }

	 public String consultarNoP(String no)
	 {
	 	String datos="";

    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;
    	boolean encontrado = false;

    	strQuery = "SELECT * FROM proyecto WHERE numeroP='"+no+"'";
    	proyectodp = new ProyectoDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{   proyectodp.setNumeroP(tr.getString("numeroP"));
    		proyectodp.setNombreP(tr.getString("nombreP")); //para agarrarlas de la base de datos
    		proyectodp.setLocalidadP(tr.getString("localidadP")); //campo tres
    		proyectodp.setNumeroD(tr.getString("numeroD"));

    		datos = datos + proyectodp.toString() + "\n";
    		encontrado=true;
      }
    	statement.close();
    	if (!encontrado)
    		datos="NOT_FOUND";

    	System.out.println(strInsert);
    	System.out.println(strQuery);
    	}
    		//catch(FileNotFoundException ioe)
    	catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}
    	return datos;
	 }

	 public String consultarL()
	 {
	 	String datos = "";
    	String strInsert = "";
    	String strQuery;
    	ResultSet tr ;

    	strQuery = "SELECT * FROM localidad";
    	localidaddp = new LocalidadDP();

    	try{

    	//1. Abrir el archivo

    	statement = conexion.createStatement();

    	//2. Procesoar datos


    	tr = statement.executeQuery(strQuery);

    	while(tr.next()) //mienstras tenga refistro el next me va a a entregar true , voy a utiluzar lo mututors para darle los valores que obtengo de los campos
    	{   localidaddp.setNdep(tr.getString("numerod"));
    		localidaddp.setNombred(tr.getString("nombred")); //para agarrarlas de la base de datos
    		localidaddp.setDir(tr.getString("direccionl")); //campo tres
    		localidaddp.setTel(tr.getString(4));

    	//	System.out.println(localidaddp.toString());
    		System.out.println(strQuery);

    		datos = datos + localidaddp.toString() + "\n";

      }

    	//3.Cerrar el archivo

    	//archivoIn.close();
    	statement.close();

    	System.out.println(strInsert);

    	}
    		//catch(FileNotFoundException ioe)
    		catch(SQLException sqlE)
    	{
    		datos = "Erroe: "+sqlE;

    	}

    	return datos;

	 }


	public String actualizarDepto(String datos)
	{
		String resultado="", nodepto="", nombre="", nss="", date="";
 		StringTokenizer st = new StringTokenizer(datos, "_");
        nodepto= st.nextToken();
        nombre=st.nextToken();
    	nss=st.nextToken();
        date=st.nextToken();

		String strUpdate="";
		strUpdate = "UPDATE Departamento SET nombred='"+nombre+"', admin='"+nss+"', fechai='"+date+"' WHERE ndepto='"+nodepto+"'";
		try
		{
			//1. Abrir el archivo
			statement = conexion.createStatement();

			//2. Escribir o al macenar los datos en el archivo
			statement.executeUpdate(strUpdate);

			//3. Cerrar archivo
			statement.close();
			resultado="Datos actualizados: "+datos;
			System.out.println(strUpdate);
		}
		catch(SQLException ioe)
		{
			resultado="Numero de nss no existe";
		}
		return resultado;
	}

	public String actualizarEmpleado(String datos)
	{
		String resultado="", nss="", nombre="", direccion="", date="", sexoe="", admin="", numerod="";
		float salario=0;
 		StringTokenizer st = new StringTokenizer(datos, "_");
        nss= st.nextToken();
        nombre=st.nextToken();
    	direccion=st.nextToken();
        date=st.nextToken();
        sexoe=st.nextToken();
        salario=Float.parseFloat(st.nextToken());
        admin=st.nextToken();
        numerod=st.nextToken();

		String strUpdate="";
		strUpdate = "UPDATE Empleado SET nombree='"+nombre+"', direccion='"+direccion+"', fecha_n='"+date+"', sexoe='"+sexoe+"', salario='"+salario+"', admin='"+admin+"', numerod='"+numerod+"' WHERE nss='"+nss+"'";

		try
		{
	         		//1. Abrir el archivo
			statement = conexion.createStatement();

			//2. Escribir o al macenar los datos en el archivo
			statement.executeUpdate(strUpdate);

			//3. Cerrar archivo
			statement.close();
			resultado="Datos actualizados: "+datos;
			System.out.println(strUpdate);
		}
		catch(SQLException ioe)
		{
			resultado = "Error el departamento no existe";
		}
		return resultado;
	}

	public String actualizarProyecto(String datos)
	{
		String resultado="", no="", nombre="", localidad="", nd="";
 		StringTokenizer st = new StringTokenizer(datos, "_");
        no= st.nextToken();
        nombre=st.nextToken();
    	localidad=st.nextToken();
        nd=st.nextToken();

		String strUpdate="";
		strUpdate = "UPDATE Proyecto SET nombreP='"+nombre+"', localidadP='"+localidad+"', numerod='"+nd+"' WHERE numeroP='"+no+"'";
		try
		{
			//1. Abrir el archivo
			statement = conexion.createStatement();

			//2. Escribir o al macenar los datos en el archivo
			statement.executeUpdate(strUpdate);

			//3. Cerrar archivo
			statement.close();
			resultado="Datos actualizados: "+datos;
		System.out.println(strUpdate);
		}
		catch(SQLException ioe)
		{
			resultado="El numero de departamento no existe";
		}
		return resultado;
	}

	public String reporte1(String depa) //empleados por departamento
{
	String datos="";
	String strInsert="";
	String strQuery="";
	ResultSet tr;

	strQuery="SELECT departamento.ndepto, departamento.nombred, empleado.nss, empleado.nombree, empleado.numerod FROM empleado JOIN departamento ON empleado.numerod = departamento.ndepto WHERE departamento.ndepto='"+depa+"'";
	try
	{
		//abrir bd
		statement=conexion.createStatement();
		//procesar
		tr=statement.executeQuery(strQuery);

		//enviar
		while(tr.next())
		{
			datos=datos+tr.getString(1)+"_"+tr.getString(2)+"_"+tr.getString(3)+"_"+tr.getString(4)+"_"+tr.getString(5)+"\n";
		}

		//cerrar bd
		statement.close();
		System.out.println(strQuery);

	}

	catch(SQLException sqlE)
	{
		datos="Error "+sqlE;
	}

	return datos;
}

	public String reporte2(String proy) //empleados por proyecto
{
	String datos="";
	String strInsert="";
	String strQuery="";
	ResultSet tr;

	strQuery="SELECT Empleado.nss, Empleado.nombree, Proyecto.numeroP, Proyecto.nombreP, Departamento.ndepto, Departamento.nombred FROM (((Empleado JOIN Trabaja ON Empleado.nss=Trabaja.numeroe) JOIN Proyecto ON Trabaja.nproyecto=Proyecto.numeroP) JOIN Departamento ON Proyecto.numerod=Departamento.ndepto) WHERE Proyecto.numeroP='"+proy+"'";
	try
	{
		//abrir bd
		statement=conexion.createStatement();
		//procesar
		tr=statement.executeQuery(strQuery);

		//enviar
		while(tr.next())
		{
			datos=datos+tr.getString(1)+"_"+tr.getString(2)+"_"+tr.getString(3)+"_"+tr.getString(4)+"_"+tr.getString(5)+"_"+tr.getString(6)+"\n";
		}

		//cerrar bd
		statement.close();
		System.out.println(strQuery);

	}

	catch(SQLException sqlE)
	{
		datos="Error "+sqlE;
	}

	return datos;
}

	public String reporte3(String emp) //proyectos por empleado
	{
		String datos="";
		String strInsert="";
		String strQuery="";
		ResultSet tr;

		strQuery="SELECT empleado.nss, empleado.nombree, proyecto.numeroP, proyecto.nombreP, departamento.nombred, departamento.ndepto FROM ((trabaja JOIN empleado ON trabaja.numeroe=empleado.nss) JOIN proyecto ON proyecto.numeroP = trabaja.nproyecto) JOIN departamento ON departamento.ndepto=proyecto.numerod WHERE  empleado.nss='"+emp+"'";
		//strQuery="SELECT empleado.nss, empleado.nombree, proyecto.numeroP, proyecto.nombreP, departamento.nombred, departamento.ndepto WHERE empleado.nss='"+emp+"' FROM departamento JOIN (proyecto JOIN (trabaja JOIN empleado ON trabaja.numeroe=empleado.nss) ON proyecto.numeroP = trabaja.nproyecto) ON departamento.ndepto=proyecto.numerod";
		try
		{
			//abrir bd
			statement=conexion.createStatement();
			//procesar
			tr=statement.executeQuery(strQuery);

			//enviar
			while(tr.next())
			{
				datos=datos+tr.getString(1)+"_"+tr.getString(2)+"_"+tr.getString(3)+"_"+tr.getString(4)+"_"+tr.getString(5)+"_"+tr.getString(6)+"\n";
			}

			//cerrar bd
			statement.close();
			System.out.println(strQuery);

		}

		catch(SQLException sqlE)
		{
			datos="Error "+sqlE;
		}

		return datos;
	}

	public String reporte4(String dep) //proyectos por departamento
	{
		String datos="";
		String strInsert="";
		String strQuery="";
		ResultSet tr;

		strQuery="SELECT departamento.nombred, proyecto.nombreP, departamento.ndepto, proyecto.numeroP FROM departamento, proyecto WHERE departamento.ndepto=proyecto.numerod AND departamento.ndepto='"+dep+"'";
		try
		{
			//abrir bd
			statement=conexion.createStatement();
			//procesar
			tr=statement.executeQuery(strQuery);

			//enviar
			while(tr.next())
			{
				datos=datos+tr.getString(1)+"_"+tr.getString(2)+"_"+tr.getString(3)+"_"+tr.getString(4)+"\n";
			}

			//cerrar bd
			statement.close();
			System.out.println(strQuery);

		}

		catch(SQLException sqlE)
		{
			datos="Error "+sqlE;
		}

		return datos;
	}

	public String reporte5(String emp) //familiares de un empleado
	{
		String datos="";
		String strInsert="";
		String strQuery="";
		ResultSet tr;

		strQuery="SELECT empleado.nombree, dependiente.nombreD, empleado.nss FROM empleado, dependiente WHERE empleado.nss='"+emp+"' AND empleado.nss=dependiente.nss";
		try
		{
			//abrir bd
			statement=conexion.createStatement();
			//procesar
			tr=statement.executeQuery(strQuery);

			//enviar
			while(tr.next())
			{
				datos=datos+tr.getString(1)+"_"+tr.getString(2)+"_"+tr.getString(3)+"\n";
			}

			//cerrar bd
			statement.close();
			System.out.println(strQuery);

		}

		catch(SQLException sqlE)
		{
			datos="Error "+sqlE;
		}

		return datos;
	}

	}
