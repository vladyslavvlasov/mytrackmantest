using NUnit.Framework;
using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.PhantomJS;


namespace webtest
{
    [TestFixture()]
    public class Test
    {
       
        private RemoteWebDriver driver;
        //public TestContext TestContext { get; set; }
        Interact i;
       

        [SetUp]
        public void init()
        {
            driver = new ChromeDriver("c:/chromedriver/");
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(10));
            i = new Interact(driver);

        }

        [TearDown]
        public void TearDown()
        {
            driver.Dispose();
        }



        [Test]
        public void SucessfulLogin()
        {
            i.goTo(URLs.prod_mytrackman);
            i.Click(LoginScreen.loginButton);
            i.Type(Users.defaultUser.username, LoginScreen.username);
        }
    }
}
