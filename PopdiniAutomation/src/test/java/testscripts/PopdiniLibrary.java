/**
* TechTrialBlogLibrary is a java class implements all reusable application library methods.
*
* @author  Sitam Jana
* @version 1.0
*/

package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import jxl.read.biff.BiffException;

public class PopdiniLibrary extends DriverScript {

    // Stores current window handle
    // public static String currentWindowHandle;

    // Store method return result
    // public static String methodReturnResult = null;
    // public static Boolean present;

    // Stores username in signup page
    public static String fullName = "Test Popdini Name";

    // Stores Delay list options in CTA message page
    public static String listOption = "5 Seconds";

    // Expected page titles
    public static String expectedTitle = null;
    public static String signInPageTitle = "Sign In - Crossover TechTrial Blog";
    public static String newPostPageTitle = "Editor - Crossover TechTrial Blog";

    public static String pageNotFoundTitle = "404 � Page not found";

    // Expected page texts
    public static String expRegSuccessText = "Registration successful. Please log in below";
    public static String expLogInSuccessText = "Sign Out";
    public static String expPaymentSuccessText = "Take the quick tutorial below to create your first pop";
    public static String expPopCreateSuccessText = "You just created your first pop!";
    // Page URLs
    public static String newPostPageUrl = CONFIG.getProperty("testSiteURL") + "editor/";

    // Name of the WebElements present on the WebPage
    public static String nameFullNameInputBox = "'Full Name' Input-box";
    public static String nameEmailIdInputBox = "'Email Address' Input-box";
    public static String namePasswordInputBox = "'Password' Input-box";
    public static String nameRepeatPasswordInputBox = "'RepeatPassword' Input-box";
    public static String nameSignUpButton = "'SIGN Up' Button";
    public static String nameSignInEmailInputBox = "Sign In 'Email' Input-Box";
    public static String nameSignInPasswordInputBox = "Sign In 'Password' Input-Box";
    public static String nameLogInButton = "'Log In' Button";
    public static String nameRegSucText = "Registration Successful message";
    public static String nameLogInSucText = "Log in successfull";
    public static String nameTryNowButton = "'Try Now' button";
    public static String nameStripeFrame = "Stripe frame";
    public static String nameStripeEmailInputBox = "Stripe email InputBox";
    public static String nameStripeCardInputBox = "Stripe Card number input box";
    public static String nameStripeExpInputBox = "Expairy date input box";
    public static String nameStripeCVCInputBox = "CVC input box";
    public static String namePayButton = "'Pay' button";
    public static String namePaymentSucText = "Payment Success";
    public static String nameCreatePopButton = "Create MY Pop Button";
    public static String nameBNameInputBox = "Brand Name Input Box";
    public static String nameHomeURLInputBox = "Home URL Input Box";
    public static String namebrandImageFile = "Brand Image file upload";
    public static String namenxtButton = "'Next' button";
    public static String nameArticleInputBox = "Article Input Box";
    public static String nameArtMsgInputBox = " Message Input box";
    public static String nameBtnTxtInputBox = " Button Text Input box";
    public static String nameBtnLinkInputBox = " Button Link Input box";
    public static String nameCtaNxtButton = "Next button in Cta page";
    public static String namePopCreateSucText = "Pop creation successful";
    public static String nameRegLink = "Sign up Link";
    public static String nameDashboardButton = "'Go to Dashboard' button";
    public static String nameCrtNwPopButton = "'Create New Pop' button in Main Overview tab";
    public static String nameSelectBrandOptn = "Select Brand list";
    public static String nameSelectBrandList = "Select Brand option";
    public static String nameSelectBrandNextButton = " 'Next' button";
    public static String nameCtaArticleInputBox = " CTA Article Input Box";
    public static String nameCtaArtMsgInputBox = " CTA Article Input Box";
    public static String nameCtaBtnTxtInputBox = " CTA Button text Input Box";
    public static String nameCtaBtnLinkInputBox = " CTA Button link Input Box";
    public static String nameCtaDelayList = "CTA Delay List";
    public static String nameCtaNxtButton1 = "Next button in Cta message";
    public static String nameCtaNxtButton2 = "'Next' button in Theme page";

