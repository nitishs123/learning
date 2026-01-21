package revise.resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takeScreenshots {

	public String getScreenshots(WebDriver driver, String testName) throws IOException {
		TakesScreenshot tcs = (TakesScreenshot) driver;
		File source = tcs.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png");
		System.out.println(file);
		FileUtils.copyFile(source, file);
		return "screenshots/" + testName + ".png";

	}

}
