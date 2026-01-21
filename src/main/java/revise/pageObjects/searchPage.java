package revise.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import revise.abstractComponents.abstractComponent;

public class searchPage extends abstractComponent {

	WebDriver driver;

	public searchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@role='row']")
	List<WebElement> searchSuggestion;

	public cartPage searchEngine(String jean) {
		waitForWebElementToAppear(searchBox);
		searchBox.sendKeys(jean);
		waitForWebElementsToAppear(searchSuggestion);
		for (WebElement suggestion : searchSuggestion) {
			String text = suggestion.getText();
			if (text.equalsIgnoreCase("jeans for man")) {
				suggestion.click();
				break;
			}
		}
		scroll();
		cartPage cart = new cartPage(driver);
		return cart;
	}

	public void newSearch(String search) {
		waitForWebElementToAppear(searchBox);
		searchBox.clear();
		searchBox.sendKeys(search, Keys.ENTER);
	}
}
