/**
* ReportUtil implements html reporting for the selenium test execution.
*
* @version 1.0
*/

package reports;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import testscripts.DriverScript;
import util.TestUtil;

public class ReportUtil extends DriverScript {
    public static int scriptNumber = 1;
    public static String indexResultFilename;
    public static String currentDir;
    public static String currentSuiteName;
    public static int tcid;

    public static double passNumber;
    public static double failNumber;
    public static boolean newTest = true;
    public static ArrayList<String> description = new ArrayList<String>();
    public static ArrayList<String> keyword = new ArrayList<String>();
    public static ArrayList<String> teststatus = new ArrayList<String>();
    public static ArrayList<String> screenShotPath = new ArrayList<String>();

    /**
     * Start report generation process
     * 
     * @param filename
     * @param testStartTime
     * @param env
     * @param rel
     * @param browser
     * @param testSiteUrl
     * @throws IOException
     */
    public static void startTesting(String filename, String testStartTime, String env, String rel, String browser,
	    String testSiteUrl) throws IOException {
	indexResultFilename = filename;
	currentDir = indexResultFilename.substring(0, indexResultFilename.lastIndexOf(fileSeparator));

	// Clear Test Report folder
	File dir = new File(currentDir);
	File[] allFiles = dir.listFiles();
	for (int i = 0; i < allFiles.length; i++) {
	    allFiles[i].delete();
	}

	// Copy css and image files into Reports folder
	FileUtils.copyDirectory(new File(reportsLib), new File(currentDir));

	// Start generating Test report
	FileWriter fstream = null;
	BufferedWriter out = null;
	try {

	    // Create file
	    fstream = new FileWriter(filename);
	    out = new BufferedWriter(fstream);

	    String RUN_DATE = TestUtil.now("dd.MMMMM.yyyy").toString();

	    String ENVIRONMENT = env;
	    String RELEASE = rel;
	    String Browser = browser;
	    String testSiteURL = testSiteUrl;

	    out.write("<html>");
	    out.write("<head>");
	    out.write("<title>Automation Test Results</title>");
	    out.write(
		    "<link rel='stylesheet' href='style.css' type='text/css' media='screen'/><link rel='stylesheet' href='style.css' type='text/css' media='screen'/>");
	    out.write("</head>");

	    out.write("<body>");
	    out.write("<table class='header'>");
	    out.write("<td>AUTOMATION TEST REPORTS</td>");
	    out.write("</table>");

	    out.write("<table class='info'>");
	    out.write("<caption>TEST ENVIRONMENT</caption>");

	    out.write("<tr>");
	    out.write("<td class='header'>RUN DATE</td>");
	    out.write("<td class='data'>" + RUN_DATE + "</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>RUN START TIME</td>");
	    out.write("<td class='data'>" + testStartTime + "</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>RUN END TIME</td>");
	    out.write("<td class='data'>END_TIME</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>ENVIRONMENT</td>");
	    out.write("<td class='data'>" + ENVIRONMENT + "</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>RELEASE</td>");
	    out.write("<td class='data'>" + RELEASE + "</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>BROWSER</td>");
	    out.write("<td class='data'>" + Browser + "</td>");
	    out.write("</tr>");

	    out.write("<tr>");
	    out.write("<td class='header'>APPLICATION URL</td>");
	    out.write("<td class='data'>" + testSiteURL + "</td>");
	    out.write("</tr>");

	    out.write("</table> <br><br>");

	    // Close the output stream
	    out.close();

	} catch (Exception e) { // Catch exception if any
	    System.err.println("Error: " + e.getMessage());
	} finally {

	    fstream = null;
	    out = null;
	}
    }

    /**
     * Start report generation for the test suite
     * 
     * @param suiteName
     */
    public static void startSuite(String suiteName) {

	FileWriter fstream = null;
	BufferedWriter out = null;
	currentSuiteName = suiteName.replaceAll(" ", "_");
	tcid = 1;
	try {

	    fstream = new FileWriter(indexResultFilename, true);
	    out = new BufferedWriter(fstream);

	    out.write("<table class='testSuites'>");
	    out.write("<caption>" + suiteName.toUpperCase() + " REPORTS</caption>");

	    out.write("<thead>");
	    out.write("<tr>");
	    out.write("<td>Test Suite ID</td>");
	    out.write("<td>Test Suite Name</td>");
	    out.write("<td>Status</td>");
	    out.write("<td>Run Start Time</td>");
	    out.write("<td>Run End Time</td>");
	    out.write("</tr>");
	    out.write("</thead>");
	    out.close();

	} catch (Exception e) {
	    System.err.println("Error: " + e.getMessage());
	} finally {

	    fstream = null;
	    out = null;
	}
    }

    /**
     * End report generation for the test suite
     */
    public static void endSuite() {

	FileWriter fstream = null;
	BufferedWriter out = null;

	try {

	    fstream = new FileWriter(indexResultFilename, true);
	    out = new BufferedWriter(fstream);
	    out.write("</tbody>");
	    out.write("</table>");
	    out.write("</body>");
	    out.write("</html>");
	    out.close();

	} catch (Exception e) {
	    System.err.println("Error: " + e.getMessage());
	} finally {

	    fstream = null;
	    out = null;
	}

    }

