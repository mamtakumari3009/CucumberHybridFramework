package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement emailText;

	@FindBy(id = "input-password")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement noMatchEmailWarningText;

	public void enterEmailAddress(String validEmailText) {

		elementUtils.typeTextIntoElement(emailText, validEmailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		

	}
	public void enterPassword(String validPasswordText) {
		
		elementUtils.typeTextIntoElement(passwordText, validPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public AccountPage clickOnLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
		
	}
	public String getWarningMessageOfNoMatchEmailText() {
		
		return elementUtils.getTextFromElement(noMatchEmailWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
