package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FrameworkUtility.ExcelUtility;
public class LogInPage {
public static void logInPage(WebDriver driver) throws Exception {

	String Uname = ExcelUtility.getCellData(1, 2,"LogInData");
	String pwd = ExcelUtility.getCellData(1, 3,"LogInData");
	String captcha = ExcelUtility.getCellData(1, 4,"LogInData");

	
	driver.findElement(By.id("username")).sendKeys(Uname);
	driver.findElement(By.id("user_pass")).sendKeys(pwd);
	driver.findElement(By.id("captcha")).sendKeys(captcha);
	driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
}
}
