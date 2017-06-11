/**
* Keywords java class lists all the automated test cases present under controller.xls file.
*
* @version 1.0
*/

package testscripts;

import java.io.IOException;

import jxl.read.biff.BiffException;
import testcases.CreatePop;

public class Keywords {

    public static String methodReturnResult = null;

    /**
     * Create new account
     * 
     * @return Pass/Fail
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */
    public static String createsNewAccount() throws BiffException, InterruptedException, IOException {
	return CreatePop.createsNewAccount();
    }

    public static String chooseAPlan() throws BiffException, InterruptedException, IOException {
	return CreatePop.chooseAPlan();
    }

    /**
     * Log in to the popdini application
     * 
     * @return Pass/Fail
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */
    public static String loginToAccount() throws BiffException, InterruptedException, IOException {
	return CreatePop.loginToAccount();
    }

    /**
     * Create First Pop
     * 
     * @return Pass/Fail
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */
    public static String createFirstPop() throws BiffException, InterruptedException, IOException {
	return CreatePop.createFirstPop();
    }

    /**
     * Create Pop using
     * 
     * @return
     * @throws BiffException
     * @throws InterruptedException
     * @throws IOException
     */

    public static String createPopUsingButton() throws BiffException, InterruptedException, IOException {
	return CreatePop.createPopUsingButton();
    }

}
