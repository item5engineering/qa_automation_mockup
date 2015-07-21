package support;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.saucelabs.common.SauceOnDemandAuthentication;

public abstract class TestCase {
	//made these nothing because I'm using google.com for the mockup
	protected String stagePrefix = "";
	protected String testPrefix = "";
	protected String currentBrowser;
	protected WebDriver driver;
	protected String url;
	protected int timeOutInSeconds = 30;
	protected Page selenium;

	protected enum Box {
		REMOTE, LOCAL, SAUCE
	}

	protected enum LocalBrowser {
		FIREFOX, CHROME
	}

	protected enum Environment {
		STAGE, TEST
	}

	protected Box box;
	protected LocalBrowser localBrowser;
	protected Environment environment;

	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
			"username", "access_key");
	public String sessionId;

	public void initialize(String sBrowser, String sBox, String sEnvironment,
			String remoteAddress, String Version) {

		try {
			if (sEnvironment.toLowerCase().contains("stage")) {
				environment = Environment.STAGE;
			} else if (sEnvironment.toLowerCase().contains("local")) {
				environment = Environment.TEST;
			}

			if (sBrowser.toLowerCase().contains("firefox")) {
				localBrowser = LocalBrowser.FIREFOX;
			} else if (sBrowser.toLowerCase().contains("chrome")) {
				localBrowser = LocalBrowser.CHROME;
			}
			if (sBox.toLowerCase().contains("remote")) {
				box = Box.REMOTE;
			} else if (sBox.toLowerCase().contains("local")) {
				box = Box.LOCAL;
			} else if (sBox.toLowerCase().contains("sauce")) {
				box = Box.SAUCE;
			}

			switch (box) {
			case LOCAL:
				switch (localBrowser) {
				case FIREFOX:

					driver = new FirefoxDriver();
					break;

				case CHROME:

					driver = new ChromeDriver();
					break;

				}
				break;

			case REMOTE:

				switch (localBrowser) {
				case FIREFOX: {
					DesiredCapabilities capability = DesiredCapabilities
							.firefox();
					driver = new RemoteWebDriver(new URL("http://"
							+ remoteAddress + ":4444/wd/hub"), capability);
					break;
				}
				case CHROME: {
					DesiredCapabilities capability = DesiredCapabilities
							.chrome();
					driver = new RemoteWebDriver(new URL("http://"
							+ remoteAddress + ":4444/wd/hub"), capability);
					break;
				}
				}
				break;

			case SAUCE:

				switch (localBrowser) {
				case FIREFOX: {
					DesiredCapabilities capability = DesiredCapabilities
							.firefox();
					capability.setCapability("platform", Platform.VISTA);
					capability.setCapability("name", getClass().getName());
					driver = new RemoteWebDriver(new URL("http://"
							+ authentication.getUsername() + ":"
							+ authentication.getAccessKey()
							+ "@ondemand.saucelabs.com:80/wd/hub"), capability);
					break;
				}
				case CHROME: {
					DesiredCapabilities capability = DesiredCapabilities
							.chrome();
					capability.setCapability("platform", Platform.VISTA);
					capability.setCapability("name", getClass().getName());
					driver = new RemoteWebDriver(new URL("http://"
							+ authentication.getUsername() + ":"
							+ authentication.getAccessKey()
							+ "@ondemand.saucelabs.com:80/wd/hub"), capability);
					break;
				}
				}
				break;

			}

			selenium = new Page(driver);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void teardown() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Failed to close the browser.  "
					+ "The browser may have crashed or been closed.");
		}
	}

}
