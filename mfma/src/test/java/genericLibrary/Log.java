package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.xml.XmlTest;

public class Log {
	
	public static boolean printconsoleoutput = true;
	
	/**
	 * cleanScreenShotFolder : Cleans screenshot folder of previous executions
	 * @param context
	 * @return None
	 * @throws Exception 
	 */
	public static void cleanScreenShotFolder(ITestContext context) throws Exception {

		try {
			
			printconsoleoutput = Boolean.valueOf(context.getCurrentXmlTest().getParameter("printconsoleoutput"));
			File screenShotFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
			screenShotFolder = new File(screenShotFolder.getParent() + File.separator + "ScreenShot");

			if (!screenShotFolder.exists()) {
				screenShotFolder.mkdir();
				return;
			}

			File[] screenShots = screenShotFolder.listFiles();

			for (File screenShot : screenShots)
				screenShot.delete();

			screenShotFolder = new File(screenShotFolder.getParent() + File.separator + "Pass_ScreenShot");

			if (!screenShotFolder.exists()) {
				screenShotFolder.mkdir();
				return;
			}

			screenShots = screenShotFolder.listFiles();

			for (File screenShot : screenShots)
				screenShot.delete();
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception in Log.cleanScreenShotFolder;", e);
		} //End catch

	} //End cleanScreenShotFolder
	
	/**
	 * deleteDownloadedFilesFolder : Deletes download file folder
	 * @param context
	 * @return None
	 * @throws Exception 
	 */
	public static void deleteDownloadedFilesFolder(ITestContext context) throws Exception {

		try {
			
			File downloadedFilesFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
			downloadedFilesFolder = new File(downloadedFilesFolder.getParent() + File.separator + "DownloadedFiles");

			if (!downloadedFilesFolder.exists()) {
				downloadedFilesFolder.mkdir();
				return;
			}

			File[] downloadedFiles = downloadedFilesFolder.listFiles();

			for (File downloadedFile : downloadedFiles)
				downloadedFile.delete();
		} //End try
		catch (Exception e) {
			throw new Exception("Exception at Log.deleteDownloadedFilesFolder", e);
		} //End catch
		
	} //End deleteDownloadedFilesFolder
	
	/**
	 * event : Prints the event log messages
	 * @param  msg - Message to be printed
	 * @param  duration - Duration in seconds taken perform this event
	 * @return None
	 * @throws Exception 
	 */
	public static void event(String msg, long duration) throws Exception {
		
		try {

			if(printconsoleoutput)
				System.out.println(msg + "." + duration + "s");
			
		} //End try
		
		catch (Exception e) {
			throw new Exception("Exception at Log.event", e);
		} //End catch
		
	} //End event
	
	/**
	 * message : Prints the log messages
	 * @param  msg - Message to be printed
	 * @return None
	 * @throws Exception 
	 */
	public static void message(String msg) throws Exception {
		
		try {
		
			Reporter.log(msg + "</br>");
			
			if (printconsoleoutput)
				System.out.println(msg);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception("Exception at Log.message;", e);
		} //End catch
		
	} //End message
	
