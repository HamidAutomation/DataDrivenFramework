package TestLuncher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FrameworkUtility.Constant;
import FrameworkUtility.ExcelUtility;
import PageObject.LogIn;
import PageObject.LogInPage;

public class TestRunner
{
	protected static WebDriver driver;

	public static void lunchApp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", Constant.driverloc);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.ApplicationURL);
		Thread.sleep(5000);
	}

	public static void main( String[] args ) throws Exception
    {	
    	int totTestCases = 2;
    	//int totTestCases = ExcelUtility.getRow("LogInData");
    	for(int strtRow = 1; strtRow <= totTestCases; strtRow++) {
    		
    			int strtCol = 0;
    			String TestCaseID = ExcelUtility.getCellData(strtRow, strtCol,"LogInData");
    			
    			strtCol = strtCol + 1;
    			
    			String ExecuteTestCase = ExcelUtility.getCellData(strtRow, strtCol,"LogInData");
    			
    			if(TestCaseID.equalsIgnoreCase("TC001") && ExecuteTestCase.equalsIgnoreCase("Yes")) {  	    		
    				TestRunner.lunchApp();
					LogInPage.logInPage(driver);
    		    	System.out.println("User logged In Successfully !");
    		    	Thread.sleep(5000);
    		    	ExcelUtility.setCellData("Pass", 1, 5);
    		    	ExcelUtility.setCellData("User logged In Successfully !", 1, 6);
    		    	driver.quit();
    	    	}
    			if(TestCaseID.equalsIgnoreCase("TC002") && ExecuteTestCase.equalsIgnoreCase("Yes")) {    	    		
    				TestRunner.lunchApp();
    		    	//WebDriver driver;
					LogIn.logInPage1(driver);
    		    	System.out.println("User logged In Successfully !");
    		    	Thread.sleep(5000);
    		    	ExcelUtility.setCellData("Pass", 2, 5);
    		    	ExcelUtility.setCellData("User logged In Successfully !", 2, 6);
    		    	driver.quit();
    	    	}
    	}	
    }
}
