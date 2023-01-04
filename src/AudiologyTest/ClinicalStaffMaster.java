package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClinicalStaffMaster extends Base_class 
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page Staff;
	
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
		Staff =new Branch_page(driver);
		Staff.clickClinicalStaff();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-5000)");

	}
	
	@Test(priority=0)
	public void ByDefault() 
	{
		String text =driver.findElement(By.xpath("//span[text()='MY SPEECH & HEARING CLINIC']")).getText();
		String Etext="MY SPEECH & HEARING CLINIC"; Assert.assertEquals(text, Etext);
		
	}
//	@Test(priority=1)
//	public void AddStaff_search() throws InterruptedException
//	{	String a=RandomStringUtils.randomNumeric(5);String b =RandomStringUtils.randomAlphabetic(5); String no =RandomStringUtils.randomAlphanumeric(5);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"staffMemberName\"]")).sendKeys(b);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"staffMemberShortCode\"]")).sendKeys(no); 
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"department\"]")).click();
//		driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[1]")).click();
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"post\"]")).click();  Thread.sleep(1000);
//		driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[1]")).click();
//		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click(); Thread.sleep(1000);
//		 driver.findElement(By.xpath("//span[text()=' 9 ']")).click(); 
//		 driver.findElement(By.xpath("//button[text()='AM']")).click();Thread.sleep(1000);
//		 driver.findElement(By.xpath("//span[text()='Ok']")).click(); 
//		 driver.findElement(By.xpath("(//button[@type='button'])[3]")).click(); 
//		 driver.findElement(By.xpath("//span[text()=' 6 ']")).click(); Thread.sleep(1000);
//		 driver.findElement(By.xpath("//button[text()='PM']")).click(); 
//		 driver.findElement(By.xpath("//span[text()='Ok']")).click(); 
//		driver.findElement(By.xpath("//input[@formcontrolname=\"staffMemberAddress\"]")).sendKeys(a+no);
//		driver.findElement(By.xpath("//input[@formcontrolname='PinCode']")).sendKeys("4"+a);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"staffContactNumbers\"]")).sendKeys("90909"+a);
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)"); Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Save ']")).click();
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)"); Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"searchStaff\"]")).sendKeys(b);
//		String text=driver.findElement(By.xpath("(//td[@mattooltip=\"click to view\"])[3]")).getText();
//		System.out.println(text);
//		String eText=b; boolean condn =text.equalsIgnoreCase(eText);
//		Assert.assertTrue(condn);
//	}
	
	
	
	
	@Test(enabled=false)
	public void Update() throws InterruptedException
	{
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"department\"]")).click();
		driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[1]")).click(); Thread.sleep(1000);
		String a=RandomStringUtils.randomNumeric(5);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
		driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"PinCode\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"PinCode\"]")).sendKeys("4"+a); 
		driver.findElement(By.xpath("//button[text()='Update ']")).click(); Thread.sleep(1000);
	}
	
	
	@Test(priority=4)
	public void add_Department() throws InterruptedException
	{
		String a=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Department\"]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"departmentName\"]")).sendKeys(a);
		driver.findElement(By.xpath("//button[text()='Save']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Department\"]")).click();;
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchdepartment\"]")).sendKeys(a);
		String text=driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[4]")).getText();
		String eText=a; boolean condn= text.equalsIgnoreCase(a);
	}
	
	
	
	
	
	
	
	
}
