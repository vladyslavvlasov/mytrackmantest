package tests;

import framework.WebTestFramework;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


// this is a BasicTest class which will serve as a parent for all tests
public class BasicTest {

    String mOriginalHandle;
    /**
     * Here we initialize WebTestFramework object, which has access to webdriver and its configuration.
     * During inializing startUrl is set
    */
    WebTestFramework w = new WebTestFramework("http://www.mytrackman.com");

    /**
     * Here we have beforeMethod TestNg annotation which takes care of initializing driver its related configs (browser choice,
     * maximizing window, deleting cookies)before each test
     * run	and remembers original window handle, which would later be used in closeAllTabs() method
     */

    @BeforeMethod
    public void beforeMethod() {
        /**
         * in initBrowserDriver() method driver initialization and its configuration takes place,
         * therefore all tests extending BasicTest class will have access to driver instance.
         */
         w.initBrowserDriver();
        mOriginalHandle = w.driver.getWindowHandle();
    }

/**Here we have cleaning afterMethod which would take care of deleting cookies,
 * making screenshot if the test fails and quiting browser after each test run.
 * afterMethod takes ITestResult instance tr which is an object that has information about just finished test (name,testClass,startTime, etc.)
 * and its result status
 */
 @AfterMethod
    public void afterMethod(ITestResult tr) {
        w.driver.manage().deleteAllCookies();

        if (!tr.isSuccess()) {

            File scrFile = ((TakesScreenshot) w.driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(tr.getName() + "_error_screenshot.png"));
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

    /**
     * This is closeAllTabs method which iterates through all open tabs,
     * switches to and closes all tabs except the original one
     */
    public void closeAllTabs() {
        for (String handle : w.driver.getWindowHandles()) {
            if (!handle.equals(mOriginalHandle)) {
                w.driver.switchTo().window(handle);
                w.driver.close();
            }
        }

        w.driver.switchTo().window(mOriginalHandle);
    }

}
