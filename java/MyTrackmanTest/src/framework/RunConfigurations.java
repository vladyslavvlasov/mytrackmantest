package framework;

import framework.RunConfiguration.browsernames;

public class RunConfigurations {
	public RunConfiguration TestChrome = new RunConfiguration("TestChrome", "chromedriver.exe", null, browsernames.CHROME);
}
