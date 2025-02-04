package Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	public static String hubURL = "https://hub.lambdatest.com/wd/hub";
    
	public void setUp(String browser,String platFormName,String browserVersion) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", browserVersion);
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "sakshi_nirkhe");
        ltOptions.put("accessKey", "aL718xeouQWBmATl3y3zDekzQkh0TMKyVAn6dlrhtQEpNhXqWF");
        ltOptions.put("build", "TestCertification-TestNG");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", platFormName);
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        DriverFactory.getInstances().setDriver(new RemoteWebDriver(new URL(hubURL), capabilities));
	}
	
	public WebDriver driver() {
		return DriverFactory.getInstances().getDriver();
	}
}
