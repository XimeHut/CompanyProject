import java.util.StringTokenizer;

public class TrabajoDP {
	
   private String	numeroe , nproyecto;
   private int horas;
   
   public TrabajoDP() 
   {	nproyecto="";
    	numeroe="";
    	
    	horas=0;
   }
    
   public TrabajoDP(String datos)
   {
    	StringTokenizer st = new StringTokenizer(datos,"_");
    	nproyecto=st.nextToken();
    	numeroe=st.nextToken();
	   	
	   	horas = Integer.parseInt(st.nextToken());
   }
   
   public String getNss()
   {
   	return this.numeroe;
   }
   
   public String getNproy()
   {
   	return this.nproyecto;
   }
   
   public int getHoras()
   {
   	return this.horas; 	
   }
   
   public void setNss (String no)
   {
   	this.numeroe = no;
   }
   
   public void setNproy(String num)
   {
       this.nproyecto = num;
   }
    
   public void setHoras(int hours)
   {
   	this.horas = hours;
   }
   
   public String toString()
   {
       return this.numeroe+"_"+this.nproyecto+"_"+this.horas;
   }
    
   	public String toStringSql()
   	{
   	return "'"+this.numeroe+"','"+this.nproyecto+"',"+this.horas;
   	}
    
}
    
    
    
    
