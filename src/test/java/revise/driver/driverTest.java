package revise.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import revise.data.dataProvider;
import revise.pageObjects.landingPage;
import revise.pageObjects.searchPage;
import revise.resources.takeScreenshots;

public class driverTest {

	public WebDriver driver;
	protected searchPage search;
	protected dataProvider dataPage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//revise//resources//browser.properties");
		prop.load(file);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod()
	public void callingDriver() throws IOException {
		driver = initializeDriver();
		landingPage landing = new landingPage(driver);
		landing.homePage();
		search = new searchPage(driver);
	}
	
//	public WebDriver getDriver() {
//	    return driver;
//	}

	// Screenshot class
	public String takeScreen(WebDriver driver, String testName) throws IOException {
		takeScreenshots screenshot = new takeScreenshots();
		return screenshot.getScreenshots(driver, testName);
	}

	public dataProvider dataGet() {
		dataPage = new dataProvider();
		return dataPage;
	}

}
