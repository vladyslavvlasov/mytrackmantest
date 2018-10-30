package helper;

import org.openqa.selenium.By;

public class ElementHelper {
	
	public String name;
	public By locator;
	
	public ElementHelper(String name, By locator)
	{
		this.name = name;
		this.locator = locator;
	}

}
