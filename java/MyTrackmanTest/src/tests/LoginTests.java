package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class LoginTests extends BasicTest{

	
	
	@Test
	public void SucessfulLogin() throws InterruptedException {
		w.gotoStartUrl();
		w.click("loginbutton");
		w.typeText("login", w.users.testUser.username);
		w.typeText("password", w.users.testUser.password);
	}
}
