package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.ElementHelper;


public class Util {

	public WebElement elasticFind(WebDriver driver, ElementHelper eh)
	{
		return elasticFind(driver, eh.locator);
	}

	public WebElement elasticFind(WebDriver driver, By locator)
	{
		for (int i=0; i < 20; i++)
		{
			WebElement webElement = driver.findElement(locator);
			if (webElement!=null && webElement.isDisplayed())
			{
				return webElement;
			}
			sleep(500);
		}
		return null;
	}
	

	public boolean doesTextFragmentExist (WebDriver driver, String text)
	{
		for (int i = 0; i < 20; i++)
		{
			WebElement bodyElement = driver.findElement(By.tagName("body"));
		    if (bodyElement.getText().contains(text))
		    		{
		    	return true;
		    		}
			sleep(500);
		}
		return false;
	}

	private void sleep(long millis)
	{
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
