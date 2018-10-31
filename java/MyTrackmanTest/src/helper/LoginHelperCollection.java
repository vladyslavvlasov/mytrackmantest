package helper;

import org.openqa.selenium.By;

public class LoginHelperCollection extends BasicHelperCollection implements IHelperCollection {
	
	public LoginHelperCollection()
	{
		collection.add(new ElementHelper("login", By.id("username")));
		collection.add(new ElementHelper("password", By.id("password")));
		collection.add(new ElementHelper("loginbutton", By.id("loginViewLink")));
		collection.add(new ElementHelper("dologinbutton", By.xpath("//section[@id='loginView']//button[contains(@class, 'form-button') and text() = 'Login']")));
    }
}
