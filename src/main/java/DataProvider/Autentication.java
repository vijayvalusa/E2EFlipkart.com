package DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import GenericClasses.ReadWriteData;



public class Autentication 
{
	String loginpath="C:\\MavenProject\\com.FlipKartE2E_Testing\\TestData\\Login";
	
	ReadWriteData read=new ReadWriteData(loginpath);
	
     private String email;
     
     public void set_email(String email)
     {
    	 this.email=email;
     }
     
     public String get_email()
     {
    	 return email;
     }
     
     @DataProvider(name="getSignInDetails")
     
     public  Object[][] aut_data() throws IOException
     {
    	 Autentication aut=new Autentication();
    	 aut.set_email(read.ReadDatafromcsv("email"));
    	 return  new Autentication[][]{{aut}};
     }
}