    // Locators for the test
    public static By locatorFullNameInputBox = By.xpath("//*[@id='fullnmae']");
    public static By locatorEmailIdInputBox = By.xpath("//*[@id='exampleInputEmail2']");
    public static By locatorPasswordInputBox = By.xpath("//*[@id='password']");
    public static By locatorRepeatPasswordInputBox = By.xpath("//*[@id='cnpassword']");
    public static By locatorSignUpButton = By.xpath("//*[@id='mybtn1']");
    public static By locatorSignInEmailInputBox = By.xpath("//*[@id='exampleInputEmail1']");
    public static By locatorSignInPasswordInputBox = By.xpath("//*[@id='exampleInputPassword1']");
    public static By locatorLogInButton = By.xpath("//button[contains(@class,'btn loginbut')]");
    public static By locatorRegSucText = By.xpath("//div[contains(@class, 'alert-success')]//p");
    public static By locatorLogInSucText = By.linkText("Sign Out");
    public static By locatorTryNowButton = By.xpath("//span[contains(text(), 'Try Now')]");
    public static By locatorStripeFrame = By.name("stripe_checkout_app");
    public static By locatorStripeEmailInputBox = By.xpath("//div[@class='Textbox-inputRow']//input[@type='email']");
    public static By locatorStripeCardInputBox = By.xpath("//input[@autocomplete='cc-number']");
    public static By locatorStripeExpInputBox = By.xpath("//input[@autocomplete='cc-exp']");
    public static By locatorStripeCVCInputBox = By.xpath("//input[@placeholder='CVC']");
    public static By locatorPayButton = By
	    .xpath("//button[contains(@class,'Button-animationWrapper-child--primary Button')]");
    public static By locatorPaymentSucText = By.xpath("//div[contains(@class,'col-md-6 col-md-offset-3')]//p");
    public static By locatorCreatePopButton = By.xpath("//a[contains(@class,'btn mypop')]");
    public static By locatorBNameInputBox = By.xpath("//*[@id='brandid']");
    public static By locatorHomeURLInputBox = By.xpath("//*[@id='homeurlid']");
    public static By locatorbrandImageFile = By.xpath("//*[@id='imgInp']");
    public static By locatorNxtButton = By.xpath("//*[@id='btn1']");
    public static By locatorArticleInputBox = By.xpath("//*[@id='linktype']");
    public static By locatorArtMsgInputBox = By.xpath("//*[@id='message']");
    public static By locatorBtnTxtInputBox = By.xpath("//*[@id='buttonid']");
    public static By locatorBtnLinkInputBox = By.xpath("//*[@id='btnid1']");
    public static By locatorCtaNxtButton = By.xpath("//*[@id='btn1']");
    public static By locatorPopCreateSucText = By.xpath("//div[@class='heading']");
    public static By locatorRegLink = By.xpath("//div[@class='haveaccount']//a");
    public static By locatorDashboardButton = By.xpath("//div[@class='col-md-3']//a");
    public static By locatorCrtNwPopButton = By.xpath("//div[@class='col-md-2 col-md-offset-5']//button");
    public static By locatorSelectBrandOptn = By.xpath("//dt[@id='bal']//img");
    public static By locatorSelectBrandList = By.xpath("//dt[@id='bal']//a");
    public static By locatorSelectBrandNextButton = By.xpath("//div[@class='col-md-3']//a[@id='nexttab']");
    public static By locatorCtaArticleInputBox = By.id("buttonlinkid1");
    public static By locatorCtaArtMsgInputBox = By.id("buttonmassageid1");
    public static By locatorCtaBtnTxtInputBox = By.id("buttonnameid1");
    public static By locatorCtaBtnLinkInputBox = By.id("buttonurlid1");
    public static By locatorCtaDelayList = By.xpath("//div[@id='tabone']//select[@name='buttondelay']");
    public static By locatorCtaNxtButton1 = By
	    .xpath("//div[@id='secstart']//a[@class='btn nextbut secstart2 disabled']");
    public static By locatorCtaNxtButton2 = By.xpath("//div[@id='thirdstart']//a[@class='btn nextbut secstart3']");

