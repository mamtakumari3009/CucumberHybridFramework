package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;
	private DriverFactory driverFactory;
	
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();

	}

	@When("User enters valid product {string} into searchbox field")
	public void user_enters_valid_product_into_searchbox_field(String validProductText) {

		homePage = new HomePage(driver);
		homePage.enterValidProduct(validProductText);
		

	}

	@When("User enters invalid product {string} into searchbox field")
	public void user_enters_invalid_product_into_searchbox_field(String inValidProductText) {
		
	    homePage = new HomePage(driver);
		homePage.enterInvalidProduct(inValidProductText);
		

	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {

	    searchPage = homePage.clickOnSearchButton();

	}

	@Then("User should get valid product display in the search results")
	public void user_should_get_valid_product_display_in_the_search_results() {
		
		Assert.assertTrue(searchPage.retrieveDisplayStatusOfValidProductText());

	//	Assert.fail();
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		Assert.assertEquals("There is no product that matches the search criteria.",
				searchPage.retrieveDisplayStatusOfInvalidProductText());

	}

	@When("User do not enter any product name into searchbox field")
	public void user_do_not_enter_any_product_name_into_searchbox_field() {
		
		homePage = new HomePage(driver);
		
	}

}
