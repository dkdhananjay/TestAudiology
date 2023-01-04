package AudiologyTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Role_Mater extends Base_class
{
	Login_Page login;
	Settings_page set;
	Role_page role;
	
	@BeforeClass
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		role = new Role_page(driver);
		role.clickrole();
	}
	@Test(enabled=false)
	public void AddRole() 
	{
	//	driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("abab");
		driver.findElement(By.xpath("//button[text()='Save ']")).click();
		driver.navigate().refresh();
	}
	@Test(priority=1)
	public void UpdateFunctionality() throws InterruptedException 
	{
		driver.findElement(By.xpath("//td[text()=' 9 ']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("extra staff");
		driver.findElement(By.xpath("//button[text()='Update ']")).click();
		driver.navigate().refresh();
	}
	@Test(priority=2)
	public void InvalidRoleName_passingAlphanumeric() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("extra staff123");
		driver.findElement(By.xpath("//button[text()='Save ']")).click();
		String text=driver.findElement(By.xpath(" //mat-error[text()=' Please enter valid Role. ']")).getText();
		String Etext="Please Enter Valid Role.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=3)
	public void InvalidRoleName_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("~!@#");
		driver.findElement(By.xpath("//button[text()='Save ']")).click();
		String text=driver.findElement(By.xpath(" //mat-error[text()=' Please enter valid Role. ']")).getText();
		String Etext="Please Enter Valid Role.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=4)
	public void InvalidRoleName_passingAlphanumericAndSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("staff123~!@#");
		driver.findElement(By.xpath("//button[text()='Save ']")).click();
		String text=driver.findElement(By.xpath(" //mat-error[text()=' Please enter valid Role. ']")).getText();
		String Etext="Please Enter Valid Role.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=5)
	public void InvalidRoleName_passingIntegers() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='roleName']")).sendKeys("1234");
		driver.findElement(By.xpath("//button[text()='Save ']")).click();
		String text=driver.findElement(By.xpath(" //mat-error[text()=' Please enter valid Role. ']")).getText();
		String Etext="Please Enter Valid Role.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}

}
