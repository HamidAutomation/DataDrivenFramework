package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import FrameworkUtility.ExcelUtility;

public class LogIn {
	public static void logInPage1(WebDriver driver) throws Exception {

		String Uname = ExcelUtility.getCellData(2, 2,"LogInData");
		String pwd = ExcelUtility.getCellData(2, 3,"LogInData");
		String captcha = ExcelUtility.getCellData(2, 4,"LogInData");
		
		
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("user_pass")).sendKeys(pwd);
		driver.findElement(By.id("captcha")).sendKeys(captcha);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
	}
}
