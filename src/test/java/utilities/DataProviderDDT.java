package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderDDT {
	@DataProvider(name="loginDt")
	public String[][] loginData() throws IOException
	{
		String path="C:\\Users\\SUREBIT\\eclipse-workspace\\OpenCartV12\\testdata\\Book1.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int totalRows = xl.getTotalRowNum("Data");//4
		System.out.println(totalRows);
		int totalCells = xl.getTotalCellNum("Data",0);//3
		System.out.println(totalCells);
		String[][] data = new String[totalRows][totalCells-1];// 4 rows , cell=3-1=2
		
		for(int r=1; r<=totalRows;r++)//1.2.3.4<=5
		{
			for (int c=1; c<totalCells;c++)//1.2
			{
				data[r-1][c-1]=xl.getCellData("Data", r, c);
			}
		}
		
		return data;
	}
}
