package AudiologyTest;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class BillingCompanyMaster extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	BillingCompanyPage billing;
	
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
	    billing= new BillingCompanyPage(driver);
		billing.clickbranch(); Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");

		
		
	}
	
	@Test(enabled=false)
	public void Save_searchfunctionality() throws InterruptedException 
	{	String a=RandomStringUtils.randomAlphabetic(5); String a1=RandomStringUtils.randomNumeric(5);
		String b =RandomString.make(8);    String b1= RandomStringUtils.randomNumeric(9);
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyName\"]")).sendKeys(a);
		driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[2]")).click();
		driver.findElement(By.xpath("//span[text()='No']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).sendKeys(b);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"companyType\"]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Pvt Ltd']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='companyRegisteredAddress']")).sendKeys("pune1 Hinjewadi");
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPinCode\"]")).sendKeys("4"+a1);
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyContactNumber\"]")).sendKeys("9"+b1);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("//button[text()='Save']")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchBilling\"]")).sendKeys(a); Thread.sleep(3000);	
		String text=driver.findElement(By.xpath("(//td[@mattooltip=\"click to view\"])[2]")).getText();
		String eText=a; boolean condn =text.equalsIgnoreCase(eText);
		Assert.assertTrue(condn);
		
		
		
		
	}
	
	@Test(priority=1)
	public void InvalidCompanyName_AlphanumericData() 
	{
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyName\"]")).sendKeys("acolade124");
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter Valid Company Name. ']")).getText();
		String eText="Enter Valid Company Name.";
		Assert.assertEquals(text, eText);
	}
	
//	@Test(priority=3)
//	public void InvalidCompanyName_symbols() 
//	{              driver.navigate().refresh();
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyName\"]")).sendKeys("~!@#%");
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).click();
//		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter Valid Company Name. ']")).getText();
//		String eText="Enter Valid Company Name.";
//		Assert.assertEquals(text, eText);
//	}
//	
//	@Test(priority=4)
//	public void compGSTnumber_isDisplayed() throws InterruptedException   
//	{
//		
//		driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[2]")).click(); 
//		driver.findElement(By.xpath("//span[text()='Yes']")).click();
//		boolean condn=driver.findElement(By.xpath("//input[@formcontrolname=\"companyGST\"]")).isDisplayed();
//		Assert.assertTrue(condn);
//	
//	}
//	
//	@Test(priority=5)
//	public void search_functionality() throws InterruptedException 
//	{
//		driver.navigate().refresh();
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
//		driver.findElement(By.xpath("//input[@placeholder=\"Search\"]")).sendKeys("dandekar");  Thread.sleep(1000);
//		driver.findElement(By.xpath("//td[text()='dandekar']")).isDisplayed();
//	}
//	
//	@Test(priority=6)
//	public void update_functionality() throws InterruptedException
//	{
//		driver.navigate().refresh();
//		String a=RandomStringUtils.randomAlphanumeric(12);
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
//		driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).click(); Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).clear();
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).sendKeys(a); 
//		driver.findElement(By.xpath("//button[text()='Update']")).click(); 
//		System.out.println(a);
//	}
//	
//	@Test(priority=7)
//	public void invalidGSTnumber() throws InterruptedException
//	{
//		driver.navigate().refresh();
//		driver.findElement(By.xpath("//input[@formcontrolname='companyGST']")).sendKeys("123dsajk1235");
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).click();
//		String text=driver.findElement(By.xpath("//mat-error[text()= ' Please enter valid GST Number. ']")).getText();
//		String Etext="Please Enter Valid GST Number."; 
//		Assert.assertEquals(text, Etext);  
//	
//	}
//	
//	@Test(priority=8)
//	public void invalidPIN_number() throws InterruptedException
//	{ 	String a =RandomString.make(6);
//		driver.navigate().refresh();
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPinCode\"]")).sendKeys(a);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"companyPAN\"]")).click();
//		String text=driver.findElement(By.xpath("//mat-error[text()='Please enter valid PinCode']")).getText();
//		String Etext="Please Enter Valid PinCode";
//		Assert.assertEquals(text, Etext);  
//	
//	}
	
	

}
