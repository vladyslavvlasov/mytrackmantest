using System;
using OpenQA.Selenium;

namespace webtest
{
    public class ElementHelper
    {
        public By locator;

        public ElementHelper(By locator) {
            this.locator = locator;
        }
    }
}
