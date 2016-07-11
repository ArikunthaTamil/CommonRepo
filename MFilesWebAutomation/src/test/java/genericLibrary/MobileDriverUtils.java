package genericLibrary;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

public class MobileDriverUtils {
	/**
	 * getDriver : Launches driver and returns the instance of the driver
	 * @return Instance of the driver
	 * @throws Exception 
	 */
	public static WebDriver getDriver() throws Exception {

		WebDriver driver = null;
		URL hubURL = null;
		
		try {
			
			XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			String platform = test.getParameter("platform");
			String device = test.getParameter("deviceName");
			String appPath = System.getProperty("user.dir") + "\\Application\\";
			String driverHost = test.getParameter("deviceHost");
			String driverPort = test.getParameter("devicePort");
			String appName = test.getParameter("appName");
			
			hubURL = new URL("http://127.0.0.1:4723/wd/hub");
			
			switch (platform.toUpperCase()) {
				
				case "ANDROID":{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "Android\\" + appName);
	    	    	driver =  new AndroidDriver(hubURL, capabilities);
	    	    	
	    	    	break;
	    		}	
	    		case "IOS":{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "IoS\\" + appName);
	    	    	driver =  new IOSDriver(hubURL, capabilities);
	    	    	break;
	    		}	
	    		default:{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "Android\\" + appName);
	    	    	driver =  new AndroidDriver(hubURL, capabilities);
	    		}	
    		
			} //End switch
			
		} //End try
		catch (Exception e) {
			throw new Exception("Exception encountered in getDriver Method." + e.getMessage().toString());
		}
		
		return driver;

	} //End getDriver
	
} //End getDriver