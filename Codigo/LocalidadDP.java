import java.util.*;

public class LocalidadDP
{
	private String numerod, nombred, direccionl, telefono;
	
	//Constructores
	public LocalidadDP()
	{
		this.numerod="";
		this.nombred="";
		this.direccionl="";
		this.telefono="";		
	}
	
	public LocalidadDP(String datos)
	{
		StringTokenizer st=new StringTokenizer(datos,"_");
		this.numerod=st.nextToken();
		this.nombred=st.nextToken();
		this.direccionl=st.nextToken();
		this.telefono=st.nextToken();
	}
	
	//Métodos
	//geters
	
	public String getNdep()
	{
		return this.numerod;
	}
	
	public String getNombred()
	{
		return this.nombred;
	}
	
	public String getDir()
	{
		return this.direccionl;
	}
	
	public String getTel()
	{
		return this.telefono;
	}
	
	//seters
	
	public void setNdep(String num)
	{
		this.numerod=num;
	}
	
	public void setNombred(String nom)
	{
		this.nombred=nom;
	}
	
	public void setDir(String di)
	{
		this.direccionl=di;
	}
	
	public void setTel(String tel)
	{
		this.telefono=tel;
	}
	
	
	//toString
	public String toString()
	{
		return this.numerod+"_"+this.nombred+"_"+this.direccionl+"_"+this.telefono;
	}
	
	public String toStringSql()
	{
		return "'"+this.numerod+"','"+this.nombred+"','"+this.direccionl+"','"+this.telefono+"'";
	}
}