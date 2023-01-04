package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Avialability_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	AudiologistAvialability_page avialable; 
	
	@BeforeTest
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		avialable= new AudiologistAvialability_page(driver);
		avialable.clickAvialability();
		
		 
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
	}
	
	@Test
	public void tc() 
	{
		driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c95-3']")).click();
		driver.findElement(By.xpath("//span[text()=' Mahesh Patil']")).click();
		driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c95-5']")).click();
		driver.findElement(By.xpath("//span[text()=' home']")).click();
		
	}

}
