package mfma.stepdefinitions;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.xml.XmlTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import genericLibrary.Session;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Hooks {
    
	@Before
	public static void launchApp() throws Exception{
		
		URL hubURL = null;
		
		try {
			
			XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			String platform = test.getParameter("platform");
			String device = test.getParameter("deviceName");
			String appPath = System.getProperty("user.dir") + "\\Application\\";
			String driverHost = test.getParameter("deviceHost");
			String driverPort = test.getParameter("devicePort");
			hubURL = new URL("http://" + driverHost + ":" + driverPort + "/wd/hub");
			
			switch (platform.toUpperCase()) {
				
				case "ANDROID":{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "Android\\");
	    	    	Session.driver =  new AndroidDriver(hubURL, capabilities);
	    	    	break;
	    		}	
	    		case "IOS":{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "IoS\\");
	    	    	Session.driver =  new IOSDriver(hubURL, capabilities);
	    	    	break;
	    		}	
	    		default:{
	    			DesiredCapabilities capabilities = new DesiredCapabilities();
	    	    	capabilities.setCapability("device",platform);
	    	    	capabilities.setCapability("deviceName",device);
	    	    	capabilities.setCapability("platformName", platform);
	    	    	capabilities.setCapability("appPackage", "com.mfiles.mobile"); 
	    	    	capabilities.setCapability("app", appPath + "Android\\");
	    	    	Session.driver =  new AndroidDriver(hubURL, capabilities);
	    		}	
    		
			} //End switch
			
		} //End try
		catch (Exception e) {
			throw new Exception("Exception encountered in getDriver Method." + e.getMessage().toString());
		}
    }
    
    @After
    public static void quitDriver(){
    	Session.driver.quit();
    	Session.driver = null;
    }
}
