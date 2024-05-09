package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLoginOption();

	}

	@When("^User enters valid email address (.+) into the email field$")
	public void user_enters_valid_email_address_into_the_email_field(String validEmailText) {

		loginPage.enterEmailAddress(validEmailText);
		

	}
	

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String validPasswordText) {
		
		loginPage.enterPassword(validPasswordText);
		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		accountPage =loginPage.clickOnLoginButton();

	}

	@Then("User should get successfully Logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
		
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {

		
		loginPage.enterPassword(invalidPasswordText);

	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {

		
		Assert.assertTrue(loginPage.getWarningMessageOfNoMatchEmailText().contains("Warning: No match for E-Mail Address and/or Password."));
		

	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String validEmailText) {
		
		loginPage.enterEmailAddress(validEmailText);
		
	}

	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		
		loginPage = new LoginPage(driver);
		
	}

	@And("User do not enters password into password field")
	public void user_do_not_enters_password_into_password_field() {

		loginPage = new LoginPage(driver);
		
	}

	
}
