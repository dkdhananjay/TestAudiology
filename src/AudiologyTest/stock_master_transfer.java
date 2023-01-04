package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Strings;

import net.bytebuddy.utility.RandomString;

public class stock_master_transfer extends Base_class
{
	Login_Page login;
	stock_page stock;
	
	@BeforeClass
	public void OpenApp() throws InterruptedException         
	{
		OpenBrowser();
		//((JavascriptExecutor)driver).executeScript("chrome.settingsPrivate.setDefaultZoom(1.5);");	
		login = new Login_Page(driver);    			
		login.EnterUN();   	 	   					                
		login.EnterPWD();    	   	
		login.clickLogin();  Thread.sleep(1000);            
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)"); Thread.sleep(2000);       
		stock= new stock_page(driver);        
		stock.clickstock(); Thread.sleep(1000);            
		driver.findElement(By.xpath("//h4[text()='Stock Transfer']")).click();Thread.sleep(1000);  
		
	}
	
	@Test
	public void transfer() throws InterruptedException 
	{     String s = RandomString.make(5);
	      System.out.println(s);
	 	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		 driver.findElement(By.xpath("//mat-select[@formcontrolname=\"fromBranchRefId\"]")).click();
		 driver.findElement(By.xpath("//span[text()='home']")).click();
		 driver.findElement(By.xpath("//mat-select[@formcontrolname=\"toBranchRefId\"]")).click(); Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[text()='pune']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname=\"handOverPerson\"]")).sendKeys("klrahul");
		 driver.findElement(By.xpath("//mat-select[@formcontrolname=\"deviceRefId\"]")).click();
		 driver.findElement(By.xpath("//span[text()='kl88 ']")).click(); Thread.sleep(1000);
	//	 driver.findElement(By.xpath("//mat-select[@formcontrolname=\"serialNumber\"]")).click();
	//	 driver.findElement(By.xpath("//span[text()='kl56 ']")).click();
	//	 driver.findElement(By.xpath("//span[text()='lk65 ']")).click(); Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@formcontrolname=\"qty\"]")).click();
		 driver.findElement(By.xpath("//button[text()='Save']")).click();
		 
		
		 
	}

}
