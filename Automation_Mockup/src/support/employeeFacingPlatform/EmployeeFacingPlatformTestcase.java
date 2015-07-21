package support.employeeFacingPlatform;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import support.TestCase;

public class EmployeeFacingPlatformTestcase extends TestCase{
	@Parameters({ "browser", "remoteOrLocal", "environment", "remoteAddress", "version"})
	@BeforeClass
	public void setup(String browser, String remoteOrLocal, String environment, String remoteAddress, String version){
		super.initialize(browser, remoteOrLocal, environment, remoteAddress, version);
		if(environment.toLowerCase().contains("stage")){
			url = "http://" + stagePrefix + ".google.com";
		}else if(environment.toLowerCase().contains("test")){
			url = "http://" + testPrefix + ".google.com";
		}
		driver.get(url);
	}
	@AfterClass
	public void callTeardown(){
		teardown();
	}
}
