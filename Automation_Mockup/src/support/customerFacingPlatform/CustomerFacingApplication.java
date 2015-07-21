package support.customerFacingPlatform;

import org.openqa.selenium.WebDriver;

import support.Page;

public class CustomerFacingApplication extends Page {
	public GoogleHomePage homePage;
	public GoogleResultsPage resultsPage;

	// CONSTRUCTOR
	public CustomerFacingApplication(WebDriver driver) {
		super(driver);
		homePage = new GoogleHomePage(driver);
		resultsPage = new GoogleResultsPage(driver);
	}

}
