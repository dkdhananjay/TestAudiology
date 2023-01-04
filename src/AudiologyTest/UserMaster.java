package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserMaster extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page User;
	
	@BeforeTest
	public void OpenApp() throws InterruptedException 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		User =new Branch_page(driver);
		User.clickUser();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-5000)");

	}
	@Test(priority=0)
	public void AddUser_assignPermission() throws InterruptedException 
	{	String ab=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"userType\"]")).click(); String a=RandomStringUtils.randomAlphanumeric(5);
		driver.findElement(By.xpath("//span[text()='Other']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"userName\"]")).sendKeys(ab);
		driver.findElement(By.xpath("//input[@formcontrolname=\"userID\"]")).sendKeys(a);
		driver.findElement(By.xpath("//input[@formcontrolname=\"emailId\"]")).sendKeys("fli"+ a +"@sol.com");  
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"roleRefId\"]")).click();
		driver.findElement(By.xpath("//mat-option[@role=\"option\"]")).click();
		driver.findElement(By.xpath("//button[text()='Next ']")).click(); Thread.sleep(1000);
		for(int i=1; i<=281; i=i+5)
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[" + i + "]")).click();
		driver.findElement(By.xpath("//button[text()='Save ']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchUser\"]")).sendKeys(ab); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("(//td[@class=\"ng-star-inserted\"])[2]")).getText();
		String eText=ab; boolean condn= text.equalsIgnoreCase(ab); Assert.assertTrue(condn);
	}
	

}
