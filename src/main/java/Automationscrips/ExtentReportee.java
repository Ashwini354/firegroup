package Automationscrips;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportee {
	 public static ExtentHtmlReporter htmlReporter;
	  public static ExtentReports extent;
	  public static ExtentTest logger;
	  static String testcaseName="null";
	  public static void main(String[] args) {
		htmlReporter=new ExtentHtmlReporter("./Report.html");
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "Salesforce");
		extent.setSystemInfo("environment","Automatio testing");
		extent.setSystemInfo("username", "ashwini");
		
		htmlReporter.config().setDocumentTitle("Test execution Report");
		htmlReporter.config().setReportName("salesforce regression testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		testcaseName="first test script";
		logger=extent.createTest(testcaseName);
		logger.log(Status.INFO,"logging the information" );
		logger.log(Status.PASS,MarkupHelper.createLabel(testcaseName+"is PassTest", ExtentColor.GREEN));
		logger.log(Status.PASS,MarkupHelper.createLabel(testcaseName+"is NotPass", ExtentColor.RED));
		extent.flush();
		
		
		
		
	}
    

}
