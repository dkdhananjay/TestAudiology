package AudiologyTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Billing_Master extends Base_class
{
	Login_Page login;
	Branch_page billing;
	
	@BeforeTest
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		billing = new Branch_page(driver);
		billing.clickbilling();
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
	}
	
	
	@Test
	public void tc() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Add New Bill ']")).click(); 
		driver.findElement(By.xpath("//span[text()=' request_quote ']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"branchRefId\"]")).click();
		driver.findElement(By.xpath("//span[text()=' Home']")).click();
		driver.findElement(By.xpath("(//input[@formcontrolname=\"patientName\"])[2]")).click();
		driver.findElement(By.xpath("//td[text()='kelkar']")).click();
		driver.findElement(By.xpath("(//mat-checkbox[@formcontrolname=\"addService\"][1])")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click(); Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='close']")).click(); driver.navigate().refresh(); 
		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//td[text()=' Unpaid '])[1]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"serviceAdvanceAmount\"]")).sendKeys("100"); 
		driver.findElement(By.xpath("(//td[@class=\"mt-2 pb-0\"])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click(); Thread.sleep(1000);
//		String text=driver.findElement(By.xpath("(//th[text()='₹ 0'])[6]")).getText();
//		String Etext="₹ 0";
//		Assert.assertEquals(text, Etext);
//		if(text.equals(Etext)) 
//		{
//			driver.findElement(By.xpath("//th[text()='Receipt No.']")).isDisplayed();
//		}
//		else 
//		{
//			driver.close();
//		}
		
		
//		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"tdate\"]")).sendKeys("");
		
		
		
	}

}
