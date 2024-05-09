package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccesPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
    private AccountSuccesPage accountSuccesPage;
    private CommonUtils commonUtils;
    private DriverFactory driverFactory;
    
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	    driverFactory=new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickOnRegisterOption();


	}

	@When("User Enter the details into below fields")
	public void user_enter_the_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerPage.enterEmailField(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephoneField(dataMap.get("telephone"));
		registerPage.enterPasswordField(dataMap.get("password"));
		registerPage.enterConfirmPasswordField(dataMap.get("confirmPassword"));

	}
	@When("User Enter the details into below fields with duplicate email")
	public void user_enter_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailField(dataMap.get("email"));
		registerPage.enterTelephoneField(dataMap.get("telephone"));
		registerPage.enterPasswordField(dataMap.get("password"));
		registerPage.enterConfirmPasswordField(dataMap.get("confirmPassword"));

	}

	@And("User selects Privacy Policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		
		registerPage.clickOnPrivacyPolicy();
		
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccesPage = registerPage.clickOnContinueButton();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		Assert.assertEquals("Your Account Has Been Created!",
				accountSuccesPage.retrieveSuccessAccountCreatedText());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {

		registerPage.clickOnNewsLetterOption();
		
	}

	@Then("User account should get a proper warning message about duplicate email address")
	public void user_account_should_get_a_proper_warning_message_about_duplicate_email_address() {

		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registerPage.retrieveDuplicateEmailWarningMessage());
	}

	@When("User do not enter any details into fields")
	public void user_do_not_enter_any_details_into_fields() {


		// Intentionally kept blank

	}

	@Then("User should get proper warning messages for all mandatory fields")

	public void user_should_get_proper_warning_messages_for_all_mandatory_fields() {

		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registerPage.retrievePrivacyPolicyWarningMessage());

		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerPage.retrieveFirstNameWarningMessage());

		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registerPage.retrieveLastNameWarningMessage());

		Assert.assertEquals("E-Mail Address does not appear to be valid!",
				registerPage.retrieveEmaiAddressWarningMessage());

		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerPage.retrieveTelephoneWarningMessage());

		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registerPage.retrievePasswordWarningMessage());

	}


}
