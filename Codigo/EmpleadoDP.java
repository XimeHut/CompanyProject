import java.util.StringTokenizer;

public class EmpleadoDP 
{
	private String nss,nombree,direccion,fecha_n,sexoe, numerod,admin;
	private float salario; 
	private EmpleadoDP next;

   public EmpleadoDP() 
   	{
   	nss="";
   	nombree="";
   	direccion="";
   	fecha_n="";
   	sexoe="";
   	salario=0;
   	numerod="";
   	admin="";
   	
    }
    
    public EmpleadoDP(String datos)
    {
    	StringTokenizer st = new StringTokenizer(datos,"_");
    	
	    nss=st.nextToken();
	   	nombree=st.nextToken();
	   	direccion=st.nextToken();
	   	fecha_n=st.nextToken();
	   	sexoe=st.nextToken();
	   	salario=Float.parseFloat(st.nextToken());
	   	admin =st.nextToken();
	   	numerod=st.nextToken();
    	
    }
    
    //ACCESORS
    public String getNss()
    {
    	return this.nss;
    }
    
    public String getNombre()
    {
    	return this.nombree;
    }
    public String getDireccion()
    {
    	return this.direccion;
    }
    public String getFecha_n()
    {
    	return this.fecha_n;
    }
    
    public String getSexo()
    {
    	return this.sexoe;
    }
    public float getSalario()
    {
    	return this.salario;
    }
    
    public String getAdmin()
    {
    	return this.admin;
    }
    public String getNumerod()
    {
    	return this.numerod;
    }
  
    //MUTATORS
    public void setNss (String no)
    {
    	this.nss = no;
    }
    
     public void setNombre(String name)
    {
        this.nombree = name;
    }
    
    public void setDireccion(String address)
    {
    	this.direccion = address;
    }
    public void setFecha_n(String date)
    {
    	this.fecha_n = date;
    }
    public void setSexo(String sex)
    {
    	this.sexoe=sex;
    }
    
    public void setSalario(float salary)
    {
    	this.salario = salary;
    }
    public void setAdmin(String admo)
    {
    	this.admin = admo;
    }
    public void setNumeroD(String num)
    {
    	this.numerod= num;
    }
    
   public String toString() //es un metodo definido en java para un obejto , para que muestre los datos y no las direcciones
	{
		return this.nss+"_"+this.nombree+"_"+this.direccion+"_"+this.fecha_n+"_"+this.sexoe+"_"+this.salario+"_"+this.admin+"_"+this.numerod;
	}
	
		public String toStringSql() //es un metodo definido en java para un obejto , para que muestre los datos y no las direcciones
	{
		return "'"+this.nss+"','"+this.nombree+"','"+this.direccion+"','"+this.fecha_n+"','"+this.sexoe+"',"+this.salario+",'"+this.admin+"','"+this.numerod+"'";
	
	}
   
}
    
    
