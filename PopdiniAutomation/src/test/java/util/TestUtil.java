/**
* TestUtil java class implements utility methods needed for test.
*
* @version 1.0
*/

package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import testscripts.DriverScript;

public class TestUtil extends DriverScript {

    /**
     * Returns current date and time
     * 
     * @param dateFormat
     * @return current date/time
     */
    public static String now(String dateFormat) {
	// Declare calendar object
	Calendar cal = Calendar.getInstance();
	// Format date
	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	return sdf.format(cal.getTime());
    }

    /**
     * Capture screenshot and store
     * 
     * @param filePath
     */
    public static void takeScreenShot(String filePath) {

	File scrFile = null;

	try {
	    // Take Screenshot from Remote machine
	    if (CONFIG.getProperty("is_remote").equals("true")) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
	    }

	    // Take Screenshot from local machine
	    else {
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    }

	    // Store screenshot to the path provided
	    FileUtils.copyFile(scrFile, new File(filePath));
	}

	catch (Throwable screenCaptureException) {
	    // Log error
	    APPLICATION_LOGS.debug("Error while taking screenshot : " + screenCaptureException.getMessage());
	    System.err.println("Error while taking screenshot : " + screenCaptureException.getMessage());
	}
    }

}