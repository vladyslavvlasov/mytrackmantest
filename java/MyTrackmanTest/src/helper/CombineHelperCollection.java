package helper;

import org.openqa.selenium.By;

/**
 * Created by Vladyslav Vlasov on 31.10.2018.
 */
public class CombineHelperCollection extends BasicHelperCollection implements IHelperCollection {

    public CombineHelperCollection() {
        collection.add(new ElementHelper("rank", By.cssSelector("td[data-bind='text: Rank']")));
    }
}
