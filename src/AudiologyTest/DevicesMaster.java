package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class DevicesMaster extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page device;
	
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
		device =new Branch_page(driver);
		device.clickDevice();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-5000)");

	}
//	@Test
//	public void save_searchFunctionality () throws InterruptedException 
//	{
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"brand\"]")).click();
//		driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[1]")).click(); String a=RandomString.make(4);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"model\"]")).sendKeys(a);
//		driver.findElement(By.xpath("//span[text()='Device Type']")).click();
//		driver.findElement(By.xpath("//span[text()=' bluetooth ']")).click();
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"billingCompanyRefId\"]")).click();
//		driver.findElement(By.xpath("//span[text()='dandekar']")).click();
//		driver.findElement(By.xpath("//input[@formcontrolname=\"mrp\"]")).sendKeys("800");
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1500)"); Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Save ']")).click(); driver.navigate().refresh(); Thread.sleep(3000);
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");
//		driver.findElement(By.xpath("//input[@formcontrolname=\"searchDevice\"]")).sendKeys(a);
//		String text = driver.findElement(By.xpath("(//td[@ng-reflect-message=\"click to view\"])[3]")).getText(); 
//		String eText=a;		boolean condn=text.equalsIgnoreCase(a);
//		
//	}
	
//	@Test(priority=1)
//	public void update()  throws InterruptedException
//	{	driver.navigate().refresh(); String a=RandomStringUtils.randomNumeric(4); ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)"); Thread.sleep(1000);
//		driver.findElement(By.xpath("(//tr[@role=\"row\"])[4]")).click();  Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"mrp\"]")).clear();
//		driver.findElement(By.xpath("//input[@formcontrolname=\"mrp\"]")).sendKeys(a);
//		driver.findElement(By.xpath("//button[@type='button']")).click(); //click to update
//	
//	}
	
	@Test
	public void AddBrand_search() throws InterruptedException
	{
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Brand\"]")).click(); String a=RandomStringUtils.randomAlphabetic(4);
		driver.findElement(By.xpath("//input[@formcontrolname=\"brandName\"]")).sendKeys(a);
		driver.findElement(By.xpath("//button[text()='Save']")).click();  Thread.sleep(1000); //click to save 
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Brand\"]")).click();//click brands to search 
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchBrand\"]")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).getText(); 
		String eText=a;
		boolean condn=text.equalsIgnoreCase(a);
	}

	@Test(enabled=false)
	public void AddDevice_search() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click(); String a=RandomStringUtils.randomAlphabetic(4);
		driver.findElement(By.xpath("")).sendKeys(a);
		driver.findElement(By.xpath("")).click(); Thread.sleep(1000); //click to save
		driver.findElement(By.xpath("")).click(); //click brands to search 
		driver.findElement(By.xpath("")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("")).getText(); String eText=a;
		boolean condn=text.equalsIgnoreCase(a);
	}
	
	
	@Test(enabled=false)
	public void AddStyle_search() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click(); String a=RandomStringUtils.randomAlphabetic(4); 
		driver.findElement(By.xpath("")).sendKeys(a);
		driver.findElement(By.xpath("")).click(); Thread.sleep(1000); //click to save
		driver.findElement(By.xpath("")).click(); //click brands to search 
		driver.findElement(By.xpath("")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("")).getText(); String eText=a;
		boolean condn=text.equalsIgnoreCase(a);
	}
	
	@Test(enabled=false)
	public void AddBatteryType_search() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click(); String a=RandomStringUtils.randomAlphabetic(4);
		driver.findElement(By.xpath("")).sendKeys(a);
		driver.findElement(By.xpath("")).click(); Thread.sleep(1000); //click to save
		driver.findElement(By.xpath("")).click(); //click brands to search 
		driver.findElement(By.xpath("")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("")).getText(); String eText=a;
		boolean condn=text.equalsIgnoreCase(a);
	}
	
	
	
	@Test(enabled=false)
	public void AddCondition_search() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click(); String a=RandomStringUtils.randomAlphabetic(4);
		driver.findElement(By.xpath("")).sendKeys(a);
		driver.findElement(By.xpath("")).click(); Thread.sleep(1000); //click to save
		driver.findElement(By.xpath("")).click(); //click brands to search 
		driver.findElement(By.xpath("")).sendKeys(a); Thread.sleep(1000);
		String text=driver.findElement(By.xpath("")).getText(); String eText=a;
		boolean condn=text.equalsIgnoreCase(a);
	}
	
	@Test(enabled=false)
	public void AddBillingCompany_searchfunctionality() throws InterruptedException 
	{	
		String a=RandomStringUtils.randomAlphabetic(5); String a1=RandomStringUtils.randomNumeric(5);
		String b =RandomString.make(8);    String b1= RandomStringUtils.randomNumeric(9);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Billing Company\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"companyName\"]")).sendKeys(a); Thread.sleep(3000);
		driver.findElement(By.xpath("(//mat-select[@role=\"combobox\"])[13]")).click();
		driver.findElement(By.xpath("(//span[text()='No'])[2]")).click();
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
	
	
	
}
