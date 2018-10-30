using System;
using OpenQA.Selenium;


namespace webtest
{
    public class LoginScreen
    {
        public static By loginButton = By.Id("loginViewLink");
        public static By username = By.Id("username");
        public static By password = By.Id("password");
        public static By loginSubmit = By.CssSelector("#loginView form:nth-of-type(1) div:nth-of-type(4) button.form-button");
        
    }
}
