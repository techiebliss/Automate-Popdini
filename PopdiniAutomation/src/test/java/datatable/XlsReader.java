
/**
* XlsReader is a java class which is responsible for all the communication with the .xls file. 
* It provides many useful methods for reading data from the spreadsheet.
*
* @version 1.0
*/

package datatable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlsReader {
    public String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;

    /**
     * Initiates xls reading process
     * 
     * @param path
     */
    public XlsReader(String path) {
	this.path = path;
	try {
	    fis = new FileInputStream(path);
	    fis.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Get row count for a specific sheet
     * 
     * @param sheetName
     * @return row count
     * @throws JXLException
     * @throws IOException
     */
    public int getRowCount(String sheetName) throws JXLException, IOException {
	File inputWorkbook = new File(path);
	Workbook w;
	w = Workbook.getWorkbook(inputWorkbook);
	Sheet sheet = w.getSheet(sheetName);
	int row_count = 0;
	for (int i = 0; i < sheet.getRows(); i++) {
	    row_count++;
	}
	return row_count;
    }

    /**
     * Get data present under a specific cell
     * 
     * @param sheetName
     * @param colNum
     * @param rowNum
     * @return cell data
     * @throws BiffException
     * @throws IOException
     */
    public String getCellData(String sheetName, int colNum, int rowNum) throws BiffException, IOException {
	File inputWorkbook = new File(path);
	Workbook w;
	w = Workbook.getWorkbook(inputWorkbook);
	Sheet sheet = w.getSheet(sheetName);
	Cell cell = sheet.getCell(colNum, rowNum);
	return cell.getContents();
    }

    /**
     * Get data present under a specific cell
     * 
     * @param sheetName
     * @param colName
     * @param rowNum
     * @return cell data
     * @throws BiffException
     * @throws IOException
     */

    public String getCellData(String sheetName, String colName, int rowNum) throws BiffException, IOException {
	File inputWorkbook = new File(path);
	Workbook w;
	w = Workbook.getWorkbook(inputWorkbook);
	Sheet sheet = w.getSheet(sheetName);
	int i = 0;
	int colNum;

	for (i = 0; i < sheet.getColumns(); i++) {
	    if (sheet.getCell(i, 0).getContents().equals(colName)) {
		break;
	    }
	}

	colNum = i;

	Cell cell = sheet.getCell(colNum, rowNum);
	return cell.getContents();
    }

    /**
     * Get first sheet name
     * 
     * @return first sheet name
     * @throws BiffException
     * @throws IOException
     */
    public String getFirstSheetname() throws BiffException, IOException {

	File inputWorkbook = new File(path);
	Workbook w;
	w = Workbook.getWorkbook(inputWorkbook);
	String sheet = w.getSheet(0).getName();
	return sheet;

    }

}
