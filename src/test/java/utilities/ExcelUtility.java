package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	 
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row ;
	XSSFCell cell;
	String filepath;
	
	public ExcelUtility(String path)
	{
		filepath=path;
	}
	
	public int getTotalRowNum(String sheetName) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		int val = workbook.getSheet(sheetName).getLastRowNum();
		workbook.close();
		fi.close();
		return val;
	}
	
	
	
	public int getTotalCellNum(String sheetName,int row) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		int val = workbook.getSheet(sheetName).getRow(row).getLastCellNum();
		workbook.close();
		fi.close();
		return val;
	}
	
	public String getCellData(String sheetName,int rowNum, int cellNum) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		row = workbook.getSheet(sheetName).getRow(rowNum);
		String val = row.getCell(cellNum).toString();
		workbook.close();
		fi.close();
		return val;
		
	}
	
	public void writeDataIntoCell(String sheetName,int rowNum, int cellNum,String value) throws IOException
	{

		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		
		cell = row.createCell(cellNum);
		cell.setCellValue(value);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

}