    /**
     * Add reporting for the test cases
     * 
     * @param testCaseName
     * @param testCaseStartTime
     * @param testCaseEndTime
     * @param status
     */
    public static void addTestCase(String testCaseName, String testCaseStartTime, String testCaseEndTime,
	    String status) {

	newTest = true;
	FileWriter fstream = null;
	BufferedWriter out = null;

	try {

	    newTest = true;

	    // build the keywords page
	    if (status.equalsIgnoreCase("Skipped") || status.equalsIgnoreCase("Skip")) {

	    } else {

		File f = new File(currentDir + fileSeparator + currentSuiteName + "_TC" + tcid + "_"
			+ testCaseName.replaceAll(" ", "_") + ".html");

		f.createNewFile();

		fstream = new FileWriter(currentDir + fileSeparator + currentSuiteName + "_TC" + tcid + "_"
			+ testCaseName.replaceAll(" ", "_") + ".html");

		out = new BufferedWriter(fstream);

		out.write("<html>");
		out.write("<head>");
		out.write("<title>" + testCaseName + " Detailed Reports </title>");

		out.write("<link rel='stylesheet' href='style.css' type='text/css' media='screen'/>");
		out.write("</head>");

		out.write("<body>");

		out.write("<table class='tests'>");
		out.write("<caption>DETAILED REPORT</caption>");

		out.write("<thead>");
		out.write("<tr>");
		out.write("<td>TCID</td>");
		out.write("<td>Description</td>");
		out.write("<td>Keyword</td>");
		out.write("<td>Result</td>");
		out.write("<td>Screenshot</td>");
		out.write("</tr>");
		out.write("</thead>");

		if (description != null) {
		    for (int i = 0; i < description.size(); i++) {

			if (teststatus.get(i).trim().toLowerCase().startsWith("pass")) {
			    out.write("<tr class='pass' title='Passed'>");
			}

			else if (teststatus.get(i).trim().toLowerCase().startsWith("fail")) {
			    out.write("<tr class='fail' title='Failed'>");
			}

			out.write("<td>TC" + (i + 1) + "</td>");
			out.write("<td>" + description.get(i) + "</td>");
			out.write("<td>" + keyword.get(i) + "</td>");
			out.write("<td>" + teststatus.get(i) + "</td>");

			if (screenShotPath.get(i) != null) {
			    out.write("<td><a href=" + screenShotPath.get(i) + " target=_blank>Screen Shot</a></td>");
			}

			else {
			    out.write("<td>&nbsp;</td>");
			}

			out.write("</tr>");

		    }

		    // End test cases reporting
		    out.write("</tbody>");
		    out.write("</table>");
		    out.write("</body>");
		    out.write("</html>");

		}

		out.close();

	    }

	    fstream = new FileWriter(indexResultFilename, true);
	    out = new BufferedWriter(fstream);

	    out.write("<tbody>");

	    if (status.trim().equalsIgnoreCase("pass") || status.trim().equalsIgnoreCase("passed")) {

		out.write("<tr class='pass' title='Passed'>");
		out.write("<td>TS" + scriptNumber + "</td>");
		out.write("<td><a href=" + currentSuiteName + "_TC" + tcid + "_" + testCaseName.replaceAll(" ", "_")
			+ ".html>" + testCaseName + "</a></td>");

		out.write("<td><img src='pass.png'></td>");

	    }

	    else if (status.trim().equalsIgnoreCase("fail") || status.trim().equalsIgnoreCase("failed")) {

		out.write("<tr class='fail' title='Failed'>");
		out.write("<td>TS" + scriptNumber + "</td>");
		out.write("<td><a href=" + currentSuiteName + "_TC" + tcid + "_" + testCaseName.replaceAll(" ", "_")
			+ ".html>" + testCaseName + "</a></td>");

		out.write("<td><img src='fail.png'></td>");

	    }

	    else if (status.trim().equalsIgnoreCase("skip") || status.trim().equalsIgnoreCase("skipped")) {

		out.write("<tr class='skip' title='Skipped'>");
		out.write("<td>TS" + scriptNumber + "</td>");
		out.write("<td>" + testCaseName + "</td>");
		out.write("<td><img src='skip.png'></td>");

	    }

	    out.write("<td>" + testCaseStartTime + "</td>");
	    out.write("<td>" + testCaseEndTime + "</td>");

	    out.write("</tr>");

	    tcid++;
	    scriptNumber++;

	}

	catch (IOException e) {
	    e.printStackTrace();
	    return;
	} finally {
	    try {
		out.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	description = new ArrayList<String>();
	keyword = new ArrayList<String>();
	teststatus = new ArrayList<String>();
	screenShotPath = new ArrayList<String>();
	newTest = false;
    }

    /**
     * Add keyword into report
     * 
     * @param desc
     * @param key
     * @param stat
     * @param path
     */
    public static void addKeyword(String desc, String key, String stat, String path) {

	description.add(desc);
	keyword.add(key);
	teststatus.add(stat);
	screenShotPath.add(path);

    }

    /**
     * Update test end time into report
     * 
     * @param endTime
     */
    public static void updateEndTime(String endTime) {
	StringBuffer buf = new StringBuffer();
	try {
	    // Open the file that is the first
	    // command line parameter
	    FileInputStream fstream = new FileInputStream(indexResultFilename);
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;

	    // Read File Line By Line
	    while ((strLine = br.readLine()) != null) {

		if (strLine.indexOf("END_TIME") != -1) {
		    strLine = strLine.replace("END_TIME", endTime);
		}
		buf.append(strLine);

	    }
	    // Close the input stream
	    in.close();
	    FileOutputStream fos = new FileOutputStream(indexResultFilename);
	    DataOutputStream output = new DataOutputStream(fos);
	    output.writeBytes(buf.toString());
	    fos.close();

	} catch (Exception e) { // Catch exception if any
	    System.err.println("Error: " + e.getMessage());
	}

    }

}