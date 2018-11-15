package FrameworkUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	 
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception{

		try{
			FileInputStream ExcelFile = new FileInputStream(Constant.testDataFile);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			}catch (Exception e){

			return"";

			}
}

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
			MissingCellPolicy xRow = null;
		try{
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
				FileOutputStream fileOut = new FileOutputStream(Constant.testDataFile);
				ExcelWBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			}catch(Exception e){
				throw (e);
		}

	}

public static int getRow(String SheetName) throws IOException {
	FileInputStream ExcelFile = new FileInputStream(Constant.testDataFile);
	ExcelWBook = new XSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(SheetName);
	/*XSSFRow row = null;
	row = ExcelWSheet.getCol(0);
	return row.getLastCellNum();*/
	int numberOfCells = 0;
    Iterator rowIterator = ExcelWSheet.rowIterator();
    /**
     * Escape the header row *
     */
    if (rowIterator.hasNext())
    {
        Row headerRow = (Row) rowIterator.next();
        //get the number of cells in the header row
        return headerRow.getPhysicalNumberOfCells();
    }
	return numberOfCells;

	
}
}