package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Service_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page service;
	
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
	    service= new Branch_page(driver);
	    service.clickservices();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
	}
	
	@Test
	public void tc() throws InterruptedException 
	{	
		String a=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Service Type\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"serviceType\"]")).sendKeys(a);
		driver.findElement(By.xpath("//button[text()='Save']")).click(); Thread.sleep(1000); 
		
		String b=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Test Type\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"testType\"]")).sendKeys(b); Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Save']")).click(); Thread.sleep(4000);  
		driver.findElement(By.xpath("//button[text()='Save ']")).click(); Thread.sleep(1000); 
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchService\"]")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("(//td[@mattooltip=\"click to view\"])[2]")).getText();
		String eText=a; boolean condn=text.equalsIgnoreCase(eText); Assert.assertTrue(condn);
	
		
	}

}
