import java.util.StringTokenizer;

public class DepartamentoDP {
	
	private String ndepto,nombred,admin,fechai;

    public DepartamentoDP() 
    {
    	ndepto="";
    	nombred="";
    	admin="";
    	fechai="";
    }
    	public DepartamentoDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		
		ndepto= st.nextToken();
		nombred = st.nextToken();
		admin = st.nextToken();
	    fechai = st.nextToken();	
	}
	
	public String getNdepto()  //me entrega un valor string , tiene que empezar con mayuscula
	{ 
		return this.ndepto; //el this es para decirle que es de esa clase 
	}
	
    public String getNombre()  //me entrega un valor string , tiene que empezar con mayuscula
	{ 
		return this.nombred; //el this es para decirle que es de esa clase 
	}
	
	public String getAdmin()
	{
		return this.admin;
	}
	
	public String getFechai()
	{
		return this.fechai;
	}

	
	//Mutators 
	
	public void setNdepto(String num)
	{
		this.ndepto = num;
	}
	
	public void setNombre(String name)
	{
		this.nombred = name;
	}
	
	public void setAdmin(String admi)
	{
		this.admin = admi;
	}
	
	public void setFechai(String date)
	{
		this.fechai = date;
	}
	
	public String toString() //es un metodo definido en java para un obejto , para que muestre los datos y no las direcciones
	{
		 return this.ndepto+"_"+this.nombred+"_"+this.admin+"_"+this.fechai;
	}
	
	public String toStringSql() //es un metodo definido en java para un obejto , para que muestre los datos y no las direcciones
	{
		return "'"+this.ndepto+"','"+this.nombred+"','"+this.admin+"','"+this.fechai+"'";//saldo sin '' porque es numerico
	}
}