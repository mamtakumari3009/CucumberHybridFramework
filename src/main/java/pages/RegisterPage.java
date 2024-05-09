package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id ="input-firstname")
	private WebElement firstNameText;

	@FindBy(id ="input-lastname")
	private WebElement lastNameText;

	@FindBy(id ="input-email")
	private WebElement emailText;

	@FindBy(id ="input-telephone")
	private WebElement telephoneText;

	@FindBy(xpath ="//input[@id='input-password']")
	private WebElement passwordText;

	@FindBy(xpath ="//input[@id='input-confirm']")
	private WebElement confirmPasswordText;

	@FindBy(xpath ="//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath ="//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath ="//label[normalize-space()='Yes']")
	private WebElement newsLetterOption;

	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningText;

	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningText;

	@FindBy(xpath ="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningText;

	@FindBy(xpath ="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningText;

	@FindBy(xpath ="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningText;

	@FindBy(xpath ="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningText;

	@FindBy(xpath ="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningText;


	public void enterAllDetailsForRegisterAccount(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {

		firstNameText.sendKeys(firstName);
		lastNameText.sendKeys(lastName);
		emailText.sendKeys(email);
		telephoneText.sendKeys(telephone);
		passwordText.sendKeys(password);
		confirmPasswordText.sendKeys(confirmPassword);
	}
	public void enterFirstName(String firstName) {
		
		elementUtils.typeTextIntoElement(firstNameText, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void enterLastName(String lastName) {
		
		elementUtils.typeTextIntoElement(lastNameText, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void enterEmailField(String email) {
		
		elementUtils.typeTextIntoElement(emailText, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void enterTelephoneField(String telephone) {
		
		elementUtils.typeTextIntoElement(telephoneText, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void enterPasswordField(String password) {
		
		elementUtils.typeTextIntoElement(passwordText, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void enterConfirmPasswordField(String confirmPassword) {
		
		elementUtils.typeTextIntoElement(confirmPasswordText, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public void clickOnPrivacyPolicy() {
		
		elementUtils.clickOnElement(privacyPolicyCheckbox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	public AccountSuccesPage clickOnContinueButton() {
		
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new AccountSuccesPage(driver);
		
	}
	
	public void clickOnNewsLetterOption() {
		
		elementUtils.clickOnElement(newsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	public String retrieveDuplicateEmailWarningMessage() {
		
		return elementUtils.getTextFromElement(duplicateEmailWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public String retrievePrivacyPolicyWarningMessage() {

		return elementUtils.getTextFromElement(privacyPolicyWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
				
	}
	public String retrieveFirstNameWarningMessage() {

		return elementUtils.getTextFromElement(firstNameWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public String retrieveLastNameWarningMessage() {

		return elementUtils.getTextFromElement(lastNameWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public String retrieveEmaiAddressWarningMessage() {

		return elementUtils.getTextFromElement(emailWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public String retrieveTelephoneWarningMessage() {

		return elementUtils.getTextFromElement(telephoneWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public String retrievePasswordWarningMessage() {

		return elementUtils.getTextFromElement(passwordWarningText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}