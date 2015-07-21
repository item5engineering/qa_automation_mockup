package testcases;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import support.customerFacingPlatform.CustomerFacingPlatformTestcase;

public class CustomerFacingGoogleSomething extends CustomerFacingPlatformTestcase{
	@Test
	public void typeSomething(){
		customerSide.homePage.typeInTheSearchBox("stuff");
	}
	@Test(dependsOnMethods = {"typeSomething"})
	public void clickSearch(){
		customerSide.resultsPage.clickSearch();
		WebElement firstResult = customerSide.resultsPage.getFirstResult();
		String title = firstResult.getText();
		Assert.assertTrue(title.toLowerCase().contains("stuff"));
	}
}
