package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Company_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Company_page company;
	
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
		company = new Company_page(driver);
		company.clickcompany();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
	}
	@Test(enabled=false)
	public void Savecompany() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='companyName']")).sendKeys("abab");
		driver.findElement(By.xpath("//input[@formcontrolname='canNumber']")).sendKeys("abab112");
		driver.findElement(By.xpath("//input[@formcontrolname='companyContact']")).sendKeys("626568656268");
     	driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).sendKeys("88,Hinjawadi,Pune");
		driver.findElement(By.xpath("//input[@formcontrolname='pincode']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.navigate().refresh();
	}
	
	@Test(priority=1)
	public void InvalidName_passingAlphanumeric() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='companyName']")).sendKeys("abab88");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid company name. ']")).getText();
		String Etext="Please Enter Valid Company Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=2)
	public void InvalidName_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='companyName']")).sendKeys("~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid company name. ']")).getText();
		String Etext="Please Enter Valid Company Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=3)
	public void InvalidName_passingAlphanumericAndSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='companyName']")).sendKeys("abab88~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid company name. ']")).getText();
		String Etext="Please Enter Valid Company Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=4)
	public void InvalidName_passingIntegers() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname='companyName']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid company name. ']")).getText();
		String Etext="Please Enter Valid Company Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=5)
	public void InvalidcanNumber_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"canNumber\"]")).sendKeys("~!@#$");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid Can Number. ']")).getText();
		String Etext="Enter Valid Can Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}

	@Test(priority=6)
	public void InvalidMobileNumber_passingAlphabates() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyContact\"]")).sendKeys("abde");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid mobile Number. ']")).getText();
		String Etext="Enter Valid Mobile Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=7)
	public void InvalidMobileNumber_passingAlphanumericData() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyContact\"]")).sendKeys("abde1234");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid mobile Number. ']")).getText();
		String Etext="Enter Valid Mobile Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=8)
	public void InvalidMobileNumber_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyContact\"]")).sendKeys("~!@#$");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid mobile Number. ']")).getText();
		String Etext="Enter Valid Mobile Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	@Test(priority=9)
	public void InvalidMobileNumber_passingAlphanumericAndSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyContact\"]")).sendKeys("abde1234~!@#$");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid mobile Number. ']")).getText();
		String Etext="Enter Valid Mobile Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=10)
	public void InvalidPINcode_passingAlphanumericData() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).sendKeys("abde1234");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter only number. ']")).getText();
		String Etext="Enter Only Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=11)
	public void InvalidPINcode_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).sendKeys("!@~#$");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter only number. ']")).getText();
		String Etext="Enter Only Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	

	@Test(priority=12)
	public void InvalidPINcode_passingLessThan6Digits() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@formcontrolname='companyAddress']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter 6 digit Pincode. ']")).getText();
		String Etext="Enter 6 Digit Pincode.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
