package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Invoice_Master extends Base_class
{
	Login_Page login;
	stock_page stock;
	
	@BeforeClass
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		stock= new stock_page(driver);
		stock.clickstock();
		stock.clickinvoice();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
	}
	
	@Test (enabled=false)
	public void SaveFunctionality()
	{
		 driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c95-14']")).click();
		 driver.findElement(By.xpath("//span[text()='kirloskar']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceNo\"]")).sendKeys("ab12");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"poNumber\"]")).sendKeys("159888");
		 driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c95-18']")).click();
		 driver.findElement(By.xpath("//span[text()='1515']")).click();
		 driver.findElement(By.xpath("(//div[@class='col-sm-2 mt-2 pl-0 ml-0 widthh2'])[2]")).click();
		 driver.findElement(By.xpath("(//input[@formcontrolname='serialNumber'])[2]")).sendKeys("ab1288");
//		 driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname=\"unitPrice\"]")).sendKeys("5000");
   }
	
	@Test  (enabled=false)
	public void UpdateFunctionality() 
	{
		driver.findElement(By.xpath("//td[text()=' 9 ']")).click();
	    driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceNo\"]")).clear();
	//    driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceNo\"]")).sendKeys("ab1258");
        driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	
	@Test  
	public void InvalidInvoiceNumber_passingSymbols()
	{
		 driver.findElement(By.xpath("//input[@formcontrolname=\"invoiceNo\"]")).sendKeys("~!@#$");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"poNumber\"]")).click();
		 String text = driver.findElement(By.xpath("//mat-error[text()=' Please enter valid invoice No. ']")).getText();
		 String eText= "Please Enter Valid Invoice No.";
		 Assert.assertEquals(text, eText);
		 driver.navigate().refresh();
   }
	@Test 
	public void InvalidMethodShifting_passingAlphanumericData()
	{
		 driver.findElement(By.xpath("//input[@formcontrolname=\"methodOfShifting\"]")).sendKeys("alpha1234");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"poNumber\"]")).click();
		 String text = driver.findElement(By.xpath("//mat-error[text()=' Please enter valid method of shifting. ']")).getText();
		 String eText= "Please Enter Valid Method Of Shifting.";
		 Assert.assertEquals(text, eText);
		 driver.navigate().refresh();
   }
	@Test 
	public void InvalidMethodShifting_passingSymbols()
	{
		 driver.findElement(By.xpath("//input[@formcontrolname=\"methodOfShifting\"]")).sendKeys("~!@#$%");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"poNumber\"]")).click();
		 String text = driver.findElement(By.xpath("//mat-error[text()=' Please enter valid method of shifting. ']")).getText();
		 String eText= "Please Enter Valid Method Of Shifting.";
		 Assert.assertEquals(text, eText);
		 driver.navigate().refresh();
   }
	@Test   
	public void InvalidPONumber_passingMoreThan10Char()
	{
		 
		 driver.findElement(By.xpath("//input[@formcontrolname=\"poNumber\"]")).sendKeys("abab8288822");
		 driver.findElement(By.xpath("//input[@formcontrolname=\"methodOfShifting\"]")).click();
		 String text = driver.findElement(By.xpath("//mat-error[text()=' Enter alphanumeric maximum length of 10 po Number. ']")).getText();
		 String eText= "Enter Alphanumeric Maximum Length Of 10 Po Number.";
		 Assert.assertEquals(text, eText);
		 driver.navigate().refresh();
   } 
	 


}
