package AudiologyTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class Transaction_PurchaseTransferAccept extends Base_class
{
	user_loginPage log;
	Login_Page login;
	stock_page stock;
	
	@BeforeTest
	public void OpenApp() throws InterruptedException 
	{   OpenBrowser();
		
		
		

		login = new Login_Page(driver);  
		login.EnterUN();                  
		login.EnterPWD();  Thread.sleep(1000);
		login.clickLogin();     
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)"); Thread.sleep(2000);      
		stock= new stock_page(driver);        
		stock.clickstock(); Thread.sleep(1000); 
		
		log= new user_loginPage(driver);
	}
	

	
	@Test
	public void purchase() throws InterruptedException			 
	{   driver.findElement(By.xpath("//h4[text()='Purchase Invoice']")).click();Thread.sleep(1000);  
		String a =RandomString.make(5); String b= RandomString.make(4);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"vendorRefId\"]")).click();
		driver.findElement(By.xpath("//span[text()='kirloskar']")).click();
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"billingRefId\"]")).click();
		driver.findElement(By.xpath("//span[text()=' dandekar']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceNo\"]")).sendKeys(a);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"deviceRefId\"]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='FL56']")).click();
		driver.findElement(By.xpath("//i[@mattooltip='Add Serial No']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"serialNumber\"]")).sendKeys(b);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"unitPrice\"]")).sendKeys("8000");
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		driver.navigate().refresh();
	}
	
	
	@Test(priority=1)
	public void transfer() throws InterruptedException 
	{
		driver.findElement(By.xpath("//i[@mattooltip=\"Home Page\"]")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)"); Thread.sleep(3000);
		stock.clickstock(); Thread.sleep(1000);
		driver.findElement(By.xpath("//h4[text()='Stock Transfer']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"fromBranchRefId\"]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Home']")).click();  
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"toBranchRefId\"]")).click();  Thread.sleep(1000);   
		driver.findElement(By.xpath("//span[text()='pune']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"handOverPerson\"]")).sendKeys("d");Thread.sleep(1000);   
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"deviceRefId\"]")).click();    
		driver.findElement(By.xpath("//span[text()='FL56 ']")).click(); Thread.sleep(1000);    
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"serialNumber\"]")).click();    
		driver.findElement(By.xpath("(//mat-option[@role=\"option\"])[1]")).click(); Thread.sleep(3000); 
		WebElement element = driver.findElement(By.xpath("//button[text()='Save']"));
		Actions a= new Actions(driver); 
		a.moveToElement(element).click().perform(); Thread.sleep(5000); 
		driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Dispatch']")).click();
		
	}
	
	
	@Test
	public void acceptStock() throws InterruptedException  
	{
		driver.switchTo().newWindow(WindowType.TAB); 
		driver.get("http://194.5.152.32:2225");
		log.EnterUN(); log.EnterPWD(); log.clickLogin(); Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@mattooltip=\"Home Page\"]")).click(); 
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");      
		stock.clickstock(); Thread.sleep(1000); driver.findElement(By.xpath("//h4[text()='Stock Transfer']")).click();
		driver.findElement(By.xpath("//button[text()='Show Dispatch List']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("(//tr[@class=\"ng-star-inserted\"])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click(); Thread.sleep(4000); 
		driver.navigate().refresh();
		driver.findElement(By.xpath("//i[@mattooltip=\"Home Page\"]")).click();
		driver.findElement(By.xpath("//h4[text()='Dashboard']")).click();
		
	}
	
	
	
	
	
	
	
	@Test(enabled=false)
	public void search_functionality() throws InterruptedException 				
	{ 
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchGoods\"]")).sendKeys("666666");
		String text=driver.findElement(By.xpath("//td[text()=' 666666 ']")).getText();
		String eText="666666";
		Assert.assertEquals(text, eText);
		
	}

}
