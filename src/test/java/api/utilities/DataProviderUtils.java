package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name="Data")
	public String[][] getAlldata() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//userdata.xlsx";
		UtilityXL xl=new UtilityXL(path);
		
		int rowcount=xl.getRowCount("Sheet1");
		int colcount=xl.getColumnCount("Sheet1",1);
		
		String apidata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getData("Sheet1",i,j);
			}
		}
		return apidata;
		
	}
	
	@DataProvider(name="Usernames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//userdata.xlsx";
		UtilityXL xl=new UtilityXL(path);
		
		int rowcount=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rowcount];
		
		for(int i=1;i<rowcount;i++)
		{
			apidata[i-1]=xl.getData("Sheet1",i,1);
		}
		return apidata;
	}
}
