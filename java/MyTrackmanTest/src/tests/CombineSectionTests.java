package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vladyslav Vlasov on 31.10.2018.
 */
public class CombineSectionTests extends BasicTest {
    @Test
    public void playersListTest(){
        w.click("combine");
        w.assertTextFragmentExists("COMBINE LEADERBOARD");
        w.assertTextFragmentExists("Top: 1 - 25");
        w.assertTextFragmentExists("Top: 25 - 50");
        w.assertElementsNumber(50,"rank");
    }

    @BeforeMethod
    public void login(){
        w.gotoStartUrl();
        w.click("loginbutton");
        w.typeText("login", w.users.testUser.username);
        w.typeText("password", w.users.testUser.password);
        w.clickAndWait("dologinbutton");
        w.assertElementDisplayed("personalmenu");
    }
}
