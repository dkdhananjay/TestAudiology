package AudiologyTest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Branch_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page branch;
	
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
	    branch= new Branch_page(driver);
		branch.clickbranch();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
	}
	
	@Test(priority=0)
	public void ByDefaultClinicNameIs_MySpeechAndHearingClinic() 
	{
		String text=driver.findElement(By.xpath("//span[text()='MY SPEECH & HEARING CLINIC']")).getText();
		String Etext="MY SPEECH & HEARING CLINIC";
		Assert.assertEquals(text, Etext);
	}
	
	@Test(priority=1)
	public void InvalidBranchCode_passingSymbols() 
	{
	   driver.findElement(By.xpath("//input[@formcontrolname=\"branchCode\"]")).sendKeys("~!@#");
	   driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).click();
	   String text= driver.findElement(By.xpath("//mat-error[text()=' Please enter valid branch code. ']")).getText();
	   String eText ="Please Enter Valid Branch Code.";	
	   Assert.assertEquals(text, eText);
	   driver.navigate().refresh();
	   
	}
	
	@Test(priority=2)
	public void InvalidBranchName_passingAlphanumericData() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).sendKeys("abde12345");
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchCode\"]")).click();
		String text = driver.findElement(By.xpath("//mat-error[text()=' Please enter valid branch Name. ']")).getText();
		String Etext="Please Enter Valid Branch Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
		
	}
	
	@Test(priority=2)
	public void InvalidBranchName_passingNumericData() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchCode\"]")).click();
		String text = driver.findElement(By.xpath("//mat-error[text()=' Please enter valid branch Name. ']")).getText();
		String Etext="Please Enter Valid Branch Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test(priority=3)//symbols other than "&", "-"
	public void InvalidBranchName_passingSymbols() 
	{
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).sendKeys("~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchCode\"]")).click();
		String text =driver.findElement(By.xpath("//mat-error[text()=' Please enter valid branch Name. ']")).getText();
		String Etext="Please Enter Valid Branch Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
		
	}
	@Test(enabled=false)
	public void SaveFunctionality() throws InterruptedException 
	{
		 driver.findElement(By.xpath("//input[@formcontrolname=\"branchCode\"]")).sendKeys("Pune Upper");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).sendKeys("Pune-Hinjawadi");
		 driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[3]")).click();
		 driver.findElement(By.xpath("//span[text()='Permanent']")).click();       Thread.sleep(1000);
	     driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	     driver.findElement(By.xpath("//span[text()=' 10 ']")).click();
		 driver.findElement(By.xpath("//span[text()='Ok']")).click();
		 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		 driver.findElement(By.xpath("//span[text()=' 5 ']")).click();
		 driver.findElement(By.xpath("//button[text()='PM']")).click();
		 driver.findElement(By.xpath("//span[text()='Ok']")).click();
		 driver.findElement(By.xpath("//span[text()='Weekly Off']")).click();
		 driver.findElement(By.xpath("//span[text()=' Sunday ']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname=\"branchStreetAddress\"]")).sendKeys("A'nagar");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"branchPinCode\"]")).sendKeys("411057");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"branchPhoneNumber\"]")).sendKeys("95695696599");
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
		 driver.findElement(By.xpath("(//button[@type=\"button\"])[3]")).click();
		 
	
	}
	@Test(priority=11)
	public void Update() throws InterruptedException 
	{   String a=RandomStringUtils.randomNumeric(5); String b=RandomStringUtils.randomNumeric(9);
		Thread.sleep(1000); ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
		driver.findElement(By.xpath("//td[text()='pune']")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchPinCode\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchPinCode\"]")).sendKeys("4"+a);
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchPhoneNumber\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"branchPhoneNumber\"]")).sendKeys("9"+b);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@Test(priority=11)
	public void Search_functionality() throws InterruptedException 
	{
		driver.navigate().refresh(); Thread.sleep(1000); ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchBranch\"]")).sendKeys("Pune-Hinjawadi");
		String text=driver.findElement(By.xpath("//td[text()='Pune-Hinjawadi']")).getText();
		String eText="Pune-Hinjawadi";
		Assert.assertEquals(text, eText);
		
		
		
		driver.findElement(By.ByCssSelector.name("ADD TO BAG"));
		
		
		
	}
	
	
	
	
}
