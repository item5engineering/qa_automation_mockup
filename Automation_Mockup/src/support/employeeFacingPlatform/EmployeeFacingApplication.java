package support.employeeFacingPlatform;

import org.openqa.selenium.WebDriver;

import support.Page;

public class EmployeeFacingApplication extends Page {
	public GoogleHomePage homePage;
	public GoogleResultsPage resultsPage;

	// CONSTRUCTOR
	public EmployeeFacingApplication(WebDriver driver) {
		super(driver);
		homePage = new GoogleHomePage(driver);
		resultsPage = new GoogleResultsPage(driver);
	}

}
