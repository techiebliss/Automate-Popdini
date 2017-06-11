/**
* Post java class implements all the test cases under Post test suite.
*
* @version 1.0
*/

package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import testscripts.DriverScript;
import testscripts.PopdiniLibrary;

public class CreatePop extends DriverScript {

    /**
     * User Creates new popdini Account
     * 
     * @return Pass/Fail
     * @throws InterruptedException
     * @throws BiffException
     * @throws IOException
     */
    public static String createsNewAccount() throws InterruptedException, BiffException, IOException {

	APPLICATION_LOGS.debug("Executing test case : Create new Popdini Account");

	// Launch the popdini application
	methodReturnResult = PopdiniLibrary.navigate(CONFIG.getProperty("webSiteURL"));
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Sign Up to Popdini application
	methodReturnResult = PopdiniLibrary.signUp(dataRowNo);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	return "Pass : New Popdini Account Created successfully";

    }

    /**
     * User subscribes to a plan
     * 
     * @return
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */

    public static String chooseAPlan() throws BiffException, InterruptedException, IOException {

	APPLICATION_LOGS.debug("Executing test case : Log in to Popdini Account");

	// Launch the Popdini application
	methodReturnResult = PopdiniLibrary.navigate(CONFIG.getProperty("webSiteURL"));
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Login to Popdini application
	methodReturnResult = PopdiniLibrary.login(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Subscribe to a plan
	methodReturnResult = PopdiniLibrary.subscribePlan(dataRowNo);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	return "Pass : Subscribed to a plan successfully";

    }

    /**
     * Users login to popdini
     * 
     * @return Pass/Fail
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */
    public static String loginToAccount() throws BiffException, InterruptedException, IOException {

	APPLICATION_LOGS.debug("Executing test case : Log in to Popdini Account");

	// Launch the Popdini application
	methodReturnResult = PopdiniLibrary.navigate(CONFIG.getProperty("webSiteURL"));
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Login to Popdini application
	methodReturnResult = PopdiniLibrary.login(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	return "Pass : Logged into popdini account successfully";

    }

    /**
     * User creates first pop
     * 
     * @return Pass/Fail
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */
    public static String createFirstPop() throws BiffException, InterruptedException, IOException {

	APPLICATION_LOGS.debug("Executing test case : Create First post");
	// Launch the Popdini application
	methodReturnResult = PopdiniLibrary.navigate(CONFIG.getProperty("webSiteURL"));
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Login to Popdini application
	methodReturnResult = PopdiniLibrary.login(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	// Create First Pop in Popdini application
	methodReturnResult = PopdiniLibrary.FirstPop(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	return "Pass : Executed Test case 'Create First Pop'";
    }

    /**
     * 
     * @return
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */

    public static String createPopUsingButton() throws BiffException, InterruptedException, IOException {

	APPLICATION_LOGS.debug("Executing test case : Create First post");
	// Launch the Popdini application
	methodReturnResult = PopdiniLibrary.navigate(CONFIG.getProperty("webSiteURL"));
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	// Login to Popdini application
	methodReturnResult = PopdiniLibrary.login(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	// Create First Pop in Popdini application
	methodReturnResult = PopdiniLibrary.FirstPop(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}
	// Create Pop using button in Popdini application
	methodReturnResult = PopdiniLibrary.CreatePopButton(1);
	if (methodReturnResult.contains(failTest)) {
	    return methodReturnResult;
	}

	return "Pass : Executed Test case 'Create Pop using Button'";
    }
}
