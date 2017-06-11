/**
* FunctionLibrary is a java class implements all reusable selenium methods.
*
* @author  Sitam Jana
* @version 1.0
*/

package testscripts;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary extends DriverScript {

    /**
     * Waits for element to appear on the page. Once appeared, highlight the
     * element and clicks on it. Returns Pass if able to click on the element.
     * Returns Fail if any exception occurs in between.
     *
     * @param locator
     *            Element locator
     * @param elemName
     *            Element name
     *
     * @return Pass/Fail
     */

    public static String clickLink(By locator, String elemName) {

	APPLICATION_LOGS.debug("Clicking on : " + elemName);

	try {

	    // Wait for link to appear on the page
	    WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	    // Highlight link
	    FunctionLibrary.highlightElement(driver, locator);

	    // Move to Element
	    FunctionLibrary.moveToWebElement(locator, elemName);

	    // Click on the link
	    driver.findElement(locator).click();

	    // Log result
	    APPLICATION_LOGS.debug("Clicked on : " + elemName);

	    return "Pass : Clicked on : " + elemName;

	}

	catch (Throwable clickLinkException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while clicking on - " + elemName + " : " + clickLinkException.getMessage());

	    return "Fail : Error while clicking on - " + elemName + " : " + clickLinkException.getMessage();

	}

    }

    /**
     * Waits for element to appear on the page. Once appeared, highlight the
     * element and clicks on it using Javascript. Returns Pass if able to click
     * on the element. Returns Fail if any exception occurs in between.
     *
     * @param locator
     *            Element locator
     * @param elemName
     *            Element name
     *
     * @return Pass/Fail
     */

    public static String jsClickLink(By locator, String elemName) {

	APPLICATION_LOGS.debug("Clicking on : " + elemName);

	try {

	    // Wait for link to appear on the page
	    WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	    // Highlight link
	    FunctionLibrary.highlightElement(driver, locator);

	    // Click on the link
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
	    Thread.sleep(1000l);

	    // Log result
	    APPLICATION_LOGS.debug("Clicked on : " + elemName);

	    return "Pass : Clicked on : " + elemName;

	}

	catch (Throwable clickLinkException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while clicking on - " + elemName + " : " + clickLinkException.getMessage());
	    return "Fail : Error while clicking on - " + elemName + " : " + clickLinkException.getMessage();

	}

    }

    /**
     * Waits for element to appear on the page. Once appeared, highlight the
     * element and clicks on it ignoring StaleElementException. Returns Pass if
     * able to click on the element. Returns Fail if any exception occurs in
     * between.
     *
     * @param locator
     *            Element locator
     * @param elemName
     *            Element name
     *
     * @return Pass/Fail
     */

    public static String staleClickLink(By locator, String elemName) {

	APPLICATION_LOGS.debug("Clicking on : " + elemName);

	try {

	    // Wait for link to appear on the page

	    // Highlight link
	    FunctionLibrary.highlightElement(driver, locator);

	    // Click on the link
	    // new WebDriverWait(driver,
	    // 60).ignoring(StaleElementReferenceException.class)
	    // .until(new Predicate<WebDriver>() {
	    // @Override
	    // public boolean apply(@Nullable WebDriver driver) {
	    // driver.findElement(locator).click();
	    // return true;
	    // }
	    // });

	    // Log result
	    APPLICATION_LOGS.debug("Clicked on : " + elemName);

	    return "Pass : Clicked on : " + elemName;

	}

	catch (Throwable clickLinkException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while clicking on - " + elemName + " : " + clickLinkException.getMessage());
	    return "Fail : Error while clicking on - " + elemName + " : " + clickLinkException.getMessage();

	}

    }

    /**
     * Waits for input box to appear on the page. Once appeared, highlight and
     * clears the box. Returns Pass if Input box got cleared successfully.
     * Returns Fail if input box didn't clear or any exception occurs in
     * between.
     *
     * @param locator
     *            Element locator
     * @param elemName
     *            Element name
     *
     * @return Pass/Fail
     */

    public static String clearField(By locator, String elemName) {

	APPLICATION_LOGS.debug("Clearing field : " + elemName);

	try {

	    // Wait for the input-box to load on the page

	    // Highlight the input-box
	    FunctionLibrary.highlightElement(driver, locator);

	    // Move to Element
	    FunctionLibrary.moveToWebElement(locator, elemName);

	    // Clear the input-box
	    driver.findElement(locator).clear();

	    // Check whether input-box has been cleared or not
	    if (!driver.findElement(locator).getAttribute("value").isEmpty()) {
		driver.findElement(locator).clear();
	    }

	    // Log result
	    APPLICATION_LOGS.debug("Cleared : " + elemName);

	    return "Pass : Cleared : " + elemName;

	}

	catch (Throwable clearFieldException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while clearing - " + elemName + " : " + clearFieldException.getMessage());

	    return "Fail : Error while clearing - " + elemName + " : " + clearFieldException.getMessage();

	}

    }

    /**
     *
     * public static String input(By locator,String elemName,String Value)
     * method specification :-
     *
     * 1) Inputs/sends value 2) locator -> identify the web element by
     * id,x-path,name,etc. 3) elemName -> the name of the web element where we
     * intend to input/send values 4) Value -> the string value which we intend
     * to input/send 5) waitForElementToLoad(locator) -> waits for web element
     * to load 6) driver.findElement(locator).sendKeys(Value) -> inputs/sends
     * the value to the intended web element
     *
     * @param :
     *            Locator for the input-box, name of the web element, value to
     *            be inputted
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String input(By locator, String elemName, String Value) {

	APPLICATION_LOGS.debug("Sending Values in : " + elemName);

	try {

	    // Wait for the input box to appear on the page

	    // Highlight the input box
	    FunctionLibrary.highlightElement(driver, locator);

	    // Send values to the input box
	    driver.findElement(locator).sendKeys(Value);

	    // Log result
	    APPLICATION_LOGS.debug("Inputted '" + Value + "' text into : '" + elemName + "'");

	    return "Pass : Inputted '" + Value + "' text into : '" + elemName + "'";

	}

	catch (Throwable inputException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while inputting into - '" + elemName + "' : " + inputException.getMessage());

	    return "Fail : Error while inputting into - '" + elemName + "' : " + inputException.getMessage();

	}

    }

    /**
     *
     * public static String clearAndInput(By locator,String elemName,String
     * Value) method specification :-
     *
     * 1) Clear and then Inputs/sends value 2) locator -> identify the web
     * element by id,x-path,name,etc. 3) elemName -> the name of the web element
     * where we intend to input/send values 4) Value -> the string value which
     * we intend to input/send 5) waitForElementToLoad(locator) -> waits for web
     * element to load 6) FunctionLibrary.clearField(locator, elemName); ->
     * clears the input field 7) driver.findElement(locator).sendKeys(Value) ->
     * inputs/sends the value to the intended web element
     *
     * @param :
     *            Locator for the input-box, name of the web element, value to
     *            be input
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String clearAndInput(By locator, String elemName, String Value) {

	try {

	    // Wait for the input box to appear on the page

	    // Highlight the input box
	    FunctionLibrary.highlightElement(driver, locator);

	    // Clear the input field before sending values
	    FunctionLibrary.clearField(locator, elemName);

	    // Send values to the input box
	    APPLICATION_LOGS.debug("Sending Values in : " + elemName);
	    FunctionLibrary.input(locator, elemName, Value);

	    // Log result
	    APPLICATION_LOGS.debug("Inputted '" + Value + "' text into : '" + elemName + "'");

	    return "Pass : Inputted '" + Value + "' text into : '" + elemName + "'";

	}

	catch (Throwable inputException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while inputting into - '" + elemName + "' : " + inputException.getMessage());

	    return "Fail : Error while inputting into - '" + elemName + "' : " + inputException.getMessage();

	}

    }

    /**
     * public static String assertText(String elemName,String actValue, String
     * expValue) method specification :-
     *
     * 1) Verifies and returns TRUE if expected and actual text match 2)
     * elemName -> the name/type of text we intend to compare 3) actValue -> the
     * actual string value which is shown in the application 4) expValue -> the
     * expected string value which should be shown in the application 5)
     * Assert.assertEquals(expValue.trim(), actValue.trim())) -> trims and
     * compares the actual and expected string value
     *
     * @param :
     *            Name of the web element, Actual text and expected text
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String assertText(String elemName, String actValue, String expValue) {

	APPLICATION_LOGS.debug("Asserting text for : '" + elemName + "' where Expected text is '" + expValue
		+ "' and Actual text is '" + actValue + "'");

	try {

	    // Assert that expected value matches with actual value
	    Assert.assertEquals(expValue.trim(), actValue.trim());

	    // Log result
	    APPLICATION_LOGS.debug("Successfully asserted text for : '" + elemName + "' where Expected text is '"
		    + expValue + "' and Actual text is '" + actValue + "'");

	    return "Pass : Expected text matches with actual text";

	}

	catch (Throwable assertTextException) {

	    // Log error
	    APPLICATION_LOGS
		    .debug("Error while Asserting Text for - '" + elemName + "' : " + assertTextException.getMessage());

	    return "Fail : Error while Asserting Text for - '" + elemName + "' : " + assertTextException.getMessage();

	}

    }

    /**
     * public static String assertText(String elemName,int actValue, int
     * expValue) method specification :-
     *
     * 1) Verifies and returns TRUE if expected and actual text match 2)
     * elemName -> the name/type of text we intend to compare 3) actValue -> the
     * actual string value which is shown in the application 4) expValue -> the
     * expected string value which should be shown in the application 5)
     * Assert.assertEquals(expValue, actValue)) -> Compares the actual and
     * expected int value
     *
     * @param :
     *            Name of the web element, Actual text and expected text
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String assertText(String elemName, int actValue, int expValue) {

	APPLICATION_LOGS
		.debug("Asserting  Text  where : ExpectedText = " + expValue + "  and ActualText = " + actValue);

	try {

	    // Assert that expected value matches with actual value
	    Assert.assertEquals(expValue, actValue);

	    // Log result
	    APPLICATION_LOGS.debug("Successfully asserted text for : '" + elemName + "' where Expected text is '"
		    + expValue + "' and Actual text is '" + actValue + "'");

	    return "Pass : Expected text matches with actual text";

	}

	catch (Throwable assertTextException) {

	    // Log error
	    APPLICATION_LOGS
		    .debug("Error while Asserting Text for - '" + elemName + "' : " + assertTextException.getMessage());

	    return "Fail : Error while Asserting Text for - '" + elemName + "' : " + assertTextException.getMessage();

	}

    }

    /**
     * public static String closeDriver() method specification :-
     *
     * 1) Closes the web driver 2) driver.close() -> Closes the webdriver
     *
     * @param :
     *            no parameters
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String closeDriver() throws InterruptedException {

	APPLICATION_LOGS.debug("Closing the driver ...");

	String currentBrowserName = null;

	try {

	    // Get current browser name
	    currentBrowserName = getBrowserInfo();

	    // Close the driver
	    driver.quit();

	    // Make driver to point to null
	    driver = null;

	    // Close IEDriverServer processes if browser is IE
	    if (currentBrowserName.contains("MSIE")) {

		APPLICATION_LOGS.debug("Killing IEDriverServer process");

		// Kill IEDriverServer from Remote machine
		String remote_ip = CONFIG.getProperty("remote_ip");
		String domain = CONFIG.getProperty("domain");
		String username = CONFIG.getProperty("username");
		String password = CONFIG.getProperty("password");
		String command = "pskill \\\\" + remote_ip + " -u " + domain + "\\" + username + "-p " + password
			+ " iedriverserver.exe";
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(command);
		int exitVal = proc.waitFor();

		// If failed to kill try once with this
		if (exitVal == -1) {

		    try {

			WindowsUtils.killByName("IEDriverServer.exe");
			APPLICATION_LOGS.debug("Killed IEDriverServer process");

		    }

		    catch (Throwable taskKillException) {
			APPLICATION_LOGS.debug("IE Driver Server already killed. Skipping ...");
		    }

		}

		else {
		    APPLICATION_LOGS.debug("Killed IEDriverServer process");
		}

	    }

	    // Log result
	    APPLICATION_LOGS.debug("Closed the driver");

	    return "Pass : Closed the driver";

	}

	catch (Throwable closeDriverException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error came while closing driver : " + closeDriverException.getMessage());

	    return "Fail : Error came while closing driver : " + closeDriverException.getMessage();

	}

    }

    /**
     * public static String retrieveText(By locator,String elemName) method
     * specification :-
     *
     * 1) Return retrieved text from webpage 2)
     * driver.findElement(locator).getText() -> Retrieves text from the web
     * element targeted by specified locator
     *
     * @param :
     *            Locator for the web element, Name of the web element
     *
     * @return : Text retrieved from the webpage
     */

    public static String retrieveText(By locator, String elemName) {

	String retrievedText = null;

	APPLICATION_LOGS.debug("Retrieving Text from : " + elemName);

	try {

	    // Wait for web element to load on the page

	    // Highlight the web element
	    FunctionLibrary.highlightElement(driver, locator);

	    // Retrieve text from web element
	    retrievedText = driver.findElement(locator).getText().trim();

	    // Log result
	    APPLICATION_LOGS.debug("Retrieved text : " + retrievedText);

	}

	catch (Throwable retrieveTextException) {

	    // Log error
	    APPLICATION_LOGS
		    .debug("Error while Getting Text from '" + elemName + "' : " + retrieveTextException.getMessage());

	}

	return retrievedText;

    }

    /**
     * public static String retrieveAttributeValue(By locator,String
     * value,String elemName) method specification :-
     *
     * 1) Return retrieved HTML attribute value from webpage 2)
     * driver.findElement(locator).getAttribute(value) -> Retrieves attribute
     * (present under a web element) value
     *
     * @param :
     *            Locator for the web element, Attribute name, Name of the web
     *            element
     *
     * @return : Attribute value retrieved
     */

    public static String retrieveAttributeValue(By locator, String value, String elemName) {

	String attributeValue = null;

	APPLICATION_LOGS.debug("Getting Attribute '" + value + "'  Value from - " + elemName);

	try {

	    // Wait for web element to load

	    // Highlight the web element
	    FunctionLibrary.highlightElement(driver, locator);

	    // Get attribute value for the web element
	    attributeValue = driver.findElement(locator).getAttribute(value);

	    // Log result
	    APPLICATION_LOGS.debug("Got Attribute '" + value + "'  Value from : " + elemName + " : " + attributeValue);

	}

	catch (Throwable retrieveAttributeValueException) {

	    // report error
	    APPLICATION_LOGS.debug("Error while Getting Attribute '" + value + "' value from '" + elemName + "' : "
		    + retrieveAttributeValueException.getMessage());

	    return "Fail : Error while Getting Attribute '" + value + "' value from '" + elemName + "' : "
		    + retrieveAttributeValueException.getMessage();

	}

	return attributeValue;

    }

    /**
     * Wait for new page to open
     * 
     * @param expectedTitle
     * @throws InterruptedException
     */

    public static void waitForNewPageToOpen(String expectedTitle) throws InterruptedException {
	int counter = 1;
	while (!getPageTitle().equals(expectedTitle)) {
	    counter++;
	    Thread.sleep(1000);
	    if (counter > 60) {
		break;
	    }
	}
	Thread.sleep(1000);
    }

    /**
     * public static String assertTitle(String expectedTitle) method
     * specification :-
     *
     * 1) Asserts page title 2) driver.getTitle() -> Retrieves page title 3)
     * Assert.assertEquals() -> Asserts for equality
     *
     * @param :
     *            Expected title to assert
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String assertTitle(String expectedTitle) {

	String actualTitle = null;

	APPLICATION_LOGS.debug("Asserting  title  where : Expected title = " + expectedTitle);

	try {

	    // Fetch actual title of the webpage
	    actualTitle = driver.getTitle();

	    // Asserts whether actual title matches with expected one
	    Assert.assertEquals(expectedTitle.trim(), actualTitle.trim());

	    // Log result
	    APPLICATION_LOGS
		    .debug("Actual title = " + actualTitle + " and matches with Expected title = " + expectedTitle);

	    return "Pass : Actual title = " + actualTitle + " and matches with Expected title = " + expectedTitle;

	}

	catch (Throwable assertTitleException) {
	    // Log error
	    APPLICATION_LOGS.debug("Error while asserting title : " + assertTitleException.getMessage());
	    return "Fail : Error while asserting title : " + assertTitleException.getMessage();
	}

    }

    /**
     * Wait for text to appear
     * 
     * @param locator
     * @param name
     * @param expectedText
     * @throws InterruptedException
     */

    public static void waitForText(By locator, String name, String expectedText) throws InterruptedException {
	APPLICATION_LOGS.debug("Waiting for text : " + expectedText);
	int counter = 1;
	while (retrieveText(locator, name).equals(expectedText)) {
	    counter++;
	    Thread.sleep(1000);
	    if (counter > 60) {
		APPLICATION_LOGS.debug("Timeout. Text didn't appear!");
		break;
	    }
	}
	if (counter < 60) {
	    APPLICATION_LOGS.debug("Waiting ends. Text appeared!");
	}
	Thread.sleep(1000);
    }

    /**
     * Wait for element to appear
     * 
     * @param locator
     * @param name
     * @throws InterruptedException
     */

    public static void waitForElementToAppear(By locator, String name) throws InterruptedException {
	APPLICATION_LOGS.debug("Waiting for " + name + " to appear on the  page ...");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try {
	    driver.findElement(locator);
	    Thread.sleep(1000);
	} catch (Throwable findElementException) {
	    // Log error
	    APPLICATION_LOGS.debug("Error while waiting for element : " + findElementException.getMessage());
	}
	APPLICATION_LOGS.debug("Waiting ends!");
    }

    /**
     * Wait for element to disappear
     * 
     * @param locator
     * @param name
     * @throws InterruptedException
     */

    public static void waitForElementToDisappear(By locator, String name) throws InterruptedException {
	APPLICATION_LOGS.debug("Waiting for " + name + " to disappear on the  page ...");
	int counter = 1;
	while (true) {
	    if (!isElementDisplayed(locator, name)) {
		break;
	    }
	    counter++;
	    Thread.sleep(1000);
	    if (counter > 60) {
		APPLICATION_LOGS.debug("Timeout. Element still displayed on the page!");
		break;
	    }
	}
	if (counter < 60) {
	    APPLICATION_LOGS.debug("Waiting ends. Element disappeared!");
	}
	Thread.sleep(1000);
    }

    /**
     * public static String selectValueByVisibleText(By Locator, String Option,
     * String elemName) method specification :-
     * 
     * 1) Select value from drop-down by visible text 2) Select -> This is a
     * in-built class in Selenium which is used to represent a drop-down 3)
     * select.selectByVisibleText(Value) -> Select by visible text
     * 
     * @param :
     *            Locator for the drop-down field, Option to be selected, Name
     *            of the web element
     * 
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String selectValueByVisibleText(By Locator, String Option, String elemName) {

	APPLICATION_LOGS.debug("Selecting '" + Option + "' from : " + elemName);

	try {

	    // Wait for drop-down element to load on the page
	    // waitForElementToLoad(Locator);

	    // Highlight the drop-down
	    FunctionLibrary.highlightElement(driver, Locator);

	    // Locate drop-down field
	    Select select = new Select(driver.findElement(Locator));

	    // Select value from drop-down
	    select.selectByVisibleText(Option);

	    // Log result
	    APPLICATION_LOGS.debug("Selected '" + Option + "' from : " + elemName);

	    return "Pass : Selected '" + Option + "' from : " + elemName;

	}

	catch (Throwable selectValueException) {

	    // Log error
	    APPLICATION_LOGS.debug(
		    "Error while Selecting Value from - '" + elemName + "' : " + selectValueException.getMessage());

	    return "Fail : Error while Selecting Value from - '" + elemName + "' : "
		    + selectValueException.getMessage();

	}

    }

    /**
     * public static String assertAlertAndAccept(String expectedAlertText)
     * method specification :-
     *
     * 1) Assert alert text and accept 2) Alert alert =
     * driver.switchTo().alert() -> Switch to the alert appeared on the page 3)
     * Assert.assertEquals() -> Asserts for equality 4) alert.accept() ->
     * Accepts the alert
     *
     * @param :
     *            Expected alert text to assert
     *
     * @return : Result of execution - Pass or fail (with cause)
     */

    // highlight the element on which action will be performed
    public static void highlightElement(WebDriver driver, By Locator) {

	try {

	    if (highlightElement) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(Locator),
			"color: red; border: 2px solid red;");

	    }

	}

	catch (Throwable t) {
	    APPLICATION_LOGS.debug("Error came : " + t.getMessage());
	}

    }

    /**
     *
     * public static void maximizeWindow() method specification : -
     *
     * 1) Maximize the currently opened browser window 2)
     * driver.manage().window().maximize() : Maximize browser window
     */
    public static void maximizeWindow() {

	APPLICATION_LOGS.debug("Maximizing the window ...");

	try {

	    driver.manage().window().maximize();
	    APPLICATION_LOGS.debug("Browser window successfully maximized");

	}

	catch (Throwable windowMaximizeException) {

	    APPLICATION_LOGS.debug("Exception came while maximizing window : " + windowMaximizeException.getMessage());

	}

    }

    /**
     * public static void refreshPage() method specification : -
     *
     * 1) Refresh the page 2) driver.navigate().refresh : This is used to
     * refresh the current page
     */
    public static void refreshPage() {

	APPLICATION_LOGS.debug("Refreshing the page ...");

	try {

	    driver.navigate().to(driver.getCurrentUrl());
	    APPLICATION_LOGS.debug("Page successfully refreshed");

	}

	catch (Throwable pageRefreshException) {

	    APPLICATION_LOGS.debug("Exception came while refreshing page : " + pageRefreshException.getMessage());

	}

    }

    // Generate randomn characters
    public static String randomnGenerator() {

	int PASSWORD_LENGTH = 8;
	String randomnCharacters;
	StringBuffer sb = new StringBuffer();

	for (int x = 0; x < PASSWORD_LENGTH; x++) {

	    sb.append((char) ((int) (Math.random() * 26) + 97));

	}

	randomnCharacters = sb.toString();
	return randomnCharacters;

    }

    /**
     *
     * Generate randomn numbers within the range provided inside the method
     * argument
     *
     * @param :
     *            Min Value in the range, Max Value in the range
     *
     * @return : Random number generated
     */

    public static String randomnNumberGenerator(int minValue, int maxValue) {

	int randomnNumber;
	String numbers;
	randomnNumber = (int) (minValue + ((new Random()).nextDouble() * (maxValue - minValue)));
	numbers = Integer.toString(randomnNumber);
	return numbers;

    }

    /**
     * public static String getFormattedDate(DateFormat dateFormat) method
     * specification :
     *
     * 1) This function gets date in the specified format 2) Date date = new
     * Date() : Locale date and time 3) return currentSystemDate : Returns
     * current syatem date and time
     */

    public static String getFormattedDate(DateFormat dateFormat) {

	APPLICATION_LOGS.debug("Getting date ...");

	String currentSystemDate = null;
	Date date = new Date();
	currentSystemDate = dateFormat.format(date);

	APPLICATION_LOGS.debug("Got formatted date : " + currentSystemDate);

	return currentSystemDate;

    }

    /**
     * public static String retrieveCSSValue(By locator,String value,String
     * elemName) method specification :-
     *
     * 1) Return retrieved CSS value for a web element 2)
     * driver.findElement(locator).getCssValue(value) -> Retrieves CSS (applied
     * for a web element) value
     *
     * @param :
     *            Locator for the web element, CSS name, Name of the web element
     *
     * @return : CSS value retrieved
     */

    public static String retrieveCSSValue(By locator, String value, String elemName) {

	String cssValue = null;

	APPLICATION_LOGS.debug("Getting CSS '" + value + "'  Value from - " + elemName);

	try {

	    // Wait for web element to load

	    // Highlight the web element
	    FunctionLibrary.highlightElement(driver, locator);

	    // Get CSS value for the web element
	    cssValue = driver.findElement(locator).getCssValue(value);

	    // Log result
	    APPLICATION_LOGS.debug("Got Attribute '" + value + "'  Value from : " + elemName + " : " + cssValue);

	}

	catch (Throwable retrieveCSSValueException) {

	    // report error

	    APPLICATION_LOGS.debug("Error while Getting CSS '" + value + "' value from '" + elemName + "' : "
		    + retrieveCSSValueException.getMessage());

	    return "Fail : Error while Getting CSS '" + value + "' value from '" + elemName + "' : "
		    + retrieveCSSValueException.getMessage();

	}

	return cssValue;

    }

    /**
     * public static String getBrowserInfo() method specification :-
     *
     * 1) JavascriptExecutor js = (JavascriptExecutor) driver : Initialize
     * Javascript executor 2) js.executeScript("return navigator.userAgent;") :
     * Get browser info
     *
     * @param :
     *            none
     *
     * @return : Browser Info
     */

    public static String getBrowserInfo() {

	APPLICATION_LOGS.debug("Getting browser info ...");

	// Declare variables need
	String browserInfo = null;
	JavascriptExecutor js = null;

	try {

	    // Initialize JavascriptExecutor
	    js = (JavascriptExecutor) driver;

	    // Get browser info
	    browserInfo = (String) js.executeScript("return navigator.userAgent;");

	    APPLICATION_LOGS.debug("Got browser info : " + browserInfo);

	}

	catch (Throwable browserInfoError) {

	    APPLICATION_LOGS.debug("Error came while getting browser info : " + browserInfoError.getMessage());

	}

	// Return browser info
	return browserInfo;

    }

    /**
     * public static String getBrowserName() method specification :-
     *
     * 1) browserInfo = getBrowserInfo() : Get browser info 2)
     * browserInfo.contains("Firefox") or browserInfo.contains("MSIE") : Get
     * browser name
     *
     * @param :
     *            none
     *
     * @return : Browser Name
     */

    public static String getBrowserName() {

	APPLICATION_LOGS.debug("Getting browser name ...");

	// Declare variables need
	String browserInfo = null;
	String browserName = null;

	// Get browser info
	browserInfo = getBrowserInfo();

	// Get browser name
	if (browserInfo.contains("Firefox")) {
	    browserName = "Firefox";
	} else if (browserInfo.contains("MSIE")) {
	    browserName = "Microsoft Internet Explorer";
	}

	APPLICATION_LOGS.debug("Got browser name : " + browserName);

	// Return browser name
	return browserName;

    }

    /**
     * public static String getBrowserVersion() method specification :-
     *
     * 1) browserInfo = getBrowserInfo() : Get browser info 2) browserInfo.split
     * : Split browser info to get browser version
     *
     * @param :
     *            none
     *
     * @return : Browser Version
     */

    public static String getBrowserVersion() {

	APPLICATION_LOGS.debug("Getting browser version ...");

	// Declare variables need
	String browserInfo = null;
	String browserVersion = null;

	// Get browser info
	browserInfo = getBrowserInfo();

	// Get browser version
	if (browserInfo.contains("Firefox")) {
	    browserVersion = browserInfo.split("Firefox/")[1];
	} else if (browserInfo.contains("MSIE")) {
	    browserVersion = browserInfo.split("MSIE ")[1].split(";")[0];
	}

	APPLICATION_LOGS.debug("Got browser version : " + browserVersion);

	// Return browser version
	return browserVersion;

    }

    /**
     * public static String getPageTitle() method specification :-
     *
     * 1) driver.getTitle() : Get current page title
     *
     * @return : Current webpage title
     */

    public static String getPageTitle() {

	APPLICATION_LOGS.debug("Getting current webpage title ...");
	String pageTitle = null;

	try {

	    // Get page title
	    pageTitle = driver.getTitle();

	} catch (Throwable getPageTitleError) {

	    APPLICATION_LOGS.debug("Error came while fetching page title : " + getPageTitleError.getMessage());

	}

	APPLICATION_LOGS.debug("Got current webpage title : " + pageTitle);
	return pageTitle;

    }

    /**
     * public static String getCurrentUrl() method specification :-
     *
     * driver.getCurrentUrl() : Get current url
     *
     * @return : Current webpage title
     */

    public static String getCurrentUrl() {

	APPLICATION_LOGS.debug("Getting current Url ...");
	String currentUrl = null;

	try {

	    // Get current url
	    currentUrl = driver.getCurrentUrl();

	} catch (Throwable getCurrentUrlError) {

	    APPLICATION_LOGS.debug("Error came while getting current Url : " + getCurrentUrlError.getMessage());

	}

	APPLICATION_LOGS.debug("Got current URL : " + currentUrl);
	return currentUrl;

    }

    /**
     * public static String loadUrl(String url) method specification :-
     *
     * driver.navigate().to(url); : Navigate to Url
     *
     * @return : (Pass) - If Url loaded successfully (Fail) - If Url NOT loaded
     *         successfully
     */

    public static String loadUrl(String url) {

	APPLICATION_LOGS.debug("Loading Url : " + url + " ...");

	try {

	    // Load url
	    driver.navigate().to(url);

	} catch (Throwable loadingUrlError) {

	    APPLICATION_LOGS.debug("Error came while loading Url : " + loadingUrlError.getMessage());

	    return "Fail : Error came while loading Url : " + loadingUrlError.getMessage();

	}

	APPLICATION_LOGS.debug("Url successfully loaded");
	return "Pass : Url successfully loaded";

    }

    /**
     * public static Boolean isElementPresent(By locator, String elemName)
     * method specification :-
     *
     * driver.findElement(locator) : Checking whether element present or not
     *
     * @param :
     *            web element locator, web element name
     *
     * @return : (true) - If element is present (false) - If element not present
     */
    public static Boolean isElementPresent(By locator, String elemName) {

	APPLICATION_LOGS.debug("Checking whether " + elemName + " is present on the page or not ...");

	try {

	    // Check whether web element is displayed or not
	    driver.findElement(locator);

	    APPLICATION_LOGS.debug(elemName + " is present on the page");
	    return true;

	}

	catch (NoSuchElementException elementPresentError) {

	    APPLICATION_LOGS.debug(elemName + " not present on the page");
	    return false;

	}

    }

    /**
     * public static Boolean isElementDisplayed(By locator, String elemName)
     * method specification :-
     *
     * driver.findElement(locator).isDisplayed() : Verifying whether element
     * displayed or not
     *
     * @param :
     *            web element locator, web element name
     *
     * @return : (true) - If element is displayed (false) - If element not
     *         displayed
     */
    public static Boolean isElementDisplayed(By locator, String elemName) {

	APPLICATION_LOGS.debug("Checking whether " + elemName + " is displayed on the page or not ...");

	Boolean isDisplayed;

	try {

	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	    // Check whether web element is displayed or not
	    isDisplayed = driver.findElement(locator).isDisplayed();

	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	    if (isDisplayed) {
		APPLICATION_LOGS.debug(elemName + " is displayed on the page");
	    } else {
		APPLICATION_LOGS.debug(elemName + " not displayed on the page");
	    }

	    return isDisplayed;

	}

	catch (NoSuchElementException elementPresentError) {

	    APPLICATION_LOGS.debug(elemName + " not present on the page");
	    return false;

	}

    }

    /**
     * public static Boolean isElementEnabled(By locator, String elemName)
     * method specification :-
     *
     * driver.findElement(locator).isEnabled() : Verifying whether element
     * enabled or not
     *
     * @param :
     *            web element locator, web element name
     *
     * @return : (true) - If element is enabled (false) - If element not enabled
     */
    public static Boolean isElementEnabled(By locator, String elemName) {

	APPLICATION_LOGS.debug("Checking whether " + elemName + " is enabled on the page or not ...");

	Boolean isEnabled;

	try {

	    // Check whether web element is enabled or not
	    isEnabled = driver.findElement(locator).isEnabled();

	    if (isEnabled) {
		APPLICATION_LOGS.debug(elemName + " is enabled on the page");
	    } else {
		APPLICATION_LOGS.debug(elemName + " not enabled on the page");
	    }

	    return isEnabled;

	}

	catch (NoSuchElementException elementPresentError) {

	    APPLICATION_LOGS.debug(elemName + " not present on the page");
	    return false;

	}

    }

    /**
     * public static Boolean isElementSelected(By locator, String elemName)
     * method specification :-
     *
     * driver.findElement(locator).isSelected() : Verifying whether element
     * selected or not
     *
     * @param :
     *            web element locator, web element name
     *
     * @return : (true) - If element is selected (false) - If element not
     *         selected
     */
    public static Boolean isElementSelected(By locator, String elemName) {

	APPLICATION_LOGS.debug("Checking whether " + elemName + " is selected on the page or not ...");

	Boolean isSelected;

	try {

	    // Check whether web element is selected or not
	    isSelected = driver.findElement(locator).isSelected();

	    if (isSelected) {
		APPLICATION_LOGS.debug(elemName + " is selected on the page");
	    } else {
		APPLICATION_LOGS.debug(elemName + " not selected on the page");
	    }

	    return isSelected;

	}

	catch (NoSuchElementException elementPresentError) {

	    APPLICATION_LOGS.debug(elemName + " not present on the page");
	    return false;

	}

    }

    /*
     * public static String switchToPopupWindow() method specification :-
     * 
     * 1) Switches to pop-up window 2) driver.getWindowHandle() -> Returns
     * current window handle 3) driver.getWindowHandles() -> Returns all the
     * available window handles 4) driver.switchTo().window(popUpWindowHandle)
     * -> Switches to pop-up window
     * 
     * @param : no parameters
     * 
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String switchToPopupWindow() throws InterruptedException {

	APPLICATION_LOGS.debug("Executing switchToPopupWindow");

	String popUpWindowHandle = null;

	try {

	    // Save current window handle for future reference
	    defaultWindow = driver.getWindowHandle();

	    // Get all the window handles one by one
	    for (String windowHandle : driver.getWindowHandles()) {

		// Save new window handle
		if (!windowHandle.equals(defaultWindow)) {

		    popUpWindowHandle = windowHandle;

		}

	    }

	    // Switches to pop-up window
	    driver.switchTo().window(popUpWindowHandle);

	    // Maximize browser window
	    driver.manage().window().maximize();

	    // Log result
	    APPLICATION_LOGS.debug("Switched to pop-up window");

	    return "Pass : Switched to pop-up window";

	}

	catch (Throwable switchToPopupWindowException) {

	    // Log error
	    APPLICATION_LOGS
		    .debug("Error while Switching to Pop Window : " + switchToPopupWindowException.getMessage());

	    return "Fail : Error while Switching to Pop Window : " + switchToPopupWindowException.getMessage();

	}

    }

    /*
     * public static String closePopupWindow() method specification :-
     * 
     * 1) Closes the popup window 2) driver.close() -> closes the popup window
     * which has the current window handle 3)
     * driver.switchTo().window(mainWindow) -> switches back to main window by
     * granting the current window handle to main window
     * 
     * @param : no parameters
     * 
     * @return : Result of execution - Pass or fail (with cause)
     */

    public static String closePopupWindow() throws InterruptedException {

	APPLICATION_LOGS.debug("Closing pop-up window ...");

	try {

	    // Close current window pointed by webdriver
	    driver.close();

	    // Switch back to the main window
	    driver.switchTo().window(defaultWindow);

	    // Log result
	    APPLICATION_LOGS.debug("Closed pop-up window");

	    return "Pass : Closed pop-up window";

	}

	catch (Throwable closePopUpException) {

	    // Log error
	    APPLICATION_LOGS.debug("Error while closing pop-up window : " + closePopUpException.getMessage());

	    return "Fail : Error while closing pop-up window : " + closePopUpException.getMessage();

	}

    }

    /**
     * Move to web element. This function is useful to move view-port within web
     * element. Works for page scroll only.
     *
     * <p>
     * This method <code>returns</code>:
     * <ul>
     * <li>Pass if moved to web element successfully</li>
     * <li>Fail if any exception occurs in between</li>
     * </ul>
     *
     * @param locator
     *            Element locator
     * @param elemName
     *            Element name
     *
     * @return Pass/Fail
     */

    public static String moveToWebElement(By locator, String elemName) {

	APPLICATION_LOGS.debug("Moving to : " + elemName + " ...");

	try {

	    // Create instance of Javascript executor
	    JavascriptExecutor je = (JavascriptExecutor) driver;

	    // Identify the WebElement which will appear after scrolling down
	    WebElement element = driver.findElement(locator);

	    // now execute query which actually will scroll until that element
	    // is not appeared on page.
	    je.executeScript("arguments[0].scrollIntoView(true);", element);

	    // Log the result
	    APPLICATION_LOGS.debug("Moved to : " + elemName);

	    return "Pass : Moved to : " + elemName;

	}

	catch (Throwable moveToElementException) {

	    APPLICATION_LOGS.debug("Error came while moving to : " + moveToElementException.getMessage());

	    return "Fail : Error came while moving to " + moveToElementException.getMessage();

	}

    }

    public static String switchToFrame(String name) {
	try {
	    driver.switchTo().frame(name);
	    APPLICATION_LOGS.debug("Switched to frame : " + name);
	    return "Pass: Switched to frame";
	} catch (Throwable switchFrameError) {
	    APPLICATION_LOGS.debug("Error came while switching to frame : " + switchFrameError.getMessage());
	    return "Fail: Error came while switching to frame : " + switchFrameError.getMessage();
	}
    }

    public static String switchToFrame(By locator, String name) {
	try {
	    WebElement frame = driver.findElement(locator);
	    driver.switchTo().frame(frame);
	    APPLICATION_LOGS.debug("Switched to frame : " + name);
	    return "Pass: Switched to frame";
	} catch (Throwable switchFrameError) {
	    APPLICATION_LOGS.debug("Error came while switching to frame : " + switchFrameError.getMessage());
	    return "Fail: Error came while switching to frame : " + switchFrameError.getMessage();
	}
    }

    public static String switchToFrame(WebElement element) {
	try {
	    driver.switchTo().frame(element);
	    APPLICATION_LOGS.debug("Switched to frame");
	    return "Pass: Switched to frame";
	} catch (Throwable switchFrameError) {
	    APPLICATION_LOGS.debug("Error came while switching to frame : " + switchFrameError.getMessage());
	    return "Fail: Error came while switching to frame : " + switchFrameError.getMessage();
	}
    }

    public static void switchToDefaultContent() {
	try {
	    driver.switchTo().defaultContent();
	} catch (Throwable switchFrameError) {
	    APPLICATION_LOGS.debug("Error came while switching to default content : " + switchFrameError.getMessage());
	}
    }

    public static WebElement findDisplayedElementFromList(By locator, String name) {
	List<WebElement> elemList = driver.findElements(locator);
	WebElement element = elemList.get(0);
	for (WebElement elem : elemList) {
	    if (isElementDisplayed(locator, name)) {
		return elem;
	    }
	}
	return element;
    }

}