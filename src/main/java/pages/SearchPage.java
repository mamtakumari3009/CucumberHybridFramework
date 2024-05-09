package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
    private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	@FindBy(linkText = "HP LP3065")
	private WebElement displayStatusOfValidProductText;

	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement displayStatusOfInvalidProductText;
	
	
	

	public boolean retrieveDisplayStatusOfValidProductText() {

		return elementUtils.displayStatusOfElement(displayStatusOfValidProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	public String retrieveDisplayStatusOfInvalidProductText() {

		return elementUtils.getTextFromElement(displayStatusOfInvalidProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
}