	/**
	 * message : Prints the messages
	 * @param  msg - Message to be printed
	 * @return None
	 * @throws Exception 
	 */
	public static void message(String msg, WebDriver driver) throws Exception {
		
		try {
			
			String inputFile = "";

			try {
				File screenShotFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
				String strBasePath = screenShotFolder.getParent() + File.separator + "ScreenShot" + File.separator;
				inputFile = Reporter.getCurrentTestResult().getName() + "_" + (new Date()).getTime() + ".png";
				driver.switchTo().defaultContent();
				WebDriver augmented = new Augmenter().augment(driver);
				File screenshot = ((TakesScreenshot) augmented).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(strBasePath + inputFile));
			}
			catch (IOException | WebDriverException e1) {
				try {
					message("Screen shot capture failed.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				e1.printStackTrace();
			}

			String screenShotLink = "<a href=\"." + File.separator + "ScreenShot" + File.separator + inputFile + "\" target=\"_blank\" >[ScreenShot]</a>";
			Reporter.log(msg + " &nbsp;&nbsp;&nbsp;" + screenShotLink + "</br>");
			
			if(printconsoleoutput) 
				System.out.println(msg);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception at Log.pass;", e);
		} //End catch
		
	} //End pass
	
	/**
	 * pass : Prints the pass description messages
	 * @param  msg - Message to be printed
	 * @return None
	 * @throws Exception 
	 */
	public static void pass(String msg) throws Exception {
		
		try {
			
			Reporter.log("<br><font color=\"green\"><strong>" + msg + "</strong></font></br>");
			
			if(printconsoleoutput)
				System.out.println(msg);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception at Log.pass;", e);
		} //End catch
		
	} //End pass
	
	/**
	 * pass : Prints the pass description messages
	 * @param  msg - Message to be printed
	 * @return None
	 * @throws Exception 
	 */
	public static void pass(String msg, WebDriver driver) throws Exception {
		
		try {
			
			String inputFile = "";

			try {
				File screenShotFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
				String strBasePath = screenShotFolder.getParent() + File.separator + "ScreenShot" + File.separator;
				inputFile = Reporter.getCurrentTestResult().getName() + "_" + (new Date()).getTime() + ".png";
				driver.switchTo().defaultContent();
				WebDriver augmented = new Augmenter().augment(driver);
				File screenshot = ((TakesScreenshot) augmented).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(strBasePath + inputFile));
			}
			catch (IOException | WebDriverException e1) {
				try {
					message("Screen shot capture failed.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				e1.printStackTrace();
			}

			String screenShotLink = "<a href=\"." + File.separator + "ScreenShot" + File.separator + inputFile + "\" target=\"_blank\" >[ScreenShot]</a>";
			Reporter.log("<br><font color=\"green\"><strong>" + msg + "</strong></font></br><p>" + screenShotLink + "</p>");
			
			if(printconsoleoutput) 
				System.out.println(msg);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception at Log.pass;", e);
		} //End catch
		
	} //End pass
	
	/**
	 * fail : Prints the fail description messages
	 * @param  msg - Message to be printed
	 * @param  driver - Web driver
	 * @return None
	 * @throws Exception 
	 */
	public static void fail(String msg, WebDriver driver) {
		
		String inputFile = "";

		try {
			File screenShotFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
			String strBasePath = screenShotFolder.getParent() + File.separator + "ScreenShot" + File.separator;
			inputFile = Reporter.getCurrentTestResult().getName() + "_" + (new Date()).getTime() + ".png";
			driver.switchTo().defaultContent();
			WebDriver augmented = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmented).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(strBasePath + inputFile));
		}
		catch (IOException | WebDriverException e1) {
			try {
				message("Screen shot capture failed.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}

		String screenShotLink = "<a href=\"." + File.separator + "ScreenShot" + File.separator + inputFile + "\" target=\"_blank\" >[ScreenShot]</a>";
		Reporter.log("<font color=\"red\"><strong>"+msg+"</strong></font></br><p>" + screenShotLink + "</p>");
		

		if (printconsoleoutput)
			System.out.println("Fail: " + msg);

		Assert.fail(msg);
		
	} //End fail
	
	/**
	 * exception : Prints the exception description messages
	 * @param  e - Exception details
	 * @param  driver - Web driver
	 * @return None
	 * @throws Exception 
	 */
	public static void exception(Exception e, WebDriver driver) throws Exception {

		String inputFile = "";

		try {
			
			File screenShotFolder = new File(Reporter.getCurrentTestResult().getTestContext().getOutputDirectory());
			String strBasePath = screenShotFolder.getParent() + File.separator + "ScreenShot" + File.separator;
			inputFile = Reporter.getCurrentTestResult().getName() + "_" + (new Date()).getTime() + ".png";
			driver.switchTo().defaultContent();
			WebDriver augmented = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmented).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(strBasePath + inputFile));
			
		} //End try
		
		catch (IOException | WebDriverException e1) {
			message("Screen shot capture failed.");
			e1.printStackTrace();
		}
		
		String screenShotLink = "<a href=\"." + File.separator + "ScreenShot" + File.separator + inputFile + "\" target=\"_blank\" >[ScreenShot]</a>";
		
		if (e instanceof SkipException) 
			Reporter.log("<div class=\"test-result\"> <font color=\"orange\"> " + e.getMessage() + " </strong> </font><p>" + screenShotLink + "</p></div>");
		else
			Reporter.log("<div class=\"exceptions\"> <font color=\"red\"><I>" + e.getMessage() + " </I> </font><p>" + screenShotLink + "</p></div>");

	/*	if (e instanceof org.testng.internal.thread.ThreadTimeoutException)
			WebDriverUtils.markUnResuable(driver);*/
		
		if (printconsoleoutput)
			e.printStackTrace();
		
		throw e;

	} //End exception
	
	/**
	 * exception : Prints the exception description messages
	 * @param  e - Exception details
	 * @return None
	 * @throws Exception 
	 */
	public static void exception(Exception e) throws Exception {

		try {
			
			if (e instanceof SkipException) 
				Reporter.log("<br><div class=\"test-result\"> <font color=\"orange\"> " + e.getMessage() + " </strong> </font> </div></br>");
			else
				Reporter.log("<br><div class=\"exceptions\"> <font color=\"red\"><I>" + e.getMessage() + " </I> </font> </div></br>");
			
			if (printconsoleoutput)
				e.printStackTrace();
			
			//throw e;
			
		} //End try

		catch (Exception e1) {
			throw new Exception("Exception at Log.exception;", e1);
		} //End catch

	}
	
	/**
	 * addTestRunMachineInfo : Prints the machine information messages
	 * @param  driver - Web driver
	 * @param  context - ITestContext
	 * @return None
	 * @throws Exception 
	 */
	public static void addTestRunMachineInfo(WebDriver driver) throws Exception {
		try {
			
			Object params[] = Reporter.getCurrentTestResult().getParameters();
			XmlTest xmlParameters = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
			
			String testMachine = "";
			String browser = "";
			String osUsed = System.getProperty("os.name");
			String javaVersion = System.getProperty("java.version");
			String sprintBuild = xmlParameters.getParameter("sprint");
			String MfilesVerion = xmlParameters.getParameter("productVersion");
			String hub = (Reporter.getCurrentTestResult().getHost() == null) ? Inet4Address.getLocalHost().getHostName() : Reporter.getCurrentTestResult().getHost();
			/*testMachine = "Hub: " + hub + "; Node: " + WebDriverUtils.getTestSessionNodeIP(driver).toUpperCase() + "; " +
										"Browser: " +	browser +"; Java Version: " + javaVersion + "; Operating System: " + osUsed + 
										"; Sprint Build: " + sprintBuild + "; MFilesVersion: " + MfilesVerion;
			*/
			try {
				if (params.length > 0) {
					String testDataCount = params[0].toString().split("S.No=")[1].split(",")[0];
					params[0] = testMachine + "; Test Data - " + testDataCount + " : " + params[0].toString().trim();
				}
				else {
					ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(params));
					temp.add(testMachine);
					temp.add(browser.split(" ")[0]);
					params = temp.toArray();
				}				
			}
			catch (Exception e1) {} 
			Reporter.getCurrentTestResult().setParameters(params);
			
		} //End try
		
		catch (Exception e) {
			throw e;// new SkipException("Exception at Log.addTestRunMachineInfo", e);
		} //End catch

	} //End addTestRunMachineInfo
	
