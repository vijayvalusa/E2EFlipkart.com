package GenericClasses;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtlity 
{
	private WebDriver driver;
	
	public WebDriverUtlity(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	
	public void udf_click(WebElement element)
	{
		try
		{
			element.click();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	public void udf__SendKeys(WebElement element,String Text)
	{
		try
		{
			element.sendKeys(Text);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	public void usd_SelectByVisibletext(WebElement element,String visibletext)
	{
		try
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(visibletext);
			
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void usd_SelectByIndex(WebElement element,int index)
	{
		try
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
			
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void usd_SelectBy(WebElement element,String value)
	{
		try
		{
			Select sel=new Select(element);
			sel.selectByValue(value);
			
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
		
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}
	/*public boolean waitForElement(final WebElement element)
	{
		nullifyImplicitlyWait();
		
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(7, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{
						@Override
						public Boolean apply(WebElement element) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}		
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
	}*/
	public void nullifyImplicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public void enableImplicitlyWait()
	{
		long implicitlyWait = 0;
		driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
	}

	public boolean waitElementPast(WebElement element, int seconds) {
		try {
			for (int sec = 0;; sec++) {
				if (sec >= seconds) {
					return false;
				}
				if (element.isDisplayed()) {
					Thread.sleep(1000);
				} else {
					return true;
				}
			}
		} catch (InterruptedException e) {
			return false;
		}
	}
	public boolean waitElementPast(WebElement by) {
		return waitElementPast(by, 60);
	}

	/**
	 * Check if a text is present. We will wait a maximum of 60 S.
	 * 
	 * @param text
	 *            the text to find
	 * @return true, if text is present
	 */
	public boolean waitTextPresent(String text) {
		return waitTextPresent(text, 60);
	}

	public boolean waitTextPresent(String text, int seconds) {
		for (int sec = 0;; sec++) {
			if (sec >= seconds) {
				break;
			}
			if (isTextPresent(text)) {
				return true;
			}
			wait(1);
		}
		return false;
	}

	private boolean isTextPresent(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean waitTextPast(String text) {
		return waitTextPast(text, 60);
	}

	public boolean waitTextPast(String text, int seconds) {
		for (int sec = 0;; sec++) {
			if (sec >= seconds) {
				break;
			}
			if (!isTextPresent(text)) {
				return true;
			}
			wait(1);
		}
		return false;
	}

	public void waitElementEnabled(WebElement element) {
		try {
			for (int sec = 0;; sec++) {
				if (sec >= 60) {
					break;
				}
				if (element.isEnabled()) {
					break;
				}
				wait(1);
			}
		} catch (NoSuchElementException e) {
		}
	}


}
