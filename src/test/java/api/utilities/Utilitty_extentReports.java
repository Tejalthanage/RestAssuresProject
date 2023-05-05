package api.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Utilitty_extentReports extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlreporter;
	public  ExtentReports extent;
	public ExtentTest logger;
	
public void onStart(ITestContext testContext) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time stamp
		String repname="Test-Report"+timestamp +".html";
		
		//htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repname); 
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","localHost");
		extent.setSystemInfo("Envoirment","QA");
		extent.setSystemInfo("user", "manoj");
		
		htmlreporter.config().setDocumentTitle("PetStore Report");
		htmlreporter.config().setReportName("Rest Assured Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		htmlreporter.config().setTheme(Theme.STANDARD);
		
	}


       public void onTestSuccess(ITestResult tr)

       {
    	   
    	   logger=extent.createTest(tr.getName());  //create new entry to the report
    	
    	   logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
       }
       
       public void onTestFailure(ITestResult tr) 
   	{
   		logger=extent.createTest(tr.getName());
   		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
   		
   		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
   		//String screenshotpath="C:\\Users\\sai\\eclipse-workspace\\Pomproject1\\screenshot\\"+tr.getName()+".png";
   		
   		File f=new File(screenshotpath);
   		if(f.exists())
   		{
   			try
   			{
   				logger.fail("Screenshot is below :" + logger.addScreenCaptureFromPath(screenshotpath));
   			}
   			catch (Exception e) 
   			{
   				e.printStackTrace();
   				// TODO: handle exception
   			}
   		}
   		
   	}
   	
   	public void onTestSkipped(ITestResult tr) {
   		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
   	
   	
   public void onFinish(ITestContext testContext) 
  
   {
		
	
	   extent.flush();
	}
   	
   	

	

	

}