	/**
	 * addTestRunMachineInfo : Prints the machine information messages
	 * @param  driver - Web driver
	 * @param  context - ITestContext
	 * @return None
	 * @throws Exception 
	 */
	public static void addTestRunMachineInfo(WebDriver driver, String driverType, ITestContext context) throws Exception {
		try {
			
			Object params[] = Reporter.getCurrentTestResult().getParameters();
			String testMachine = "";
			String hub = "localhost";
			String browser = driverType + "-" +context.getCurrentXmlTest().getParameter("driverVersion");
			String osUsed = System.getProperty("os.name");
			String javaVersion = System.getProperty("java.version");
			String applBuild = context.getCurrentXmlTest().getParameter("webAccessSprint");
			String MfilesVerion = context.getCurrentXmlTest().getParameter("MFilesAPI");
			hub = (Reporter.getCurrentTestResult().getHost() == null) ? Inet4Address.getLocalHost().getHostName() : Reporter.getCurrentTestResult().getHost();
			/*testMachine = "(Hub: " + hub + ", Node: " + WebDriverUtils.getTestSessionNodeIP(driver).toUpperCase() + "), Browser: "+
					browser+", Java Version: "+javaVersion+" Operating System: "+osUsed+" Application Build: "+applBuild+" MFilesVersion: "+MfilesVerion;
			params[0] = testMachine + ", Test Data : " + params[0].toString().trim();
		*/
			Reporter.getCurrentTestResult().setParameters(params);
		
		} //End try
		
		catch (Exception e) {
			throw new Exception("Exception at Log.addTestRunMachineInfo", e);
		} //End catch

	} //End addTestRunMachineInfo
		
