package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
	
	@Test
	public void SucessfulLogin() throws InterruptedException {
		w.typeText("login", w.users.testUser.username);
		w.typeText("password", w.users.testUser.password);
		w.clickAndWait("dologinbutton");
		w.assertElementDisplayed("personalmenu");
	}

	@Test
	public void UnsuccessfulLoginEmptyFields(){
		w.typeText("login", "");
		w.typeText("password", "");
		w.clickAndWait("dologinbutton");
		w.assertTextFragmentExists("Email or Username is required");
		w.assertTextFragmentExists("Password is required");
	}

	@Test
	public void UnsuccessfulLoginEmptyEmailOrLogin(){
		w.typeText("login", "");
		w.typeText("password", w.users.testUser.password);
		w.clickAndWait("dologinbutton");
		w.assertTextFragmentExists("Email or Username is required");
		w.assertTextFragmentDoesNotExists("Password is required");
	}

	@Test
	public void UnsuccessfulLoginEmptyPassword(){
		w.typeText("login", w.users.testUser.username);
		w.typeText("password", "");
		w.clickAndWait("dologinbutton");
		w.assertTextFragmentExists("Password is required");
		w.assertTextFragmentDoesNotExists("Email or Username is required");
	}

	@Test
	public void UnsuccessfulLoginIncorrectPassword(){
		w.typeText("login", w.users.testUser.username);
		w.typeText("password", "incorrectPassString");
		w.clickAndWait("dologinbutton");
		w.assertTextFragmentExists("The user name or password provided is incorrect.");
	}

	@BeforeMethod
	public void goToLoginForm(){
		w.gotoStartUrl();
		w.click("loginbutton");
	}
}
