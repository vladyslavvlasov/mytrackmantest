package framework;

import framework.RunConfiguration.browsernames;

public class RunConfigurations {
	public RunConfiguration TestChrome = new RunConfiguration("TestChrome", "c:/chromedriver/chromedriver.exe", null, browsernames.CHROME);
}