	/**
	 * testCaseInfo : Prints the test case information
	 * @param  description - test case description
	 * @return None
	 * @throws Exception 
	 */
	public static void testCaseInfo(String description) throws Exception {

		try {
			
			if (Reporter.getOutput(Reporter.getCurrentTestResult()).toString().contains("<div class=\"test-title\">"))
				Reporter.log("<div class=\"test-title\"> <strong><font color = \"blue\"> Description : " + description + "</font> </strong> </div><div><strong>Steps:</strong></div>");
			else 
				Reporter.log("<div class=\"test-title\"> <strong><font color = \"blue\"> Description : " + description + "</font> </strong> </div><div><strong>Steps:</strong></div><!-- Report -->");
			
			if (printconsoleoutput)
				System.out.println(description);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception at Log.testCaseInfo;", e);
		} //End catch
		
	} //End testCaseInfo
	
	/**
	 * testCaseInfo : Prints the test case information
	 * @param  None
	 * @return None
	 * @throws Exception 
	 */
	public static void testCaseInfo() throws Exception {

		try {
			
			String description = Reporter.getCurrentTestResult().getMethod().getDescription().toString().trim();
			
			if (Reporter.getOutput(Reporter.getCurrentTestResult()).toString().contains("<div class=\"test-title\">"))
				Reporter.log("<div class=\"test-title\" align=\"center\"> <strong><font color = \"blue\">" + description + "</font> </strong> </div></br><div><strong>Steps:</strong></div>");
			else 
				Reporter.log("<div class=\"test-title\" align=\"center\"> <strong><font color = \"blue\">" + description + "</font> </strong> </div></br><div><strong>Steps:</strong></div><!-- Report -->");
			
			if (printconsoleoutput)
				System.out.println(description);
			
		} //End try
		
		catch (Exception e) {
			throw new Exception ("Exception at Log.testCaseInfo;", e);
		} //End catch
		
	} //End testCaseInfo

	/**
	 * testDataInfo : Prints the test data information
	 * @param  message - test data description
	 * @return None
	 * @throws Exception 
	 */
	public static void testDataInfo(String message) throws Exception {
		
		try {
			
			Reporter.log("<strong><font color = \"blue\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + message + "</font> </strong><br>");
			
			if (printconsoleoutput)
				System.out.println(message);
		} //End try
		
		catch (Exception e) {
			throw new Exception("Exception at Log.testDataInfo;", e);
		} //End catch
		
	} //End testDataInfo
	
	public static String getStackTrace(final Throwable throwable) {
    final StringWriter sw = new StringWriter();
    final PrintWriter pw = new PrintWriter(sw, true);
    throwable.printStackTrace(pw);
    return sw.getBuffer().toString();
}
	
} //End Log