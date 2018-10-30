package helper;

import org.openqa.selenium.By;

public class MainScreenHelperCollection extends BasicHelperCollection implements IHelperCollection{
	
	public MainScreenHelperCollection()
	{
		collection.add(new ElementHelper("myactivities", By.id("gallery-tab-my-activities")));
		collection.add(new ElementHelper("screencasts", By.id("gallery-tab-screencasts")));
	}

}
