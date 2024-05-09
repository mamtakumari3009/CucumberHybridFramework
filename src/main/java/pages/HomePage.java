package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils =new ElementUtils(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText ="Login")
	private WebElement loginOption;

	@FindBy(linkText ="Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement productText;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {

		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public LoginPage clickOnLoginOption() {

		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterOption() {

		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	public void enterValidProduct(String validProduct) {

		elementUtils.typeTextIntoElement(productText, validProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public void enterInvalidProduct(String inValidProduct) {

		elementUtils.typeTextIntoElement(productText, inValidProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public SearchPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new SearchPage(driver);
	}
}
