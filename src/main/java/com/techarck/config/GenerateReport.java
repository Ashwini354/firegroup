package com.techarck.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReport {
	public static ExtentHtmlReporter htmlReporter;
	  public static ExtentReports extent;
	  public ExtentTest logger;
	  static String testcaseName="null";
	  private GenerateReport ob;
	  
	  public  GenerateReport getInstance() {
		  try {
			if(ob==null) {
				  ob=new GenerateReport();
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ob;
		  
		  
	  }
	  
	  public void  StartExtentReport() {
		htmlReporter=new ExtentHtmlReporter("/Users/ashwiniramamurthy/eclipse-workspace/FireGroup/reporttest.html");
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "Salesforce");
		extent.setSystemInfo("environment","Automatio testing");
		extent.setSystemInfo("username", "ashwini");
		
		htmlReporter.config().setDocumentTitle("Test execution Report");
		htmlReporter.config().setReportName("salesforce regression testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	  }
	  public void StartSingleTestReport(String testname) {
		
		testcaseName=testname;
		logger=extent.createTest(testcaseName);
	  }
	  public void logTestInfo(String message) {
		  
		logger.log(Status.INFO, message );
	  }
		public void logTestPass() {
			logger.log(Status.PASS,MarkupHelper.createLabel(testcaseName+"is PassTest", ExtentColor.GREEN));
			
		}
		public void logTestFail() {
			logger.log(Status.FAIL,MarkupHelper.createLabel(testcaseName+"is NotPass", ExtentColor.RED));
		
		
		}
	  public void endReport() {
		  extent.flush();
		
		
	  }
		
	}
  