    // public static By locatorNewPostLink = By.linkText("New Post");
    // public static By locatorGhostAlertCloseIcon =
    // By.xpath("//button[contains(@class,'alert-close')]");
    // public static By locatorPostTitleInputBox = By.id("entry-title");
    // public static By locatorPostContentInputBox =
    // By.xpath("//section[@id='entry-markdown-content']//textarea");
    // public static By locatorPostSettingsButton =
    // By.xpath("//button[@class='post-settings']");
    // public static By locatorImageUrlButton =
    // By.xpath("//a[@class='image-url']");
    // public static By locatorImageUrlInputBox =
    // By.xpath("//form[@class='url-form']//input[@type='text']");
    // public static By locatorSaveButton =
    // By.xpath("//form[@class='url-form']//button[text()='Save']");
    // public static By locatorPostUrlInputBox = By.id("url");
    // public static By locatorPostTagsInputBox = By.id("tag-input-selectized");
    // public static By locatorMetaDataNavigationButton =
    // By.xpath("//form//ul[contains(@class,'nav-list')]");
    // public static By locatorMetaTitleInputBox = By.id("meta-title");
    // public static By locatorMetaDescriptionInputBox =
    // By.id("meta-description");
    // public static By locatorMetaDataNavigationBackButton =
    // By.xpath("//button[contains(@class,'back')]");
    // public static By locatorPostSettingsCloseButton = By
    // .xpath("//div[@class='settings-menu-header']//button[contains(@class,'close')]");
    //
    // public static By locatorDropdownToggle = By
    // .xpath("//section[@class='view-actions']//button[contains(@class,'dropdown-toggle')]");
    //
    // public static By locatorPublishNowLink = By.linkText("Publish Now");
    // public static By locatorPublishNowButton = By
    // .xpath("//section[@class='view-actions']//button[contains(@class,'publish')]");
    // public static By locatorPostTitle = By.className("post-title");
    // public static By locatorPostContent =
    // By.xpath("//section[@class='post-content']//p");
    // public static By locatorContentLink =
    // By.xpath("//a[contains(@class,'nav-main-content')]");
    // public static By locatorNewPost;
    // public static By locatorEditPostIcon = By.xpath("//a[contains(@class,
    // 'post-edit')]");
    // public static By locatorPostTagsPublicPost = By
    // .xpath("//form//input[@id='tag-input-selectized']//preceding-sibling::div[@class='item']");
    //
    // public static By locatorNewPostPublicSite;
    // public static By locatorPostImageUrl =
    // By.xpath("//header[contains(@class,'main-header')]");
    // public static By locatorPostTags =
    // By.xpath("//section[@class='post-meta']//a");
    // public static By locatorRemovePostImage =
    // By.xpath("//a[contains(@class,'image-cancel')]");
    // public static By locatorRemoveTag = By.className("remove");
    // public static By locatorUpdatePostButton = By
    // .xpath("//section[@class='view-actions']//button[contains(@class,'publish')]");
    //
    // public static By locatorPostPublishedNotification =
    // By.xpath("//div[contains(@class,'notification-content')]");
    // public static By locatorDeletePostLink = By.linkText("Delete Post");
    // public static By locatorDeleteButton =
    // By.xpath("//div[contains(@class,'modal')]//button[contains(@class,'red')]");
    // public static By locatorDeletePostDialog =
    // By.xpath("//section[contains(@class,'modal-content')]");

