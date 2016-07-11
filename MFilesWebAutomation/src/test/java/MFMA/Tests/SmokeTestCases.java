package MFMA.Tests;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import MFMA.Pages.LoginPage;

import genericLibrary.DataProviderUtils;
import genericLibrary.EmailReport;
import genericLibrary.Log;
import genericLibrary.MobileDriverUtils;

@Listeners(EmailReport.class)
public class SmokeTestCases {
	
	public static String xlTestDataWorkBook = null;
	public static String userName = null;
	public static String password = null;
	public static String testVault = null;
	
	/**
	 * onSuiteStart : Before Suite method to clean screenshots folder and backup the test vault before starting the execution
	 * @throws Exception 
	 */
	@BeforeSuite (alwaysRun=true)
	public void onSuiteStart(ITestContext context) throws Exception {
		
		try {
			
			Log.cleanScreenShotFolder(context);
			Log.deleteDownloadedFilesFolder(context);
			
		} //End try
		catch (Exception e) {
			throw e;
		}	//End catch	
		
	} //End onSuiteStart
	
	/**
	 * init : Before Class method to perform initial operations.
	 */
	@BeforeClass (alwaysRun=true)
	public void init() throws Exception {
		
		try {
			
			xlTestDataWorkBook = "SmokeTestCases.xls";
			XmlTest xmlParameters = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			userName = xmlParameters.getParameter("UserName");
			password = xmlParameters.getParameter("Password");
			testVault = xmlParameters.getParameter("VaultName");			
			
		} //End try
		
		catch(Exception e) {
			if (e.getClass().toString().contains("NullPointerException")) 
				throw new Exception ("Test data sheet does not exists.");
			else {
				System.out.println(e);
				throw e;
			}
		} //End catch
		
	} //End init
	
	/**
	 * TC_001 : Login to application
	 */
	@Test(description = "Login to application")
	public void AdvancedUseCaseTest1_1_10A() throws Exception {
		
		WebDriver driver = MobileDriverUtils.getDriver();
		
		try {
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToMfiles("AlexK", "Password", "sample vault");
							
		}
		catch (Exception e) {
			Log.exception(e, driver);
		} //End catch
		
		finally {
		} //End finally
		
	} //End AdvancedUseCaseTest1_1_10A
	
	/**
	 * TC_001 : Login to application
	 *//*
	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "excelDataReader", groups = {""}, 
			description = "Login to application")
	public void AdvancedUseCaseTest1_1_10A(HashMap<String,String> dataValues, String driverType) throws Exception {
		
		WebDriver driver = MobileDriverUtils.getDriver();
		
		try {
			
			ConcurrentHashMap <String, String> dataPool = new ConcurrentHashMap <String, String>(dataValues);
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToMfiles("AlexK", "Password", "sample vault");
							
		}
		catch (Exception e) {
			Log.exception(e, driver);
		} //End catch
		
		finally {
		} //End finally
		
	} //End AdvancedUseCaseTest1_1_10A
*/	
		 
}
