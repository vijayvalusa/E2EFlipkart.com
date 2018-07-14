package POClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericClasses.WebDriverUtlity;

public class AutenticationPo extends WebDriverUtlity {

	WebDriver driver;
	
	public AutenticationPo(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email_create")
	private WebElement email_create;
	
	@FindBy(id="SubmitCreate")
	private WebElement CreateAccount;
	
	public WebElement SendKeys_Aut_Email(String text)
	{
		waitElementEnabled(email_create);
		udf__SendKeys(email_create,text);
		return email_create;
	}
	
	public WebElement clickon_Aut_CreateAccount()
	{
		waitElementEnabled(CreateAccount);
		udf_click(CreateAccount);
		return CreateAccount;
	}
	

}
