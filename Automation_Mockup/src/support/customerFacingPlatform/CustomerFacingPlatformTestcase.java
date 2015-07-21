package support.customerFacingPlatform;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import support.TestCase;

public class CustomerFacingPlatformTestcase extends TestCase{
	public CustomerFacingApplication customerSide;

	@Parameters({ "browser", "remoteOrLocal", "environment", "remoteAddress", "version"})
	@BeforeClass
	public void setup(String browser, String remoteOrLocal, String environment, String remoteAddress, String version){
		super.initialize(browser, remoteOrLocal, environment, remoteAddress, version);
		if(environment.toLowerCase().contains("stage")){
			url = "http://www" + stagePrefix + ".google.com";
		}else if(environment.toLowerCase().contains("test")){
			url = "http://www" + testPrefix + ".google.com";
		}
		
		customerSide = new CustomerFacingApplication(driver);
		driver.get(url);
	}
	@AfterClass
	public void callTeardown(){
		teardown();
	}
}
