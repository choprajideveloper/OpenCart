package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\OpenCart_Test_Data.xlsx";

		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) { //ignoring header so we start from 1
			for (int j = 0; j < totalcols; j++) { // 0 i is row and j is column
				loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0 storing in 2 dimensional array, array index start from 0 i.e. row
			}
		}

		return loginData; // returning two dimension array

	}
	
	// we can have multiple dataproviders.
	
	

}