    /**
     * Create a browser instance and navigate to the test site
     * 
     * @param url
     * @return Pass/Fail
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    public static String navigate(String url) throws MalformedURLException, InterruptedException {

	APPLICATION_LOGS.debug("Creating a browser instance and navigating to the popdini site ...");

	// Disable log messages
	java.util.logging.Logger.getLogger("org.apache.http.impl.client").setLevel(java.util.logging.Level.WARNING);

	// Create a browser instance if not created already
	if (driver == null) {

	    try {

		// Create IE browser instance
		if (CONFIG.getProperty("test_browser").toLowerCase().contains("internet explorer")
			|| CONFIG.getProperty("test_browser").toLowerCase().contains("ie")) {

		    // System.setProperty("webdriver.ie.driver",
		    // System.getProperty("user.dir") +
		    // "\\BrowserDrivers\\IEDriverServer.exe");

		    dc = DesiredCapabilities.internetExplorer();
		    dc.setCapability("silent", true);
		    driver = new InternetExplorerDriver(dc);

		}

		// Create FF browser instance
		else if (CONFIG.getProperty("test_browser").toLowerCase().contains("firefox")
			|| CONFIG.getProperty("test_browser").toLowerCase().contains("ff")) {

		    // System.setProperty("webdriver.gecko.driver",
		    // System.getProperty("user.dir") +
		    // "\\BrowserDrivers\\geckodriver.exe");

		    driver = new FirefoxDriver();

		}

		// Create Chrome browser instance
		else if (CONFIG.getProperty("test_browser").toLowerCase().contains("chrome")) {

		    // System.setProperty("webdriver.chrome.driver",
		    // System.getProperty("user.dir") +
		    // "\\BrowserDrivers\\chromedriver.exe");

		    driver = new ChromeDriver();

		}

		// Maximize browser window
		APPLICATION_LOGS.debug("Maximizing Browser window...");
		driver.manage().window().maximize();
		APPLICATION_LOGS.debug("Browser window is maximized");

		// Implicitly wait for 30 seconds for browser to open
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Delete all browser cookies
		driver.manage().deleteAllCookies();

	    }

	    catch (Throwable initBrowserException) {

		APPLICATION_LOGS
			.debug("Error came while creating a browser instance : " + initBrowserException.getMessage());

		return "Fail : Error came while creating a browser instance : " + initBrowserException.getMessage();

	    }

	}

	APPLICATION_LOGS.debug("Created browser instance successfully");

	try {
	    // Navigate to the application
	    driver.navigate().to(url);
	    APPLICATION_LOGS.debug("Navigated to : " + url);
	}

	catch (Throwable navigationError) {

	    APPLICATION_LOGS.debug("Error came while navigating to the test site : " + navigationError.getMessage());

	}

	return "Pass : Navigated to the application";

    }

    /**
     * 
     * Signup to the application
     * 
     * @param dataRowNo
     * @return
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */

    public static String signUp(int dataRowNo) throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Signing up to application ...");

	// Click on Don't have an account? link for signing up
	methodReturnResult = FunctionLibrary.clickLink(locatorRegLink, nameRegLink);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	String emailAddressPre = null;
	String emailAddressPost = null;
	String password = null;
	String ReEnterPassword = null;

	try {

	    emailAddressPre = testData.getCellData("Cred", "RandEmailPre", dataRowNo);
	    emailAddressPost = testData.getCellData("Cred", "RandEmailPost", dataRowNo);

	    password = testData.getCellData("Cred", "Password", dataRowNo);
	    ReEnterPassword = password;

	    APPLICATION_LOGS.debug("Successfully Retrieved data from Xls File :- Email address pre: " + emailAddressPre
		    + "Email address post: " + emailAddressPost + " , Password : " + password + "and Confirm Password :"
		    + ReEnterPassword);

	}

	catch (Throwable fetchExcelDataError) {

	    APPLICATION_LOGS.debug("Error while retrieving data from xls file" + fetchExcelDataError.getMessage());
	    return "Error while retrieving data from xls file" + fetchExcelDataError.getMessage();

	}

