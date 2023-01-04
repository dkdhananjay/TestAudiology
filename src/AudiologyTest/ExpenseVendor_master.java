package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.math.field.FiniteField;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpenseVendor_master extends Base_class   //branch page is pom
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page expense;
	
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
		expense= new Branch_page(driver);
		expense.clickExpenseVendor();
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-5000)");

	}
//	@Test
//	public void Save_searchFunctionality() throws InterruptedException 
//	{	
//		String a=RandomStringUtils.randomAlphabetic(5); String b= RandomStringUtils.randomNumeric(2);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"vendorName\"]")).sendKeys(a);
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"vendorBrands\"]")).click(); Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[text()=' MI ']")).click(); // 15abcde1234l2Z1
//		driver.findElement(By.xpath("//input[@formcontrolname=\"vendorGstNo\"]")).sendKeys(b+a+"8818"+"l5Z5");
//		String no=RandomStringUtils.randomNumeric(9);  String pin=RandomStringUtils.randomNumeric(5);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"vendorPhoneNumber\"]")).sendKeys("9"+no);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"contactPersonAccounts\"]")).sendKeys(a);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"contactPersonAccountNo\"]")).sendKeys("8"+no);
//		driver.findElement(By.xpath("//input[@formcontrolname=\"vendorStreetAddress\"]")).sendKeys("h pune1");
//		driver.findElement(By.xpath("//input[@formcontrolname=\"vendorPinCode\"]")).sendKeys("4"+pin);
//		driver.findElement(By.xpath("//button[text()='Save']")).click(); driver.navigate().refresh(); Thread.sleep(3000);
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");
//		driver.findElement(By.xpath("//input[@formcontrolname=\"searchVendor\"]")).sendKeys(a);
//		String text=driver.findElement(By.xpath("(//td[@class=\"mat-tooltip-trigger\"])[2]")).getText();
//		String eText=a; boolean condn=text.equalsIgnoreCase(eText);  Assert.assertTrue(condn);
//	}
	
	@Test
	public void addBrands_searchFunctionality() throws InterruptedException 
	{
		String a=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Brand\"]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"brandName\"]")).sendKeys(a);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@mattooltip=\"Add New Brand\"]")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchBrand\"]")).sendKeys(a);
		String text=driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[4]")).getText();
		String eText=a; boolean condn= text.equalsIgnoreCase(a);
	}
	
//	@Test(priority=1)
//	public void updateFunctionality() throws InterruptedException  
//	{	String a=RandomStringUtils.randomNumeric(5);	 
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 5000)");     
//		driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).click(); WebElement pin = driver.findElement(By.xpath("//input[@formcontrolname=\"vendorPinCode\"]"));
//		Thread.sleep(1000); pin.clear();	pin.sendKeys("4"+a); 
//		driver.findElement(By.xpath("//button[text()='Update']")).click();
//	}
//	

}
