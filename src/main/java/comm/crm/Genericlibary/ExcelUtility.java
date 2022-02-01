package comm.crm.Genericlibary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * Read the data from excel sheet based on arguments passed
	 * @param Sheet1
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getDataFromExcel(String Sheet1,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		  Sheet sh = wb.getSheet(Sheet1);
		 Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		String d = c.getStringCellValue();
		wb.close();
		return 	d;
		}
	
	/**
	 * used to get last used rowNumber from excel
	 * @param Sheet1
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowCount(String Sheet1) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet1);
		wb.close();
		return sh.getLastRowNum();
	}
	
	
	public void setDataExcel(String Sheet1,int rowNum,int CellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet1);
		Row ronum = sh.getRow(rowNum);
		 Cell cl = ronum.createCell(CellNum);
		 cl.setCellValue(data);
		 FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\Book1.xlsx");
		 wb.write(fout);
		 wb.close();
	}



}
