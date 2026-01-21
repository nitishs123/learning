package revise.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public abstractComponent(WebDriver driver) {
		this.driver = driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.wait = wait;
		this.js = js;
	}

	public void waitForWebElementToAppear(WebElement s) {
		wait.until(ExpectedConditions.visibilityOf(s));
	}

	public void waitForWebElementsToAppear(List<WebElement> searchSuggestion) {
		wait.until(ExpectedConditions.visibilityOfAllElements(searchSuggestion));
	}

	public void scroll() {
		js.executeScript("window.scrollBy(0,700)");
	}
}
