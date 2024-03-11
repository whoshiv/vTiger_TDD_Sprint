package vtiger.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String fetchStringDataFromExcelFile(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	}
	public long fetchNumericDataFromExcelFile(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fis);
		 return (long)workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getNumericCellValue();
	}
	
	public boolean fetchBooleanDataFromExcelFile(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getBooleanCellValue();
	}
	
	public String fetchDateDataFromExcelFile(String sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
		
		Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetname).getRow(rowno).getCell(cellno).getLocalDateTimeCellValue().toString().substring(0,10);
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility e = new ExcelUtility();
		String date = e.fetchDateDataFromExcelFile("Opportunity", 1, 1);
		System.out.println(date);
	}
}
