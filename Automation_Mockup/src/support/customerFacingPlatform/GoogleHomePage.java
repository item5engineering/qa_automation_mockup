package support.customerFacingPlatform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.Page;

public class GoogleHomePage extends Page{

	//UI ELEMENTS
	@FindBy(id = "lst-ib")
	private WebElement searchBox;

	//CONSTRUCTOR
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//USER INTERACTIONS
	public void typeInTheSearchBox(String text){
		type(searchBox, text);
	}

	//GETTERS
	
}
