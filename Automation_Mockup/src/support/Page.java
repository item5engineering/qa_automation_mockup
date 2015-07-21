package support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page {
	protected WebDriver driver;
	protected int timeOutInSeconds = 60;
	
	public Page(WebDriver driver){
		this.driver = driver;
	}
	public void hardWaitInSeconds(int waitTimeInSeconds ) {
		try{
			Thread.sleep(waitTimeInSeconds * 1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean isElementPresent(By locator){
		try{
			new WebDriverWait(driver, timeOutInSeconds)
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean isElementPresent(By locator, int customTimeOut){
		try{
			new WebDriverWait(driver, customTimeOut)
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean isElementVisible(WebElement element){
		try {
			new WebDriverWait(driver, timeOutInSeconds)
			.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e){
			return false;
		}
	}
	public boolean isElementVisible(WebElement element, int customTimeOut){
		try {
			new WebDriverWait(driver, customTimeOut)
			.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e){
			return false;
		}
	}
	public boolean isElementClickable(WebElement element){
		try{
			new WebDriverWait(driver, timeOutInSeconds)
			.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean isElementClickable(WebElement element, int customTimeOut){
		try{
			new WebDriverWait(driver, customTimeOut)
			.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public WebElement waitUntil(ExpectedCondition<WebElement> expectedCondition){
		WebElement e = new WebDriverWait(driver, timeOutInSeconds).until( expectedCondition);
		return e;
	}
	public boolean waitUntilBoolean(ExpectedCondition<Boolean> expectedCondition){
		boolean e = new WebDriverWait(driver, timeOutInSeconds).until( expectedCondition);
		return e;
	}

	public void click(WebElement e){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

	public void click(WebElement e, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

	public void click(By by){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void click(By by, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void clear(By by){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(by)).clear();
	}

	public void clear(By by, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(by)).clear();
	}

	public void clear(WebElement e){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(e)).clear();
	}

	public void clear(WebElement e, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(e)).clear();
	}

	public void type(WebElement e, String text){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
	}

	public void type(WebElement e, String text, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
	}

	public void type(By by, String text){
		new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
	}

	public void type(By by, String text, int customTimeOut){
		new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
	}

	public String getText(WebElement e){
		 return new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.visibilityOf(e)).getText();
	}

	public String getText(WebElement e, int customTimeOut){
		 return new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.visibilityOf(e)).getText();
	}

	public String getText(By by){
		 return new WebDriverWait(driver, timeOutInSeconds)
		.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	public String getText(By by, int customTimeOut){
		 return new WebDriverWait(driver, customTimeOut)
		.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}

}
