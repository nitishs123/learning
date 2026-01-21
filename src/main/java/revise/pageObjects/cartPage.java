package revise.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import revise.abstractComponents.abstractComponent;

public class cartPage extends abstractComponent {

	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//div//a//h2")
	List<WebElement> products;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement button;

	public void addToCart() {
		waitForWebElementsToAppear(products);
		for (WebElement product : products) {
			product.click();
			break;
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String childOne = it.next();
		driver.switchTo().window(childOne);
		waitForWebElementToAppear(button);
		button.click();
		driver.switchTo().window(parent);
	}

}
