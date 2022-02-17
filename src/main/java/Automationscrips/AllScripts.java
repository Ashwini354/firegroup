package Automationscrips;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ReportAggregatesListener;
import com.techarck.config.PropertiesConfguration;

import Reusablemethods.ReusableAllMethod;

public class AllScripts extends ReusableAllMethod {


	@Test(priority=2)
	public static void HandleWindowAlert() throws InterruptedException {
		
//report.StartSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(switchTo).build().perform();
		Thread.sleep(5000);
		report.logTestInfo("swicth to accept");
		
		driver.findElement(By.linkText("Alert")).click();//here your wish to fail it
     // Thread.sleep(3000);
		WebElement windoepromp = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/button[1]"));
		clickOper(windoepromp);
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text: " + alert.getText());
		report.logTestInfo("swicth to window");
		Thread.sleep(5000);
		alert.accept();
		close();

	}
	@Test(priority=1)
	public static void HandlePromptAlert() throws InterruptedException {
		
	//report.StartSingleTestReport(Thread.currentThread().getStackTrace()[1].getMethodName());
		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(switchTo).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Alert")).click();
		report.logTestInfo("alert clicked");
		WebElement windoepromp = driver.findElement(By.xpath("//button[normalize-space()='Promt Alert']"));
		clickOper(windoepromp);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("xxxx");
		report.logTestInfo("send value  successfully");
		System.out.println("alert :" + alert.getText());
		alert.accept();
		close();

	}

	public static void handleWindowsNewWindows() throws InterruptedException {
		

		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(switchTo).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Windows")).click();
		WebElement windowbutton = driver.findElement(By.xpath("//button[contains(text(),'Window')]"));
		String oldwindow = driver.getWindowHandle();
		clickOper(windowbutton);
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("aaaa");

		Thread.sleep(5000);
		driver.switchTo().window(oldwindow);
		driver.quit();

	}

	public static void handleWindowsNewTab() throws InterruptedException {
		

		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(switchTo).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Windows")).click();
		WebElement windowbutton = driver.findElement(By.xpath("//button[contains(text(),'Tab')]"));
		String oldwindow = driver.getWindowHandle();
		clickOper(windowbutton);
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
				// System.out.println();
			}
		}
		driver.findElement(By.name("q")).sendKeys("aaaa");
		Thread.sleep(5000);

		driver.switchTo().window(oldwindow);
		Thread.sleep(5000);
		driver.findElement(By.xpath(" //a[@onclick='logout()']")).click();
		close();
	}

	public static void RightClickOperation() throws InterruptedException {
		Launch(prop.getProperty("demoUrl"));
		Thread.sleep(20000);
		WebElement right_click = driver.findElement(By.xpath("//span[contains(text(),'right click me')] "));
		Actions action = new Actions(driver);
		action.contextClick(right_click).perform();// action.contextClick(right_click);
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/ul[1]/li[4]")).click();
		AcceptAlert();
		close();
	}

	public static void DoubleClickOperation() throws InterruptedException {
		Launch(prop.getProperty("demoUrl"));
		Thread.sleep(20000);
		WebElement double_click = driver
				.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
		Actions action1 = new Actions(driver);
		action1.doubleClick(double_click).perform();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text: " + alert.getText());
		Thread.sleep(5000);
		alert.accept();
		close();

	}


	public static void handleWidget() throws InterruptedException {
		Launch(prop.getProperty("url"));
		ImplicitWait();
		Login(prop.getProperty("Firename"), prop.getProperty("Firepassword"));
		ImplicitWait();

		WebElement widget = driver.findElement(By.xpath("//button[normalize-space()='Widget']"));
		widget.click();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(widget).build().perform();
		driver.findElement(By.xpath("//a[normalize-space()='AutoComplete']")).click();
		driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("un");
		Thread.sleep(5000);
		List<WebElement> ListOfCountry = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']//div"));
		String speci_country = "United States of America";
		for (WebElement webElem : ListOfCountry) {

			if (speci_country.equals(webElem.getText())) {
				webElem.click();
			} else {
				System.out.println("not");
			}

		}
		close();
	}
		
		public static void HandleDragDrop() throws InterruptedException {
			
			WebElement interaction = driver.findElement(By.xpath("//button[normalize-space()='Intractions']"));
			interaction.click();
			Actions action = new Actions(driver);
			action.moveToElement(interaction);
			driver.findElement(By.linkText("Drag & Drop")).click();
			
			WebElement drag=driver.findElement(By.xpath("//img[@id='drag1']"));
			WebElement drop=driver.findElement(By.xpath("//div[@class='container']//div[1]"));
			Thread.sleep(5000);
			//action.dragAndDrop(drag, drop).perform();
			action.clickAndHold(drag).pause(Duration.ofSeconds(3))
			.moveToElement(drop).pause(Duration.ofSeconds(3)).build().perform();
			close();
			
			
			
		}
		public static void handletable() throws InterruptedException {
			Launch(prop.getProperty("url"));
			ImplicitWait();
			Login(prop.getProperty("Firename"), prop.getProperty("Firepassword"));
			ImplicitWait();
			WebElement widget = driver.findElement(By.xpath("//button[normalize-space()='Widget']"));
			widget.click();
			Actions action = new Actions(driver);
			Thread.sleep(5000);
			action.moveToElement(widget).build().perform();
			driver.findElement(By.linkText("Table")).click();
			WebElement table=driver.findElement(By.tagName("Table"));
			List<WebElement> row=table.findElements(By.xpath("//tr"));
			System.out.println(row.size());
			for(WebElement single_row:row) {
				ImplicitWait();
				List<WebElement> data=single_row.findElements(By.xpath("//td"));
				for(WebElement single_data:data) {
					System.out.print(single_data.getText()+" ");
				}
				System.out.println();
				
			}
			driver.close();
			
			
		}

		public static void Handleframe() throws InterruptedException {
			Launch(prop.getProperty("qaurl"));
			Thread.sleep(15000);

			List<WebElement> multipleframes = driver.findElements(By.tagName("iframe"));
			System.out.println(multipleframes.size());
			driver.switchTo().frame("frame1");
			WebElement frame = driver.findElement(By.id("sampleHeading"));
			System.out.println(frame.getText());
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame2");
			WebElement Otherframe = driver.findElement(By.id("sampleHeading"));
			System.out.println(Otherframe.getText());
			close();
			
			
			
		}

	

	
}
