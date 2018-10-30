package tests;

import framework.WebTestFramework;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BasicTest {

	String mOriginalHandle;
	WebTestFramework w = new WebTestFramework("http://www.mytrackman.com");

	@BeforeMethod
	public void beforeMethod() {
		w.initBrowserDriver();
		mOriginalHandle = w.driver.getWindowHandle();
	}

	@AfterMethod
	public void afterMethod(ITestResult tr) {
		w.driver.manage().deleteAllCookies();
		
		if (!tr.isSuccess())
		{

			File scrFile = ((TakesScreenshot)w.driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(tr.getName()+"_error_screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		w.gotoStartUrl();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.driver.manage().deleteAllCookies();
		
		
		w.quitBrowser();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	public void closeAllTabs() {
		for(String handle : w.driver.getWindowHandles()) {
			if (!handle.equals(mOriginalHandle)) {
				w.driver.switchTo().window(handle);
				w.driver.close();
			}
		}

		w.driver.switchTo().window(mOriginalHandle);
	}

}
