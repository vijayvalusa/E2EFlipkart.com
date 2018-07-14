package GenericClasses;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadWriteData 
{

	String sCsvpath ;
	public ReadWriteData(String sCsvpath)
	{
		this.sCsvpath=sCsvpath;
	}
	public String ReadDatafromcsv(String key) throws IOException
	{
	    FileReader reader=new FileReader(sCsvpath);
	    BufferedReader br=new BufferedReader(reader);
	    String line="";
	    String value = "";
	   
	      while(( line=br.readLine())!=null)
	      {
	    	 String[] data=line.split(",");
	    	 if(data[0].equalsIgnoreCase(key))
	    	 {
	    		value=data[1];
	    	 }
	      }
	 
			return value;
      }
}

