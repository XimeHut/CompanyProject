import java.util.*;

public class DependienteDP
{
	private String nss, nombreD, fecha, sexo, parentesco;
	
	//Constructores
	public DependienteDP()
	{
		this.nss="";
		this.nombreD="";
		this.fecha="";
		this.sexo="";
		this.parentesco="";
		
	}
	
	public DependienteDP(String datos)
	{
		StringTokenizer st=new StringTokenizer(datos,"_");
		this.nss=st.nextToken();
		this.nombreD=st.nextToken();
		this.fecha=st.nextToken();
		this.sexo=st.nextToken();
		this.parentesco=st.nextToken();
	}
	
	//Métodos
	//geters
	
	public String getNss()
	{
		return this.nss;
	}
	
	public String getNombreD()
	{
		return this.nombreD;
	}
	
	public String getFecha()
	{
		return this.fecha;
	}
	
	public String getSexo()
	{
		return this.sexo;
	}
	
	public String getParentesco()
	{
		return this.parentesco;
	}
	
	//seters
	
	public void setNss(String num)
	{
		this.nss=num;
	}
	
	public void setNombreD(String nom)
	{
		this.nombreD=nom;
	}
	
	public void setFecha(String fec)
	{
		this.fecha=fec;
	}
	
	public void setSexo(String se)
	{
		this.sexo=se;
	}
	
	public void setParentesco(String par)
	{
		this.parentesco=par;
	}
	
	//toString
	public String toString()
	{
		return this.nombreD+"_"+this.fecha+"_"+this.sexo+"_"+this.parentesco+"_"+this.nss;
	}
	
	public String toStringSql()
	{
		return "'"+this.nombreD+"','"+this.fecha+"','"+this.sexo+"','"+this.parentesco+"','"+this.nss+"'";
	}
}