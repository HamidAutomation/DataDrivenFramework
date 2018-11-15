package TestLuncher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FrameworkUtility.Constant;

public class NewTestNg {
	public WebDriver driver;
  @Test
  public void logInGstnApp() throws InterruptedException {
	
	  	driver.findElement(By.id("username")).sendKeys("Sandeep_1");
		driver.findElement(By.id("user_pass")).sendKeys("Test@1111");
		driver.findElement(By.id("captcha")).sendKeys("121212");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(5000);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
/*	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://uatr1services.gst.gov.in/services/login");*/
		System.setProperty("webdriver.chrome.driver", Constant.driverloc);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://uatr1services.gst.gov.in/services/login");
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
