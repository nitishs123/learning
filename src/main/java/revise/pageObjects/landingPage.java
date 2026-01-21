package revise.pageObjects;

import org.openqa.selenium.WebDriver;

public class landingPage {
	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		this.driver=driver;
	}

	public void homePage() {
		driver.get(
				"https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=74877943452078136&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007800&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		
	}
}
