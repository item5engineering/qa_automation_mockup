package support.employeeFacingPlatform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.Page;

public class GoogleResultsPage extends Page{
	//UI ELEMENTS
	@FindBy(css = "#sblsbb > button")
	private WebElement searchButton;
	@FindBy(css = "#rso > li:nth-child(2) > div > div > h3 > a")
	private WebElement firstResult;

	//CONSTRUCTOR
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//USER INTERACTIONS
	public void clickSearch(){
		click(searchButton);
	}

	//GETTERS
	public WebElement getFirstResult(){
		return waitUntil(ExpectedConditions.visibilityOf(firstResult));
	}
	
}
