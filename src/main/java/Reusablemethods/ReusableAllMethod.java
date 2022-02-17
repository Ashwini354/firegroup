package Reusablemethods;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.annotations.ITest;

import com.techarck.config.GenerateReport;
import com.techarck.config.PropertiesConfguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableAllMethod {
	
	 protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 private static Properties prop;
	  protected  static GenerateReport report=new GenerateReport().getInstance();
		static {
			prop = PropertiesConfguration.loadProperties();
		}
		@BeforeClass
		public void setUp() {
			report.StartExtentReport();
		}
	public static void  Launch(String element) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(element);
		
		
	}
	@BeforeMethod()
	public void setup(Method method) {
		report.StartSingleTestReport(method.getName());
		Launch(prop.getProperty("url"));
		ImplicitWait();
		Login(prop.getProperty("Firename"), prop.getProperty("Firepassword"));
		ImplicitWait();
	}
	public static void Login(String username,String passwordEle) {
		WebElement email=driver.findElement(By.id("email_field"));
		email.sendKeys(username);
		
		WebElement password=driver.findElement(By.id("password_field"));
		password.sendKeys(passwordEle);
		WebElement button=driver.findElement(By.tagName("button"));
		button.click();
		
//		
	}
	public static void clickOper(WebElement ele) {
		ele.click();
		
	}
	@AfterClass
	public void endUp() {
		report.endReport();
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			report.logTestPass();
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
				report.logTestFail();
			
		String path=takeScreenShot();
		try {
			report.logger.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void waitUntilVisible(WebElement element) {
		wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public static void waitUntilAlertIsPresent() {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void AcceptAlert() {
		waitUntilAlertIsPresent();
		Alert alert=driver.switchTo().alert();
		System.out.println("alert text="+alert.getText());
		alert.accept();

}
	public static void close() {
		driver.close();
	}
	public static  String takeScreenShot() {
		TakesScreenshot screen=((TakesScreenshot)driver);
		File src_file=screen.getScreenshotAs(OutputType.FILE);
		String file_path="/Users/ashwiniramamurthy/eclipse-workspace/FireGroup/firebase.jpg";
		File des_file=new File(file_path);
		try {
			FileUtils.copyFile(src_file, des_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/Users/ashwiniramamurthy/eclipse-workspace/FireGroup/firebase.jpg";
	}
}
