/**
* DriverScript java class is the automation test suite controller. It controls the complete test execution.
*
* @version 1.0
*/

package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import datatable.XlsReader;
import jxl.JXLException;
import jxl.read.biff.BiffException;
import reports.ReportUtil;
import util.TestUtil;

public class DriverScript {

    public static Properties CONFIG;
    public static Properties LOG;
    public static XlsReader controller;
    public static XlsReader testData;
    public static WebDriver driver = null;
    public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
    public static String currentTest;
    public static int testRepeat;
    public static String object;
    public static int dataRowNo = 1;
    public static String keyword;
    public static String currentTSID;
    public static String stepDescription;
    public static String proceedOnFail;
    public static String testStatus;
    public static DesiredCapabilities dc = null;
    public static URL remote_url = null;
    public static String defaultWindow;
    public static String firstSheetName;
    public static String failTest = "Fail";
    public static String fileSeparator = File.separator;
    public static String currentSystemDate;
    public static Boolean highlightElement = true;
    public static String methodReturnResult;

    public static String postTitle = null;
    public static String postContent = null;
    public static String postImageUrl = null;
    public static String postUrl = null;
    public static String postTags = null;
    public static String postMetaTitle = null;
    public static String postMetaDescription = null;
    public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String screenshotPath = System.getProperty("user.dir") + "\\Report\\";
    public static String reportsLib = System.getProperty("user.dir") + fileSeparator + "ReportsLibrary";
    public static String emailAddress;

    /**
     * Prepares pre-requisites to run the automation suite
     * 
     * @throws IOException
     */
    @BeforeClass
    public static void initialize() throws IOException {

	// Override default J2SE built-in workable logger built-in
	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

	// Locates and loads the config properties
	CONFIG = new Properties();
	FileInputStream fs = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
	CONFIG.load(fs);

	// Locates controller sheet
	controller = new XlsReader(System.getProperty("user.dir") + "\\src\\test\\java\\config\\controller.xls");

	// Locates testData sheet
	testData = new XlsReader(System.getProperty("user.dir") + "\\src\\test\\java\\config\\testData.xls");

	// Start the process of HTML report generation
	ReportUtil.startTesting(System.getProperty("user.dir") + "\\Report\\index.html",
		TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), CONFIG.getProperty("env"), CONFIG.getProperty("version"),
		CONFIG.getProperty("test_browser"), CONFIG.getProperty("webSiteURL"));

    }

    /**
     * Executes automation suite
     * 
     * @throws NumberFormatException
     * @throws BiffException
     * @throws JXLException
     * @throws IOException
     */
    @Test
    public void testApp() throws NumberFormatException, BiffException, JXLException, IOException {

	String startTime = null;
	String runMode = null;

	// Get the first sheet name under 'controller.xls'
	firstSheetName = controller.getFirstSheetname();

	ReportUtil.startSuite(firstSheetName);

	// Start the test run
	for (int tcid = 1; tcid < controller.getRowCount(firstSheetName); tcid++) {

	    // Stores the current sub-module
	    currentTest = controller.getCellData(firstSheetName, "TCID", tcid).trim();

	    // Runs the respective sub-module if Runmode for the sub-module is
	    // 'Y'
	    runMode = controller.getCellData(firstSheetName, "Runmode", tcid).trim();
	    if (runMode.equalsIgnoreCase("Y") || runMode.equalsIgnoreCase("Yes") || runMode.equalsIgnoreCase("True")) {

		APPLICATION_LOGS.debug("Executing test : " + currentTest);

		// Initialize start time of test
		startTime = TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");

		// Implement keyword
		for (int tsid = 1; tsid < controller.getRowCount(currentTest); tsid++) {

		    // values from xls
		    // Stores the current keyword
		    keyword = controller.getCellData(currentTest, "Keyword", tsid).trim();

		    // Stores the current TSID
		    currentTSID = controller.getCellData(currentTest, "TSID", tsid).trim();

		    // Stores the current description
		    stepDescription = controller.getCellData(currentTest, "Description", tsid).trim();

		    try {

			Method method = Keywords.class.getMethod(keyword);
			String result = (String) method.invoke(method);
			APPLICATION_LOGS.debug("Result of test case execution - " + result);

			if (!result.startsWith("Fail")) {
			    ReportUtil.addKeyword(stepDescription, keyword, result, null);
			}

			// Take screenshot - only on error
			if (result.startsWith("Fail")) {

			    // Set test status to fail
			    testStatus = "Fail";

			    // Give a fileName for the screenshot and store
			    String fileName = "Suite1_TC" + tcid + "_TS" + tsid + "_" + keyword + testRepeat + ".jpg";
			    String path = screenshotPath + fileName;
			    TestUtil.takeScreenShot(path);
			    APPLICATION_LOGS.debug("SCREENSHOT taken under : " + path);

			    // Write the test result to HTML report
			    ReportUtil.addKeyword(stepDescription, keyword, result, fileName);

			    if (proceedOnFail.equalsIgnoreCase("N")) {
				break;
			    }

			}

			if (driver != null) {
			    FunctionLibrary.closeDriver();
			}

		    }

		    catch (Throwable testException) {
			APPLICATION_LOGS.debug("Error came : " + testException.getMessage());
		    }

		}

		// Report pass or fail
		if (testStatus == null) {
		    testStatus = "Pass";
		}

		APPLICATION_LOGS.debug("Result of the '" + currentTest + "' test suite execution - " + testStatus);
		ReportUtil.addTestCase(currentTest, startTime, TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), testStatus);

	    }

	    else {

		APPLICATION_LOGS.debug("Skipping the test : " + currentTest);
		testStatus = "Skip";

		// Report skipped
		ReportUtil.addTestCase(currentTest, TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
			TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), testStatus);

	    }

	    testStatus = null;

	}

	// End test reporting
	ReportUtil.endSuite();

    }

    /**
     * Executes tear down for the test execution
     * 
     * @throws BiffException
     * @throws IOException
     */
    @AfterClass
    public static void endScript() throws BiffException, IOException {

	// Update test end time under HTML test report
	ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));

	APPLICATION_LOGS.debug("*** Test run finished ***");

    }

}
