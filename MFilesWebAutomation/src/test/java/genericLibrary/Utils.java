package genericLibrary;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import genericLibrary.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static int snoozeTime = 0;
	public static int snoozeIdx = 0;
	
	/**
	 * fluentWait: This method is to wait until the current progress gets completed
	 * @param driver
	 * @return None
	 * @throws Exception
	 */
	public static void fluentWait(WebDriver driver) throws Exception {

		final long startTime = StopWatch.startTime();
	
		try {

			

		} // End try
		catch (Exception e) {
			throw new Exception("Exception at Utils.fluentWait : ", e);
		} // End catch

		finally {
			
			long elapsedTime = StopWatch.elapsedTime(startTime);
			Log.event("Utils.fluentWait : Fluent wait operation completed", elapsedTime);
		}

	} // End fluentWait
    
}
