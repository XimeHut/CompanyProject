import java.util.*;

public class ProyectoDP
{
	private String nombreP, numeroP, localidadP,numeroD;
	
	//Constructores
	public ProyectoDP()
	{
		this.numeroP="";
		this.nombreP="";
		this.localidadP="";
		this.numeroD="";
	}
	
	public ProyectoDP(String datos)
	{
		StringTokenizer st=new StringTokenizer(datos, "_");
		this.numeroP=st.nextToken();
		this.nombreP=st.nextToken();	
		this.localidadP=st.nextToken();
		this.numeroD=st.nextToken();
	}
	
	//Métodos
	//geters
	
	public String getNombreP()
	{
		return this.nombreP;
	}
	
	public String getNumeroP()
	{
		return this.numeroP;
	}
	
	public String getLocalidadP()
	{
		return this.localidadP;
	}
		public String getNumeroD()
	{
		return this.numeroD;
	}
	
	
	//seters
	
	public void setNombreP(String nom)
	{
		this.nombreP=nom;
	}
	
	public void setNumeroP(String num)
	{
		this.numeroP=num;
	}
	
	public void setLocalidadP(String local)
	{
		this.localidadP=local;
	}
	
		public void setNumeroD(String num)
	{
		this.numeroD=num;
	}
	
	//toString
	public String toString()
	{
		return this.numeroP+"_"+this.nombreP+"_"+this.localidadP+"_"+this.numeroD;
	}
	
	public String toStringSql()
	{
		return "'"+this.numeroP+"','"+this.nombreP+"','"+this.localidadP+"','"+this.numeroD+"'";
	}
}