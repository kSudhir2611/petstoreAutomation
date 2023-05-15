package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class StoreDDTest 
{
	@DataProvider(name="allData")
	public String[][] getAllStoredata() throws IOException 
	{
		String path = System.getProperty("user.dir")+".//testdata//storedata.xlsx";
		
		XLUtility xl = new XLUtility(path);
		
		int rowCount = xl.getRowCount("store");
		int colCount = xl.getColCount("store", 1);
		
		String[][] data = new String[rowCount][colCount];
		
		for(int i = 1; i <= rowCount; i++) 
		{
			for(int j=0; j < colCount;j++) 
			{
				data[i-1][j] = xl.getCellData("store", i, j);
			}
		}
		return data;
		
	}
	
	
	@DataProvider(name="orderid")
	public String[] getOrderId() throws IOException 
	{
		String path = System.getProperty("user.dir")+".//testdata//storedata.xlsx";
		
		XLUtility xl = new XLUtility(path);
		
		int rowCount = xl.getRowCount("store");
		
		String[] data = new String[rowCount];
		
		for(int i =1; i <= rowCount;i++) 
		{
			data[i-1]=xl.getCellData("store", i, 1);
		}
		return data;
	}

}
