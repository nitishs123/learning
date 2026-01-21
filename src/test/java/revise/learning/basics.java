package revise.learning;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import revise.driver.driverTest;
import revise.pageObjects.cartPage;

public class basics extends driverTest {

	@Test(dataProvider = "dataSearch")
	public void Amazon(HashMap<String, String> input) throws InterruptedException {
		cartPage cart = search.searchEngine(input.get("search1"));
		cart.addToCart();
		search.newSearch(input.get("search2"));
	}

	@DataProvider(name = "dataSearch")
	public Object[] data() throws IOException {
		List<HashMap<String, String>> mappedData = dataPage.searchData();
		return new Object[] { mappedData.get(0) };
	}
}
