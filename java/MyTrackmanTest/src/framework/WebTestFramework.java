package framework;


import helper.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import framework.RunConfiguration.browsernames;

public class WebTestFramework {

    private Util util = new Util();
    public WebDriver driver;
    private RunConfiguration runConfiguration = new RunConfigurations().TestChrome;
    public Users users = new Users();
    private IHelperCollection helperCollection = new BasicHelperCollection();

    private String starturl;

    public WebTestFramework(String starturl) {
        this.starturl = starturl;
    }

    public String getStartUrl() {
        return this.starturl;
    }

    public void select(String elementName, String labelName) {
        ElementHelper e = helperCollection.getElementHelper(elementName);
        Select droplist = new Select(driver.findElement(e.locator));
        driver.findElements(By.className("mb-message")).get(0).click();
        droplist.selectByVisibleText(labelName);
    }

    public WebElement ElasticFind(ElementHelper eh) {
        return util.elasticFind(driver, eh);
    }

    public void initBrowserDriver() {
        if (runConfiguration.browser.equals(browsernames.CHROME)) {
            System.setProperty("webdriver.chrome.driver", runConfiguration.chromedriverpath);
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("user-data-dir=c:/users/trackman/Appdata/local/google/chrome/user data/default");
            if (runConfiguration.chromeuserprofileargument != null)
                options.addArguments(runConfiguration.chromeuserprofileargument);
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        if (runConfiguration.browser.equals(browsernames.FIREFOX)) {
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        helperCollection = new LoginHelperCollection();
        helperCollection = new MainScreenHelperCollection();
        helperCollection = new CombineHelperCollection();

    }

    public void quitBrowser() {
        driver.quit();
    }

    public boolean doesTextFragmentExist(String textfragment) {
        boolean result = util.doesTextFragmentExist(driver, textfragment);
        return result;
    }

    public void assertTextFragmentExists(String textfragment) {
        boolean result = util.doesTextFragmentExist(driver, textfragment);
        if (result == false) {
            Assert.assertEquals(null, textfragment, "Assert on text failed - looked for '" + textfragment + "' but was not found");
        }
    }

    public void assertTextFragmentDoesNotExists(String textfragment) {
        boolean result = util.doesTextFragmentExist(driver, textfragment);
        if (result == true) {
            Assert.assertEquals(null, textfragment, "Assert on text failed - looked for '" + textfragment + "' which was found when it should not");
        }
    }

    public void assertElementDisplayed(String elementName) {
        By elementLocator = helperCollection.getElementHelper(elementName).locator;
        Assert.assertTrue(util.isElementDisplayed(driver, elementLocator), "Assert on element " + elementName + " displayed failed");
    }

    public void assertElementsNumber(int expectedNumber, String elementName) {
        By elementLocator = helperCollection.getElementHelper(elementName).locator;

        int actualNumber = driver.findElements(elementLocator).size();
        Assert.assertEquals(actualNumber, expectedNumber, "Assert on number of elements failed. Expected " + expectedNumber + " but found " + actualNumber);
    }

    public void clickFirstOccourenceOfText(String text) {
        System.out.println("Click first occurence: " + text);
        WebElement webElement = util.elasticFind(driver, By.cssSelector("//*[text()='" + text + "']"));
        if (webElement != null) {
            webElement.click();
            return;
        }


    }

    public void clickAndWait(String elementName) {
        this.click(elementName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void click(String elementName) {
        System.out.println("Click: " + elementName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ElementHelper e = helperCollection.getElementHelper(elementName);
        if (e != null) {
            WebElement webElement = util.elasticFind(driver, e.locator);
            if (webElement != null) {
                webElement.click();
            } else {
                System.err.println("Did not locate the element");
                return;
            }
        } else {
            System.err.println("Helper name not found");
            return;
        }
        System.out.println("Click: " + elementName + " done");
    }

    public void typeText(String elementName, String text) {
        System.out.println("Type: " + text);
        ElementHelper e = helperCollection.getElementHelper(elementName);
        if (e != null) {
            WebElement webElement = util.elasticFind(driver, e.locator);

            if (webElement != null) {

                webElement.sendKeys(text);
            }
        }
    }

    public void clearField(String elementName) {
        System.out.println("Clear: " + elementName);
        ElementHelper e = helperCollection.getElementHelper(elementName);
        if (e != null) {
            WebElement webElement = util.elasticFind(driver, e.locator);

            if (webElement != null) {
                webElement.clear();
            }
        }
    }

    public void gotoPageUrl(String url) {
        driver.get(url);
    }

    public void gotoStartUrl() {
        driver.get(starturl);
    }

    public void setHelperCollection(IHelperCollection helperCollection) {
        this.helperCollection = helperCollection;
    }


    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void click() {
    }
}
