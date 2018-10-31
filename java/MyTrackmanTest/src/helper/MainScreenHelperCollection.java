package helper;

import org.openqa.selenium.By;

public class MainScreenHelperCollection extends BasicHelperCollection implements IHelperCollection {

    public MainScreenHelperCollection() {
        collection.add(new ElementHelper("myactivities", By.id("gallery-tab-my-activities")));
        collection.add(new ElementHelper("screencasts", By.id("gallery-tab-screencasts")));
        collection.add(new ElementHelper("combine", By.id("gallery-tab-combine")));
        collection.add(new ElementHelper("personalmenu", By.cssSelector("#desktopHeader #personal_menu")));
    }

}
