package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	private WebDriverWait wait;
	private WebElement webElement = null;
	private Alert alert = null;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textBetyped, long durationInSeconds) {

		webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textBetyped);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return element;

	}

	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

		webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);

	}

	public void acceptAlert(long durationInSeconds) {

		alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {

		alert = waitForAlert(durationInSeconds);
		alert.dismiss();
		;
	}

	public Alert waitForAlert(long durationInSeconds) {
		try {

			wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClickAction(WebElement element, long durationInSeconds) {

		webElement = waitForVisibilityOfElement(element, durationInSeconds);

		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {

		webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("argument[0].click()", webElement);

	}

	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {

		webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("argument[0].value='"+textToBeTyped+"'", webElement);

	}
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		
		webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
		
	}
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
		webElement = waitForVisibilityOfElement(element, durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
	}
}
