package com.FlipKartE2E;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DataProvider.Autentication;
import GenericClasses.ReadWriteData;
import POClasses.AutenticationPo;
import POClasses.SignInPo;


public class TC_001_SignInTest 
{
	String path="C:\\MavenProject\\com.FlipKartE2E_Testing\\config.properties";
	String CSVPath="C:\\MavenProject\\com.FlipKartE2E_Testing\\Login";
	WebDriver driver;
	FileReader reader;
	Properties prop;
	ReadWriteData read;
	
	@BeforeClass
	public void setup() throws IOException
	{
		reader=new FileReader(path);
		prop=new Properties();
		prop.load(reader);
        read=new ReadWriteData(CSVPath);
		System.setProperty("webdriver.chrome.driver","C:\\MavenProject\\com.FlipKartE2E_Testing\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test()
	public void SignIn() throws IOException
	{
		SignInPo signin=new SignInPo(driver);
		signin.clickonSignIn();
	}
	
	
	@Test(dataProvider="getSignInDetails",dataProviderClass=Autentication.class,dependsOnMethods= {"SignIn"})
	public void Autentication(DataProvider.Autentication aut) throws IOException
	{
		
		AutenticationPo autentication	=	new AutenticationPo(driver);
		autentication.SendKeys_Aut_Email(aut.get_email());
		autentication.clickon_Aut_CreateAccount();
	}
    
}
