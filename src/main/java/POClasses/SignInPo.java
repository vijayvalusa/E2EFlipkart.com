package POClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericClasses.WebDriverUtlity;

public class SignInPo extends  WebDriverUtlity
{

	WebDriver driver;
	public SignInPo(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	private WebElement SignIn;
	
	@FindBy(xpath="//a[text()='Contact us']")
	private WebElement Contactus;
	
	public WebElement clickonSignIn()
	{
		waitElementEnabled(SignIn);
		udf_click(SignIn);
		return SignIn;
		
	}
	
	private WebElement clickonContcatus() 
	{
		waitElementEnabled(Contactus);
		udf_click(Contactus);
		return Contactus;	
 
	} 
}
