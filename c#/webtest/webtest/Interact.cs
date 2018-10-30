using System;
using OpenQA.Selenium;


namespace webtest
{
    public class Interact
    {
        public IWebDriver driver { get; set; }

        public Interact(IWebDriver driver)
        {
            this.driver = driver;
        }

        public void Click(By b) 
        {
            driver.FindElement(b).Click();    
        }

        public void Type (String text, By b)
        {
            driver.FindElement(b).SendKeys(text);
        }

        public void formsubmit (By b)
        {
            driver.FindElement(b).Submit();
        }

        public void ScreenShot()
        {
            Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
            ss.SaveAsFile("temp.jpg",System.Drawing.Imaging.ImageFormat.Jpeg);
        }

        public Boolean doesTextExist(String text)
        {
            if (driver.FindElement(By.XPath("//*")).Text.Contains(text)) { return true;  }
            return false;
        }

        public void switchToLastTab() 
        {
            driver.SwitchTo().Window(driver.WindowHandles[driver.WindowHandles.Count - 1]);
        }

        public void switchToFirstTab()
        {
            driver.SwitchTo().Window(driver.WindowHandles[0]);
        }

        public void goTo(String url)
        {
            driver.Navigate().GoToUrl(url);
        }

        public void LongWait ()
        {
            System.Threading.Thread.Sleep(5000);
        }
    }
}