	// Input Username in sign up page
	methodReturnResult = FunctionLibrary.clearAndInput(locatorFullNameInputBox, nameFullNameInputBox, fullName);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	emailAddress = emailAddressPre + FunctionLibrary.randomnNumberGenerator(300, 500) + emailAddressPost;
	// Clear Email address input-box and input email address
	methodReturnResult = FunctionLibrary.clearAndInput(locatorEmailIdInputBox, nameEmailIdInputBox, emailAddress);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Password input-box and input password
	methodReturnResult = FunctionLibrary.clearAndInput(locatorPasswordInputBox, namePasswordInputBox, password);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	// Clear Re-Enter Password input-box and input password
	methodReturnResult = FunctionLibrary.clearAndInput(locatorRepeatPasswordInputBox, nameRepeatPasswordInputBox,
		ReEnterPassword);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Continue button
	methodReturnResult = FunctionLibrary.clickLink(locatorSignUpButton, nameSignUpButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Verify Sign Up was successful

	String actRegSuccessText = FunctionLibrary.retrieveText(locatorRegSucText, nameRegSucText);
	methodReturnResult = FunctionLibrary.assertText(nameRegSucText, actRegSuccessText, expRegSuccessText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	else {
	    return "Pass : Sign up in to the application";
	}

    }

    /**
     * Login to the application
     * 
     * @param dataRowNo
     * @return Pass/Fail
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */
    public static String login(int dataRowNo) throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Logging in to application ...");

	// String emailAddress = null;
	String password = null;

	try {

	    // emailAddress = testData.getCellData("Cred", "Email", dataRowNo);
	    password = testData.getCellData("Cred", "Password", dataRowNo);

	    APPLICATION_LOGS.debug("Successfully Retrieved data from Xls File :-  Email address : " + emailAddress
		    + " and Password : " + password);

	}

	catch (Throwable fetchExcelDataError) {

	    APPLICATION_LOGS.debug("Error while retrieving data from xls file" + fetchExcelDataError.getMessage());
	    return "Error while retrieving data from xls file" + fetchExcelDataError.getMessage();

	}

	// Clear Email address input-box and input email address
	methodReturnResult = FunctionLibrary.clearAndInput(locatorSignInEmailInputBox, nameSignInEmailInputBox,
		emailAddress);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Password input-box and input password
	methodReturnResult = FunctionLibrary.clearAndInput(locatorSignInPasswordInputBox, nameSignInPasswordInputBox,
		password);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Log In button
	methodReturnResult = FunctionLibrary.clickLink(locatorLogInButton, nameLogInButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Verify login was successful
	String actLogInSuccessText = FunctionLibrary.retrieveText(locatorLogInSucText, nameLogInSucText);
	methodReturnResult = FunctionLibrary.assertText(nameLogInSucText, actLogInSuccessText, expLogInSuccessText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	else {
	    return "Pass : Logged in to the application";
	}

    }

    /**
     * Subscription of a plan
     * 
     * @param dataRowNo
     * @return
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */

    public static String subscribePlan(int dataRowNo) throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Subscribing to a package ...");

	// Click on Try Now button
	methodReturnResult = FunctionLibrary.clickLink(locatorTryNowButton, nameTryNowButton);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	// String beforePageSource = driver.getPageSource();
	// System.out.println("Before iFrame Page Source:" + beforePageSource);
	// Switch to stripe payment frame
	// methodReturnResult =
	// FunctionLibrary.switchToFrame("stripe_checkout_app");
	WebElement stripeFrame = FunctionLibrary.findDisplayedElementFromList(By.name("stripe_checkout_app"),
		"Stripe checkout frame");
	methodReturnResult = FunctionLibrary.switchToFrame(stripeFrame);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// String afterPageSource = driver.getPageSource();
	// System.out.println("After iFrame Page Source:" + afterPageSource);
	// Thread.sleep(5000);

	String EmailAddress = null;
	String cardNumber = null;
	String expairyDate = null;
	String cVCNumber = null;

	try {
	    EmailAddress = testData.getCellData("StripeDetails", "Email", dataRowNo);
	    cardNumber = TestData.STRIPE_CARD_NO;
	    expairyDate = testData.getCellData("StripeDetails", "DateOfExpairy", dataRowNo);
	    cVCNumber = testData.getCellData("StripeDetails", "CVV", dataRowNo);

	    APPLICATION_LOGS.debug(
		    "Successfully Retrieved data from Xls File :- Email Address" + EmailAddress + ", Card Number : "
			    + cardNumber + " , Expairy Date : " + expairyDate + " and CVV number " + cVCNumber);

	}

	catch (Throwable fetchExcelDataError) {

	    APPLICATION_LOGS.debug("Error while retrieving data from xls file" + fetchExcelDataError.getMessage());
	    return "Error while retrieving data from xls file" + fetchExcelDataError.getMessage();

	}

	// Clear Email address input-box and input email address
	methodReturnResult = FunctionLibrary.clearAndInput(locatorStripeEmailInputBox, nameStripeEmailInputBox,
		EmailAddress);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Card number input-box and input card number
	methodReturnResult = FunctionLibrary.clearAndInput(locatorStripeCardInputBox, nameStripeCardInputBox,
		cardNumber);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Expire Date input-box and input Expire date
	methodReturnResult = FunctionLibrary.clearAndInput(locatorStripeExpInputBox, nameStripeExpInputBox,
		expairyDate);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear CVC number input-box and input CVC number
	methodReturnResult = FunctionLibrary.clearAndInput(locatorStripeCVCInputBox, nameStripeCVCInputBox, cVCNumber);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Pay button
	methodReturnResult = FunctionLibrary.clickLink(locatorPayButton, namePayButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Switch to default content
	FunctionLibrary.switchToDefaultContent();

	// Verify Payment was successful
	String actPaymentSuccessText = FunctionLibrary.retrieveText(locatorPaymentSucText, namePaymentSucText);
	methodReturnResult = FunctionLibrary.assertText(namePaymentSucText, actPaymentSuccessText,
		expPaymentSuccessText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	else {
	    return "Pass : Subscription completed";
	}

    }

    /**
     * Create First Pop
     * 
     * @param dataRowNo
     * @return
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */
    public static String FirstPop(int dataRowNo) throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Creating first pop ...");

	String brandName = null;
	String homeURL = null;
	String articleURL = null;
	String articleMessage = null;
	String buttonText = null;
	String buttonLink = null;
	String pathValue = System.getProperty("user.dir") + "\\Images\\BrandImage.jpg";

	try {
	    brandName = testData.getCellData("FirstPopContent", "BrandName", dataRowNo);
	    homeURL = testData.getCellData("FirstPopContent", "BrandURL", dataRowNo);
	    articleURL = testData.getCellData("FirstPopContent", "ArticleURL", dataRowNo);
	    articleMessage = testData.getCellData("FirstPopContent", "ArticleMessage", dataRowNo);
	    buttonText = testData.getCellData("FirstPopContent", "ButtonText", dataRowNo);
	    buttonLink = testData.getCellData("FirstPopContent", "ButtonLink", dataRowNo);

	    APPLICATION_LOGS.debug("Successfully Retrieved data from Xls File :- Brand Name" + brandName
		    + ", Brand URL : " + homeURL + ", Article URL " + articleURL + ", Article Message " + articleMessage
		    + ", Button Text " + buttonText + ", Button Link " + buttonLink);

	}

	catch (Throwable fetchExcelDataError) {

	    APPLICATION_LOGS.debug("Error while retrieving data from xls file" + fetchExcelDataError.getMessage());
	    return "Error while retrieving data from xls file" + fetchExcelDataError.getMessage();

	}

	// Click on Create My Pop Button on welcome page
	methodReturnResult = FunctionLibrary.clickLink(locatorCreatePopButton, nameCreatePopButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Name your Brand input-box and input Name your Brand
	methodReturnResult = FunctionLibrary.clearAndInput(locatorBNameInputBox, nameBNameInputBox, brandName);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Home URL input-box and input Home URL
	methodReturnResult = FunctionLibrary.clearAndInput(locatorHomeURLInputBox, nameHomeURLInputBox, homeURL);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Upload brand image
	methodReturnResult = FunctionLibrary.input(locatorbrandImageFile, namebrandImageFile, pathValue);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Next button
	methodReturnResult = FunctionLibrary.clickLink(locatorNxtButton, namenxtButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Article input-box and input Article
	methodReturnResult = FunctionLibrary.clearAndInput(locatorArticleInputBox, nameArticleInputBox, articleURL);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Message input-box and input Message
	methodReturnResult = FunctionLibrary.clearAndInput(locatorArtMsgInputBox, nameArtMsgInputBox, articleMessage);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Button Text input-box and input Button Text
	methodReturnResult = FunctionLibrary.clearAndInput(locatorBtnTxtInputBox, nameBtnTxtInputBox, buttonText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Button Link input-box and input Button Link
	methodReturnResult = FunctionLibrary.clearAndInput(locatorBtnLinkInputBox, nameBtnLinkInputBox, buttonLink);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Next button in CTA page
	methodReturnResult = FunctionLibrary.clickLink(locatorCtaNxtButton, nameCtaNxtButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Verify Pop creation was successful
	String actPopCreateSuccessText = FunctionLibrary.retrieveText(locatorPopCreateSucText, namePopCreateSucText);
	methodReturnResult = FunctionLibrary.assertText(namePopCreateSucText, actPopCreateSuccessText,
		expPopCreateSuccessText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Go to Dashboard button in CTA page
	methodReturnResult = FunctionLibrary.clickLink(locatorDashboardButton, nameDashboardButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	return "Pass : First pop creation successfully completed";

    }

    /**
     * Create Pop using create pop button
     * 
     * @param dataRowNo
     * @return
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */

    public static String CreatePopButton(int dataRowNo) throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Creating pop using button ...");

	// Click on Create New Pop button from Main Overview tab
	methodReturnResult = FunctionLibrary.clickLink(locatorCrtNwPopButton, nameCrtNwPopButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Select brand option
	methodReturnResult = FunctionLibrary.clickLink(locatorSelectBrandOptn, nameSelectBrandOptn);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on existing brand
	methodReturnResult = FunctionLibrary.clickLink(locatorSelectBrandList, nameSelectBrandList);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Next button
	methodReturnResult = FunctionLibrary.clickLink(locatorSelectBrandNextButton, nameSelectBrandNextButton);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	String ctaArticleURL = null;
	String ctaArticleMessage = null;
	String ctaButtonText = null;
	String ctaButtonLink = null;
	// String pathValue = System.getProperty("user.dir") +
	// "\\Images\\BrandImage.jpg";

	try {
	    ctaArticleURL = testData.getCellData("CreatePopButton", "ArticleURL", dataRowNo);
	    ctaArticleMessage = testData.getCellData("CreatePopButton", "ArticleMessage", dataRowNo);
	    ctaButtonText = testData.getCellData("CreatePopButton", "ButtonText", dataRowNo);
	    ctaButtonLink = testData.getCellData("CreatePopButton", "ButtonLink", dataRowNo);

	    APPLICATION_LOGS.debug(
		    "Successfully Retrieved data from Xls File :- Article URL " + ctaArticleURL + ", Article Message "
			    + ctaArticleMessage + ", Button Text " + ctaButtonText + ", Button Link " + ctaButtonLink);

	}

	catch (Throwable fetchExcelDataError) {

	    APPLICATION_LOGS.debug("Error while retrieving data from xls file" + fetchExcelDataError.getMessage());
	    return "Error while retrieving data from xls file" + fetchExcelDataError.getMessage();

	}

	// Clear Article input-box and input Article in CTA message page
	methodReturnResult = FunctionLibrary.clearAndInput(locatorCtaArticleInputBox, nameCtaArticleInputBox,
		ctaArticleURL);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear Message input-box and input Message in CTA message page
	methodReturnResult = FunctionLibrary.clearAndInput(locatorCtaArtMsgInputBox, nameCtaArtMsgInputBox,
		ctaArticleMessage);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear CTA Button Text input-box and input Button Text
	methodReturnResult = FunctionLibrary.clearAndInput(locatorCtaBtnTxtInputBox, nameCtaBtnTxtInputBox,
		ctaButtonText);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Clear CTA Button Link input-box and input Button Link
	methodReturnResult = FunctionLibrary.clearAndInput(locatorCtaBtnLinkInputBox, nameCtaBtnLinkInputBox,
		ctaButtonLink);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Select option from Delay list in CTA page
	methodReturnResult = FunctionLibrary.selectValueByVisibleText(locatorCtaDelayList, listOption,
		nameCtaDelayList);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Next button in CTA page
	methodReturnResult = FunctionLibrary.clickLink(locatorCtaNxtButton1, nameCtaNxtButton1);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Click on Next button in CTA theme page
	methodReturnResult = FunctionLibrary.clickLink(locatorCtaNxtButton2, nameCtaNxtButton2);

	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	By locatorPopCreateBtnSucText = By.xpath("//div[contains(text(),'You just created your')]");
	String namePopCreateBtnSucText = "Pop Creation successful using button";

	// Verify Pop creation was successful using Create pop button
	if (!FunctionLibrary.isElementDisplayed(locatorPopCreateBtnSucText, namePopCreateBtnSucText)) {
	    return "Fail : Pop creation using Create pop button successfully completed";
	}

	return "Pass : New post published successfully";
    }

}
